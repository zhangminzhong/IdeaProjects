package com.test.model;

/**
 * Created by AdministratorZhang on 2019/11/22 20:18
 */
public class User {
    private int id;
    private String userName;
    private int age;

    public User(){}

    public User(String userName,int age){
        this.userName = userName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*public User(int id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }*/
}
