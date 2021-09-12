package com.test.mapper;

import com.test.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by AdministratorZhang on 2018/3/29.
 */

public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User findByName(@Param("username")String username);

    @Insert("insert into user(username,password) values(#{username},#{password})")
    void insertUser(@Param("username")String username, @Param("password")String password);
}
