package org.bookManageSystem.business.book.entity;

/**
 * Created with IntelliJ IDEA.
 * User: cww
 * Date: 14-12-22
 * Time: 下午2:26
 * To change this template use File | Settings | File Templates.
 */
public class OptionType {
    private long id;
    private String name;
    private String description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }
}
