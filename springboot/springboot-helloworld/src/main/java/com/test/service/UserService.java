package com.test.service;

import com.test.dao.UserDao;
import com.test.entity.User;
import com.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by AdministratorZhang on 2018/3/29.
 */
@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;

    public void createUser(String name, String password) {
        System.out.println("createUser()");
        jdbcTemplate.update("insert into user values(null,?,?);", name, password);
        System.out.println("创建用户成功");
    }

    public List<User> getUser(){
        System.out.println("getUser()");
        return userDao.findAll();
    }

    //@Transactional
    public User findUser(String username) {
        System.out.println("findUser()");
        User user = userMapper.findByName(username);
        //userMapper.insertUser("aaa","aaa");
        //int i = 1/0;
        return user;
    }
}
