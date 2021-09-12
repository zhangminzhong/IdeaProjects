package 并发;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhang_minzhong on 2017/6/29.
 */
public class TestTimer {
    private static int i = 0;
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(++i);
                if (i==10)
                    System.exit(0);
            }
        },0,1000);
    }
}
