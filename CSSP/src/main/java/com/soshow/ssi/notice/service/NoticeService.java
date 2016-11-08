package com.soshow.ssi.notice.service;

import java.util.List;

import com.soshow.ssi.notice.dto.Notice;
import com.soshow.ssi.notice.dto.NoticeCondition;

/**
 * 公告Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface NoticeService {

	/**
	 * 新增公告
	 */
	public Integer add(Notice po);
	/**
	 * 删除公告
	 */
	public int delete(Integer id);
	/**
	 * 修改公告
	 */
	public int update(Notice po);
	/**
	 * 根据id获取公告
	 */
	public Notice findById(Integer id);
	/**
	 * 分页查询公告
	 */
	public List<Notice> findPageByCondition(NoticeCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Long countByCondition(NoticeCondition pc);
	
}
