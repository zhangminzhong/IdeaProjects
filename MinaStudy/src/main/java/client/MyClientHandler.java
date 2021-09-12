package client;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * Created by zhang_minzhong on 2017/5/22.
 */
public class MyClientHandler implements IoHandler {
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        System.out.println("session创建");
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("session打开");
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("session关闭");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println("session id="+session.getId()+" 空闲");
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        System.out.println("异常");
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String str = message.toString();
        System.out.println("客户端"+Thread.currentThread().getName()+"收到："+str);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        System.out.println("消息发出");
    }

    @Override
    public void inputClosed(IoSession session) throws Exception {

    }

}
