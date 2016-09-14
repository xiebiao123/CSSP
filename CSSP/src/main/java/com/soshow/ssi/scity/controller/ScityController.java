package com.soshow.ssi.scity.controller;

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

import com.soshow.ssi.scity.dto.Scity;
import com.soshow.ssi.scity.dto.ScityCondition;
import com.soshow.ssi.scity.service.ScityService;
import com.soshow.ssi.util.common.MyResponse;
import com.soshow.ssi.enums.CommStatusEnum;
import com.soshow.ssi.enums.CommErrorEnum;

/**
 * 城市controller
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
@Controller
@RequestMapping(value = "scity")
public class ScityController extends BaseController{

    private final Logger logger = Logger.getLogger(ScityController.class);
	
	@Resource
	private ScityService scityService;
	
	/**
	 *通过id查找城市
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MyResponse<Scity> findCityById(@PathVariable Integer id) {
		MyResponse<Scity> response = new MyResponse<Scity>();
		try {
			Scity scity= scityService.findById(id);
			response.setData(scity);
			logger.info(scity);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *添加城市
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public MyResponse<Void> addCity(@Valid @RequestBody Scity scity) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			Integer id = scityService.add(scity);
			logger.info(id);
			response.setStatusResponse(CommStatusEnum.ADD);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *删除城市
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MyResponse<Void> deleteCity(@PathVariable Integer id) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = scityService.delete(id);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.DELETE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *修改城市
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public MyResponse<Void> updateCity(@Valid @RequestBody Scity scity) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = scityService.update(scity);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.UPDATE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *通过条件分页查询城市
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public MyResponse<List<Scity>> findCityPageByCondition(ScityCondition condition) {
		MyResponse<List<Scity>> response = new MyResponse<List<Scity>>();
		try {
			/*初始化分页查询*/
			if(condition.getPageSize()>0){
				condition.init();
			}
			int count =  scityService.countByCondition(condition);
			if(count==0){
				response.setStatusResponse(CommStatusEnum.NOFIND);
				return response;
			}
			response.setToken(count);
			List<Scity> scityList = scityService.findPageByCondition(condition);
			logger.info(scityList);
			response.setData(scityList);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}
}
