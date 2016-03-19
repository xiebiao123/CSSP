package com.soshow.ssi.emp.controller;

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

import com.soshow.ssi.emp.dto.Emp;
import com.soshow.ssi.emp.dto.EmpCondition;
import com.soshow.ssi.emp.service.EmpService;
import com.soshow.ssi.enums.CommStatusEnum;
import com.soshow.ssi.enums.CommErrorEnum;
import com.soshow.ssi.util.MyResponse;

/**
 * 员工controller
 * @author xieb
 * @version 1.00
 * 2016/03/19
 */
@Controller
@RequestMapping(value = "emp")
public class EmpController extends BaseController{

    private final Logger logger = Logger.getLogger(EmpController.class);
	
	@Resource
	private EmpService empService;
	
	/**
	 *通过id查找员工
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MyResponse<Emp> findCityById(@PathVariable Integer id) {
		MyResponse<Emp> response = new MyResponse<Emp>();
		try {
			Emp emp= empService.findById(id);
			response.setData(emp);
			logger.info(emp);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.info("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *添加员工
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public MyResponse<Void> addCity(@Valid @RequestBody Emp emp) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			Integer id = empService.add(emp);
			logger.info(id);
			response.setStatusResponse(CommStatusEnum.ADD);
		} catch (Throwable t) {
			logger.info("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *删除员工
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MyResponse<Void> deleteCity(@PathVariable Integer id) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = empService.delete(id);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.DELETE);
		} catch (Throwable t) {
			logger.info("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *修改员工
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public MyResponse<Void> updateCity(@Valid @RequestBody Emp emp) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = empService.update(emp);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.UPDATE);
		} catch (Throwable t) {
			logger.info("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *通过条件分页查询员工
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public MyResponse<List<Emp>> findCityPageByCondition(EmpCondition condition) {
		MyResponse<List<Emp>> response = new MyResponse<List<Emp>>();
		try {
			int count =  empService.countByCondition(condition);
			if(count==0){
				response.setStatusResponse(CommStatusEnum.NOFIND);
				return response;
			}
			response.setToken(count);
			List<Emp> empList = empService.findPageByCondition(condition);
			logger.info(empList);
			response.setData(empList);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}
}
