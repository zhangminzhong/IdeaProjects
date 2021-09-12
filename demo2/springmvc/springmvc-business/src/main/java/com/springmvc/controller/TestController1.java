package com.springmvc.controller;

import com.springmvc.model.Person;
import com.sun.glass.ui.View;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 16-10-8
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/test")
public class TestController1 {
    @RequestMapping("/hello2.do")
    public String hello(){
        System.out.println("hello()");
        return "jsp/index";
    }
    @RequestMapping("/toPerson.do")
    public String toPerson(HttpServletRequest request){
        String result = request.getParameter("name");
        System.out.println(result);
        return "jsp/index";

    }
    @RequestMapping("/toPerson1.do")
    public String toPerson1(String name,Date date){
        System.out.println("name:"+name+",date:"+date);
        return "jsp/index";

    }

    @RequestMapping("/toPerson2.do")
    public String toPerson2(Person person){
        System.out.println(person);
        return "jsp/index";
    }

    @RequestMapping("/toPerson3.do")
    public String toPerson3(String[] name){
        for(String s:name)
            System.out.println(s);
        return "index";
    }

    @RequestMapping("/toPerson4.do")
    public ModelAndView toPerson4() throws ParseException {
        Person person = new Person();
        person.setName("james");
        person.setAge(28);
        person.setAddress("maami");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("1985-04-22");
        person.setBirthday(date);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("p",person);
        return new ModelAndView("index",map);
    }

    @RequestMapping("/toPerson5.do")
    public String toPerson5(Map<String,Object> map) throws ParseException {
        Person person = new Person();
        person.setName("james");
        person.setAge(28);
        person.setAddress("maami");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("1985-04-22");
        person.setBirthday(date);
        map.put("p",person);
        return "index";
    }

    @RequestMapping("/toPerson6.do")
    public String toPerson6(Model model) throws ParseException {
        Person person = new Person();
        person.setName("james");
        person.setAge(28);
        person.setAddress("maami");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("1985-04-22");
        person.setBirthday(date);
        model.addAttribute("p",person);
        return "index";
    }

    @RequestMapping("/ajax.do")
    public void ajax(String name,HttpServletResponse response) throws IOException {
        String result = "hello "+name;
        response.getWriter().write(result);
    }

    @RequestMapping("/ajax1.do")
    public void ajax1(String name,PrintWriter out) throws IOException {
        String result = "hello "+name;
        out.write(result);
    }

    @RequestMapping(value = "/toPerson7.do",method = RequestMethod.POST)
    public String toPerson7(Person person){
        System.out.println(person);
        return "jsp/index";
    }

    //文件上传
    @RequestMapping(value = "/toPerson8.do",method = RequestMethod.POST)
    public String toPerson8(Person person,HttpServletRequest request) throws IOException {
         System.out.println(person);
        //转化request
        MultipartHttpServletRequest rm = (MultipartHttpServletRequest) request;
        //获取文件
        CommonsMultipartFile cfile = (CommonsMultipartFile) rm.getFile("pic");
        //获取文件字节数组
        byte[] bfile = cfile.getBytes();
        String fileName = "";
        //获取当前时间最小精度
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        fileName = format.format(new Date());
        //获取三位随机数
        Random random = new Random();
        for(int i=0;i<3;i++){
            fileName += random.nextInt(9);
        }
        //获得原始文件名
        String origFileName = cfile.getOriginalFilename();
        //XXX.jpg，获取.后缀名
        String suffix = origFileName.substring(origFileName.lastIndexOf("."));
        //拿到项目部署路径
        String path = request.getSession().getServletContext().getRealPath("/");
        OutputStream os = new FileOutputStream(new File(path+"/upload/"+fileName+suffix));
        os.write(bfile);
        os.flush();
        os.close();
        return "jsp/index";
    }

    @RequestMapping("/toAjax.do")
    public String toAjax(){
        return "ajax";
    }

    @RequestMapping("/toForm.do")
    public String toForm(){
        return "form";
    }

    @RequestMapping("/redirectToForm.do")
    public String redirectToForm(){
          return "redirect:toForm.do";
    }

    @RequestMapping("/redirectToForm1.do")
    public ModelAndView redirectToForm1(){
        System.out.println("redirectToForm1()");
        return new ModelAndView("redirect:/test2/toForm.do");
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        System.out.println("initBinder(...)");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }
}
