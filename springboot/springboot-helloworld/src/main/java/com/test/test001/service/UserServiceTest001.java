package com.test.test001.service;

import com.test.entity.User;
import com.test.test001.dao.UserMapperTest001;
import com.test.test002.dao.UserMapperTest002;
import com.test.test002.service.UserServiceTest002;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by AdministratorZhang on 2018/3/29.
 */
@Service
public class UserServiceTest001 {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTest001.class);
    @Autowired
    private UserMapperTest001 userMapperTest001;
    @Autowired
    private UserServiceTest002 userServiceTest002;
    //private UserMapperTest002 userMapperTest002;

    public User findUserTest001(String username) {
        return userMapperTest001.findByName(username);
    }

    @Transactional
    public void insertUserTest001(String username, int age) {
        userMapperTest001.insertUser(username,age);
        userServiceTest002.insertUserTest002(username,age);
        //userMapperTest002.insertUser(username,age);
        int i=1/0;
    }

    //异步调用
    @Async
    public void sendMsg(){
        LOGGER.info("sendMsg——3");
        for(int i=1;i<=3;i++){
            LOGGER.info(String.valueOf(i));
        }
        LOGGER.info("sendMsg——4");
    }
}
