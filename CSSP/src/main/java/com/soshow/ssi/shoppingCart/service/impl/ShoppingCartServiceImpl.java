package com.soshow.ssi.shoppingCart.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.shoppingCart.dao.ShoppingCartDao;
import com.soshow.ssi.shoppingCart.dto.ShoppingCart;
import com.soshow.ssi.shoppingCart.dto.ShoppingCartCondition;
import com.soshow.ssi.shoppingCart.service.ShoppingCartService;

/**
 * 购物车ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

	@Resource
	private ShoppingCartDao shoppingCartDao;
	
	public Integer add(ShoppingCart po) {
		return shoppingCartDao.add(po);
	}
	
	public int delete(Integer id) {
		return shoppingCartDao.delete(id);
	}
	
	public int update(ShoppingCart po) {
		return shoppingCartDao.update(po);
	}
	
	public ShoppingCart findById(Integer id) {
		return shoppingCartDao.findById(id);
	}
	
	public List<ShoppingCart> findPageByCondition(ShoppingCartCondition pc) {
		return shoppingCartDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(ShoppingCartCondition pc) {
		return shoppingCartDao.countByCondition(pc);
	}
}
