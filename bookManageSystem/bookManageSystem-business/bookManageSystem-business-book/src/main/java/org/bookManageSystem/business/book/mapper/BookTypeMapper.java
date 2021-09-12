package org.bookManageSystem.business.book.mapper;

import org.apache.ibatis.annotations.Param;
import org.bookManageSystem.business.book.entity.BookType;
import org.bookManageSystem.fundamental.orm.mapper.AbstractMapper;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Steven
 * Date: 15-1-1
 * Time: 下午2:29
 * To change this template use File | Settings | File Templates.
 */
public interface BookTypeMapper extends AbstractMapper<BookType> {
    public List<Map<String,String>> getListByAppId(long appId);
    public long getIdByName(@Param("name")String name,@Param("appId")long appId);
}
