package com.soshow.ssi.workType.service;

import java.util.List;

import com.soshow.ssi.workType.dto.WorkType;
import com.soshow.ssi.workType.dto.WorkTypeCondition;

/**
 * 职位类别Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface WorkTypeService {

	/**
	 * 新增职位类别
	 */
	public Integer add(WorkType po);
	/**
	 * 删除职位类别
	 */
	public int delete(Integer id);
	/**
	 * 修改职位类别
	 */
	public int update(WorkType po);
	/**
	 * 根据id获取职位类别
	 */
	public WorkType findById(Integer id);
	/**
	 * 分页查询职位类别
	 */
	public List<WorkType> findPageByCondition(WorkTypeCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Integer countByCondition(WorkTypeCondition pc);
	
}
