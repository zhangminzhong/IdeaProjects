package org.bookManageSystem.business.reader.entity;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: cww
 * Date: 14-12-18
 * Time: 下午2:50
 * To change this template use File | Settings | File Templates.
 */
public class Reader {
    private long id;
    private long userId;
    private String name;
    private String number;
    private String sex;
    private Date createTime;
    private long appId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
