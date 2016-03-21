package com.soshow.ssi.activity.dao.impl;

import org.springframework.stereotype.Repository;

import com.soshow.ssi.base.BaseDaoImpl;
import com.soshow.ssi.activity.dao.ActivityDao;
import com.soshow.ssi.activity.dto.Activity;
import com.soshow.ssi.activity.dto.ActivityCondition;

/**
 * 活动信息daoImpl
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
 
@Repository
public class ActivityDaoImpl extends BaseDaoImpl<Activity,ActivityCondition> implements ActivityDao{
	
}
