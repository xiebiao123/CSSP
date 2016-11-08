package com.soshow.ssi.clubActivity.service;

import java.util.List;

import com.soshow.ssi.clubActivity.dto.ClubActivity;
import com.soshow.ssi.clubActivity.dto.ClubActivityCondition;

/**
 * 社团活动关联Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface ClubActivityService {

	/**
	 * 新增社团活动关联
	 */
	public Integer add(ClubActivity po);
	/**
	 * 删除社团活动关联
	 */
	public int delete(Integer id);
	/**
	 * 修改社团活动关联
	 */
	public int update(ClubActivity po);
	/**
	 * 根据id获取社团活动关联
	 */
	public ClubActivity findById(Integer id);
	/**
	 * 分页查询社团活动关联
	 */
	public List<ClubActivity> findPageByCondition(ClubActivityCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Long countByCondition(ClubActivityCondition pc);
	
}
