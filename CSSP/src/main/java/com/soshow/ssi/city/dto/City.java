package com.soshow.ssi.city.dto;

import javax.validation.constraints.NotNull;

/**
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 上午11:07:11
 */
public class City{

	private Integer id;
	@NotNull(message="城市名不能为空")
	private String cityName;
	private Integer provinceId;

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
