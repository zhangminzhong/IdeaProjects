package com.test;

import com.test.datasource.DBConfig1;
import com.test.datasource.DBConfig2;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by AdministratorZhang on 2018/3/28.
 */
//@ComponentScan(basePackages = {"com.test.controller","com.test.service"})//jdbc、jpa、mybatis
//@EnableJpaRepositories("com.test.dao")//jpa
//@EntityScan("com.test.entity")//jpa、mybatis
@MapperScan("com.test.mapper")//mybatis
//@EnableAutoConfiguration
@SpringBootApplication//整合常用注解，扫包作用，只能在当前同级包下，@Configuration配置启动、@EnableAutoConfiguration创建SpringBoot容器项目、@ComponentScan扫包
@EnableConfigurationProperties(value = { DBConfig1.class, DBConfig2.class })//分布式事务管理，启动时读取DBConfig1和DBConfig2
//@EnableScheduling//启动定时任务
@EnableAsync//启动异步注解
public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        //运行SpringBoot项目
        SpringApplication.run(App.class, args);
        LOGGER.info("SpringBoot项目启动");
    }
}
