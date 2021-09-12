package 并发;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhang_minzhong on 2017/6/27.
 */
public class SimpleDaemons implements Runnable {
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
       //ExecutorService exec = Executors.newSingleThreadExecutor();
        Thread t = new Thread(new SimpleDaemons());
        t.setDaemon(true);
        t.start();
        //exec.execute(t);
        //exec.shutdown();
        TimeUnit.MILLISECONDS.sleep(5000);
    }
}
