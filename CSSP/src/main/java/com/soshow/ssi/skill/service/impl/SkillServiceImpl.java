package com.soshow.ssi.skill.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.skill.dao.SkillDao;
import com.soshow.ssi.skill.dto.Skill;
import com.soshow.ssi.skill.dto.SkillCondition;
import com.soshow.ssi.skill.service.SkillService;

/**
 * 个人技能ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class SkillServiceImpl implements SkillService{

	@Resource
	private SkillDao skillDao;
	
	public Integer add(Skill po) {
		return skillDao.add(po);
	}
	
	public int delete(Integer id) {
		return skillDao.delete(id);
	}
	
	public int update(Skill po) {
		return skillDao.update(po);
	}
	
	public Skill findById(Integer id) {
		return skillDao.findById(id);
	}
	
	public List<Skill> findPageByCondition(SkillCondition pc) {
		return skillDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(SkillCondition pc) {
		return skillDao.countByCondition(pc);
	}
}
