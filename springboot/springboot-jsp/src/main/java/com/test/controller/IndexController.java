package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by AdministratorZhang on 2018/3/28.
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        System.out.println("index()");
        return "index";
    }
}
