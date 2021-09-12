package com.springmvc.controller;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by zhang_minzhong on 2017/7/17.
 */
public class TestFileUploadController extends AbstractController{

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //System.out.println(httpServletRequest instanceof MultipartHttpServletRequest);
        MultipartHttpServletRequest request = (MultipartHttpServletRequest) httpServletRequest;
        MultipartFile mulFile =  request.getFile("fileUpload");
        byte[] bytes = mulFile.getBytes();
        String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Random random = new Random();
        for(int i=0;i<3;i++)
            fileName += random.nextInt();
        String originalFilename = mulFile.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        fileName += suffix;
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File file = new File(path+"/"+fileName);
        OutputStream os = new FileOutputStream(file);
        os.write(bytes);
        os.flush();
        os.close();
        return new ModelAndView("jsp/index");
    }
}
