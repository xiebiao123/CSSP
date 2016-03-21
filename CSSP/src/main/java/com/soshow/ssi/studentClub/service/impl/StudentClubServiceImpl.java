package com.soshow.ssi.studentClub.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.studentClub.dao.StudentClubDao;
import com.soshow.ssi.studentClub.dto.StudentClub;
import com.soshow.ssi.studentClub.dto.StudentClubCondition;
import com.soshow.ssi.studentClub.service.StudentClubService;

/**
 * 学生社团关联ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class StudentClubServiceImpl implements StudentClubService{

	@Resource
	private StudentClubDao studentClubDao;
	
	public Integer add(StudentClub po) {
		return studentClubDao.add(po);
	}
	
	public int delete(Integer id) {
		return studentClubDao.delete(id);
	}
	
	public int update(StudentClub po) {
		return studentClubDao.update(po);
	}
	
	public StudentClub findById(Integer id) {
		return studentClubDao.findById(id);
	}
	
	public List<StudentClub> findPageByCondition(StudentClubCondition pc) {
		return studentClubDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(StudentClubCondition pc) {
		return studentClubDao.countByCondition(pc);
	}
}
