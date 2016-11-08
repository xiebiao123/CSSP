package com.soshow.ssi.log.controller;

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

import com.soshow.ssi.util.common.MyResponse;
import com.soshow.ssi.enums.CommStatusEnum;
import com.soshow.ssi.log.service.ActLogService;
import com.soshow.ssi.log.dto.ActLog;
import com.soshow.ssi.enums.CommErrorEnum;

/**
 * 日志记录controller
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
@Controller
@RequestMapping(value = "ActLog")
public class ActLogController extends BaseController{

    private final Logger logger = Logger.getLogger(ActLogController.class);
	
	@Resource
	private ActLogService actLogService;
	
	/**
	 *通过id查找操作日志
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MyResponse<ActLog> findActLogById(@PathVariable String id) {
		MyResponse<ActLog> response = new MyResponse<ActLog>();
		try {
			ActLog actLog= actLogService.findById(id);
			response.setData(actLog);
			logger.info(actLog);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *添加操作日志
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public MyResponse<Void> addActLog(@Valid @RequestBody ActLog ActLog) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			ActLog log = actLogService.add(ActLog);
			logger.info(log.getId());
			response.setStatusResponse(CommStatusEnum.ADD);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *删除操作日志
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MyResponse<Void> deleteActLog(@PathVariable String id) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			ActLog actLog = new ActLog();
			actLog.setId(id);
			int count = actLogService.delete(actLog);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.DELETE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *修改操作日志
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public MyResponse<Void> updateActLog(@Valid @RequestBody ActLog ActLog) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = actLogService.update(ActLog);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.UPDATE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *通过条件分页查询操作日志
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public MyResponse<List<ActLog>> findActLogPageByCondition(ActLog actLog) {
		MyResponse<List<ActLog>> response = new MyResponse<List<ActLog>>();
		try {
			/*初始化分页查询*/
			if(actLog.getPageSize()>0){
				actLog.init();
			}
			long count =  actLogService.countByCondition(actLog);
			if(count==0){
				response.setStatusResponse(CommStatusEnum.NOFIND);
				return response;
			}
			response.setToken(count);
			List<ActLog> ActLogList = actLogService.findPageByCondition(actLog);
			logger.info(ActLogList);
			response.setData(ActLogList);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}
}
