package org.bookManageSystem.business.book.service;

import org.bookManageSystem.business.book.entity.Book;
import org.bookManageSystem.business.book.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Steven
 * Date: 14-12-29
 * Time: 下午12:54
 * To change this template use File | Settings | File Templates.
 */
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    public void add(Book book){
        bookMapper.add(book);
    }

    public int delete(Book book){
        return bookMapper.delete(book);
    }

    public int update(Book book){
        return bookMapper.update(book);
    }

    public List<Map<String,String>> getListByAppId(long appId){
        return bookMapper.getListByAppId(appId);
    }

    public long getIdByNumber(String number,long appId){
        return bookMapper.getIdByNumber(number,appId);
    }

    public Map<String,String> findImageAndDescription(String number,long appId) {
        return bookMapper.findImageAndDescription(number,appId);
    }

    public List<Map<String,String>> search(String searchContent,String typeVal){
        return bookMapper.search(searchContent,typeVal);
    }

    public Book getBookById(long bookId){
        return bookMapper.getBookById(bookId);
    }
}
