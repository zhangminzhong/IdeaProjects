package org.apache.mina.cluster.master;

import org.apache.mina.cluster.cmcodec.CMCodecFactory;
import org.apache.mina.cluster.master.algorithm.Dynamic;
import org.apache.mina.cluster.master.algorithm.RoundRobin;
import org.apache.mina.cluster.master.algorithm.interfaces.DynamicLoadBalancer;
import org.apache.mina.cluster.master.algorithm.interfaces.StaticLoadBalancer;
import org.apache.mina.cluster.util.XMLParse;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.mina.cluster.master.algorithm.interfaces.LoadBalancer;
import org.apache.mina.cluster.util.Information;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by AdministratorZhang on 2017/11/15.
 */
public class Master {
    private static final Logger LOGGER = LoggerFactory.getLogger(Master.class);
    private NioSocketAcceptor clientAcceptor;//接收客户端连接
    private NioSocketAcceptor slaveAcceptor;//接收slave节点连接
    private int clientPort;//监听Client的端口号
    private int slavePort;//监听Slave节点的端口号
    ScheduledExecutorService service = Executors.newScheduledThreadPool(1);//开启一个新线程用于周期性调用负载均衡算法计算最小负载slave节点
    private ConcurrentHashMap<Long,Information> map = new ConcurrentHashMap<Long, Information>();//保存Slave节点信息的map
    private LoadBalancer loadBalancer  = new RoundRobin();//负载均衡算法，默认轮询算法
    private volatile String ipPort;//存放最优服务器的"IP:PORT"信息
    private XMLParse xmlParse = new XMLParse();

    public Master(){
        this.clientPort = xmlParse.getClientPort();
        this.slavePort = xmlParse.getSlavePort();
    }

    public LoadBalancer getLoadBalancer() {
        return loadBalancer;
    }
    public void setLoadBalancer(LoadBalancer loadBalancer){
        this.loadBalancer = loadBalancer;
    }

    /**
     * 启动Master节点
     */
    public void start() {
        bindForClient(clientPort);//监听客户端
        bindForSlave(slavePort);//监听Slave节点
        service.scheduleWithFixedDelay(new Runnable() {//启动计算最优服务器的线程，用于动态负载均衡
            @Override
            public void run() {
                if(loadBalancer instanceof DynamicLoadBalancer) {
                    ipPort = loadBalancer.getServer(map, null);
                }
            }
        }, 0,500, TimeUnit.MILLISECONDS);
    }

    public void stop(){
        clientAcceptor.dispose();
        slaveAcceptor.dispose();
        service.shutdownNow();
        LOGGER.info("master close");
    }

    /**
     * 启动监听客户端连接的服务器
     * @param clientPort
     */
    private void bindForClient(int clientPort)  {
        clientAcceptor = new NioSocketAcceptor();
        clientAcceptor.getFilterChain().addLast("clientLog",new LoggingFilter());
        clientAcceptor.getFilterChain().addLast("cmCodec",new ProtocolCodecFilter(new CMCodecFactory()));
        clientAcceptor.getFilterChain().addLast("clientExecutor", new ExecutorFilter());
        clientAcceptor.setHandler(new IoHandlerAdapter(){
            @Override
            public void messageReceived(IoSession session, Object message) throws Exception {
                String s = (String) message;
                LOGGER.info("master receive message of client:"+s);
                String retStr = "";
                if(s.equals("query")){
                    if(loadBalancer instanceof StaticLoadBalancer){
                        InetSocketAddress clientAddress = (InetSocketAddress)session.getRemoteAddress();
                        String clientIp = clientAddress.getHostString();
                        ipPort = loadBalancer.getServer(map,clientIp);
                    }
                    retStr = ipPort;//使用负载最小节点的ip
                }else {
                    retStr = "error";
                }
                session.write(retStr);
            }
        });
        try {
            clientAcceptor.bind(new InetSocketAddress(clientPort));
        } catch (IOException e) {
            LOGGER.error("bind error,{}",e);
        }
        LOGGER.info("server for client starts listening at "+clientPort);
    }

    /**
     * 启动监听Slave节点的服务器
     * @param slavePort
     */
    private void bindForSlave(int slavePort) {
        slaveAcceptor = new NioSocketAcceptor();
        //acceptor2.getFilterChain().addLast("slaveLog",new LoggingFilter());
        slaveAcceptor.getFilterChain().addLast("slaveCodec", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
        //acceptor2.getFilterChain().addLast("slaveExecutor",new ExecutorFilter());
        slaveAcceptor.setHandler(new IoHandlerAdapter() {
            @Override
            public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
                LOGGER.error("exceptionCaught",cause);
                map.remove(session.getId());
                session.closeNow();
            }

            @Override
            public void sessionClosed(IoSession session) throws Exception {
                map.remove(session.getId());
                InetSocketAddress address = (InetSocketAddress)session.getRemoteAddress();
                String ip = address.getHostString();
                LOGGER.info("slave ip="+ip+"断开连接");
            }

            @Override
            public void messageReceived(IoSession session, Object message) throws Exception {
                //更新节点信息
                Information information = (Information) message;
                map.put(session.getId(), information);
                LOGGER.info("master receive message of slave" + session.getId() + ":" + information.toString());
            }

            @Override
            public void sessionCreated(IoSession session) throws Exception {
                LOGGER.info("slave "+session.getId()+" connect");
            }
        });
        try {
            slaveAcceptor.bind(new InetSocketAddress(slavePort));
        } catch (IOException e) {
            LOGGER.error("bind error,{}",e);
        }
        LOGGER.info("server for slave starts listening at "+slavePort);
    }
}
