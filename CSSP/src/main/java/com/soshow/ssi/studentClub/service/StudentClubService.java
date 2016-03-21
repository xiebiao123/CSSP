package com.soshow.ssi.studentClub.service;

import java.util.List;

import com.soshow.ssi.studentClub.dto.StudentClub;
import com.soshow.ssi.studentClub.dto.StudentClubCondition;

/**
 * 学生社团关联Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface StudentClubService {

	/**
	 * 新增学生社团关联
	 */
	public Integer add(StudentClub po);
	/**
	 * 删除学生社团关联
	 */
	public int delete(Integer id);
	/**
	 * 修改学生社团关联
	 */
	public int update(StudentClub po);
	/**
	 * 根据id获取学生社团关联
	 */
	public StudentClub findById(Integer id);
	/**
	 * 分页查询学生社团关联
	 */
	public List<StudentClub> findPageByCondition(StudentClubCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Integer countByCondition(StudentClubCondition pc);
	
}
