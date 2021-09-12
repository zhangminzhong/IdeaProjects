package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

//    @Autowired//本地注解注入
    /**
     * 1.从zookeeper注册中心获取UserService的访问url
     * 2.远程调用
     * 3.将结果封装成一个代理对象，给变量赋值
     */
    @Reference(timeout = 1000,version = "1.0",loadbalance = "random")//远程注入
    private UserService userService;

    @RequestMapping("/sayHello")
    public String sayHello(){
        return userService.sayHello();
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    int i = 1;
    @RequestMapping("/find")
    public User find(int id){

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    System.out.println(i++);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();

        return userService.findUserById(id);
    }
}