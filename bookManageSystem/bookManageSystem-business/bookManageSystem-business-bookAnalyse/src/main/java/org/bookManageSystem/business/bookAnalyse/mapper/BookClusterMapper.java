package org.bookManageSystem.business.bookAnalyse.mapper;

import org.bookManageSystem.business.bookAnalyse.entity.BookCluster;
import org.bookManageSystem.fundamental.orm.mapper.AbstractMapper;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 15-1-1
 * Time: 下午11:30
 * To change this template use File | Settings | File Templates.
 */
public interface BookClusterMapper extends AbstractMapper<BookCluster>{
    public List<Map<String,String>> getClusterByAppId(long appId);
}
