package com.soshow.ssi.empAddress.controller;

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

import com.soshow.ssi.empAddress.dto.EmpAddress;
import com.soshow.ssi.empAddress.dto.EmpAddressCondition;
import com.soshow.ssi.empAddress.service.EmpAddressService;
import com.soshow.ssi.enums.CommStatusEnum;
import com.soshow.ssi.enums.CommErrorEnum;
import com.soshow.ssi.util.MyResponse;

/**
 * 员工地址controller
 * @author xieb
 * @version 1.00
 * 2016/03/19
 */
@Controller
@RequestMapping(value = "empAddress")
public class EmpAddressController extends BaseController{

    private final Logger logger = Logger.getLogger(EmpAddressController.class);
	
	@Resource
	private EmpAddressService empAddressService;
	
	/**
	 *通过id查找员工地址
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MyResponse<EmpAddress> findCityById(@PathVariable Integer id) {
		MyResponse<EmpAddress> response = new MyResponse<EmpAddress>();
		try {
			EmpAddress empAddress= empAddressService.findById(id);
			response.setData(empAddress);
			logger.info(empAddress);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *添加员工地址
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public MyResponse<Void> addCity(@Valid @RequestBody EmpAddress empAddress) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			Integer id = empAddressService.add(empAddress);
			logger.info(id);
			response.setStatusResponse(CommStatusEnum.ADD);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *删除员工地址
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MyResponse<Void> deleteCity(@PathVariable Integer id) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = empAddressService.delete(id);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.DELETE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *修改员工地址
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public MyResponse<Void> updateCity(@Valid @RequestBody EmpAddress empAddress) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = empAddressService.update(empAddress);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.UPDATE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *通过条件分页查询员工地址
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public MyResponse<List<EmpAddress>> findCityPageByCondition(EmpAddressCondition condition) {
		MyResponse<List<EmpAddress>> response = new MyResponse<List<EmpAddress>>();
		try {
			int count =  empAddressService.countByCondition(condition);
			if(count==0){
				response.setStatusResponse(CommStatusEnum.NOFIND);
				return response;
			}
			response.setToken(count);
			List<EmpAddress> empAddressList = empAddressService.findPageByCondition(condition);
			logger.info(empAddressList);
			response.setData(empAddressList);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}
}
