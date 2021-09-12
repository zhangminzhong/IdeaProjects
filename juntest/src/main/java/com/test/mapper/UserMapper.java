package com.test.mapper;

import com.test.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by AdministratorZhang on 2019/11/22 20:47
 */
@Repository
public interface UserMapper {
    public void addUser(@Param("user") User user);
}
