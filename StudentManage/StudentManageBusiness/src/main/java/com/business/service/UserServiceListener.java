package com.business.service;

import com.business.entity.User;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-4-5
 * Time: 下午3:45
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceListener extends ContextLoaderListener {
    private UserService userService;
    private WebApplicationContext context;
    @Override
    public void contextInitialized(ServletContextEvent event) {
        context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
        userService = (UserService) context.getBean("userService");
        User user = userService.findUserByName("admin");
        System.out.println(user.getUsername());
    }
}
