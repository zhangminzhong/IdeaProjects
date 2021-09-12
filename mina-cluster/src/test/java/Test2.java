import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by AdministratorZhang on 2017/11/17.
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        final HashMap<String,A> map = new HashMap<String, A>();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                A a = map.get("a");
                System.out.println(a);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(a);
            }
        },200,500, TimeUnit.MILLISECONDS);
        for(int i=0;i<10;i++){
            System.out.println(i);
            map.put("a",new A(i,i));
            Thread.sleep(50);
        }
    }
    static class A{
        int a;
        int b;

        public A(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "a="+a+",b="+b;
        }
    }
}
