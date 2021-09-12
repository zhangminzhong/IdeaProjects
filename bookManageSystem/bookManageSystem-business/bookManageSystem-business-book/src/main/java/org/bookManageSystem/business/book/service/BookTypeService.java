package org.bookManageSystem.business.book.service;

import org.bookManageSystem.business.book.entity.BookType;
import org.bookManageSystem.business.book.mapper.BookTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Steven
 * Date: 14-12-29
 * Time: 下午1:00
 * To change this template use File | Settings | File Templates.
 */
public class BookTypeService {
    @Autowired
    private BookTypeMapper bookTypeMapper;

    public void add(BookType bookType){
        bookTypeMapper.add(bookType);
    }

    public int delete(BookType bookType){
        return bookTypeMapper.delete(bookType);
    }

    public int update(BookType bookType){
        return bookTypeMapper.update(bookType);
    }

    public List<Map<String,String>> getListByAppId(long appId){
        return bookTypeMapper.getListByAppId(appId);
    }

    public long getIdByName(String name,long appId){
        return bookTypeMapper.getIdByName(name,appId);
    }
}
