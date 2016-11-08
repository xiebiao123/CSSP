package com.soshow.ssi.leaveMessageComments.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.leaveMessageComments.dao.LeaveMessageCommentsDao;
import com.soshow.ssi.leaveMessageComments.dto.LeaveMessageComments;
import com.soshow.ssi.leaveMessageComments.dto.LeaveMessageCommentsCondition;
import com.soshow.ssi.leaveMessageComments.service.LeaveMessageCommentsService;

/**
 * 留言评论ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class LeaveMessageCommentsServiceImpl implements LeaveMessageCommentsService{

	@Resource
	private LeaveMessageCommentsDao leaveMessageCommentsDao;
	
	public Integer add(LeaveMessageComments po) {
		return leaveMessageCommentsDao.add(po);
	}
	
	public int delete(Integer id) {
		return leaveMessageCommentsDao.delete(id);
	}
	
	public int update(LeaveMessageComments po) {
		return leaveMessageCommentsDao.update(po);
	}
	
	public LeaveMessageComments findById(Integer id) {
		return leaveMessageCommentsDao.findById(id);
	}
	
	public List<LeaveMessageComments> findPageByCondition(LeaveMessageCommentsCondition pc) {
		return leaveMessageCommentsDao.findPageByCondition(pc);
	}
	
	public Long countByCondition(LeaveMessageCommentsCondition pc) {
		return leaveMessageCommentsDao.countByCondition(pc);
	}
}
