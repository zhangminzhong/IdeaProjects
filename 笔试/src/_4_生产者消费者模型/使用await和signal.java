package _4_生产者消费者模型;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhang_minzhong on 2017/8/19.
 */

public class 使用await和signal {

    static class Storage {
        private final int MAX_SIZE = 100;
        private LinkedList<Object> list = new LinkedList<Object>();
        private final Lock lock = new ReentrantLock();
        private final Condition full = lock.newCondition();
        private final Condition empty = lock.newCondition();

        public void produce(int num){
            try{
                lock.lock();
                while(list.size()+num>MAX_SIZE){
                    System.out.println("【要生产的产品数量】:" + num + "\t【库存量】:"
                            + list.size() + "\t暂时不能执行生产任务!");
                    try {
                        full.await();//队列已满，等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1;i <= num;i++){
                    list.offer(new Object());
                }
                System.out.println("【已经生产产品数】:" + num + "\t【现仓储量为】:" + list.size());
                //唤醒等在full和empty条件上的所有线程
                full.signalAll();
                empty.signalAll();
            }finally {
                lock.unlock();
            }
        }
        public void consume(int num){
            try{
                lock.lock();
                while(list.size()<num){
                    System.out.println("【要消费的产品数量】:" + num + "\t【库存量】:"
                            + list.size() + "\t暂时不能执行生产任务!");
                    try {
                        empty.await();//库存不够，等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0;i < num;i++){
                    System.out.println("list容量："+list.size());
                    list.poll();
                }
                System.out.println("【已经消费产品数】:" + num + "\t【现仓储量为】:" + list.size());
                empty.signalAll();
                full.signalAll();
            }finally {
                lock.unlock();
            }
        }
    }

    static class Producer implements Runnable{
        private Storage storage;
        private int num;

        public Producer(int num, Storage storage) {
            this.num = num;
            this.storage = storage;
        }

        @Override
        public void run() {
            storage.produce(num);
        }
    }

    static class Consumer implements Runnable{
        private Storage storage;
        private int num;

        public Consumer(int num, Storage storage) {
            this.num = num;
            this.storage = storage;
        }

        @Override
        public void run() {
            storage.consume(num);
        }
    }

    public static void main(String[] args) {
        Storage storage = new Storage();
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<3;i++){
            exec.submit(new Consumer(10,storage));
        }
        for(int i=0;i<10;i++){
            exec.submit(new Producer(6,storage));
        }
        exec.shutdown();
    }
}
