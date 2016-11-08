package com.soshow.ssi.log.dao.impl;

import org.springframework.stereotype.Repository;

import com.soshow.ssi.base.MongoBaseDaoImpl;
import com.soshow.ssi.log.dao.ActLogDao;
import com.soshow.ssi.log.dto.ActLog;

/**
 * 操作日志daoImpl
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
 
@Repository
public class ActLogDaoImpl extends MongoBaseDaoImpl<ActLog> implements ActLogDao{

	@Override
	public String getCollectionName() {
		return "tb_act_log";
	}

	@Override
	public Class<ActLog> getEntityClass() {
		return ActLog.class;
	}
	
}
