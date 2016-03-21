package com.soshow.ssi.studentWork.controller;

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

import com.soshow.ssi.studentWork.dto.StudentWork;
import com.soshow.ssi.studentWork.dto.StudentWorkCondition;
import com.soshow.ssi.studentWork.service.StudentWorkService;
import com.soshow.ssi.enums.CommStatusEnum;
import com.soshow.ssi.enums.CommErrorEnum;
import com.soshow.ssi.util.MyResponse;

/**
 * 学生工作关联controller
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
@Controller
@RequestMapping(value = "studentWork")
public class StudentWorkController extends BaseController{

    private final Logger logger = Logger.getLogger(StudentWorkController.class);
	
	@Resource
	private StudentWorkService studentWorkService;
	
	/**
	 *通过id查找学生工作关联
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MyResponse<StudentWork> findCityById(@PathVariable Integer id) {
		MyResponse<StudentWork> response = new MyResponse<StudentWork>();
		try {
			StudentWork studentWork= studentWorkService.findById(id);
			response.setData(studentWork);
			logger.info(studentWork);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *添加学生工作关联
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public MyResponse<Void> addCity(@Valid @RequestBody StudentWork studentWork) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			Integer id = studentWorkService.add(studentWork);
			logger.info(id);
			response.setStatusResponse(CommStatusEnum.ADD);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *删除学生工作关联
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MyResponse<Void> deleteCity(@PathVariable Integer id) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = studentWorkService.delete(id);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.DELETE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *修改学生工作关联
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public MyResponse<Void> updateCity(@Valid @RequestBody StudentWork studentWork) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = studentWorkService.update(studentWork);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.UPDATE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *通过条件分页查询学生工作关联
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public MyResponse<List<StudentWork>> findCityPageByCondition(StudentWorkCondition condition) {
		MyResponse<List<StudentWork>> response = new MyResponse<List<StudentWork>>();
		try {
			int count =  studentWorkService.countByCondition(condition);
			if(count==0){
				response.setStatusResponse(CommStatusEnum.NOFIND);
				return response;
			}
			response.setToken(count);
			List<StudentWork> studentWorkList = studentWorkService.findPageByCondition(condition);
			logger.info(studentWorkList);
			response.setData(studentWorkList);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}
}
