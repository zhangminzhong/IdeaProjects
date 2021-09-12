package org.bookManageSystem.business.reader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.bookManageSystem.business.reader.entity.Reader;
import org.bookManageSystem.business.reader.mapper.ReaderMapper;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: cww
 * Date: 14-12-18
 * Time: 下午2:58
 * To change this template use File | Settings | File Templates.
 */
public class ReaderService {
    @Autowired
    private ReaderMapper readerMapper;

    public void add(Reader reader){
        readerMapper.add(reader);
    }

    public int delete(Reader reader){
        return readerMapper.delete(reader);
    }

    public int update(Reader reader){
        return readerMapper.update(reader);
    }

    public int deleteById(long id,long appId){
        return readerMapper.deleteById(id,appId);
    }

    public List<Reader> getListByAppId(long appId){
        return readerMapper.getListByAppId(appId);
    }

    public Reader getReaderById(long id,long appId){
        return readerMapper.getReaderById(id,appId);
    }

    public String getNameById(long id){
        return readerMapper.getNameById(id);
    }

    public Map<String,String> getReaderByUserId(long userId,long appId) {
        return  readerMapper.getReaderByUserId(userId, appId);
    }
}
