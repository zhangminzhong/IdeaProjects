package _7_设计模式._1_动态代理;

/**
 * Created by zhang_minzhong on 2017/8/29.
 */
public class MySubject implements Subject {
    @Override
    public void request() {
        System.out.println("MySubject request()...");
    }
}
