package _7_设计模式._2_观察者.自定义观察者模式;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhang_minzhong on 2017/9/2.
 */
public class MySubject implements Subject {
    private float temprature;
    private List<Observer> observers = new ArrayList<Observer>();

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public float getTemprature() {
        return temprature;
    }

    public void setTemprature(float temprature) {
        this.temprature = temprature;
        this.tempratureChanged();
    }

    public void tempratureChanged(){
        this.notifyObservers();
    }

    @Override
    public void registerOberver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if(observers.indexOf(observer)>0)
            observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer o:observers){
            o.update(temprature);
        }
    }

}
