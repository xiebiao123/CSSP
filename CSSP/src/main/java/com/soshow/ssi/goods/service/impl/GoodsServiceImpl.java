package com.soshow.ssi.goods.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.goods.dao.GoodsDao;
import com.soshow.ssi.goods.dto.Goods;
import com.soshow.ssi.goods.dto.GoodsCondition;
import com.soshow.ssi.goods.service.GoodsService;

/**
 * 商品信息ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService{

	@Resource
	private GoodsDao goodsDao;
	
	public Integer add(Goods po) {
		return goodsDao.add(po);
	}
	
	public int delete(Integer id) {
		return goodsDao.delete(id);
	}
	
	public int update(Goods po) {
		return goodsDao.update(po);
	}
	
	public Goods findById(Integer id) {
		return goodsDao.findById(id);
	}
	
	public List<Goods> findPageByCondition(GoodsCondition pc) {
		return goodsDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(GoodsCondition pc) {
		return goodsDao.countByCondition(pc);
	}
}
