package com.study.controller;

import com.study.bean.User;
import com.study.config.UserConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang minzhong
 * @date 2021/9/11 22:40
 */
@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserConfig userConfig;

    @GetMapping("/getUser")
    public User getUser(){
        log.info(userConfig.toString());
        log.info(userConfig.userName);//取不到值
        return new User(userConfig.getUserName(), userConfig.getPassword());
    }
}
