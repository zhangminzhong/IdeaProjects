package com.gupaoedu.example.userservice.controller;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
public class UserController {

    @NacosValue("${redis.host}")
    private String redisHost;

    @GetMapping("/users")
    public String queryUsers(){
        System.out.println("queryUsers()");
        return "user1";
    }

    @GetMapping("/getConfig")
    public String getConfig() throws NacosException {
        System.out.println(redisHost);

        String address = "127.0.0.1:8848";
        String dataId = "configtest.yml";
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put("serverAddr",address);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String config = configService.getConfig(dataId, group, 3000);
        return config;
    }
}
