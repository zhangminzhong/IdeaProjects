package com.test.service.impl;


import com.test.model.User;
import com.test.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by AdministratorZhang on 2019/11/23 17:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserService userService;

    @Test
    @Transactional
    public void testAddUser() {
        User user = new User("bbbb",18);
        userService.addUser(user);
    }

    @Test
    public void testLog(){
        logger.debug("这是debug类型日志");
        logger.info("这是info类型日志");
        logger.warn("这是warn类型日志");
        logger.error("这是error类型日志");
    }
}