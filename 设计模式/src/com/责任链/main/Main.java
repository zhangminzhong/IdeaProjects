package com.责任链.main;

import com.责任链.filter.FaceFilter;
import com.责任链.filterchain.FilterChain;
import com.责任链.filter.HTMLFilter;
import com.责任链.filter.SensitiveFilter;
import com.责任链.process.MessageProcessor;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-14
 * Time: 下午3:32
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        String msg = "大家好：），<script>，敏感，被就业,敏感";
        MessageProcessor messageProcessor = new MessageProcessor();
        messageProcessor.setMessage(msg);
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HTMLFilter())
                .addFilter(new SensitiveFilter());
        FilterChain filterChain1 = new FilterChain();
        filterChain1.addFilter(new FaceFilter());
        filterChain.addFilter(filterChain1);
        messageProcessor.setFilterChain(filterChain);
        String result = messageProcessor.procss();
        System.out.println(result);
    }
}
