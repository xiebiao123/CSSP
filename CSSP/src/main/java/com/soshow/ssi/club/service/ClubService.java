package com.soshow.ssi.club.service;

import java.util.List;

import com.soshow.ssi.club.dto.Club;
import com.soshow.ssi.club.dto.ClubCondition;

/**
 * 社团信息Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface ClubService {

	/**
	 * 新增社团信息
	 */
	public Integer add(Club po);
	/**
	 * 删除社团信息
	 */
	public int delete(Integer id);
	/**
	 * 修改社团信息
	 */
	public int update(Club po);
	/**
	 * 根据id获取社团信息
	 */
	public Club findById(Integer id);
	/**
	 * 分页查询社团信息
	 */
	public List<Club> findPageByCondition(ClubCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Long countByCondition(ClubCondition pc);
	
}
