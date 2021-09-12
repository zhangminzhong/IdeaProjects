package com.listener;

import com.server.MinaTimeServer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created with IntelliJ IDEA.
 * User: zhang_minzhong
 * Date: 16-10-20
 * Time: 上午11:10
 * To change this template use File | Settings | File Templates.
 */
public class MinaStartListener implements ServletContextListener{
    Thread t = new Thread(new MinaTimeServer());
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
        t.start();
        System.out.println("服务器启动完成");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        System.out.println("服务器关闭");

    }
}
