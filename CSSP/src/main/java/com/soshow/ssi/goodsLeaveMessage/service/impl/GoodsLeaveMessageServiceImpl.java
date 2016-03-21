package com.soshow.ssi.goodsLeaveMessage.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.goodsLeaveMessage.dao.GoodsLeaveMessageDao;
import com.soshow.ssi.goodsLeaveMessage.dto.GoodsLeaveMessage;
import com.soshow.ssi.goodsLeaveMessage.dto.GoodsLeaveMessageCondition;
import com.soshow.ssi.goodsLeaveMessage.service.GoodsLeaveMessageService;

/**
 * 留言信息表ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class GoodsLeaveMessageServiceImpl implements GoodsLeaveMessageService{

	@Resource
	private GoodsLeaveMessageDao goodsLeaveMessageDao;
	
	public Integer add(GoodsLeaveMessage po) {
		return goodsLeaveMessageDao.add(po);
	}
	
	public int delete(Integer id) {
		return goodsLeaveMessageDao.delete(id);
	}
	
	public int update(GoodsLeaveMessage po) {
		return goodsLeaveMessageDao.update(po);
	}
	
	public GoodsLeaveMessage findById(Integer id) {
		return goodsLeaveMessageDao.findById(id);
	}
	
	public List<GoodsLeaveMessage> findPageByCondition(GoodsLeaveMessageCondition pc) {
		return goodsLeaveMessageDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(GoodsLeaveMessageCondition pc) {
		return goodsLeaveMessageDao.countByCondition(pc);
	}
}
