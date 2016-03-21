package com.soshow.ssi.work.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.work.dao.WorkDao;
import com.soshow.ssi.work.dto.Work;
import com.soshow.ssi.work.dto.WorkCondition;
import com.soshow.ssi.work.service.WorkService;

/**
 * 职位信息ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class WorkServiceImpl implements WorkService{

	@Resource
	private WorkDao workDao;
	
	public Integer add(Work po) {
		return workDao.add(po);
	}
	
	public int delete(Integer id) {
		return workDao.delete(id);
	}
	
	public int update(Work po) {
		return workDao.update(po);
	}
	
	public Work findById(Integer id) {
		return workDao.findById(id);
	}
	
	public List<Work> findPageByCondition(WorkCondition pc) {
		return workDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(WorkCondition pc) {
		return workDao.countByCondition(pc);
	}
}
