package com.soshow.ssi.emp.dao.impl;

import org.springframework.stereotype.Repository;

import com.soshow.ssi.base.BaseDaoImpl;
import com.soshow.ssi.emp.dao.EmpDao;
import com.soshow.ssi.emp.dto.Emp;
import com.soshow.ssi.emp.dto.EmpCondition;

/**
 * 员工daoImpl
 * @author xieb
 * @version 1.00
 * 2016/03/19
 */
 
@Repository
public class EmpDaoImpl extends BaseDaoImpl<Emp,EmpCondition> implements EmpDao{
	
}
