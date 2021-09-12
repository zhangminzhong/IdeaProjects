package com.责任链.web.filterchain;

import com.责任链.web.Request;
import com.责任链.web.Response;
import com.责任链.web.filter.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-14
 * Time: 下午4:36
 * To change this template use File | Settings | File Templates.
 */
public class FilterChain implements Filter {
    private List<Filter> filters = new ArrayList<Filter>();
    private int index = 0;

    public FilterChain addFilter(Filter f){
        filters.add(f);
        return this;
    }

    public boolean remove(Filter f){
        return filters.remove(f);
    }

    @Override
    public void doFilter(Request request, Response response,FilterChain chain) {
        if(index == filters.size())
            return;
        Filter f = filters.get(index);
        index++;
        f.doFilter(request,response,chain);
    }
}
