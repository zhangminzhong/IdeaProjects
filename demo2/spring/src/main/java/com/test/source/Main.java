package com.test.source;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.*;

/**
 * Created by zhang_minzhong on 2017/7/5.
 */
public class Main {
    public static void main(String[] args) {
        //ResourceLoader resourceLoader = new DefaultResourceLoader();
        //Resource resource = resourceLoader.getResource("applicationContext.xml");
        //ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(new FileSystemResourceLoader());
        //Resource resource = resolver.getResource("F:\\新建文件夹\\人民的名义(书本网www.bookben.com).txt");
        ResourcePatternResolver resolver = new ClassPathXmlApplicationContext();
        Resource resource = resolver.getResource("test1.xml");
        BufferedReader br = null;
        String tempString = null;
        try {
            File file = resource.getFile();
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"gbk"));
            while((tempString=br.readLine())!=null)
                System.out.println(tempString);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
