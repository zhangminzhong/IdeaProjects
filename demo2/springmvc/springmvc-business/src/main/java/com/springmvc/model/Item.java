package com.springmvc.model;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 16-10-12
 * Time: 上午10:34
 * To change this template use File | Settings | File Templates.
 */
public class Item {
    private String name;
    private float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name+":"+price;
    }
}
