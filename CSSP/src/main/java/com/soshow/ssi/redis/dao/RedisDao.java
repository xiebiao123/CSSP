package com.soshow.ssi.redis.dao;
 
import java.util.List;

import com.soshow.ssi.redis.dto.RedisDto;
 
public interface RedisDao {
	
    boolean add(RedisDto redisDto);
 
    abstract boolean add(List<RedisDto> list);
 
    void delete(String key);
 
    RedisDto get(String key);
     
}