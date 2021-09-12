package com.test.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by AdministratorZhang on 2018/3/28.
 */
@ComponentScan("com.test.controller")
@EnableAutoConfiguration
public class AppJsp {
    public static void main(String[] args) {
        SpringApplication.run(AppJsp.class,args);
    }
}
