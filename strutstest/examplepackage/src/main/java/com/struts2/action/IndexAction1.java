package com.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-9-16
 * Time: 上午1:08
 * To change this template use File | Settings | File Templates.
 */
public class IndexAction1  extends ActionSupport{

    @Override
    public String execute() throws Exception {
        System.out.println("execute()");
        return "success";
    }

    public String add(){
        System.out.println("add()");
        return "success";
    }

}
