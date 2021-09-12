package org.bookManageSystem.business.anonymous.mapper;

import org.apache.ibatis.annotations.Param;
import org.bookManageSystem.business.anonymous.entity.AnonymousUser;
import org.bookManageSystem.fundamental.orm.mapper.AbstractMapper;

/**
 * Created with IntelliJ IDEA.
 * AnonymousUser: MikuKing
 * Date: 14-12-22
 * Time: 下午3:22
 * To change this template use File | Settings | File Templates.
 */
public interface AnonymousUserMapper extends AbstractMapper<AnonymousUser>{
    public Long getIdByName(@Param("name")String name);
}
