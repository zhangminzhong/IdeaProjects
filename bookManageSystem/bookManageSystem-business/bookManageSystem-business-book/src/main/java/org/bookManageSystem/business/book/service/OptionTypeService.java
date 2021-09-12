package org.bookManageSystem.business.book.service;

import org.bookManageSystem.business.book.entity.OptionType;
import org.bookManageSystem.business.book.mapper.OptionTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cww
 * Date: 14-12-22
 * Time: 下午2:28
 * To change this template use File | Settings | File Templates.
 */
public class OptionTypeService {
    @Autowired
    private OptionTypeMapper optionTypeMapper;

    public void add(OptionType optionType){
        optionTypeMapper.add(optionType);
    }

    public int delete(OptionType optionType){
        return optionTypeMapper.delete(optionType);
    }

    public int update(OptionType optionType){
        return optionTypeMapper.update(optionType);
    }

    public int deleteById(long id,long appId){
        return optionTypeMapper.deleteById(id,appId);
    }

    public List<OptionType> getListByAppId(long appId){
        return optionTypeMapper.getListByAppId(appId);
    }

    public OptionType getOptionTypeById(long id,long appId){
        return optionTypeMapper.getOptionTypeById(id, appId);
    }
}
