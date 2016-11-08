package com.soshow.ssi.leaveMessageComments.service;

import java.util.List;

import com.soshow.ssi.leaveMessageComments.dto.LeaveMessageComments;
import com.soshow.ssi.leaveMessageComments.dto.LeaveMessageCommentsCondition;

/**
 * 留言评论Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface LeaveMessageCommentsService {

	/**
	 * 新增留言评论
	 */
	public Integer add(LeaveMessageComments po);
	/**
	 * 删除留言评论
	 */
	public int delete(Integer id);
	/**
	 * 修改留言评论
	 */
	public int update(LeaveMessageComments po);
	/**
	 * 根据id获取留言评论
	 */
	public LeaveMessageComments findById(Integer id);
	/**
	 * 分页查询留言评论
	 */
	public List<LeaveMessageComments> findPageByCondition(LeaveMessageCommentsCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Long countByCondition(LeaveMessageCommentsCondition pc);
	
}
