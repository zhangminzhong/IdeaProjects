package org.bookManageSystem.business.anonymous.service;

import org.bookManageSystem.business.anonymous.entity.AnonymousUser;
import org.bookManageSystem.business.anonymous.entity.AnonymousUserAuthority;
import org.bookManageSystem.business.anonymous.mapper.AnonymousUserAuthorityMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: MikuKing
 * Date: 14-12-28
 * Time: 下午4:05
 * To change this template use File | Settings | File Templates.
 */
public class AnonymousUserAuthorityService {
    @Autowired
    private AnonymousUserAuthorityMapper anonymousUserAuthorityMapper;
    public void add(AnonymousUserAuthority anonymousUserAuthority){
       anonymousUserAuthorityMapper.add(anonymousUserAuthority);
    };
}
