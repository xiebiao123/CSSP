package com.soshow.ssi.resume.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.resume.dao.ResumeDao;
import com.soshow.ssi.resume.dto.Resume;
import com.soshow.ssi.resume.dto.ResumeCondition;
import com.soshow.ssi.resume.service.ResumeService;

/**
 * 简历ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class ResumeServiceImpl implements ResumeService{

	@Resource
	private ResumeDao resumeDao;
	
	public Integer add(Resume po) {
		return resumeDao.add(po);
	}
	
	public int delete(Integer id) {
		return resumeDao.delete(id);
	}
	
	public int update(Resume po) {
		return resumeDao.update(po);
	}
	
	public Resume findById(Integer id) {
		return resumeDao.findById(id);
	}
	
	public List<Resume> findPageByCondition(ResumeCondition pc) {
		return resumeDao.findPageByCondition(pc);
	}
	
	public Long countByCondition(ResumeCondition pc) {
		return resumeDao.countByCondition(pc);
	}
}
