package _4_生产者消费者模型;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by zhang_minzhong on 2017/8/19.
 * 有时使用BlockingQueue可能会出现put()和System.out.println()输出不匹配的情况，这是由于它们之间没有同步造成的。
 * 当缓冲区已满，生产者在put()操作时，put()内部调用了await()方法，放弃了线程的执行，然后消费者线程执行，
 * 调用take()方法，take()内部调用了signal()方法，通知生产者线程可以执行，
 * 致使在消费者的println()还没运行的情况下生产者的println()先被执行，所以有了输出不匹配的情况。
 */
public class 使用LinkedBlockingQueue {
    static class Storage{
        private final int MAX_SIZE = 100;
        private LinkedBlockingDeque<Object> list = new LinkedBlockingDeque<Object>(100);

        public void produce(int num){
            if(list.size()==MAX_SIZE)
                System.out.println("【库存量】:" + MAX_SIZE + "\t暂时不能执行生产任务!");
            for(int i=0;i<num;i++){
                try {
                    list.put(new Object());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("【已经生产产品数】:" + num + "\t【现仓储量为】:" + list.size());
        }
        public void consume(int num){
            if(list.size()==0){
                System.out.println("【库存量】:0\t暂时不能执行生产任务!");
            }
            for(int i=0;i<num;i++){
                try {
                    list.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("【已经消费产品数】:" + num + "\t【现仓储量为】:" + list.size());
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
