package com.soshow.ssi.company.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.soshow.ssi.company.dao.CompanyDao;
import com.soshow.ssi.company.dto.Company;
import com.soshow.ssi.company.dto.CompanyCondition;
import com.soshow.ssi.company.service.CompanyService;

/**
 * 公司信息ServiceImpl
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:09:48
 *
 */
@Service
public class CompanyServiceImpl implements CompanyService{

	@Resource
	private CompanyDao companyDao;
	
	public Integer add(Company po) {
		return companyDao.add(po);
	}
	
	public int delete(Integer id) {
		return companyDao.delete(id);
	}
	
	public int update(Company po) {
		return companyDao.update(po);
	}
	
	public Company findById(Integer id) {
		return companyDao.findById(id);
	}
	
	public List<Company> findPageByCondition(CompanyCondition pc) {
		return companyDao.findPageByCondition(pc);
	}
	
	public Long countByCondition(CompanyCondition pc) {
		return companyDao.countByCondition(pc);
	}
}
