package com.soshow.ssi.studentWork.dao.impl;

import org.springframework.stereotype.Repository;

import com.soshow.ssi.base.BaseDaoImpl;
import com.soshow.ssi.studentWork.dao.StudentWorkDao;
import com.soshow.ssi.studentWork.dto.StudentWork;
import com.soshow.ssi.studentWork.dto.StudentWorkCondition;

/**
 * 学生工作关联daoImpl
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
 
@Repository
public class StudentWorkDaoImpl extends BaseDaoImpl<StudentWork,StudentWorkCondition> implements StudentWorkDao{
	
}
