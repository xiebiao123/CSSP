package com.soshow.ssi.resume.service;

import java.util.List;

import com.soshow.ssi.resume.dto.Resume;
import com.soshow.ssi.resume.dto.ResumeCondition;

/**
 * 简历Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface ResumeService {

	/**
	 * 新增简历
	 */
	public Integer add(Resume po);
	/**
	 * 删除简历
	 */
	public int delete(Integer id);
	/**
	 * 修改简历
	 */
	public int update(Resume po);
	/**
	 * 根据id获取简历
	 */
	public Resume findById(Integer id);
	/**
	 * 分页查询简历
	 */
	public List<Resume> findPageByCondition(ResumeCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Long countByCondition(ResumeCondition pc);
	
}
