package 笔试2017.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by AdministratorZhang on 2017/11/10.
 */
public class Test1 {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world!");
            }
        },0,1, TimeUnit.SECONDS);
    }
}
