package com.serverhandler;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-4
 * Time: 上午11:25
 * To change this template use File | Settings | File Templates.
 */
public class TimeServerHandler extends IoHandlerAdapter {

    private int random = new Random().nextInt(100);
    //private List<String> messageList = new ArrayList<String>();
    @Override
    public void exceptionCaught(IoSession arg0, Throwable arg1)
            throws Exception {
        arg1.printStackTrace();

    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {


       // session.setAttribute("random",random);
        System.out.println(Thread.currentThread().getId());
        String str = message.toString();
        System.out.println("接受到的消息:"+str);

        List<String> messageList = new ArrayList<String>();
        //session.setAttribute("messageList",messageList);
       //List<String> mList = (List<String>) session.getAttribute("messageList");
        messageList.add(str);
        for(int i=0;i<messageList.size();i++){
            System.out.println("第"+i+"条："+messageList.get(i));
        }

        if( str.trim().equalsIgnoreCase("quit") ) {
            session.close(true);
            return;
        }
        Date date = new Date();
        session.write(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date)+",random="+random );
        System.out.println("Message written...");
        //Thread.sleep(15000);
    }

    @Override
    public void messageSent(IoSession arg0, Object arg1) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("发送信息:"+arg1.toString());
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        // TODO Auto-generated method stub
        //System.out.println("一个连接断开");
        System.out.println("IP:"+session.getRemoteAddress().toString()+"断开连接");
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("IP:"+session.getRemoteAddress().toString()+"已连接");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        // TODO Auto-generated method stub
        //System.out.println( "IDLE " + session.getIdleCount( status ));

    }

    @Override
    public void sessionOpened(IoSession arg0) throws Exception {
        // TODO Auto-generated method stub

    }
}
