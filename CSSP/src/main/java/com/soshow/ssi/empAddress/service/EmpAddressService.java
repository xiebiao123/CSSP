package com.soshow.ssi.empAddress.service;

import java.util.List;

import com.soshow.ssi.empAddress.dto.EmpAddress;
import com.soshow.ssi.empAddress.dto.EmpAddressCondition;

/**
 * 员工地址Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface EmpAddressService {

	/**
	 * 新增员工地址
	 */
	public Integer add(EmpAddress po);
	/**
	 * 删除员工地址
	 */
	public int delete(Integer id);
	/**
	 * 修改员工地址
	 */
	public int update(EmpAddress po);
	/**
	 * 根据id获取员工地址
	 */
	public EmpAddress findById(Integer id);
	/**
	 * 分页查询员工地址
	 */
	public List<EmpAddress> findPageByCondition(EmpAddressCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Integer countByCondition(EmpAddressCondition pc);
	
}
