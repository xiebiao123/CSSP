package com.soshow.ssi.goodsOrderDetailed.service;

import java.util.List;

import com.soshow.ssi.goodsOrderDetailed.dto.GoodsOrderDetailed;
import com.soshow.ssi.goodsOrderDetailed.dto.GoodsOrderDetailedCondition;

/**
 * 订单详细Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface GoodsOrderDetailedService {

	/**
	 * 新增订单详细
	 */
	public Integer add(GoodsOrderDetailed po);
	/**
	 * 删除订单详细
	 */
	public int delete(Integer id);
	/**
	 * 修改订单详细
	 */
	public int update(GoodsOrderDetailed po);
	/**
	 * 根据id获取订单详细
	 */
	public GoodsOrderDetailed findById(Integer id);
	/**
	 * 分页查询订单详细
	 */
	public List<GoodsOrderDetailed> findPageByCondition(GoodsOrderDetailedCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Long countByCondition(GoodsOrderDetailedCondition pc);
	
}
