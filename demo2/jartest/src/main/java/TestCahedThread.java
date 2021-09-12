import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: zhang_minzhong
 * Date: 16-10-19
 * Time: 下午6:49
 * To change this template use File | Settings | File Templates.
 */
public class TestCahedThread {
    public static void main(String[] args){
        ExecutorService exec= Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            final int index = i;
            Runnable run=new Runnable(){
                public void run(){
                    long time=(long)(Math.random()*1000);
                    System.out.println("sleep:"+time+" ss ,index="+index);
                    try{
                        Thread.sleep(time);
                    }catch (Exception e) {
// TODO: handle exception
                    }
                }
            };
            exec.execute(run);
        }
        exec.shutdown();
    }
}
