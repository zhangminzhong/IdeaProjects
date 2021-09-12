package org.bookManageSystem.business.anonymous.entity;

/**
 * Created with IntelliJ IDEA.
 * User: MikuKing
 * Date: 14-12-28
 * Time: 下午4:04
 * To change this template use File | Settings | File Templates.
 */
public class AnonymousUserAuthority {
    private Long id;
    private Long userId;
    private Long authorityId;
    private String userName;
    private String authorityName;

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public String getUserName() {
        return userName;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
