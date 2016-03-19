package com.soshow.ssi.emp.service;

import java.util.List;

import com.soshow.ssi.emp.dto.Emp;
import com.soshow.ssi.emp.dto.EmpCondition;

/**
 * 员工Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface EmpService {

	/**
	 * 新增员工
	 */
	public Integer add(Emp po);
	/**
	 * 删除员工
	 */
	public int delete(Integer id);
	/**
	 * 修改员工
	 */
	public int update(Emp po);
	/**
	 * 根据id获取员工
	 */
	public Emp findById(Integer id);
	/**
	 * 分页查询员工
	 */
	public List<Emp> findPageByCondition(EmpCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Integer countByCondition(EmpCondition pc);
	
}
