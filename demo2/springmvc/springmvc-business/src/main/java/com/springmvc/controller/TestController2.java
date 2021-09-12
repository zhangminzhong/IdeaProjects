package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 16-10-8
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/test2")
public class TestController2 {


    @RequestMapping("/toForm.do")
    public String toForm(){
        return "form";
    }

}
