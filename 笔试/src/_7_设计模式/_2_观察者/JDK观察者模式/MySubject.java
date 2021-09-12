package _7_设计模式._2_观察者.JDK观察者模式;

import java.util.Observable;

/**
 * Created by zhang_minzhong on 2017/9/2.
 */
public class MySubject extends Observable {
    private String subjectContent;

    public String getSubjectContent() {
        return subjectContent;
    }

    public void setSubjectContent(String subjectContent) {
        this.subjectContent = subjectContent;
        this.setChanged();
        //notifyObservers();//拉模式通知
        notifyObservers(subjectContent);//推模式通知
    }
}
