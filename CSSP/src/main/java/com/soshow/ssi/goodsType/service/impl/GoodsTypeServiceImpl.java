package com.soshow.ssi.goodsType.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.goodsType.dao.GoodsTypeDao;
import com.soshow.ssi.goodsType.dto.GoodsType;
import com.soshow.ssi.goodsType.dto.GoodsTypeCondition;
import com.soshow.ssi.goodsType.service.GoodsTypeService;

/**
 * 商品类别ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService{

	@Resource
	private GoodsTypeDao goodsTypeDao;
	
	public Integer add(GoodsType po) {
		return goodsTypeDao.add(po);
	}
	
	public int delete(Integer id) {
		return goodsTypeDao.delete(id);
	}
	
	public int update(GoodsType po) {
		return goodsTypeDao.update(po);
	}
	
	public GoodsType findById(Integer id) {
		return goodsTypeDao.findById(id);
	}
	
	public List<GoodsType> findPageByCondition(GoodsTypeCondition pc) {
		return goodsTypeDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(GoodsTypeCondition pc) {
		return goodsTypeDao.countByCondition(pc);
	}
}
