package com.soshow.ssi.sdistrict.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.sdistrict.dao.SdistrictDao;
import com.soshow.ssi.sdistrict.dto.Sdistrict;
import com.soshow.ssi.sdistrict.dto.SdistrictCondition;
import com.soshow.ssi.sdistrict.service.SdistrictService;

/**
 * 县乡ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class SdistrictServiceImpl implements SdistrictService{

	@Resource
	private SdistrictDao sdistrictDao;
	
	public Integer add(Sdistrict po) {
		return sdistrictDao.add(po);
	}
	
	public int delete(Integer id) {
		return sdistrictDao.delete(id);
	}
	
	public int update(Sdistrict po) {
		return sdistrictDao.update(po);
	}
	
	public Sdistrict findById(Integer id) {
		return sdistrictDao.findById(id);
	}
	
	public List<Sdistrict> findPageByCondition(SdistrictCondition pc) {
		return sdistrictDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(SdistrictCondition pc) {
		return sdistrictDao.countByCondition(pc);
	}
}
