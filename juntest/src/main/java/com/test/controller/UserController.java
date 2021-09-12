package com.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.test.enums.ResPonseEnum;
import com.test.model.User;
import com.test.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by AdministratorZhang on 2019/11/22 23:47
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public String addUser(@RequestParam("userName")String userName,@RequestParam("age") int age){
        User user = new User();
        user.setUserName(userName);
        user.setAge(age);
        try {
            userService.addUser(user);
        }catch (Exception e){
            logger.error("插入失败："+e.getMessage());
            logger.info(ResPonseEnum.FAIL.toString());
            return ResPonseEnum.FAIL.toString();
        }
        logger.info(ResPonseEnum.SUCCESS.toString());
        return ResPonseEnum.SUCCESS.toString();
    }
}
