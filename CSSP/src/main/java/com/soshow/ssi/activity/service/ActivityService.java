package com.soshow.ssi.activity.service;

import java.util.List;

import com.soshow.ssi.activity.dto.Activity;
import com.soshow.ssi.activity.dto.ActivityCondition;

/**
 * 活动信息Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface ActivityService {

	/**
	 * 新增活动信息
	 */
	public Integer add(Activity po);
	/**
	 * 删除活动信息
	 */
	public int delete(Integer id);
	/**
	 * 修改活动信息
	 */
	public int update(Activity po);
	/**
	 * 根据id获取活动信息
	 */
	public Activity findById(Integer id);
	/**
	 * 分页查询活动信息
	 */
	public List<Activity> findPageByCondition(ActivityCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Long countByCondition(ActivityCondition pc);
	
}
