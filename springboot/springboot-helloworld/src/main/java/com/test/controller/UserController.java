package com.test.controller;

import com.test.dao.UserDao;
import com.test.entity.User;
import com.test.service.UserService;
import com.test.test001.service.UserServiceTest001;
import com.test.test002.service.UserServiceTest002;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by AdministratorZhang on 2018/3/29.
 */
@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;
    @Autowired
    UserServiceTest001 userServiceTest001;
    @Autowired
    UserServiceTest002 userServiceTest002;

    //jdbc test
    @RequestMapping("/createUser")
    public String createUser(String name,String password){
        userService.createUser(name,password);
        return "success";
    }

    //jpa test
    @RequestMapping("/getUser")
    public List<User> getUser(){
        LOGGER.info("getUser()");
        return userService.getUser();
    }

    //mybatis test
    @RequestMapping("/findUser")
    public User findUser(String username){
        LOGGER.info("findUser()");
        return userService.findUser(username);
    }

    //多数据源
    @RequestMapping("/findUserTest001")
     public User findUserTest001(String username){
        LOGGER.info("findUserTest001()");
        return userServiceTest001.findUserTest001(username);
    }
    @RequestMapping("/insertUserTest001")//test001、test002两个操作
    public void insertUserTest001(String username,int age){
        LOGGER.info("insertUserTest001()");
        userServiceTest001.insertUserTest001(username,age);
    }
    @RequestMapping("/insertUserTest002")
    public void insertUserTest002(String username,int age){
        LOGGER.info("insertUserTest002()");
        userServiceTest002.insertUserTest002(username,age);
    }

    @RequestMapping("/sendMsg")
    public void sendMsg(){
        LOGGER.info("sendMsg——1");
        userServiceTest001.sendMsg();
        LOGGER.info("sendMsg——2");
    }
}
