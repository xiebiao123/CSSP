package com.soshow.ssi.base;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * @author xieb 
 */
@SuppressWarnings("hiding")
public interface MongoBaseDao<T>{
    
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
    public T save(T t);   
    
    /**
     * 删除   
     * @param t
     * @return
     */
    public void remove(T t);    
    
    /**
     * 修改满足条件的第一条数据
     * @param query
     * @param update
     * @return
     */
    public int updateFirst(Query query,Update update); 
    
    /**
     * 修改满足条件的所有数据
     * @param query
     * @param update
     * @return
     */
    public int updateMulti(Query query,Update update);   
    
    /**
     * 根据Id查找
     * @param id
     * @return
     */
    public T findById(String id); 
    
    /**
     * 根据条件查找
     * @param query
     * @return
     */
    public List<T> findByCondition(Query query);   
    
    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param query
     * @return
     */
    public List<T> findPageByCondition(int pageNo,int pageSize,Query query);    
    
    /**
     * 统计条数
     * @param query
     * @return
     */
    public long count(Query query);    
}