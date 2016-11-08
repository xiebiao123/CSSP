package com.soshow.ssi.log.service;

import java.util.List;

import com.soshow.ssi.log.dto.ActLog;
import com.soshow.ssi.log.dto.ActLogCondition;

/**
 * 操作记录Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface ActLogService {
	
	/**
	 * 新增
	 * @param po
	 * @return
	 */
	public ActLog add(ActLog po);
	
	/**
	 * 删除
	 * @param po
	 * @return
	 */
	public void delete(ActLog po);
	
	/**
	 * 修改
	 * @param query
	 * @param update
	 * @return
	 */
	public int update(ActLog po);
	
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	public ActLog findById(String id);
	
	/**
	 * 分页查找
	 * @param pageNo
	 * @param pageSize
	 * @param query
	 * @return
	 */
	public List<ActLog> findPageByCondition(ActLogCondition po);
	
	/**
	 * 统计条数
	 * @param query
	 * @return
	 */
	public long countByCondition(ActLogCondition po);
}
