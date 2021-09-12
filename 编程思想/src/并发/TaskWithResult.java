package 并发;

import java.util.concurrent.Callable;

/**
 * Created by zhang_minzhong on 2017/6/27.
 */
public class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        //TimeUnit.MILLISECONDS.sleep(5000);
        return "id = "+id;
    }
}
