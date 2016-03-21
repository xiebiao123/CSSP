package com.soshow.ssi.activity.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.activity.dao.ActivityDao;
import com.soshow.ssi.activity.dto.Activity;
import com.soshow.ssi.activity.dto.ActivityCondition;
import com.soshow.ssi.activity.service.ActivityService;

/**
 * 活动信息ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class ActivityServiceImpl implements ActivityService{

	@Resource
	private ActivityDao activityDao;
	
	public Integer add(Activity po) {
		return activityDao.add(po);
	}
	
	public int delete(Integer id) {
		return activityDao.delete(id);
	}
	
	public int update(Activity po) {
		return activityDao.update(po);
	}
	
	public Activity findById(Integer id) {
		return activityDao.findById(id);
	}
	
	public List<Activity> findPageByCondition(ActivityCondition pc) {
		return activityDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(ActivityCondition pc) {
		return activityDao.countByCondition(pc);
	}
}
