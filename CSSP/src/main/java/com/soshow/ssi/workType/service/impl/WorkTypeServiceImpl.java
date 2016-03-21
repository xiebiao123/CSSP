package com.soshow.ssi.workType.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.workType.dao.WorkTypeDao;
import com.soshow.ssi.workType.dto.WorkType;
import com.soshow.ssi.workType.dto.WorkTypeCondition;
import com.soshow.ssi.workType.service.WorkTypeService;

/**
 * 职位类别ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class WorkTypeServiceImpl implements WorkTypeService{

	@Resource
	private WorkTypeDao workTypeDao;
	
	public Integer add(WorkType po) {
		return workTypeDao.add(po);
	}
	
	public int delete(Integer id) {
		return workTypeDao.delete(id);
	}
	
	public int update(WorkType po) {
		return workTypeDao.update(po);
	}
	
	public WorkType findById(Integer id) {
		return workTypeDao.findById(id);
	}
	
	public List<WorkType> findPageByCondition(WorkTypeCondition pc) {
		return workTypeDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(WorkTypeCondition pc) {
		return workTypeDao.countByCondition(pc);
	}
}
