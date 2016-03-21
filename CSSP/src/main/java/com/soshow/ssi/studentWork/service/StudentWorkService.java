package com.soshow.ssi.studentWork.service;

import java.util.List;

import com.soshow.ssi.studentWork.dto.StudentWork;
import com.soshow.ssi.studentWork.dto.StudentWorkCondition;

/**
 * 学生工作关联Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface StudentWorkService {

	/**
	 * 新增学生工作关联
	 */
	public Integer add(StudentWork po);
	/**
	 * 删除学生工作关联
	 */
	public int delete(Integer id);
	/**
	 * 修改学生工作关联
	 */
	public int update(StudentWork po);
	/**
	 * 根据id获取学生工作关联
	 */
	public StudentWork findById(Integer id);
	/**
	 * 分页查询学生工作关联
	 */
	public List<StudentWork> findPageByCondition(StudentWorkCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Integer countByCondition(StudentWorkCondition pc);
	
}
