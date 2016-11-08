package com.soshow.ssi.student.service;

import java.util.List;

import com.soshow.ssi.student.dto.Student;
import com.soshow.ssi.student.dto.StudentCondition;

/**
 * 学生信息Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface StudentService {

	/**
	 * 新增学生信息
	 */
	public Integer add(Student po);
	/**
	 * 删除学生信息
	 */
	public int delete(Integer id);
	/**
	 * 修改学生信息
	 */
	public int update(Student po);
	/**
	 * 根据id获取学生信息
	 */
	public Student findById(Integer id);
	/**
	 * 分页查询学生信息
	 */
	public List<Student> findPageByCondition(StudentCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Long countByCondition(StudentCondition pc);
	
}
