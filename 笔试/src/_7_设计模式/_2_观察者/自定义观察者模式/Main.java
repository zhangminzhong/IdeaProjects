package _7_设计模式._2_观察者.自定义观察者模式;

/**
 * Created by zhang_minzhong on 2017/9/2.
 */
public class Main {
    public static void main(String[] args) {
        MySubject subject = new MySubject();
        MyObserver observer = new MyObserver();
        subject.registerOberver(observer);
        System.out.println(observer.getTemprature());
        subject.setTemprature(25);
        System.out.println(observer.getTemprature());
    }
}
