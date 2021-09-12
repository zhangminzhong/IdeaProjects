package 笔试2017.test;

/**
 * Created by zhang_minzhong on 2017/9/18.
 * u5123e4
 asdfaasdf
 sadgadg
 asdfdsa
 sadf
 saf
 asdf
 asdfass
 asdfgdf
 dfgdsf
 */
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Main{
    public static  ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(200000);
    static final CountDownLatch latch = new CountDownLatch(3);
    public static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<10;i++){
            queue.put(scanner.nextLine());
        }
        scanner.close();
        for(int i=0;i<3;i++){
            new Thread(){
                public void run() {
                    runMethod();
                };
            }.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    private static void runMethod(){
        String str = null;
        try {
            str = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(str);
        if(str != null && str.contains("u51")){
            addOne();
        }
        latch.countDown();
    }

    private synchronized static void addOne() {
        count++;
    }

    /*private static String getString() throws InterruptedException {
        if(queue.size() > 0){
            System.out.println(queue.size());
            return queue.take();
        }
        return null;
    }*/
}


