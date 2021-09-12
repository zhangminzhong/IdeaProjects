package com.itheima;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

public class Ticket12306 implements Runnable{

    private int tickets = 10;//数据库票数
    private InterProcessMutex lock;
    public Ticket12306(){
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString("192.168.0.106:2181")
                .sessionTimeoutMs(60*1000).connectionTimeoutMs(15*1000)
                .retryPolicy(new ExponentialBackoffRetry(3*1000,10))
                .build();
        client.start();
        lock = new InterProcessMutex(client,"/lock");
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
                //获取锁
                lock.acquire(60*1000, TimeUnit.SECONDS);
                if(tickets > 0){
                    System.out.println(Thread.currentThread()+":"+tickets);
                    tickets--;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    //释放锁
                    lock.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
