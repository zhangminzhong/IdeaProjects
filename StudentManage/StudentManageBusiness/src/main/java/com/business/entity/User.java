package com.business.entity;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-4-4
 * Time: 下午3:28
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private int id;
    private String username;
    private  String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return this.getUsername();
    }
}
