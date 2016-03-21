package com.soshow.ssi.sprovince.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.sprovince.dao.SprovinceDao;
import com.soshow.ssi.sprovince.dto.Sprovince;
import com.soshow.ssi.sprovince.dto.SprovinceCondition;
import com.soshow.ssi.sprovince.service.SprovinceService;

/**
 * 省份ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class SprovinceServiceImpl implements SprovinceService{

	@Resource
	private SprovinceDao sprovinceDao;
	
	public Integer add(Sprovince po) {
		return sprovinceDao.add(po);
	}
	
	public int delete(Integer id) {
		return sprovinceDao.delete(id);
	}
	
	public int update(Sprovince po) {
		return sprovinceDao.update(po);
	}
	
	public Sprovince findById(Integer id) {
		return sprovinceDao.findById(id);
	}
	
	public List<Sprovince> findPageByCondition(SprovinceCondition pc) {
		return sprovinceDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(SprovinceCondition pc) {
		return sprovinceDao.countByCondition(pc);
	}
}
