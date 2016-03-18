package com.soshow.ssi.city.service;

import java.util.List;

import com.soshow.ssi.city.dto.City;
import com.soshow.ssi.city.dto.CityCondition;

/**
 * 
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:08:06
 *
 */
public interface CityService {

	/**
	 * 新增城市
	 * @param po
	 * @return
	 */
	public Integer add(City po);
	/**
	 * 删除城市
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	/**
	 * 修改城市
	 * @param po
	 * @return
	 */
	public int update(City po);
	/**
	 * 根据省id获取市
	 * @param param
	 * @return
	 */
	public City findById(Integer id);
	/**
	 * 分页查询
	 * @param pc
	 * @return
	 */
	public List<City> findPageByCondition(CityCondition pc);
	
}
