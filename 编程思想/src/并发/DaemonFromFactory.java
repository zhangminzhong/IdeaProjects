package 并发;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhang_minzhong on 2017/6/27.
 */
public class DaemonFromFactory implements Runnable{
   private static class DaemonThreadFactory implements ThreadFactory{

       @Override
       public Thread newThread(Runnable r) {
           Thread t = new Thread(r);
           t.setDaemon(true);
           return t;
       }
   }
    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("守护线程");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        exec.execute(new DaemonFromFactory());
        exec.shutdown();
        TimeUnit.MILLISECONDS.sleep(5000);
    }
}
