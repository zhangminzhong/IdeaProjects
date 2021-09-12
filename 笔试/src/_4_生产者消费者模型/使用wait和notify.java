package _4_生产者消费者模型;

import java.util.LinkedList;

/**
 * Created by zhang_minzhong on 2017/8/19.
 */

public class 使用wait和notify {

    static class Storage {
        private final int MAX_SIZE = 100;
        private LinkedList<Object> list = new LinkedList<Object>();

        public void produce(int num){
            synchronized (list){
                while(list.size()+num>MAX_SIZE){
                    System.out.println("【要生产的产品数量】:" + num + "\t【库存量】:"
                            + list.size() + "\t暂时不能执行生产任务!");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1;i <= num;i++){
                    list.offer(new Object());
                }
                System.out.println("【已经生产产品数】:" + num + "\t【现仓储量为】:" + list.size());
                list.notifyAll();
            }
        }
        public void consume(int num){
            synchronized (list){
                while(list.size()<num){
                    System.out.println("【要消费的产品数量】:" + num + "\t【库存量】:"
                            + list.size() + "\t暂时不能执行生产任务!");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0;i < num;i++){
                    System.out.println("list容量："+list.size());
                    list.poll();
                }
                System.out.println("【已经消费产品数】:" + num + "\t【现仓储量为】:" + list.size());
                list.notifyAll();
            }
        }
    }

    static class Producer extends Thread{
        private Storage storage;
        private int num;

        public Producer(Storage storage,int num){
            this.storage = storage;
            this.num = num;
        }

        @Override
        public void run() {
            storage.produce(num);
        }
    }

    static class Consumer extends Thread{
        private Storage storage;
        private int num;

        public Consumer(Storage storage,int num) {
            this.storage = storage;
            this.num = num;
        }

        @Override
        public void run() {
            storage.consume(num);
        }
    }

    public static void main(String[] args) {
        Storage storage = new Storage();
        for(int i=0;i<3;i++){
            Consumer c = new Consumer(storage,10);
            c.start();
        }
        for(int i=0;i<10;i++){
            Producer p = new Producer(storage,6);
            p.start();
        }
    }
}
