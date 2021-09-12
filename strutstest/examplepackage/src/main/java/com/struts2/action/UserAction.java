package com.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts2.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-9-16
 * Time: 上午1:46
 * To change this template use File | Settings | File Templates.
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
    /*
    1.属性接收参数
    private String username;
    private String password;

    public String add(){
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        return "success";
    }

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
    }*/

    /*
    2.域模型
    private User user;

    public String add(){
        System.out.println("username:"+user.getUsername());
        System.out.println("password:"+user.getPassword());
        return "success";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
    public String execute(){
        System.out.println("execute()");
        return SUCCESS;
    }
    private User user = new User();

    public String add(){
        System.out.println("ModelDriven");
        System.out.println("username:"+user.getUsername());
        System.out.println("password:"+user.getPassword());
        return "success";
    }


    @Override
    public User getModel() {
        return user;
    }
}
