package org.bookManageSystem.business.anonymous.service;

import org.bookManageSystem.business.anonymous.mapper.AnonymousMapper;
import org.bookManageSystem.business.book.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 15-1-2
 * Time: 上午2:49
 * To change this template use File | Settings | File Templates.
 */
public class AnonymousService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private AnonymousMapper anonymousMapper;

    private Map<String,List<Map<String,String>>> commends = new HashMap<String, List<Map<String,String>>>();
    /**
     * 效率太低，放弃该方法
     */
//    public Map<String,List<Map<String,String>>> commendMap(long appId) {
//        List<Map<String,String>> l = bookMapper.getListByAppId(appId);
//        Map<String,Integer> types = new HashMap<String, Integer>();
//        List<String> typeList = new ArrayList<String>();
//        for (Map<String,String> m:l) {
//            String curType = String.valueOf(m.get("BOOKTYPEID"));
//            if (types.get(curType) == null) {
//                types.put(curType,0);
//                typeList.add(curType);
//            }
//            Integer i = types.get(curType);
//            if (Long.parseLong(String.valueOf(m.get("COUNT"))) != 0)
//            i = i + 1;
//            types.put(curType,i);
//        }
//        Integer[] integers = new Integer[l.size()];
//        String[] results = new String[l.size()];
//        for (int i=0; i<typeList.size(); i++) {
//            String curType = typeList.get(i);
//            integers[i] = types.get(curType);
//            results[i] = curType;
//        }
//
//        for (int i=typeList.size();i<l.size();i++) {
//            integers[i] = 0;
//            results[i] = "0";
//        }
//
//        for (int i=0; i<integers.length; i++) {
//            for (int j=0; j<integers.length; j++) {
//                if (integers[j] > integers[i]) {
//                    int temp = integers[j];
//                    integers[j] = integers[i];
//                    integers[i] = temp;
//
//                    String tempStr = results[j];
//                    results[j] = results[i];
//                    results[i] = tempStr;
//                }
//            }
//        }
//        for (int i=0; i<results.length; i++) {
//            System.out.println("result[i]" + results[i]);
//            if (!results[i].equals("0")) {
//                List<Map<String,String>> list = anonymousMapper.getCommendBook(Long.parseLong(results[i]),appId);
//                commends.put(results[i],list);
//            }
//        }
//        return commends;
//    }
    public List<Map<String,String>> commendBook(long bookTypeId,long appId) {
        return anonymousMapper.getCommendBook(bookTypeId, appId);
    }

    public List<Map<String,Object>> getBestBookTypes(long appId) {
        return anonymousMapper.getBestBookTypes(appId);
    }
}
