package org.bookManageSystem.business.bookAnalyse.service;

import org.bookManageSystem.business.bookAnalyse.entity.BookCluster;
import org.bookManageSystem.business.bookAnalyse.entity.ReaderRule;
import org.bookManageSystem.business.bookAnalyse.entity.SubBook;
import org.bookManageSystem.business.bookAnalyse.mapper.BookAnalyseMapper;
import org.bookManageSystem.business.bookAnalyse.mapper.BookClusterMapper;
import org.bookManageSystem.business.bookAnalyse.mapper.ReaderRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 15-1-1
 * Time: 下午8:20
 * To change this template use File | Settings | File Templates.
 */
public class BookAnalyseService {
    @Autowired
    private BookAnalyseMapper bookAnalyseMapper;
    @Autowired
    private BookClusterMapper bookClusterMapper;
    @Autowired
    private ReaderRuleMapper readerRuleMapper;

    public List<SubBook> getListByAppId(long appId) {
        return bookAnalyseMapper.getSubBookList(appId);
    }

    public void addToBookCluster(List<SubBook>[] lists) {
        for (int i=0; i<lists.length; i++) {
            BookCluster bookCluster = new BookCluster();
            String tempStr = "";
            List<SubBook> l = lists[i];
            for (SubBook b : l) {
                tempStr += b.getNumber() + ";";
            }
//            System.out.println(tempStr);
            bookCluster.setAppId(1);
            bookCluster.setClusterName("聚类" + i);
            bookCluster.setBookNumbers(tempStr);
            bookClusterMapper.add(bookCluster);
        }
    }

    public List<Map<String,String>> getReaderBookByAppId(long appId) {
        return bookAnalyseMapper.getReaderBookByAppId(appId);
    }

    public void addToReaderRule(ReaderRule readerRule) {
        readerRuleMapper.add(readerRule);
    }

    public List<Map<String,String>> getReaderRuleByReaderId(long readerId,long appId) {
        return readerRuleMapper.getRulesByReaderId(readerId, appId);
    }

    public List<Map<String,String>> getClusterByAppId(long appId) {
        return bookClusterMapper.getClusterByAppId(appId);
    }

    public List<Map<String,String>> getReaderBookByUserId(long userId,long appId) {
        return bookAnalyseMapper.getReaderBookByUserId(userId, appId);
    }

    public List<Map<String,String>> getReaderCommendsList(long userId,long appId) {
        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        List<Map<String,String>> books = bookAnalyseMapper.getReaderBookByUserId(userId,appId);
        List<Map<String,String>> rules = readerRuleMapper.getRulesByReaderId(userId, appId);
        List<String> bookIds = new ArrayList<String>();
        List<String> readerBooks = new ArrayList<String>();
        for (int v = 0; v<books.size(); v++) {
            readerBooks.add(v,books.get(v).get("id"));
        }
        System.out.println(readerBooks);
        //关联规则推荐
        for (int i=0; i< books.size(); i++) {
            String bookId = String.valueOf(books.get(i).get("id"));
            for (int j=0;j<rules.size();j++) {
                if (rules.get(j).get("itemX").contains(bookId)) {
                    String[] temp = rules.get(j).get("itemY").split(";");
                    for (int m=0; m<temp.length; m++) {
                        if (!bookIds.contains(temp[m])) {
                            bookIds.add(temp[m]+"");
                        }
                    }
                }
            }
        }

        for (int k=0;k<bookIds.size();k++) {
            for (int p=0;p<readerBooks.size();p++) {
                if (bookIds.get(k).equals(String.valueOf(readerBooks.get(p)))) {
                    bookIds.set(k,"0");
                }
            }
        }

        for (int k=0; k<bookIds.size();k++) {
            if (!bookIds.get(k).equals("0")) {
                Map<String,String> tempMap = bookAnalyseMapper.getBookById(Long.parseLong(bookIds.get(k)),appId);
                list.add(tempMap);
            }
        }
        //聚类分析推荐
        List<Map<String,String>> clusters = bookClusterMapper.getClusterByAppId(appId);
        List<String> bookNumbers = new ArrayList<String>();
        List<String> readerNumbers = new ArrayList<String>();

        for (int v = 0; v<books.size(); v++) {
            String tempNum = bookAnalyseMapper.getNumberById(Long.parseLong(String.valueOf(readerBooks.get(v))),appId);
            readerNumbers.add(tempNum);
        }

        for (int p=0;p<readerNumbers.size();p++) {
            for (int v=0;v<clusters.size();v++) {
                if (clusters.get(v).get("bookNumbers").contains(readerNumbers.get(p))) {
                    String[] temp = clusters.get(v).get("bookNumbers").split(";");
                    for (int m=0; m<temp.length; m++) {
                        if (!bookNumbers.contains(temp[m])) {
                            bookNumbers.add(temp[m]+"");
                        }
                    }
                }
            }
        }

        for (int k=0;k<bookNumbers.size();k++) {
            for (int p=0;p<readerBooks.size();p++) {
                if (bookNumbers.get(k).equals(String.valueOf(readerNumbers.get(p)))) {
                    bookNumbers.set(k,"0");
                }
            }
        }

        for (int k=0; k<bookNumbers.size();k++) {
            if (!bookNumbers.get(k).equals("0")) {
                Map<String,String> tempMap = bookAnalyseMapper.getBookByNumber(bookNumbers.get(k),appId);
                list.add(tempMap);
            }
        }
        return list;
    }
}
