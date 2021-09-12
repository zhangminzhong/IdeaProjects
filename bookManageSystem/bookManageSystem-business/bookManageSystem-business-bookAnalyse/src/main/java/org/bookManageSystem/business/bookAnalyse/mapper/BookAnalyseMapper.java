package org.bookManageSystem.business.bookAnalyse.mapper;

import org.apache.ibatis.annotations.Param;
import org.bookManageSystem.business.bookAnalyse.entity.SubBook;
import org.bookManageSystem.fundamental.orm.mapper.AbstractMapper;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 15-1-1
 * Time: 下午9:00
 * To change this template use File | Settings | File Templates.
 */
public interface BookAnalyseMapper extends AbstractMapper<SubBook> {
    public List<SubBook> getSubBookList(long appId);
    public List<Map<String,String>> getReaderBookByAppId(long appId);
    public List<Map<String,String>> getReaderBookByUserId(@Param("userId")long userId,@Param("appId")long appId);
    public Map<String,String> getBookById(@Param("id")long id,@Param("appId")long appId);
    public Map<String,String> getBookByNumber(@Param("number")String number,@Param("appId")long appId);
    public String getNumberById(@Param("id")long id,@Param("appId")long appId);
}
