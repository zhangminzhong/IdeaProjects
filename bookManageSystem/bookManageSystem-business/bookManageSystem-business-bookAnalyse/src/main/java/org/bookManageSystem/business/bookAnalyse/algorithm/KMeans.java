package org.bookManageSystem.business.bookAnalyse.algorithm;

import org.bookManageSystem.business.bookAnalyse.annotation.KMeansField;
import org.bookManageSystem.business.bookAnalyse.entity.SubBook;
import org.bookManageSystem.fundamental.logger.FundamentalLogger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 14-12-29
 * Time: 上午8:09
 * To change this template use File | Settings | File Templates.
 */
public class KMeans<T> {
    /**
     * 所有数据列表
     */
    private List<T> objs = new ArrayList<T>();
    /**
     * 数据类别
     */
    private Class<T> classT;
    /**
     * 初始化列表
     */
    private List<T> initObjs;
    /**
     * 需要加入算法的属性名称
     */
    private List<String> fieldNames = new ArrayList<String>();
    /**
     * 分类数
     */
    private int k = 1;

    private final static FundamentalLogger logger = FundamentalLogger.getLogger(KMeans.class);

    public List<T> getInitObjs() {
        return initObjs;
    }

    public void setInitObjs(List<T> initObjs) {
        this.initObjs = initObjs;
    }

    public KMeans(List<T> list,int k) {
        this.objs = list;
        this.k = k;
        T t = list.get(0);
        this.classT = (Class<T>)t.getClass();
        Field[] fields = this.classT.getDeclaredFields();
        for (int i=0; i<fields.length; i++) {
            Annotation KMeansAnnoation = fields[i].getAnnotation(KMeansField.class);
            if (KMeansAnnoation != null) {
                fieldNames.add(fields[i].getName());
            }
        }
        initObjs = new ArrayList<T>();
        for (int i=0; i<k; i++) {
            initObjs.add(objs.get(i));
        }
    }

    public List<T>[] comput() {
        List<T>[] results = new ArrayList[k];
        boolean centerchange = true;
        while(centerchange) {
            centerchange = false;
            for (int i = 0; i < k; i++) {
                results[i] = new ArrayList<T>();
            }
            for (int i=0; i<objs.size(); i++) {
                T t = objs.get(i);
                double[] dists = new double[k];
                for (int j=0; j<initObjs.size(); j++) {
                    T initT = initObjs.get(j);
                    double dist = distance(initT,t);
                    dists[j] = dist;
                }
                int dist_index = computOrder(dists);
                results[dist_index].add(t);
            }
            for (int i=0; i<k; i++) {
                T t_new = fieldNewCenter(results[i]);
                T t_old = initObjs.get(i);
                if (!IsObjEqual(t_new,t_old)) {
                    centerchange = true;
                    initObjs.set(i,t_new);
                }
            }
        }
        return results;
    }

    private boolean IsObjEqual(T t1, T t2) {
        if (t1 == t2) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        boolean flag = true;
        try {
            for (int i=0; i<fieldNames.size(); i++) {
                String fieldName = fieldNames.get(i);
                String getName = "get"
                        + fieldName.substring(0,1).toUpperCase()
                        + fieldName.substring(1);
                Object value1 = invokeMethod(t1,getName,null);
                Object value2 = invokeMethod(t2,getName,null);
                if (!value1.equals(value2)) {
                    flag = false;
                    break;
                }
            }
        } catch (Exception e) {
            flag = false;
            logger.error(e.getMessage());
        }
        return flag;
    }

    private T fieldNewCenter(List<T> result) {
        try {
            T t = classT.newInstance();
            if (result == null || result.size() == 0) {
                return t;
            }
            double[] ds = new double[fieldNames.size()];
            for (T vo : result) {
                for (int i=0; i<fieldNames.size(); i++) {
                    String fieldName = fieldNames.get(i);
                    String getName = "get"
                            + fieldName.substring(0,1).toUpperCase()
                            + fieldName.substring(1);
                    Object obj = invokeMethod(vo,getName,null);
                    Double fv = (obj == null ? 0 : Double.parseDouble(obj + ""));
                    ds[i] += fv;
                }
            }
            for (int i=0; i<fieldNames.size(); i++) {
                ds[i] = ds[i] / result.size();
                String fieldName = fieldNames.get(i);
                String setName = "set"
                        + fieldName.substring(0,1).toUpperCase()
                        + fieldName.substring(1);
                invokeMethod(t,setName,new Class[]{double.class},ds[i]);
            }
            return t;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private int computOrder(double[] dists) {
        double min = 0;
        int index = 0;
        for (int i=0; i<dists.length - 1; i++) {
            double dist0 = dists[i];
            if (i == 0) {
                min = dist0;
                index = 0;
            }
            double dist1 = dists[i+1];
            if (min > dist1) {
                min = dist1;
                index = i + 1;
            }
        }
        return index;  //To change body of created methods use File | Settings | File Templates.
    }

    private double distance(T t0, T t1) {
        double dis = 0;
        try {
            for (int i=0; i<fieldNames.size(); i++) {
                String fieldName = fieldNames.get(i);
                String getName = "get"
                        + fieldName.substring(0,1).toUpperCase()
                        + fieldName.substring(1);
                Double field0Value = Double.parseDouble(invokeMethod(t0,getName,null) + "");
                Double field1Value = Double.parseDouble(invokeMethod(t1,getName,null) + "");
                dis += Math.pow(field0Value - field1Value,2);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Math.sqrt(dis);  //To change body of created methods use File | Settings | File Templates.
    }

    public Object invokeMethod(Object owner, String methodName, Class[] argsClass, Object... args) {
        Class ownerClass = owner.getClass();
        try {
            Method method = ownerClass.getDeclaredMethod(methodName, argsClass);
            return method.invoke(owner,args);
        } catch (SecurityException e) {
            logger.error(e.getMessage());
        } catch (NoSuchMethodError e) {
            logger.error(e.getMessage());
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        List<SubBook> bookList = new ArrayList<SubBook>();

        for (int i=0; i<15; i++) {
            int tempNum1 = new Random(i*20).nextInt();
            int num1 = Math.abs(tempNum1)%15;
            int tempNum2 = new Random(i*20).nextInt();
            int num2 = Math.abs(tempNum2)%15;
            System.out.println("num1: " + num1 + "num2: " + num2);
            SubBook b = new SubBook();
            b.setNumber("book_" + i);
            b.setRentNum(num1);
            b.setTotalNum(2*num2);
            b.setBookTypeId(num1);
            bookList.add(b);
        }

        KMeans<SubBook> kMeans = new KMeans<SubBook>(bookList,15);
        List<SubBook>[] result = kMeans.comput();
        for (int i=0; i<result.length; i++) {
            System.out.println("===========类别" + (i + 1) + "================");
            List<SubBook> list = result[i];
            for (SubBook b : list) {
                System.out.println(b.getNumber() + "--->"
                + b.getRentNum() + "," + b.getTotalNum());
            }
        }
        List<SubBook> centers = kMeans.getInitObjs();
        for (int j=0; j< centers.size(); j++) {
            System.out.println("中心--->" + (j + 1) + centers.get(j).getNumber());
        }
    }
}
