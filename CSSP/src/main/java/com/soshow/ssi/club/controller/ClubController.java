package com.soshow.ssi.club.controller;

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

import com.soshow.ssi.club.dto.Club;
import com.soshow.ssi.club.dto.ClubCondition;
import com.soshow.ssi.club.service.ClubService;
import com.soshow.ssi.enums.CommStatusEnum;
import com.soshow.ssi.util.common.MyResponse;
import com.soshow.ssi.enums.CommErrorEnum;

/**
 * 社团信息controller
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
@Controller
@RequestMapping(value = "club")
public class ClubController extends BaseController{

    private final Logger logger = Logger.getLogger(ClubController.class);
	
	@Resource
	private ClubService clubService;
	
	/**
	 *通过id查找社团信息
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MyResponse<Club> findCityById(@PathVariable Integer id) {
		MyResponse<Club> response = new MyResponse<Club>();
		try {
			Club club= clubService.findById(id);
			response.setData(club);
			logger.info(club);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *添加社团信息
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public MyResponse<Void> addCity(@Valid @RequestBody Club club) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			Integer id = clubService.add(club);
			logger.info(id);
			response.setStatusResponse(CommStatusEnum.ADD);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *删除社团信息
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MyResponse<Void> deleteCity(@PathVariable Integer id) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = clubService.delete(id);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.DELETE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *修改社团信息
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public MyResponse<Void> updateCity(@Valid @RequestBody Club club) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = clubService.update(club);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.UPDATE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *通过条件分页查询社团信息
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public MyResponse<List<Club>> findCityPageByCondition(ClubCondition condition) {
		MyResponse<List<Club>> response = new MyResponse<List<Club>>();
		try {
			/*初始化分页查询*/
			if(condition.getPageSize()>0){
				condition.init();
			}
			int count =  clubService.countByCondition(condition);
			if(count==0){
				response.setStatusResponse(CommStatusEnum.NOFIND);
				return response;
			}
			response.setToken(count);
			List<Club> clubList = clubService.findPageByCondition(condition);
			logger.info(clubList);
			response.setData(clubList);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}
}
