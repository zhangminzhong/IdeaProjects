package com.test.test002.service;

import com.test.test002.dao.UserMapperTest002;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Created by AdministratorZhang on 2018/3/29.
 */
@Service
public class UserServiceTest002 {
    @Autowired
    private UserMapperTest002 userMapperTest002;

    @Transactional
    public void insertUserTest002(String username, int age) {
        userMapperTest002.insertUser(username,age);
        int i = 1/0;
    }
}
