package com.springmvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 16-9-30
 * Time: 下午4:09
 * To change this template use File | Settings | File Templates.
 */
public class TestController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("hello springmvc!");
        return new ModelAndView("index");  //To change body of implemented methods use File | Settings | File Templates.
    }
}
