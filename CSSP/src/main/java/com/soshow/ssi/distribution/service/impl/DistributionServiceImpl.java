package com.soshow.ssi.distribution.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.distribution.dao.DistributionDao;
import com.soshow.ssi.distribution.dto.Distribution;
import com.soshow.ssi.distribution.dto.DistributionCondition;
import com.soshow.ssi.distribution.service.DistributionService;

/**
 * 配送方式ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class DistributionServiceImpl implements DistributionService{

	@Resource
	private DistributionDao distributionDao;
	
	public Integer add(Distribution po) {
		return distributionDao.add(po);
	}
	
	public int delete(Integer id) {
		return distributionDao.delete(id);
	}
	
	public int update(Distribution po) {
		return distributionDao.update(po);
	}
	
	public Distribution findById(Integer id) {
		return distributionDao.findById(id);
	}
	
	public List<Distribution> findPageByCondition(DistributionCondition pc) {
		return distributionDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(DistributionCondition pc) {
		return distributionDao.countByCondition(pc);
	}
}
