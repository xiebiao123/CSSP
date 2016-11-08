package com.soshow.ssi.log.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.soshow.ssi.log.dao.ActLogDao;
import com.soshow.ssi.log.dto.ActLog;
import com.soshow.ssi.log.dto.ActLogCondition;
import com.soshow.ssi.log.service.ActLogService;

/**
 * 操作日志记录ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class ActLogServiceImpl implements ActLogService{

	@Resource
	private ActLogDao actLogDao;
	
	public ActLog add(ActLog po) {
		return actLogDao.save(po);
	}
	
	public void delete(ActLog po) {
		actLogDao.remove(po);
	}
	
	public int update(ActLog actLog) {
		Query query = new Query();
		Update update = new Update();
		
		return actLogDao.updateMulti(query, update);
	}
	
	public ActLog findById(String id) {
		return actLogDao.findById(id);
	}
	
	public List<ActLog> findPageByCondition(ActLogCondition po) {
		int pageNo = po.getPageNo();
		int pageSize =po.getPageSize();
		Query query = new Query();
		
		return actLogDao.findPageByCondition(pageNo, pageSize, query);
	}
	
	public long countByCondition(ActLogCondition po) {
		Query query = new Query();
		return actLogDao.count(query);
	}
}
