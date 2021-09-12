package com.test;

import com.alibaba.fastjson.JSONObject;
import com.test.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by AdministratorZhang on 2019/11/22 19:53
 */
@SpringBootApplication
@MapperScan("com.test.mapper")
public class Application {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class,args);
    }

}
