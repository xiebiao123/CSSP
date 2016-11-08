package com.soshow.ssi.goodsOrder.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.goodsOrder.dao.GoodsOrderDao;
import com.soshow.ssi.goodsOrder.dto.GoodsOrder;
import com.soshow.ssi.goodsOrder.dto.GoodsOrderCondition;
import com.soshow.ssi.goodsOrder.service.GoodsOrderService;

/**
 * 商品订单ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class GoodsOrderServiceImpl implements GoodsOrderService{

	@Resource
	private GoodsOrderDao goodsOrderDao;
	
	public Integer add(GoodsOrder po) {
		return goodsOrderDao.add(po);
	}
	
	public int delete(Integer id) {
		return goodsOrderDao.delete(id);
	}
	
	public int update(GoodsOrder po) {
		return goodsOrderDao.update(po);
	}
	
	public GoodsOrder findById(Integer id) {
		return goodsOrderDao.findById(id);
	}
	
	public List<GoodsOrder> findPageByCondition(GoodsOrderCondition pc) {
		return goodsOrderDao.findPageByCondition(pc);
	}
	
	public Long countByCondition(GoodsOrderCondition pc) {
		return goodsOrderDao.countByCondition(pc);
	}
}
