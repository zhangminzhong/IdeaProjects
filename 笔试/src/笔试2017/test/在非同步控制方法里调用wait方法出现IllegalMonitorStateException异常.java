package 笔试2017.test;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhang_minzhong on 2017/9/2.
 */
public class 在非同步控制方法里调用wait方法出现IllegalMonitorStateException异常 {
    public static void main(String[] args) {
        final Object o = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("T1 start!");
                /*try {
                    o.wait();
                } catch (InterruptedException e) {
                    System.out.println("T1 throws InterruptedException");
                }*/
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1 end!");
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                System.out.println("T2 start!");
                o.notify();
                System.out.println("T2 end!");
            }
        };
        t1.start();
        //t2.start();
    }
}
