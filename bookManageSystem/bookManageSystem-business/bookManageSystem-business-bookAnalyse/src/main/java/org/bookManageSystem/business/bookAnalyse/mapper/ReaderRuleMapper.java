package org.bookManageSystem.business.bookAnalyse.mapper;

import org.apache.ibatis.annotations.Param;
import org.bookManageSystem.business.bookAnalyse.entity.ReaderRule;
import org.bookManageSystem.fundamental.orm.mapper.AbstractMapper;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 15-1-2
 * Time: 上午1:57
 * To change this template use File | Settings | File Templates.
 */
public interface ReaderRuleMapper extends AbstractMapper<ReaderRule> {
    public List<Map<String,String>> getRulesByReaderId(@Param("readerId")long readerId,@Param("appId")long appId);
}
