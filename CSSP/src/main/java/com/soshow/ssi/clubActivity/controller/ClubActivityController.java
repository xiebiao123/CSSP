package com.soshow.ssi.clubActivity.controller;

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

import com.soshow.ssi.clubActivity.dto.ClubActivity;
import com.soshow.ssi.clubActivity.dto.ClubActivityCondition;
import com.soshow.ssi.clubActivity.service.ClubActivityService;
import com.soshow.ssi.enums.CommStatusEnum;
import com.soshow.ssi.util.common.MyResponse;
import com.soshow.ssi.enums.CommErrorEnum;

/**
 * 社团活动关联controller
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
@Controller
@RequestMapping(value = "clubActivity")
public class ClubActivityController extends BaseController{

    private final Logger logger = Logger.getLogger(ClubActivityController.class);
	
	@Resource
	private ClubActivityService clubActivityService;
	
	/**
	 *通过id查找社团活动关联
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MyResponse<ClubActivity> findCityById(@PathVariable Integer id) {
		MyResponse<ClubActivity> response = new MyResponse<ClubActivity>();
		try {
			ClubActivity clubActivity= clubActivityService.findById(id);
			response.setData(clubActivity);
			logger.info(clubActivity);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *添加社团活动关联
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public MyResponse<Void> addCity(@Valid @RequestBody ClubActivity clubActivity) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			Integer id = clubActivityService.add(clubActivity);
			logger.info(id);
			response.setStatusResponse(CommStatusEnum.ADD);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *删除社团活动关联
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MyResponse<Void> deleteCity(@PathVariable Integer id) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = clubActivityService.delete(id);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.DELETE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *修改社团活动关联
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public MyResponse<Void> updateCity(@Valid @RequestBody ClubActivity clubActivity) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = clubActivityService.update(clubActivity);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.UPDATE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *通过条件分页查询社团活动关联
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public MyResponse<List<ClubActivity>> findCityPageByCondition(ClubActivityCondition condition) {
		MyResponse<List<ClubActivity>> response = new MyResponse<List<ClubActivity>>();
		try {
			/*初始化分页查询*/
			if(condition.getPageSize()>0){
				condition.init();
			}
			int count =  clubActivityService.countByCondition(condition);
			if(count==0){
				response.setStatusResponse(CommStatusEnum.NOFIND);
				return response;
			}
			response.setToken(count);
			List<ClubActivity> clubActivityList = clubActivityService.findPageByCondition(condition);
			logger.info(clubActivityList);
			response.setData(clubActivityList);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}
}
