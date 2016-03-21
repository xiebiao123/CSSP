package com.soshow.ssi.work.service;

import java.util.List;

import com.soshow.ssi.work.dto.Work;
import com.soshow.ssi.work.dto.WorkCondition;

/**
 * 职位信息Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface WorkService {

	/**
	 * 新增职位信息
	 */
	public Integer add(Work po);
	/**
	 * 删除职位信息
	 */
	public int delete(Integer id);
	/**
	 * 修改职位信息
	 */
	public int update(Work po);
	/**
	 * 根据id获取职位信息
	 */
	public Work findById(Integer id);
	/**
	 * 分页查询职位信息
	 */
	public List<Work> findPageByCondition(WorkCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Integer countByCondition(WorkCondition pc);
	
}
