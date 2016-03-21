package com.soshow.ssi.scity.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.scity.dao.ScityDao;
import com.soshow.ssi.scity.dto.Scity;
import com.soshow.ssi.scity.dto.ScityCondition;
import com.soshow.ssi.scity.service.ScityService;

/**
 * 城市ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class ScityServiceImpl implements ScityService{

	@Resource
	private ScityDao scityDao;
	
	public Integer add(Scity po) {
		return scityDao.add(po);
	}
	
	public int delete(Integer id) {
		return scityDao.delete(id);
	}
	
	public int update(Scity po) {
		return scityDao.update(po);
	}
	
	public Scity findById(Integer id) {
		return scityDao.findById(id);
	}
	
	public List<Scity> findPageByCondition(ScityCondition pc) {
		return scityDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(ScityCondition pc) {
		return scityDao.countByCondition(pc);
	}
}
