package com.example.study.config;

import com.example.study.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhang minzhong
 * @date 2021/9/11 11:15
 */
@Configuration
public class UserConfig {
    
    @Bean
    public User getUser(){
        return new User("张三","123");
    }

}
