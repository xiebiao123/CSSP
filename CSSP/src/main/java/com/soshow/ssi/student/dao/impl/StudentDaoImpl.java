package com.soshow.ssi.student.dao.impl;

import org.springframework.stereotype.Repository;

import com.soshow.ssi.base.BaseDaoImpl;
import com.soshow.ssi.student.dao.StudentDao;
import com.soshow.ssi.student.dto.Student;
import com.soshow.ssi.student.dto.StudentCondition;

/**
 * 学生信息daoImpl
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
 
@Repository
public class StudentDaoImpl extends BaseDaoImpl<Student,StudentCondition> implements StudentDao{
	
}
