package com.soshow.ssi.sprovince.service;

import java.util.List;

import com.soshow.ssi.sprovince.dto.Sprovince;
import com.soshow.ssi.sprovince.dto.SprovinceCondition;

/**
 * 省份Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface SprovinceService {

	/**
	 * 新增省份
	 */
	public Integer add(Sprovince po);
	/**
	 * 删除省份
	 */
	public int delete(Integer id);
	/**
	 * 修改省份
	 */
	public int update(Sprovince po);
	/**
	 * 根据id获取省份
	 */
	public Sprovince findById(Integer id);
	/**
	 * 分页查询省份
	 */
	public List<Sprovince> findPageByCondition(SprovinceCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Integer countByCondition(SprovinceCondition pc);
	
}
