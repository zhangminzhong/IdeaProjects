package org.bookManageSystem.business.book.service;

import org.bookManageSystem.business.book.entity.Prefix;
import org.bookManageSystem.business.book.mapper.PrefixMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cww
 * Date: 14-12-22
 * Time: 下午2:28
 * To change this template use File | Settings | File Templates.
 */
public class PrefixService {
    @Autowired
    private PrefixMapper prefixMapper;

    public void add(Prefix prefix){
        prefixMapper.add(prefix);
    }

    public int delete(Prefix prefix){
        return prefixMapper.delete(prefix);
    }

    public int update(Prefix prefix){
        return prefixMapper.update(prefix);
    }

    public int deleteById(long id,long appId){
        return prefixMapper.deleteById(id,appId);
    }

    public List<Prefix> getListByAppId(long appId){
        return prefixMapper.getListByAppId(appId);
    }

    public Prefix getPrefixById(long id,long appId){
        return prefixMapper.getPrefixById(id, appId);
    }
}
