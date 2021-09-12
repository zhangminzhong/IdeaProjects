package com.test.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by AdministratorZhang on 2018/3/30.
 */
@Service
public class RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setObject(String key,Object value,Long time){
        //redis的5种数据类型：String、list、set、zset（可以排序）、hash
        if(StringUtils.isEmpty(key) || value == null){
            return;
        }
        if(value instanceof String){
            stringRedisTemplate.opsForValue().set(key, (String) value);
            if(time!=null){
                stringRedisTemplate.opsForValue().set(key, (String) value,time, TimeUnit.SECONDS);
            }
            return;
        }
        if(value instanceof List){
            List<String> listValue = (List<String>) value;
            for(String string:listValue){
                stringRedisTemplate.opsForList().leftPush(key,string);
            }
            return;
        }

    }
}
