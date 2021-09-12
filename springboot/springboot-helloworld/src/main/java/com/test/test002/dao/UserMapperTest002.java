package com.test.test002.dao;

import com.test.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by AdministratorZhang on 2018/3/29.
 */

public interface UserMapperTest002 {
    @Select("select * from users where username = #{username}")
    User findByName(@Param("username") String username);

    @Insert("insert into users(username,age) values(#{username},#{age})")
    void insertUser(@Param("username")String username, @Param("age")int age);
}
