package com.springmvc.controller;

import com.springmvc.model.Item;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 16-10-12
 * Time: 上午10:29
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/requestJson")
public class RequestJson {

    @RequestMapping("/getJson.do")
    public @ResponseBody Item getJson(@RequestBody Item item ){
        System.out.println(item);
        return item;
    }

    @RequestMapping("/getJson1.do")
    public @ResponseBody Item getJson1(String s ){
        System.out.println(s);
        Item item=null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            item = objectMapper.readValue(s,Item.class);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return item;
    }

    @RequestMapping("/getKeyValueJson.do")
    public @ResponseBody Item getKeyValueJson( Item item ){
        System.out.println(item);
        return item;
    }

    @RequestMapping("/jsonTest.do")
    public String getJsonTest(){
        System.out.println("getJsonTest()");
        return "jsonTest";
    }
}
