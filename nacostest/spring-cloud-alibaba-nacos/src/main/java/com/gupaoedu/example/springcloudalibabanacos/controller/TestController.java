package com.gupaoedu.example.springcloudalibabanacos.controller;

import com.gupaoedu.example.springcloudalibabanacos.bean.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@ApiOperation(value = "测试控制器")
@RestController
public class TestController {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/test")
    public String test(){
        System.out.println("test()");
        return restTemplate.getForObject("http://user-service/users",String.class);
    }

    @ApiOperation(value = "swagger示例",notes = "restful风格")
    @PostMapping("/test1/getUser")
    public User getUser(@RequestBody User user){
        return user;
    }
}
