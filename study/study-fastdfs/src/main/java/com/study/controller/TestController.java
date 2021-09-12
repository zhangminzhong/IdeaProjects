package com.study.controller;

import com.study.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang minzhong
 * @date 2021/9/11 22:40
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${user.userName}")
    private String userName;
    @Value("${user.password}")
    private String password;

    @GetMapping("/getUser")
    public User getUser(){
        return new User(userName, password);
    }
}
