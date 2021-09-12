package org.bookManageSystem.business.book.mapper;

import org.apache.ibatis.annotations.Param;
import org.bookManageSystem.business.book.entity.OptionType;
import org.bookManageSystem.fundamental.orm.mapper.AbstractMapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cww
 * Date: 14-12-22
 * Time: 下午2:27
 * To change this template use File | Settings | File Templates.
 */
public interface OptionTypeMapper extends AbstractMapper<OptionType> {
    public List<OptionType> getListByAppId(@Param("appId")long appId) ;
    public OptionType getOptionTypeById(@Param("id")long id,@Param("appId")long appId);
    public int deleteById(@Param("id")long id,@Param("appId")long appId);
}
