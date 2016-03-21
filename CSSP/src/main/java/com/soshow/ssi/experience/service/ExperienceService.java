package com.soshow.ssi.experience.service;

import java.util.List;

import com.soshow.ssi.experience.dto.Experience;
import com.soshow.ssi.experience.dto.ExperienceCondition;

/**
 * 个人经验Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface ExperienceService {

	/**
	 * 新增个人经验
	 */
	public Integer add(Experience po);
	/**
	 * 删除个人经验
	 */
	public int delete(Integer id);
	/**
	 * 修改个人经验
	 */
	public int update(Experience po);
	/**
	 * 根据id获取个人经验
	 */
	public Experience findById(Integer id);
	/**
	 * 分页查询个人经验
	 */
	public List<Experience> findPageByCondition(ExperienceCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Integer countByCondition(ExperienceCondition pc);
	
}
