package org.bookManageSystem.business.reader.mapper;

import org.apache.ibatis.annotations.Param;
import org.bookManageSystem.fundamental.orm.mapper.AbstractMapper;
import org.bookManageSystem.business.reader.entity.Reader;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: cww
 * Date: 14-12-18
 * Time: 下午2:54
 * To change this template use File | Settings | File Templates.
 */
public interface ReaderMapper extends AbstractMapper<Reader> {
    public List<Reader> getListByAppId(@Param("appId")long appId) ;
    public Reader getReaderById(@Param("id")long id,@Param("appId")long appId);
    public int deleteById(@Param("id")long id,@Param("appId")long appId);
    public String getNameById(@Param("id")long id) ;
    public Map<String,String> getReaderByUserId(@Param("userId")long userId,@Param("appId")long appId);
}
