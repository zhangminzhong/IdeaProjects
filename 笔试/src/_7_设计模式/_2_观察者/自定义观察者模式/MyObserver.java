package _7_设计模式._2_观察者.自定义观察者模式;

/**
 * Created by zhang_minzhong on 2017/9/2.
 */
public class MyObserver implements Observer{
    private float temprature;

    public float getTemprature() {
        return temprature;
    }

    public void setTemprature(float temprature) {
        this.temprature = temprature;
    }

    @Override
    public void update(float temprature) {
        this.temprature = temprature;
    }
}
