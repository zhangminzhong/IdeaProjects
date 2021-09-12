package _7_设计模式._2_观察者.JDK观察者模式;

/**
 * Created by zhang_minzhong on 2017/9/2.
 */
public class Main {
    public static void main(String[] args) {
        MyObserver observer1 = new MyObserver();
        observer1.setObserverName("观察者1");
        MyObserver observer2 = new MyObserver();
        observer2.setObserverName("观察者2");
        MySubject subject = new MySubject();
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.setSubjectContent("天晴！");
    }
}
