package org.bookManageSystem.business.book.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Steven
 * Date: 14-12-29
 * Time: 下午12:53
 * To change this template use File | Settings | File Templates.
 */
public class Book {
    private long id;
    private String name;
    private String number;
    private long prefixId;
    private long bookTypeId;
    private long count;
    private long rentNumber;
    private long appId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getPrefixId() {
        return prefixId;
    }

    public void setPrefixId(long prefixId) {
        this.prefixId = prefixId;
    }

    public long getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(long bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getRentNumber() {
        return rentNumber;
    }

    public void setRentNumber(long rentNumber) {
        this.rentNumber = rentNumber;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }
}
