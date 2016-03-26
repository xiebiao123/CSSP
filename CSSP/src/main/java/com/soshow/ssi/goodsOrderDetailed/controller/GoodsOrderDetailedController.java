package com.soshow.ssi.goodsOrderDetailed.controller;

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

import com.soshow.ssi.goodsOrderDetailed.dto.GoodsOrderDetailed;
import com.soshow.ssi.goodsOrderDetailed.dto.GoodsOrderDetailedCondition;
import com.soshow.ssi.goodsOrderDetailed.service.GoodsOrderDetailedService;
import com.soshow.ssi.enums.CommStatusEnum;
import com.soshow.ssi.enums.CommErrorEnum;
import com.soshow.ssi.util.MyResponse;

/**
 * 订单详细controller
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
@Controller
@RequestMapping(value = "goodsOrderDetailed")
public class GoodsOrderDetailedController extends BaseController{

    private final Logger logger = Logger.getLogger(GoodsOrderDetailedController.class);
	
	@Resource
	private GoodsOrderDetailedService goodsOrderDetailedService;
	
	/**
	 *通过id查找订单详细
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MyResponse<GoodsOrderDetailed> findCityById(@PathVariable Integer id) {
		MyResponse<GoodsOrderDetailed> response = new MyResponse<GoodsOrderDetailed>();
		try {
			GoodsOrderDetailed goodsOrderDetailed= goodsOrderDetailedService.findById(id);
			response.setData(goodsOrderDetailed);
			logger.info(goodsOrderDetailed);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *添加订单详细
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public MyResponse<Void> addCity(@Valid @RequestBody GoodsOrderDetailed goodsOrderDetailed) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			Integer id = goodsOrderDetailedService.add(goodsOrderDetailed);
			logger.info(id);
			response.setStatusResponse(CommStatusEnum.ADD);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *删除订单详细
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MyResponse<Void> deleteCity(@PathVariable Integer id) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = goodsOrderDetailedService.delete(id);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.DELETE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *修改订单详细
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public MyResponse<Void> updateCity(@Valid @RequestBody GoodsOrderDetailed goodsOrderDetailed) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = goodsOrderDetailedService.update(goodsOrderDetailed);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.UPDATE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *通过条件分页查询订单详细
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public MyResponse<List<GoodsOrderDetailed>> findCityPageByCondition(GoodsOrderDetailedCondition condition) {
		MyResponse<List<GoodsOrderDetailed>> response = new MyResponse<List<GoodsOrderDetailed>>();
		try {
			/*初始化分页查询*/
			if(condition.getPageSize()>0){
				condition.init();
			}
			int count =  goodsOrderDetailedService.countByCondition(condition);
			if(count==0){
				response.setStatusResponse(CommStatusEnum.NOFIND);
				return response;
			}
			response.setToken(count);
			List<GoodsOrderDetailed> goodsOrderDetailedList = goodsOrderDetailedService.findPageByCondition(condition);
			logger.info(goodsOrderDetailedList);
			response.setData(goodsOrderDetailedList);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}
}
