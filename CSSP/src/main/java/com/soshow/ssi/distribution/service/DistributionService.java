package com.soshow.ssi.distribution.service;

import java.util.List;

import com.soshow.ssi.distribution.dto.Distribution;
import com.soshow.ssi.distribution.dto.DistributionCondition;

/**
 * 配送方式Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface DistributionService {

	/**
	 * 新增配送方式
	 */
	public Integer add(Distribution po);
	/**
	 * 删除配送方式
	 */
	public int delete(Integer id);
	/**
	 * 修改配送方式
	 */
	public int update(Distribution po);
	/**
	 * 根据id获取配送方式
	 */
	public Distribution findById(Integer id);
	/**
	 * 分页查询配送方式
	 */
	public List<Distribution> findPageByCondition(DistributionCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Long countByCondition(DistributionCondition pc);
	
}
