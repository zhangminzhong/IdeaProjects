package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by AdministratorZhang on 2018/3/28.
 */
@Controller
public class IndexController {

    @RequestMapping("/IndexController")
    public String index(Map<String,Object> result){
        //int i = 1/0;
        //System.out.println("IndexController...index");
        result.put("name","zhangsan");
        result.put("sex","1");
        List<String> list = new ArrayList<String>();
        list.add("lisi");
        list.add("wangwu");
        result.put("userlist",list);
        return "index";
    }
}
