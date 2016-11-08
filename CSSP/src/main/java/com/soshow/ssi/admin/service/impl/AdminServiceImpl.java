package com.soshow.ssi.admin.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.admin.dao.AdminDao;
import com.soshow.ssi.admin.dto.Admin;
import com.soshow.ssi.admin.dto.AdminCondition;
import com.soshow.ssi.admin.service.AdminService;

/**
 * 管理员ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class AdminServiceImpl implements AdminService{

	@Resource
	private AdminDao adminDao;
	
	public Integer add(Admin po) {
		return adminDao.add(po);
	}
	
	public int delete(Integer id) {
		return adminDao.delete(id);
	}
	
	public int update(Admin po) {
		return adminDao.update(po);
	}
	
	public Admin findById(Integer id) {
		return adminDao.findById(id);
	}
	
	public List<Admin> findPageByCondition(AdminCondition pc) {
		return adminDao.findPageByCondition(pc);
	}
	
	public Long countByCondition(AdminCondition pc) {
		return adminDao.countByCondition(pc);
	}
}
