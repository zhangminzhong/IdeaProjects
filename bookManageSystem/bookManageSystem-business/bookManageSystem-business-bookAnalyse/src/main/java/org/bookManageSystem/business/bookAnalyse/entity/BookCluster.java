package org.bookManageSystem.business.bookAnalyse.entity;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 15-1-1
 * Time: 下午11:25
 * To change this template use File | Settings | File Templates.
 */
public class BookCluster {
    private long id;
    private String clusterName;
    private String bookNumbers;
    private long appId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getBookNumbers() {
        return bookNumbers;
    }

    public void setBookNumbers(String bookNumbers) {
        this.bookNumbers = bookNumbers;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }
}
