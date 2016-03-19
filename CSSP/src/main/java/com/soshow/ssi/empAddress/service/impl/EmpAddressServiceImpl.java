package com.soshow.ssi.empAddress.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.empAddress.dao.EmpAddressDao;
import com.soshow.ssi.empAddress.dto.EmpAddress;
import com.soshow.ssi.empAddress.dto.EmpAddressCondition;
import com.soshow.ssi.empAddress.service.EmpAddressService;

/**
 * 员工地址ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class EmpAddressServiceImpl implements EmpAddressService{

	@Resource
	private EmpAddressDao empAddressDao;
	
	public Integer add(EmpAddress po) {
		return empAddressDao.add(po);
	}
	
	public int delete(Integer id) {
		return empAddressDao.delete(id);
	}
	
	public int update(EmpAddress po) {
		return empAddressDao.update(po);
	}
	
	public EmpAddress findById(Integer id) {
		return empAddressDao.findById(id);
	}
	
	public List<EmpAddress> findPageByCondition(EmpAddressCondition pc) {
		return empAddressDao.findPageByCondition(pc);
	}
	
	public Integer countByCondition(EmpAddressCondition pc) {
		return empAddressDao.countByCondition(pc);
	}
}
