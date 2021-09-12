package server;


import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhang_minzhong on 2017/5/22.
 */
public class MyServerHandler implements IoHandler {
    private Logger logger = LoggerFactory.getLogger(MyServerHandler.class);
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        InetSocketAddress address = (InetSocketAddress) session.getRemoteAddress();
        String ip = address.getAddress().getHostAddress();
        int port = address.getPort();
        System.out.println(ip+":"+port+"连接");
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {

    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {

    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        logger.info(Thread.currentThread().getName()+" session id="+session.getId()+" 空闲");
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {

    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String str = message.toString();
        System.out.println(Thread.currentThread().getName()+"收到："+str);
        if(str.trim().equalsIgnoreCase("quit")){
            session.closeNow();
            return;
        }
        Date date = new Date();
        String dateStr = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss").format(date);
        //Thread.sleep(20000000);
        session.write(dateStr);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {

    }

    @Override
    public void inputClosed(IoSession session) throws Exception {

    }
}
