package com.soshow.ssi.skill.service;

import java.util.List;

import com.soshow.ssi.skill.dto.Skill;
import com.soshow.ssi.skill.dto.SkillCondition;

/**
 * 个人技能Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface SkillService {

	/**
	 * 新增个人技能
	 */
	public Integer add(Skill po);
	/**
	 * 删除个人技能
	 */
	public int delete(Integer id);
	/**
	 * 修改个人技能
	 */
	public int update(Skill po);
	/**
	 * 根据id获取个人技能
	 */
	public Skill findById(Integer id);
	/**
	 * 分页查询个人技能
	 */
	public List<Skill> findPageByCondition(SkillCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Long countByCondition(SkillCondition pc);
	
}
