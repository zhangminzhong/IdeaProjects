package org.bookManageSystem.business.book.mapper;

import org.apache.ibatis.annotations.Param;
import org.bookManageSystem.business.book.entity.Book;
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
public interface BookMapper extends AbstractMapper<Book> {
    public List<Map<String,String>> getListByAppId(long appId);
    public long getIdByNumber(@Param("number")String number,@Param("appId")long appId);
    public Map<String,String> findImageAndDescription(@Param("number")String number,@Param("appId")long appId);
    public List<Map<String,String>> search(@Param("searchContent")String searchContent,@Param("typeVal")String typeVal);
    public Book getBookById(@Param("bookId")long bookId);
}
