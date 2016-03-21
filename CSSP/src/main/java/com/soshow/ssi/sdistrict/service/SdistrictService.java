package com.soshow.ssi.sdistrict.service;

import java.util.List;

import com.soshow.ssi.sdistrict.dto.Sdistrict;
import com.soshow.ssi.sdistrict.dto.SdistrictCondition;

/**
 * 县乡Service
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface SdistrictService {

	/**
	 * 新增县乡
	 */
	public Integer add(Sdistrict po);
	/**
	 * 删除县乡
	 */
	public int delete(Integer id);
	/**
	 * 修改县乡
	 */
	public int update(Sdistrict po);
	/**
	 * 根据id获取县乡
	 */
	public Sdistrict findById(Integer id);
	/**
	 * 分页查询县乡
	 */
	public List<Sdistrict> findPageByCondition(SdistrictCondition pc);
	
	/**
	 * 统计查询数据的条数
	 */
	public Integer countByCondition(SdistrictCondition pc);
	
}
