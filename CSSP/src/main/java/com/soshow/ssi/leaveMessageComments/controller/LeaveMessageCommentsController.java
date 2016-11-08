package com.soshow.ssi.leaveMessageComments.controller;

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

import com.soshow.ssi.leaveMessageComments.dto.LeaveMessageComments;
import com.soshow.ssi.leaveMessageComments.dto.LeaveMessageCommentsCondition;
import com.soshow.ssi.leaveMessageComments.service.LeaveMessageCommentsService;
import com.soshow.ssi.util.common.MyResponse;
import com.soshow.ssi.enums.CommStatusEnum;
import com.soshow.ssi.enums.CommErrorEnum;

/**
 * 留言评论controller
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
@Controller
@RequestMapping(value = "leaveMessageComments")
public class LeaveMessageCommentsController extends BaseController{

    private final Logger logger = Logger.getLogger(LeaveMessageCommentsController.class);
	
	@Resource
	private LeaveMessageCommentsService leaveMessageCommentsService;
	
	/**
	 *通过id查找留言评论
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MyResponse<LeaveMessageComments> findCityById(@PathVariable Integer id) {
		MyResponse<LeaveMessageComments> response = new MyResponse<LeaveMessageComments>();
		try {
			LeaveMessageComments leaveMessageComments= leaveMessageCommentsService.findById(id);
			response.setData(leaveMessageComments);
			logger.info(leaveMessageComments);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *添加留言评论
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public MyResponse<Void> addCity(@Valid @RequestBody LeaveMessageComments leaveMessageComments) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			Integer id = leaveMessageCommentsService.add(leaveMessageComments);
			logger.info(id);
			response.setStatusResponse(CommStatusEnum.ADD);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *删除留言评论
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MyResponse<Void> deleteCity(@PathVariable Integer id) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = leaveMessageCommentsService.delete(id);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.DELETE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *修改留言评论
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public MyResponse<Void> updateCity(@Valid @RequestBody LeaveMessageComments leaveMessageComments) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = leaveMessageCommentsService.update(leaveMessageComments);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.UPDATE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *通过条件分页查询留言评论
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public MyResponse<List<LeaveMessageComments>> findCityPageByCondition(LeaveMessageCommentsCondition condition) {
		MyResponse<List<LeaveMessageComments>> response = new MyResponse<List<LeaveMessageComments>>();
		try {
			/*初始化分页查询*/
			if(condition.getPageSize()>0){
				condition.init();
			}
			long count =  leaveMessageCommentsService.countByCondition(condition);
			if(count==0){
				response.setStatusResponse(CommStatusEnum.NOFIND);
				return response;
			}
			response.setToken(count);
			List<LeaveMessageComments> leaveMessageCommentsList = leaveMessageCommentsService.findPageByCondition(condition);
			logger.info(leaveMessageCommentsList);
			response.setData(leaveMessageCommentsList);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}
}
