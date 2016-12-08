package com.soshow.ssi.redis.dao.impl;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.soshow.ssi.redis.dao.RedisDao;
import com.soshow.ssi.redis.dao.RedisGeneratorDao;
import com.soshow.ssi.redis.dto.RedisDto;
 
@Repository(value="RedisDtoDao")
public class RedisDaoImpl extends RedisGeneratorDao<String,RedisDto> implements RedisDao{
   
  /**
   * 添加对象
   */
  public boolean add(final RedisDto redisDto) { 
    boolean result = redisTemplate.execute(new RedisCallback<Boolean>() { 
      public Boolean doInRedis(RedisConnection connection) 
          throws DataAccessException { 
        RedisSerializer<String> serializer = getRedisStringSerializer(); 
        byte[] key  = serializer.serialize(redisDto.getKeyString()); 
        byte[] value = serializer.serialize(redisDto.getValueString()); 
        return connection.setNX(key, value); 
      } 
    }); 
    return result; 
  } 
 
  /**
   * 添加集合
   */
  public boolean add(final List<RedisDto> list) {
    Assert.notEmpty(list); 
    boolean result = redisTemplate.execute(new RedisCallback<Boolean>() { 
      public Boolean doInRedis(RedisConnection connection) 
          throws DataAccessException { 
        RedisSerializer<String> serializer = getRedisStringSerializer(); 
        for (RedisDto redisDto : list) { 
          byte[] key  = serializer.serialize(redisDto.getKeyString()); 
          byte[] value = serializer.serialize(redisDto.getValueString()); 
          connection.setNX(key, value); 
        } 
        return true; 
      } 
    }, false, true); 
    return result;
  } 
   
  /**
   * 删除对象 ,依赖key
   */
  public void delete(String key) { 
    List<String> list = new ArrayList<String>(); 
    list.add(key); 
    delete(list); 
  } 
   
  /**
   * 删除集合 ,依赖key集合
   */
  public void delete(List<String> keys) { 
    redisTemplate.delete(keys); 
  } 
   
  /**
   * 修改对象
   */
  public boolean update(final RedisDto redisDto) { 
    String key = redisDto.getKeyString(); 
    if (get(key) == null) { 
      throw new NullPointerException("数据行不存在, key = " + key); 
    } 
    boolean result = redisTemplate.execute(new RedisCallback<Boolean>() { 
      public Boolean doInRedis(RedisConnection connection) 
          throws DataAccessException { 
        RedisSerializer<String> serializer = getRedisStringSerializer(); 
        byte[] key  = serializer.serialize(redisDto.getKeyString()); 
        byte[] value = serializer.serialize(redisDto.getValueString()); 
        connection.set(key, value); 
        return true; 
      } 
    }); 
    return result; 
  } 
   
  /**
   * 根据key获取对象
   */
  public RedisDto get(final String keyString) { 
    RedisDto result = redisTemplate.execute(new RedisCallback<RedisDto>() { 
      public RedisDto doInRedis(RedisConnection connection) 
          throws DataAccessException { 
        RedisSerializer<String> serializer = getRedisStringSerializer(); 
        byte[] key = serializer.serialize(keyString); 
        byte[] value = connection.get(key);
        if (value == null) { 
          return null; 
        } 
        String valueString = serializer.deserialize(value);
        RedisDto redisDto = new RedisDto();
        redisDto.setKeyString(keyString);
        redisDto.setValueString(valueString);
        return redisDto; 
      } 
    }); 
    return result; 
  } 
 
}
 