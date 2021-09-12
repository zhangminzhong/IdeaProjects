package com.business.web;

import com.business.entity.User;
import com.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-4-5
 * Time: 下午4:52
 * To change this template use File | Settings | File Templates.
 */

@Component
@Path("/user")
public class UserServiceWeb {
    @Autowired
    UserService userService;

    @POST
    @Path("/postUser")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    public String postUser(@FormParam("username")String username,@FormParam("password")String password){
        System.out.println(username);
        User u=userService.findUserByName("zhangsan");
        System.out.println(u.getId());
        return "{'status':'OK'}";
    }

    @GET
    @Path("/getUser")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    public String getUser(){
        User u=userService.findUserByName("zhangsan");
        System.out.println(u.getId());
        return "{'status':'OK'}";
    }
}
