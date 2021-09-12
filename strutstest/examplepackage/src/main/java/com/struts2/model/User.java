package com.struts2.model;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-9-16
 * Time: 上午2:27
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
