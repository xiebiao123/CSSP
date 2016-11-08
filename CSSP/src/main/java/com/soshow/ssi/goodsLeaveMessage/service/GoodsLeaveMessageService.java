package com.soshow.ssi.goodsLeaveMessage.service;

import java.util.List;

import com.soshow.ssi.goodsLeaveMessage.dto.GoodsLeaveMessage;
import com.soshow.ssi.goodsLeaveMessage.dto.GoodsLeaveMessageCondition;

/**
 * 留言信息表Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface GoodsLeaveMessageService {

	/**
	 * 新增留言信息表
	 */
	public Integer add(GoodsLeaveMessage po);
	/**
	 * 删除留言信息表
	 */
	public int delete(Integer id);
	/**
	 * 修改留言信息表
	 */
	public int update(GoodsLeaveMessage po);
	/**
	 * 根据id获取留言信息表
	 */
	public GoodsLeaveMessage findById(Integer id);
	/**
	 * 分页查询留言信息表
	 */
	public List<GoodsLeaveMessage> findPageByCondition(GoodsLeaveMessageCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Long countByCondition(GoodsLeaveMessageCondition pc);
	
}
