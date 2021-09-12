package org.bookManageSystem.business.reader.entity;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: cww
 * Date: 14-12-31
 * Time: 下午3:32
 * To change this template use File | Settings | File Templates.
 */
public class ReaderRecord {
    private long id;
    private long readerId;
    private String bookSet;
    private long optionTypeId;
    private Date createTime;
    private String curBookSet;
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

    public String getBookSet() {
        return bookSet;
    }

    public void setBookSet(String bookSet) {
        this.bookSet = bookSet;
    }

    public long getOptionTypeId() {
        return optionTypeId;
    }

    public void setOptionTypeId(long optionTypeId) {
        this.optionTypeId = optionTypeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public String getCurBookSet() {
        return curBookSet;
    }

    public void setCurBookSet(String curBookSet) {
        this.curBookSet = curBookSet;
    }
}
