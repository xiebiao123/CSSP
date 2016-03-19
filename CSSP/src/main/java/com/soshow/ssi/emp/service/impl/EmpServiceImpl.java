package com.soshow.ssi.emp.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.emp.dao.EmpDao;
import com.soshow.ssi.emp.dto.Emp;
import com.soshow.ssi.emp.dto.EmpCondition;
import com.soshow.ssi.emp.service.EmpService;

/**
 * 员工ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class EmpServiceImpl implements EmpService{

	@Resource
	private EmpDao empDao;
	
	public Integer add(Emp po) {
		return empDao.add(po);
	}
	
	public int delete(Integer id) {
		return empDao.delete(id);
	}
	
	public int update(Emp po) {
		return empDao.update(po);
	}
	
	public Emp findById(Integer id) {
		return empDao.findById(id);
	}
	
	public List<Emp> findPageByCondition(EmpCondition pc) {
		return empDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(EmpCondition pc) {
		return empDao.countByCondition(pc);
	}
}
