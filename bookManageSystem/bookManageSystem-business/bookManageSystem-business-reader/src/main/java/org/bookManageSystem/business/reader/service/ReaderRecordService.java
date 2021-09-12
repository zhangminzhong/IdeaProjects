package org.bookManageSystem.business.reader.service;

import org.bookManageSystem.business.reader.entity.ReaderRecord;
import org.bookManageSystem.business.reader.mapper.ReaderRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cww
 * Date: 14-12-31
 * Time: 下午4:34
 * To change this template use File | Settings | File Templates.
 */
public class ReaderRecordService {
    @Autowired
    private ReaderRecordMapper readerRecordMapper;

    public void add(ReaderRecord readerRecord){
        readerRecordMapper.add(readerRecord);
    }

    public int delete(ReaderRecord readerRecord){
        return readerRecordMapper.delete(readerRecord);
    }

    public int update(ReaderRecord readerRecord){
        return readerRecordMapper.update(readerRecord);
    }

    public int deleteById(long id,long appId){
        return readerRecordMapper.deleteById(id,appId);
    }

    public List<ReaderRecord> getListByAppId(long appId){
        return readerRecordMapper.getListByAppId(appId);
    }

    public ReaderRecord getReaderRecordById(long id,long appId){
        return readerRecordMapper.getReaderRecordById(id,appId);
    }

    public String getBookSetById(long id){
        return readerRecordMapper.getBookSetById(id);
    }

    public String getCurBookSetByReaderId(long readerId){
        return readerRecordMapper.getCurBookSetByReaderId(readerId);
    }
}
