package com.springmvc.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 16-10-8
 * Time: 上午11:21
 * To change this template use File | Settings | File Templates.
 */
public class Person {
    private String name;
    private int age;
    private String address;
    private Date birthday;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name="+name+",age="+age+",address="+address+",birthday="+birthday;
    }
}
