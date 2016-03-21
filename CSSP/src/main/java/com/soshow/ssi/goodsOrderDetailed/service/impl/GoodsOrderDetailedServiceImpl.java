package com.soshow.ssi.goodsOrderDetailed.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.goodsOrderDetailed.dao.GoodsOrderDetailedDao;
import com.soshow.ssi.goodsOrderDetailed.dto.GoodsOrderDetailed;
import com.soshow.ssi.goodsOrderDetailed.dto.GoodsOrderDetailedCondition;
import com.soshow.ssi.goodsOrderDetailed.service.GoodsOrderDetailedService;

/**
 * 订单详细ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class GoodsOrderDetailedServiceImpl implements GoodsOrderDetailedService{

	@Resource
	private GoodsOrderDetailedDao goodsOrderDetailedDao;
	
	public Integer add(GoodsOrderDetailed po) {
		return goodsOrderDetailedDao.add(po);
	}
	
	public int delete(Integer id) {
		return goodsOrderDetailedDao.delete(id);
	}
	
	public int update(GoodsOrderDetailed po) {
		return goodsOrderDetailedDao.update(po);
	}
	
	public GoodsOrderDetailed findById(Integer id) {
		return goodsOrderDetailedDao.findById(id);
	}
	
	public List<GoodsOrderDetailed> findPageByCondition(GoodsOrderDetailedCondition pc) {
		return goodsOrderDetailedDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(GoodsOrderDetailedCondition pc) {
		return goodsOrderDetailedDao.countByCondition(pc);
	}
}
