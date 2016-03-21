package com.soshow.ssi.goods.service;

import java.util.List;

import com.soshow.ssi.goods.dto.Goods;
import com.soshow.ssi.goods.dto.GoodsCondition;

/**
 * 商品信息Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface GoodsService {

	/**
	 * 新增商品信息
	 */
	public Integer add(Goods po);
	/**
	 * 删除商品信息
	 */
	public int delete(Integer id);
	/**
	 * 修改商品信息
	 */
	public int update(Goods po);
	/**
	 * 根据id获取商品信息
	 */
	public Goods findById(Integer id);
	/**
	 * 分页查询商品信息
	 */
	public List<Goods> findPageByCondition(GoodsCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Integer countByCondition(GoodsCondition pc);
	
}
