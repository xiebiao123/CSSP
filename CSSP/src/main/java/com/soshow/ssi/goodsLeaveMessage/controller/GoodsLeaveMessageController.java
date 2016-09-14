package com.soshow.ssi.goodsLeaveMessage.controller;

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

import com.soshow.ssi.goodsLeaveMessage.dto.GoodsLeaveMessage;
import com.soshow.ssi.goodsLeaveMessage.dto.GoodsLeaveMessageCondition;
import com.soshow.ssi.goodsLeaveMessage.service.GoodsLeaveMessageService;
import com.soshow.ssi.util.common.MyResponse;
import com.soshow.ssi.enums.CommStatusEnum;
import com.soshow.ssi.enums.CommErrorEnum;

/**
 * 留言信息表controller
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
@Controller
@RequestMapping(value = "goodsLeaveMessage")
public class GoodsLeaveMessageController extends BaseController{

    private final Logger logger = Logger.getLogger(GoodsLeaveMessageController.class);
	
	@Resource
	private GoodsLeaveMessageService goodsLeaveMessageService;
	
	/**
	 *通过id查找留言信息表
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MyResponse<GoodsLeaveMessage> findCityById(@PathVariable Integer id) {
		MyResponse<GoodsLeaveMessage> response = new MyResponse<GoodsLeaveMessage>();
		try {
			GoodsLeaveMessage goodsLeaveMessage= goodsLeaveMessageService.findById(id);
			response.setData(goodsLeaveMessage);
			logger.info(goodsLeaveMessage);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *添加留言信息表
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public MyResponse<Void> addCity(@Valid @RequestBody GoodsLeaveMessage goodsLeaveMessage) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			Integer id = goodsLeaveMessageService.add(goodsLeaveMessage);
			logger.info(id);
			response.setStatusResponse(CommStatusEnum.ADD);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *删除留言信息表
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MyResponse<Void> deleteCity(@PathVariable Integer id) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = goodsLeaveMessageService.delete(id);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.DELETE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *修改留言信息表
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public MyResponse<Void> updateCity(@Valid @RequestBody GoodsLeaveMessage goodsLeaveMessage) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = goodsLeaveMessageService.update(goodsLeaveMessage);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.UPDATE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *通过条件分页查询留言信息表
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public MyResponse<List<GoodsLeaveMessage>> findCityPageByCondition(GoodsLeaveMessageCondition condition) {
		MyResponse<List<GoodsLeaveMessage>> response = new MyResponse<List<GoodsLeaveMessage>>();
		try {
			/*初始化分页查询*/
			if(condition.getPageSize()>0){
				condition.init();
			}
			int count =  goodsLeaveMessageService.countByCondition(condition);
			if(count==0){
				response.setStatusResponse(CommStatusEnum.NOFIND);
				return response;
			}
			response.setToken(count);
			List<GoodsLeaveMessage> goodsLeaveMessageList = goodsLeaveMessageService.findPageByCondition(condition);
			logger.info(goodsLeaveMessageList);
			response.setData(goodsLeaveMessageList);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}
}
