package com.soshow.ssi.company.service;

import java.util.List;

import com.soshow.ssi.company.dto.Company;
import com.soshow.ssi.company.dto.CompanyCondition;

/**
 * 公司信息Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface CompanyService {

	/**
	 * 新增公司信息
	 */
	public Integer add(Company po);
	/**
	 * 删除公司信息
	 */
	public int delete(Integer id);
	/**
	 * 修改公司信息
	 */
	public int update(Company po);
	/**
	 * 根据id获取公司信息
	 */
	public Company findById(Integer id);
	/**
	 * 分页查询公司信息
	 */
	public List<Company> findPageByCondition(CompanyCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Integer countByCondition(CompanyCondition pc);
	
}
