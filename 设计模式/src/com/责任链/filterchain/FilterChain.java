package com.责任链.filterchain;

import com.责任链.filter.Filter;

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

    public FilterChain addFilter(Filter f){
        filters.add(f);
        return this;
    }

    public boolean remove(Filter f){
        return filters.remove(f);
    }

    public String doFilter(String s){
        String r = s;
        for(Filter f:filters){
            r = f.doFilter(r);
        }
        return r;
    }
}
