package com.soshow.ssi.base;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * @author xieb 
 */
@SuppressWarnings("hiding")
@Component
public abstract class MongoBaseDaoImpl<T> implements MongoBaseDao<T>{

    @Autowired
    protected MongoTemplate mongoTemplate;
    
    /**
     * 获取集合的名称
     * @return
     */
    public abstract String getCollectionName();
    /**
     * 获取实体的名称
     * @return
     */
    public abstract Class<T> getEntityClass();
    /**
     * 新增   
     * @param t
     * @return
     */
    public T save(T t){
        this.mongoTemplate.save(t,this.getCollectionName());;
		return t;
    }    
    
    /**
     * 删除   
     * @param t
     * @return
     */
    public int remove(T t){
        return this.mongoTemplate.remove(t, this.getCollectionName()).getN();
    }    
    
    /**
     * 修改满足条件的第一条数据
     * @param query
     * @param update
     * @return
     */
    public int updateFirst(Query query,Update update){
    	return this.mongoTemplate.updateFirst(query, update, this.getCollectionName()).getN();
    }  
    
    /**
     * 修改满足条件的所有数据
     * @param query
     * @param update
     * @return
     */
    public int updateMulti(Query query,Update update){
    	return this.mongoTemplate.updateMulti(query, update, this.getCollectionName()).getN();
    }    
    
    /**
     * 根据Id查找
     * @param id
     * @return
     */
    public T findById(String id){
        return this.mongoTemplate.findById(id, this.getEntityClass(), this.getCollectionName());
    }    
    
    /**
     * 根据条件查找
     * @param query
     * @return
     */
    public List<T> findByCondition(Query query){
        return this.mongoTemplate.find(query, this.getEntityClass(),this.getCollectionName());
    }    
    
    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param query
     * @return
     */
    public List<T> findPageByCondition(int pageNo,int pageSize,Query query){
    	//skip从那条记录开始读取数据
    	query.skip((pageNo-1)*pageSize);
    	//从skip位置读取limit条数据
    	query.limit(pageSize);
    	return this.mongoTemplate.find(query, this.getEntityClass(),this.getCollectionName());
    }    
    
    /**
     * 统计条数
     * @param query
     * @return
     */
    public long count(Query query){
        return this.mongoTemplate.count(query, this.getEntityClass(),this.getCollectionName());
    }    
}