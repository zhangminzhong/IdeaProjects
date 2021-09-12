package _7_设计模式._2_观察者.JDK观察者模式;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by zhang_minzhong on 2017/9/2.
 */
public class MyObserver implements Observer {
    private String observerName;

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void update(Observable o, Object arg) {
        MySubject subject = (MySubject) o;
        System.out.println(observerName+"收到了目标变化，拉模式，获取变化的内容:" +subject.getSubjectContent());
        System.out.println(observerName + "收到了目标变化，推模式，获取变化的内容:" + arg);
    }
}
