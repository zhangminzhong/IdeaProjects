package org.bookManageSystem.business.book.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Steven
 * Date: 14-12-29
 * Time: 下午12:59
 * To change this template use File | Settings | File Templates.
 */
public class BookType {
    private long id;
    private String name;
    private String description;
    private long appId;

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
