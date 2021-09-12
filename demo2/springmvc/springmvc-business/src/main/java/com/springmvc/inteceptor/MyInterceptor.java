package com.springmvc.inteceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 16-10-8
 * Time: 下午6:51
 * To change this template use File | Settings | File Templates.
 */
public class MyInterceptor implements HandlerInterceptor {

    //执行时机：controller之前执行
    //返回值类型：true代表放行，可以访问controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("preHandle(...)");
        return true;
    }

    //执行时机：controller执行完，视图解析器没有解析成页面
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle(...)");
        //Map<String,Object> map = modelAndView.getModel();
       // map.put("test","append something");
    }

    //执行时机：视图解析完毕，类似try catch finally中的finally
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion(...)");
        //e.printStackTrace();
    }
}
