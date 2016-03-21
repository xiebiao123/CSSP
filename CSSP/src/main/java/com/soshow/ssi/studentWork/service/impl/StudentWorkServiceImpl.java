package com.soshow.ssi.studentWork.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.studentWork.dao.StudentWorkDao;
import com.soshow.ssi.studentWork.dto.StudentWork;
import com.soshow.ssi.studentWork.dto.StudentWorkCondition;
import com.soshow.ssi.studentWork.service.StudentWorkService;

/**
 * 学生工作关联ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class StudentWorkServiceImpl implements StudentWorkService{

	@Resource
	private StudentWorkDao studentWorkDao;
	
	public Integer add(StudentWork po) {
		return studentWorkDao.add(po);
	}
	
	public int delete(Integer id) {
		return studentWorkDao.delete(id);
	}
	
	public int update(StudentWork po) {
		return studentWorkDao.update(po);
	}
	
	public StudentWork findById(Integer id) {
		return studentWorkDao.findById(id);
	}
	
	public List<StudentWork> findPageByCondition(StudentWorkCondition pc) {
		return studentWorkDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(StudentWorkCondition pc) {
		return studentWorkDao.countByCondition(pc);
	}
}
