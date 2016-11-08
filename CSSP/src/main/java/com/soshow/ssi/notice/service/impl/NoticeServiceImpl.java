package com.soshow.ssi.notice.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.notice.dao.NoticeDao;
import com.soshow.ssi.notice.dto.Notice;
import com.soshow.ssi.notice.dto.NoticeCondition;
import com.soshow.ssi.notice.service.NoticeService;

/**
 * 公告ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class NoticeServiceImpl implements NoticeService{

	@Resource
	private NoticeDao noticeDao;
	
	public Integer add(Notice po) {
		return noticeDao.add(po);
	}
	
	public int delete(Integer id) {
		return noticeDao.delete(id);
	}
	
	public int update(Notice po) {
		return noticeDao.update(po);
	}
	
	public Notice findById(Integer id) {
		return noticeDao.findById(id);
	}
	
	public List<Notice> findPageByCondition(NoticeCondition pc) {
		return noticeDao.findPageByCondition(pc);
	}
	
	public Long countByCondition(NoticeCondition pc) {
		return noticeDao.countByCondition(pc);
	}
}
