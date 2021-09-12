package com.study.controller;

import com.study.bean.User;
import com.study.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang minzhong
 * @date 2021/9/11 22:40
 */
@RestController
public class UserController {
    @Autowired
    private UserConfig userConfig;

    @GetMapping("/getUser")
    public User getUser(){

        return new User(userConfig.userName, userConfig.password);
    }
}
