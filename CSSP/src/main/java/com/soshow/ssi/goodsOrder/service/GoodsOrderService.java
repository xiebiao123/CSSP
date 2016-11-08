package com.soshow.ssi.goodsOrder.service;

import java.util.List;

import com.soshow.ssi.goodsOrder.dto.GoodsOrder;
import com.soshow.ssi.goodsOrder.dto.GoodsOrderCondition;

/**
 * 商品订单Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface GoodsOrderService {

	/**
	 * 新增商品订单
	 */
	public Integer add(GoodsOrder po);
	/**
	 * 删除商品订单
	 */
	public int delete(Integer id);
	/**
	 * 修改商品订单
	 */
	public int update(GoodsOrder po);
	/**
	 * 根据id获取商品订单
	 */
	public GoodsOrder findById(Integer id);
	/**
	 * 分页查询商品订单
	 */
	public List<GoodsOrder> findPageByCondition(GoodsOrderCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Long countByCondition(GoodsOrderCondition pc);
	
}
