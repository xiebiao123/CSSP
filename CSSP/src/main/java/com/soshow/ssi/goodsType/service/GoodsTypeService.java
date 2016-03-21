package com.soshow.ssi.goodsType.service;

import java.util.List;

import com.soshow.ssi.goodsType.dto.GoodsType;
import com.soshow.ssi.goodsType.dto.GoodsTypeCondition;

/**
 * 商品类别Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface GoodsTypeService {

	/**
	 * 新增商品类别
	 */
	public Integer add(GoodsType po);
	/**
	 * 删除商品类别
	 */
	public int delete(Integer id);
	/**
	 * 修改商品类别
	 */
	public int update(GoodsType po);
	/**
	 * 根据id获取商品类别
	 */
	public GoodsType findById(Integer id);
	/**
	 * 分页查询商品类别
	 */
	public List<GoodsType> findPageByCondition(GoodsTypeCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Integer countByCondition(GoodsTypeCondition pc);
	
}
