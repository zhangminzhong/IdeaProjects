package _7_设计模式._2_观察者.自定义观察者模式;

/**
 * Created by zhang_minzhong on 2017/9/2.
 */
public interface Subject {
    public void registerOberver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
