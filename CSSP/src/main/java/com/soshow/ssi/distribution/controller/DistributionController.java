package com.soshow.ssi.distribution.controller;

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

import com.soshow.ssi.distribution.dto.Distribution;
import com.soshow.ssi.distribution.dto.DistributionCondition;
import com.soshow.ssi.distribution.service.DistributionService;
import com.soshow.ssi.enums.CommStatusEnum;
import com.soshow.ssi.util.common.MyResponse;
import com.soshow.ssi.enums.CommErrorEnum;

/**
 * 配送方式controller
 * @author xieb
 * @version 1.00
 * 2016/04/07
 */
@Controller
@RequestMapping(value = "distribution")
public class DistributionController extends BaseController{

    private final Logger logger = Logger.getLogger(DistributionController.class);
	
	@Resource
	private DistributionService distributionService;
	
	/**
	 *通过id查找配送方式
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MyResponse<Distribution> findCityById(@PathVariable Integer id) {
		MyResponse<Distribution> response = new MyResponse<Distribution>();
		try {
			Distribution distribution= distributionService.findById(id);
			response.setData(distribution);
			logger.info(distribution);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *添加配送方式
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public MyResponse<Void> addCity(@Valid @RequestBody Distribution distribution) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			Integer id = distributionService.add(distribution);
			logger.info(id);
			response.setStatusResponse(CommStatusEnum.ADD);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *删除配送方式
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MyResponse<Void> deleteCity(@PathVariable Integer id) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = distributionService.delete(id);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.DELETE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *修改配送方式
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public MyResponse<Void> updateCity(@Valid @RequestBody Distribution distribution) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = distributionService.update(distribution);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.UPDATE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *通过条件分页查询配送方式
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public MyResponse<List<Distribution>> findCityPageByCondition(DistributionCondition condition) {
		MyResponse<List<Distribution>> response = new MyResponse<List<Distribution>>();
		try {
			/*初始化分页查询*/
			if(condition.getPageSize()>0){
				condition.init();
			}
			long count =  distributionService.countByCondition(condition);
			if(count==0){
				response.setStatusResponse(CommStatusEnum.NOFIND);
				return response;
			}
			response.setToken(count);
			List<Distribution> distributionList = distributionService.findPageByCondition(condition);
			logger.info(distributionList);
			response.setData(distributionList);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}
}
