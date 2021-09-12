package com.business.web;

import com.business.entity.User;
import com.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-4-4
 * Time: 下午4:12
 * To change this template use File | Settings | File Templates.
 */
@Component
@Path("/user")
public class UserServiceWeb {
    @Autowired
    UserService userService;
    @Context
    HttpServletRequest request;
    @Context
    HttpServletResponse response;

    @POST
    @Path("/validation")
    //@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    public String setSession(@FormParam("username") String username,@FormParam("password") String password,@FormParam("checkCode") String checkCode,@FormParam("imageCheck") String imageCeck){
        System.out.println(username+":"+password);
        if(!checkCode.equals(imageCeck))
            return "验证码错误！";
        User u = userService.findUserByName(username);
        if(u!=null&&u.getPassword().equals(password)){
            System.out.println(u.getId()+":"+u.getUsername()+":"+u.getPassword());
            request.getSession().setAttribute("user",u);
            return "admin/index.html";
        }
        else
            return "fail";
    }
    @GET
    @Path("/getUserName")
    public String getUserName(){
        User u = (User) request.getSession().getAttribute("user");
        if(u != null)
            return u.getUsername();
        else
            return "fail";
    }
    @GET
    @Path("/cancelUser")
    public String removeUser(){
        request.getSession().removeAttribute("user");
        return "OK";
    }

    @POST
    @Path("/register")
    public String addUser(@FormParam("username") String username,@FormParam("password") String password){
        User user = userService.findUserByName(username);
        if(user != null){
                return "fail";
        }
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
       try{
           userService.addUser(u);
       }catch (Exception e){
           e.printStackTrace();
           return "inserterror";
       }
        return "success";

    }
}
