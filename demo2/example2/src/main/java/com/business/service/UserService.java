package com.business.service;

import com.business.entity.User;
import com.business.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-4-5
 * Time: 下午4:47
 * To change this template use File | Settings | File Templates.
 */

@Component
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User findUserByName(String name){
        return userMapper.findUserByName(name);
    }
}
