package com.example.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

/**
 * @author zhang minzhong
 * @date 2021/9/21 10:02
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ApplicationTest {

    public void setUp() throws Exception {
    }

    public void tearDown() throws Exception {
    }

    @Test
    public void testUpload() throws Exception {
        String uploadFilePath="D:\\new.txt";
        File file = new File(uploadFilePath);
    }
}