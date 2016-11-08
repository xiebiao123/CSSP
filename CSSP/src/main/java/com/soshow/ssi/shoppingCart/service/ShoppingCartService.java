package com.soshow.ssi.shoppingCart.service;

import java.util.List;

import com.soshow.ssi.shoppingCart.dto.ShoppingCart;
import com.soshow.ssi.shoppingCart.dto.ShoppingCartCondition;

/**
 * 购物车Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface ShoppingCartService {

	/**
	 * 新增购物车
	 */
	public Integer add(ShoppingCart po);
	/**
	 * 删除购物车
	 */
	public int delete(Integer id);
	/**
	 * 修改购物车
	 */
	public int update(ShoppingCart po);
	/**
	 * 根据id获取购物车
	 */
	public ShoppingCart findById(Integer id);
	/**
	 * 分页查询购物车
	 */
	public List<ShoppingCart> findPageByCondition(ShoppingCartCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Long countByCondition(ShoppingCartCondition pc);
	
}
