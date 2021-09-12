package org.bookManageSystem.business.reader.mapper;

import org.apache.ibatis.annotations.Param;
import org.bookManageSystem.business.reader.entity.ReaderRecord;
import org.bookManageSystem.fundamental.orm.mapper.AbstractMapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cww
 * Date: 14-12-31
 * Time: 下午4:04
 * To change this template use File | Settings | File Templates.
 */
public interface ReaderRecordMapper extends AbstractMapper<ReaderRecord> {
    public List<ReaderRecord> getListByAppId(@Param("appId")long appId) ;
    public ReaderRecord getReaderRecordById(@Param("id")long id,@Param("appId")long appId);
    public int deleteById(@Param("id")long id,@Param("appId")long appId);
    public String getBookSetById(@Param("id")long id) ;
    public String getCurBookSetByReaderId(@Param("readerId")long readerId) ;

}
