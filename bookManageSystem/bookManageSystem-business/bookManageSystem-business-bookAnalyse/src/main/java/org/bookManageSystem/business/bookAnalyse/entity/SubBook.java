package org.bookManageSystem.business.bookAnalyse.entity;

import org.bookManageSystem.business.bookAnalyse.annotation.KMeansField;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 14-12-29
 * Time: 上午9:10
 * To change this template use File | Settings | File Templates.
 */
public class SubBook {
    private Long id;
    private String name;
    private String number;
    @KMeansField
    private double rentNum;
    @KMeansField
    private double totalNum;
    @KMeansField
    private long bookTypeId;
    private String appId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public double getRentNum() {
        return rentNum;
    }

    public void setRentNum(double rentNum) {
        this.rentNum = rentNum;
    }

    public double getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(double totalNum) {
        this.totalNum = totalNum;
    }

    public long getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(long bookTypeId) {
        this.bookTypeId = bookTypeId;
    }
}
