package com.test.dao;

import com.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by AdministratorZhang on 2018/3/29.
 */
public interface UserDao extends JpaRepository<User, Integer> {
}
