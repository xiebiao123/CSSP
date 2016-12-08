package com.soshow.ssi.redis.service;
 
import javax.annotation.Resource;

import com.soshow.ssi.redis.dao.RedisDao;
import com.soshow.ssi.redis.dto.RedisDto;
 
public class RedisService {
      
     @Resource(name="RedisDao")
     private RedisDao RedisDao;
      
     public void setRedisDao(RedisDao RedisDao)
     {
        this.RedisDao = RedisDao;
     }
       
     public void add(RedisDto Redis){
         RedisDao.add(Redis);
     }
      
     public void delete(String key){
         RedisDao.delete(key);
     }
      
     public RedisDto get(String key)
     {
         return RedisDao.get(key);
     }
}