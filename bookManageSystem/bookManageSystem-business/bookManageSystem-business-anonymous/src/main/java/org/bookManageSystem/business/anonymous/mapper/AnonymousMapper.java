package org.bookManageSystem.business.anonymous.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 15-1-2
 * Time: 上午3:21
 * To change this template use File | Settings | File Templates.
 */
public interface AnonymousMapper {
    public List<Map<String,String>> getCommendBook(@Param("bookTypeId")long bookTypeId,@Param("appId")long appId);
    public List<Map<String,Object>> getBestBookTypes(long appId);
}
