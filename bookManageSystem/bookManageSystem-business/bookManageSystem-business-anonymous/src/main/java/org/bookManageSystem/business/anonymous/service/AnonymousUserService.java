package org.bookManageSystem.business.anonymous.service;

import org.bookManageSystem.business.anonymous.entity.AnonymousUser;
import org.bookManageSystem.business.anonymous.mapper.AnonymousUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * AnonymousUser: MikuKing
 * Date: 14-12-22
 * Time: 下午3:23
 * To change this template use File | Settings | File Templates.
 */
public class AnonymousUserService {
    @Autowired
    private AnonymousUserMapper anonymousUserMapper;

    public void add(AnonymousUser user) {
        anonymousUserMapper.add(user);
    }

    public Long getIdByName(String name) {
        return anonymousUserMapper.getIdByName(name);
    }
}
