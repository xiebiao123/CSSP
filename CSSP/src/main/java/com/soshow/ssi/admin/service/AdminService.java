package com.soshow.ssi.admin.service;

import java.util.List;

import com.soshow.ssi.admin.dto.Admin;
import com.soshow.ssi.admin.dto.AdminCondition;

/**
 * 管理员Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface AdminService {

	/**
	 * 新增管理员
	 */
	public Integer add(Admin po);
	/**
	 * 删除管理员
	 */
	public int delete(Integer id);
	/**
	 * 修改管理员
	 */
	public int update(Admin po);
	/**
	 * 根据id获取管理员
	 */
	public Admin findById(Integer id);
	/**
	 * 分页查询管理员
	 */
	public List<Admin> findPageByCondition(AdminCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Long countByCondition(AdminCondition pc);
	
}
