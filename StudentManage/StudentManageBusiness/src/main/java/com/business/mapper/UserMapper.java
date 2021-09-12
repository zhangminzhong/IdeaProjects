package com.business.mapper;

import com.business.entity.User;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-4-5
 * Time: 下午3:25
 * To change this template use File | Settings | File Templates.
 */
public interface UserMapper {
    public User findUserByName(String name);
    public void addUser(User u);
}
