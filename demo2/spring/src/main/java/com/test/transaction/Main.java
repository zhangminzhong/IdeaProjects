package com.test.transaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by zhang_minzhong on 2017/7/12.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IQuoteService quoteService = (IQuoteService) ctx.getBean("quoteServiceTarget");
        quoteService.deleteQuote(new Quote());
    }
}
