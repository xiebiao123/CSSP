package com.soshow.ssi.clubActivity.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.clubActivity.dao.ClubActivityDao;
import com.soshow.ssi.clubActivity.dto.ClubActivity;
import com.soshow.ssi.clubActivity.dto.ClubActivityCondition;
import com.soshow.ssi.clubActivity.service.ClubActivityService;

/**
 * 社团活动关联ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class ClubActivityServiceImpl implements ClubActivityService{

	@Resource
	private ClubActivityDao clubActivityDao;
	
	public Integer add(ClubActivity po) {
		return clubActivityDao.add(po);
	}
	
	public int delete(Integer id) {
		return clubActivityDao.delete(id);
	}
	
	public int update(ClubActivity po) {
		return clubActivityDao.update(po);
	}
	
	public ClubActivity findById(Integer id) {
		return clubActivityDao.findById(id);
	}
	
	public List<ClubActivity> findPageByCondition(ClubActivityCondition pc) {
		return clubActivityDao.findPageByCondition(pc);
	}
	
	public Long countByCondition(ClubActivityCondition pc) {
		return clubActivityDao.countByCondition(pc);
	}
}
