package com.itheima.service.impl;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.apache.dubbo.config.annotation.Service;

//@Service//将该类对象创建出来放到Spring IOC容器中
//dubbo的注解，将类提供的方法（服务）对外发布。将访问地址、ip、端口、路径放到注册中心
@Service(timeout = 3000,retries = 2,version = "2.0")//3秒超时
public class UserServiceImpl2 implements UserService {

    public String sayHello() {
        return "hello dubbo! hello dubbo!";
    }

    int i=1;
    public User findUserById(int id) {
//        System.out.println("服务被调用了"+(i++)+"次");
        System.out.println("new...");
        User user = new User(1,"zhangsan","123");
        return user;
    }
}
