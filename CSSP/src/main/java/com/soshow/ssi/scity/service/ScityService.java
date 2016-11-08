package com.soshow.ssi.scity.service;

import java.util.List;

import com.soshow.ssi.scity.dto.Scity;
import com.soshow.ssi.scity.dto.ScityCondition;

/**
 * 城市Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface ScityService {

	/**
	 * 新增城市
	 */
	public Integer add(Scity po);
	/**
	 * 删除城市
	 */
	public int delete(Integer id);
	/**
	 * 修改城市
	 */
	public int update(Scity po);
	/**
	 * 根据id获取城市
	 */
	public Scity findById(Integer id);
	/**
	 * 分页查询城市
	 */
	public List<Scity> findPageByCondition(ScityCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Long countByCondition(ScityCondition pc);
	
}
