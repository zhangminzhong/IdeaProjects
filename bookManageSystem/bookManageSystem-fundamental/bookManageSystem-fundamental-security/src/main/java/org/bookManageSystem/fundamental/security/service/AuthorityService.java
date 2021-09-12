package org.bookManageSystem.fundamental.security.service;
import org.bookManageSystem.fundamental.security.entity.Authority;
import org.bookManageSystem.fundamental.security.mapper.AuthorityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xiaozhujun
 * Date: 14-3-16
 * Time: 下午8:16
 * To change this template use File | Settings | File Templates.
 */
public class AuthorityService {
     @Autowired
     private AuthorityMapper mapper;

     public void add(Authority authority){
         mapper.add(authority);
     }

     public int update(Authority authority){
         return mapper.update(authority);
     }

     public int delete(Authority authority){
         return mapper.delete(authority);
     }

     public List<Authority> list(){
         return mapper.findByCondition(new HashMap<String, Object>());
     }


     public long getIdByName(String name){
         return mapper.getIdByName(name);
     }

    public String getNameById(long id)
    {
        return mapper.getNameById(id);
    }
}
