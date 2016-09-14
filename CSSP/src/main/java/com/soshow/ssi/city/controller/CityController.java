package com.soshow.ssi.city.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soshow.ssi.base.BaseController;
import com.soshow.ssi.city.dto.City;
import com.soshow.ssi.city.dto.CityCondition;
import com.soshow.ssi.city.service.CityService;
import com.soshow.ssi.enums.CommErrorEnum;
import com.soshow.ssi.enums.CommStatusEnum;
import com.soshow.ssi.util.common.MyResponse;

/**
 * 
 * @version 1.0
 * @author xieb
 * @date 2014年12月9日 下午2:11:33
 *
 */
@Controller
@RequestMapping(value = "city")
public class CityController extends BaseController{

	private final Logger logger = Logger.getLogger(CityController.class);

	@Resource
	private CityService cityService;

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MyResponse<City> findCityById(@PathVariable Integer id) {
		MyResponse<City> response = new MyResponse<City>();
		try {
			City city= cityService.findById(id);
			response.setData(city);
			logger.info(city);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.info("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public MyResponse<Void> addCity(@Valid @RequestBody City city) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			Integer id = cityService.add(city);
			logger.info(id);
			response.setStatusResponse(CommStatusEnum.ADD);
		} catch (Throwable t) {
			logger.info("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MyResponse<Void> deleteCity(@PathVariable Integer id) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = cityService.delete(id);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.DELETE);
		} catch (Throwable t) {
			logger.info("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public MyResponse<Void> updateCity(@Valid @RequestBody City city) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = cityService.update(city);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.UPDATE);
		} catch (Throwable t) {
			logger.info("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public MyResponse<List<City>> findCityPageByCondition(CityCondition condition) {
		MyResponse<List<City>> response = new MyResponse<List<City>>();
		try {
			/*初始化分页查询*/
			if(condition.getPageSize()>0){
				condition.init();
			}
			int count = cityService.countByCondition(condition);
			if(count==0){
				response.setStatusResponse(CommStatusEnum.NOFIND);
				return response;
			}
			response.setToken(count);
			List<City> cityList = cityService.findPageByCondition(condition);
			logger.info(cityList);
			response.setData(cityList);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.info("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}
}
