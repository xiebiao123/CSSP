package com.soshow.ssi.experience.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.experience.dao.ExperienceDao;
import com.soshow.ssi.experience.dto.Experience;
import com.soshow.ssi.experience.dto.ExperienceCondition;
import com.soshow.ssi.experience.service.ExperienceService;

/**
 * 个人经验ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class ExperienceServiceImpl implements ExperienceService{

	@Resource
	private ExperienceDao experienceDao;
	
	public Integer add(Experience po) {
		return experienceDao.add(po);
	}
	
	public int delete(Integer id) {
		return experienceDao.delete(id);
	}
	
	public int update(Experience po) {
		return experienceDao.update(po);
	}
	
	public Experience findById(Integer id) {
		return experienceDao.findById(id);
	}
	
	public List<Experience> findPageByCondition(ExperienceCondition pc) {
		return experienceDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(ExperienceCondition pc) {
		return experienceDao.countByCondition(pc);
	}
}
