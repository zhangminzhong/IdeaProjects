package com.动态代理;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-15
 * Time: 下午12:38
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    public static void main(String[] args) throws Exception{
        Tank t = new Tank();
        InvocationHandler handler = new TimeHandler(t);
        Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class,handler);
        //System.out.println(m.getClass().getName());
        m.move();

    }
}
