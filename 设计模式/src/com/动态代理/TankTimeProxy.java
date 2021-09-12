package com.动态代理;
public class TankTimeProxy implements Moveable {
    private Moveable t;
    public TankTimeProxy(Moveable t) {
        this.t = t;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        t.move();
        long end = System.currentTimeMillis();
        System.out.println("time："+(end-start));
    }
}
