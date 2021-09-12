package org.apache.mina.cluster.slave;

import org.apache.mina.cluster.util.Information;
import org.apache.mina.cluster.util.XMLParse;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * Created by AdministratorZhang on 2017/11/17.
 */
public class Slave {
    private static final Logger LOGGER = LoggerFactory.getLogger(Slave.class);
    private NioSocketAcceptor acceptor;//接收客户端连接的具体服务器
    private NioSocketConnector connector;//连接Master节点的管理器
    private String masterIp;//Master节点所在服务器IP地址
    private int masterPort;//Master节点监听Slave节点的端口
    private ScheduledExecutorService service= Executors.newScheduledThreadPool(1);//开启一个线程每隔200毫秒向master上报节点信息
    private XMLParse xmlParse = new XMLParse();

    public Slave() {
        this.masterIp = xmlParse.getMasterIp();
        this.masterPort = xmlParse.getSlavePort();
    }

    /**
     * 关联真实服务器
     * @param acceptor
     */
    public void add(NioSocketAcceptor acceptor){
        this.acceptor = acceptor;
        //LOGGER.info("已关联服务器");
    }

    /**
     * 启动Slave节点
     */
    public void start() {
        connectMaster(masterIp,masterPort);
    }

    public void stop() {
        connector.dispose();
        service.shutdownNow();
        acceptor.dispose();
    }

    /**
     * 创建到Master节点的socket连接
     * @param ip
     * @param port
     */
    private void connectMaster(String ip,int port) {
        connector = new NioSocketConnector();
        //connector.getFilterChain().addLast("masterLog",new LoggingFilter());
        connector.getFilterChain().addLast("slaveCodec",new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
        connector.setHandler(new IoHandlerAdapter() {
            @Override
            public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
                LOGGER.error("exceptionCaught", cause);
                session.closeNow();
            }

            @Override
            public void messageSent(IoSession session, Object message) throws Exception {
                LOGGER.info("salve"+session.getId()+" send "+message.toString());
            }
        });
        ConnectFuture future = connector.connect(new InetSocketAddress(ip, port));
        future.awaitUninterruptibly();
        final IoSession session = future.getSession();
        LOGGER.info("slave"+session.getId()+" connect to master");
        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                InformationGather gather = new InformationGather();
                Information information = gather.getInformation(acceptor);
                session.write(information);
            }
        },0,200, TimeUnit.MILLISECONDS);
    }
}
