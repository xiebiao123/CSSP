package com.soshow.ssi.student.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.student.dao.StudentDao;
import com.soshow.ssi.student.dto.Student;
import com.soshow.ssi.student.dto.StudentCondition;
import com.soshow.ssi.student.service.StudentService;

/**
 * 学生信息ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class StudentServiceImpl implements StudentService{

	@Resource
	private StudentDao studentDao;
	
	public Integer add(Student po) {
		return studentDao.add(po);
	}
	
	public int delete(Integer id) {
		return studentDao.delete(id);
	}
	
	public int update(Student po) {
		return studentDao.update(po);
	}
	
	public Student findById(Integer id) {
		return studentDao.findById(id);
	}
	
	public List<Student> findPageByCondition(StudentCondition pc) {
		return studentDao.findPageByCondition(pc);
	}
	
	public Long countByCondition(StudentCondition pc) {
		return studentDao.countByCondition(pc);
	}
}
