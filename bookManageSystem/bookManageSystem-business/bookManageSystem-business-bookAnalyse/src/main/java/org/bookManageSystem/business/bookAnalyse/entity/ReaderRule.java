package org.bookManageSystem.business.bookAnalyse.entity;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 15-1-2
 * Time: 上午1:55
 * To change this template use File | Settings | File Templates.
 */
public class ReaderRule {
    private long id;
    private long readerId;
    private String itemX;
    private String itemY;
    private long appId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getReaderId() {
        return readerId;
    }

    public void setReaderId(long readerId) {
        this.readerId = readerId;
    }

    public String getItemX() {
        return itemX;
    }

    public void setItemX(String itemX) {
        this.itemX = itemX;
    }

    public String getItemY() {
        return itemY;
    }

    public void setItemY(String itemY) {
        this.itemY = itemY;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }
}
