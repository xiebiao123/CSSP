package com.soshow.ssi.club.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.club.dao.ClubDao;
import com.soshow.ssi.club.dto.Club;
import com.soshow.ssi.club.dto.ClubCondition;
import com.soshow.ssi.club.service.ClubService;

/**
 * 社团信息ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class ClubServiceImpl implements ClubService{

	@Resource
	private ClubDao clubDao;
	
	public Integer add(Club po) {
		return clubDao.add(po);
	}
	
	public int delete(Integer id) {
		return clubDao.delete(id);
	}
	
	public int update(Club po) {
		return clubDao.update(po);
	}
	
	public Club findById(Integer id) {
		return clubDao.findById(id);
	}
	
	public List<Club> findPageByCondition(ClubCondition pc) {
		return clubDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(ClubCondition pc) {
		return clubDao.countByCondition(pc);
	}
}
