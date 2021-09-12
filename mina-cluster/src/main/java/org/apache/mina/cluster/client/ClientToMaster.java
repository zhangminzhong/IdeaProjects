package org.apache.mina.cluster.client;

import org.apache.mina.cluster.cmcodec.CMCodecFactory;
import org.apache.mina.cluster.slave.Slave;
import org.apache.mina.cluster.util.XMLParse;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Client创建到Master节点的连接
 * Created by AdministratorZhang on 2017/11/10.
 */
public class ClientToMaster {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientToMaster.class);
    private  String masterIp;//master ip
    private int masterPort;//master port
    //private String messageStr;//
    private String realIp;//slave ip
    private int realPort;//slave port
    private XMLParse xmlParse = new XMLParse();

    public ClientToMaster() {
        this.masterIp = xmlParse.getMasterIp();
        this.masterPort = xmlParse.getClientPort();
        //LOGGER.info("客户端成功读取master节点信息");
        //LOGGER.info("masterIp="+masterIp+",port="+masterPort);
    }

    /**
     * 获取真实服务器IP
     * @return
     */
    public String getRealIp() {
        return realIp;
    }

    /**
     * 获取真实服务器监听客户端的端口号
     * @return
     */
    public int getRealPort() {
        return realPort;
    }

    /**
     * 创建到Master节点的socket连接，根据返回值判断是否有可用服务器
     * @return
     */
    public boolean connectMaster(){
        IoConnector connector = new NioSocketConnector();
        //connector.setConnectTimeoutMillis(10*1000);
        connector.getFilterChain().addLast("logForMaster",new LoggingFilter());
        connector.getFilterChain().addLast("cmCodec",new ProtocolCodecFilter(new CMCodecFactory()));
        connector.setHandler(new IoHandlerAdapter(){
            @Override
            public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
                LOGGER.error("exceptionCaught",cause);
                session.closeNow();
            }

            @Override
            public void messageReceived(IoSession session, Object message) throws Exception {
                String messageStr = (String) message;
                if(message.equals("error")){
                    LOGGER.error("server is unavailable");
                }else {
                    String[] strings = messageStr.split(":");
                    realIp = strings[0];
                    realPort = Integer.parseInt(strings[1]);
                    LOGGER.info("real server ip="+realIp+",port="+realPort);
                }
                session.closeNow();
            }
        });
        IoSession session = null;
        ConnectFuture future = connector.connect(new InetSocketAddress(masterIp,masterPort));
        future.awaitUninterruptibly();
        session = future.getSession();
        session.write("query");
        session.getCloseFuture().awaitUninterruptibly();
        connector.dispose();
        if(realIp!=null){
            return true;
        }else {
            return false;
        }
    }
}
