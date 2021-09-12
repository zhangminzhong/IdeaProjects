package com.business.service;

import com.business.entity.User;
import com.business.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-4-4
 * Time: 下午3:53
 * To change this template use File | Settings | File Templates.
 */

@Component
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User findUserByName(String username){
        return userMapper.findUserByName(username);
    }
    public void addUser(User u){
        userMapper.addUser(u);
    }
}
