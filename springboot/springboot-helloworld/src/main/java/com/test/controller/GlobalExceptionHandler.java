package com.test.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AdministratorZhang on 2018/3/28.
 */
/*@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String,Object> resultError(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("errorCode","500");
        map.put("errorMsg","系统错误");
        return map;
    }
}*/
