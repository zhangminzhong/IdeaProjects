package com.springmvc.controller;

import com.springmvc.model.Person;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhang_minzhong on 2017/7/17.
 */
public class GenericCRUDMultiActionController extends MultiActionController {
    public ModelAndView list(HttpServletRequest request,HttpServletResponse response,Object command) throws Exception {
        System.out.println(request.getParameter("name"));
        return new ModelAndView("jsp/index");
    }
}
