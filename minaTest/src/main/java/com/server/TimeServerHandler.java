package com.server;

import javafx.scene.input.DataFormat;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-4
 * Time: 上午11:25
 * To change this template use File | Settings | File Templates.
 */
public class TimeServerHandler extends IoHandlerAdapter {

    //private int random = new Random().nextInt(100);
    //private List<Integer> intList = T.getIntList();
    @Override
    public void exceptionCaught(IoSession arg0, Throwable arg1) throws Exception {
        arg1.printStackTrace();
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
       // session.setAttribute("random",random);
        System.out.println("messageReceived方法线程id："+Thread.currentThread().getId()+"，名称："+Thread.currentThread().getName());
        String str = message.toString();
        System.out.println("接收到的消息:"+str);

        //List<String> messageList = new ArrayList<String>();
        //session.setAttribute("messageList",messageList);
       List<String> messageList = (List<String>) session.getAttribute("messageList");
        messageList.add(str);
        for(int i=0;i<messageList.size();i++){
            System.out.println("第"+(i+1)+"条："+messageList.get(i));
        }
        /*System.out.print("整数list：");
        Iterator<Integer> iterator = intList.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        if(intList.size()>0)
            intList.remove(intList.get(0));
        */
        if( str.trim().equalsIgnoreCase("quit") ) {
            session.closeNow();
            return;
        }
        Date date = new Date();
        //session.write(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date)+",random="+random+"\n");
        session.write(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        //byte[] bytes = {0xA,0xB};
        // session.write(bytes);
        System.out.println("Message written...");
        //Thread.sleep(1500000);
    }

    @Override
    public void messageSent(IoSession arg0, Object arg1) throws Exception {
        System.out.println("发送信息:"+arg1.toString());
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("session关闭，连接断开");
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        List<String> messageList = new ArrayList<String>();
        session.setAttribute("messageList",messageList);
        System.out.println("IP:"+session.getRemoteAddress().toString()+"已连接");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println("session id="+session.getId()+" 进入空闲状态");
        /*session.closeNow();
        System.out.println("session id="+session.getId()+" 断开连接");*/

    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("session id="+session.getId()+" 打开");
    }
}
