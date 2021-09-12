package com.动态代理;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-15
 * Time: 下午12:31
 * To change this template use File | Settings | File Templates.
 */
public class Tank implements Moveable{
    @Override
    public void move() {
        //long start = System.currentTimeMillis();
        System.out.println("tank moving.......");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //long end = System.currentTimeMillis();
        //System.out.println("time："+(end-start));
    }

   /* @Override
    public void stop() {
        System.out.println("tank stopping.......");
    }*/
}