package org.bookManageSystem.business.bookAnalyse.communication;

import org.bookManageSystem.business.bookAnalyse.algorithm.Apriori;
import org.bookManageSystem.business.bookAnalyse.algorithm.KMeans;
import org.bookManageSystem.business.bookAnalyse.entity.ReaderRule;
import org.bookManageSystem.business.bookAnalyse.entity.SubBook;
import org.bookManageSystem.business.bookAnalyse.service.BookAnalyseService;
import org.bookManageSystem.fundamental.logger.FundamentalLogger;

import javax.servlet.ServletContext;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 15-1-1
 * Time: 下午8:41
 * To change this template use File | Settings | File Templates.
 */
public class BookAnalyseTask extends TimerTask{
    private static boolean isRunning = false;
    private BookAnalyseService bookAnalyseService;
    private KMeans<SubBook> kMeans;
    private Apriori apriori = new Apriori();
    private static final FundamentalLogger logger = FundamentalLogger.getLogger(BookAnalyseTask.class);
    public BookAnalyseTask(BookAnalyseService bookAnalyseService) {
        this.bookAnalyseService = bookAnalyseService;
    }
    @Override
    public void run() {
        if (!isRunning) {
            isRunning = true;
            logger.info("正在执行");
            List<SubBook> list = bookAnalyseService.getListByAppId (1);
//            for (int i=0; i<list.size(); i++) {
//                System.out.println(list.get(i).getName());
//            }
            /**
             * 开始聚类分析，主要用于分析书之间的关系
             */
            kMeans = new KMeans<SubBook>(list,20);
            List<SubBook>[] result = kMeans.comput();
            for (int i=0; i<result.length; i++) {
                System.out.println("===========类别" + (i + 1) + "================");
                List<SubBook> l = result[i];
                for (SubBook b : l) {
                    System.out.println(b.getNumber() + "--->"
                            + b.getRentNum() + "," + b.getTotalNum() + "," + b.getBookTypeId());
                }
            }
            bookAnalyseService.addToBookCluster(result);

            /**
             * 开始关联关系分析，主要用于读者数据聚类
             */
            List<Map<String,String>> readerList = bookAnalyseService.getReaderBookByAppId(1);
            Map<String,List<String>> readerMap = new HashMap<String, List<String>>();
            List<String> readerIdList = new ArrayList<String>();
            for (Map<String,String> map:readerList) {
                String readerId = String.valueOf(map.get("readerId"));
                String bookSet = map.get("bookSet");
                if (readerMap.get(readerId) == null) {
                    readerMap.put(readerId,new ArrayList<String>());
                    readerIdList.add(readerId);
                }
                readerMap.get(readerId).add(bookSet);
            }

            for (String s:readerIdList) {
                for (int i=0;i<readerMap.get(s).size();i++) {
                    apriori.getTransList().add(readerMap.get(s).get(i));
                }
                Map<String,Integer> frequentCollectionMap=apriori.getFC();
                Map<String,Double> relationRulesMap=apriori.getRelationRules(frequentCollectionMap);
                Set<String> rrKeySet=relationRulesMap.keySet();
                for(String rrKey:rrKeySet){
                    System.out.println("readerId: " + s + " " + rrKey+"  :  "+relationRulesMap.get(rrKey));
                    String r[] = rrKey.split("->");
                    String itemX = r[0];
                    String itemY = r[1];
                    ReaderRule readerRule = new ReaderRule();
                    readerRule.setAppId(1);
                    readerRule.setItemX(itemX);
                    readerRule.setItemY(itemY);
                    readerRule.setReaderId(Long.parseLong(s));
                    bookAnalyseService.addToReaderRule(readerRule);
                }
            }
            isRunning = false;
        } else {
            logger.info("等待上次任务完成");
        }
    }
}