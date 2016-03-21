package com.soshow.ssi.admin.dao.impl;

import org.springframework.stereotype.Repository;

import com.soshow.ssi.base.BaseDaoImpl;
import com.soshow.ssi.admin.dao.AdminDao;
import com.soshow.ssi.admin.dto.Admin;
import com.soshow.ssi.admin.dto.AdminCondition;

/**
 * 管理员daoImpl
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
 
@Repository
public class AdminDaoImpl extends BaseDaoImpl<Admin,AdminCondition> implements AdminDao{
	
}
