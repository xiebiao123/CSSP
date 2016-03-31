package com.soshow.ssi.goodsOrder.controller;

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

import com.soshow.ssi.goodsOrder.dto.GoodsOrder;
import com.soshow.ssi.goodsOrder.dto.GoodsOrderCondition;
import com.soshow.ssi.goodsOrder.service.GoodsOrderService;
import com.soshow.ssi.enums.CommStatusEnum;
import com.soshow.ssi.enums.CommErrorEnum;
import com.soshow.ssi.util.MyResponse;

/**
 * 商品订单controller
 * @author xieb
 * @version 1.00
 * 2016/03/31
 */
@Controller
@RequestMapping(value = "goodsOrder")
public class GoodsOrderController extends BaseController{

    private final Logger logger = Logger.getLogger(GoodsOrderController.class);
	
	@Resource
	private GoodsOrderService goodsOrderService;
	
	/**
	 *通过id查找商品订单
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MyResponse<GoodsOrder> findCityById(@PathVariable Integer id) {
		MyResponse<GoodsOrder> response = new MyResponse<GoodsOrder>();
		try {
			GoodsOrder goodsOrder= goodsOrderService.findById(id);
			response.setData(goodsOrder);
			logger.info(goodsOrder);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *添加商品订单
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public MyResponse<Void> addCity(@Valid @RequestBody GoodsOrder goodsOrder) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			Integer id = goodsOrderService.add(goodsOrder);
			logger.info(id);
			response.setStatusResponse(CommStatusEnum.ADD);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *删除商品订单
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MyResponse<Void> deleteCity(@PathVariable Integer id) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = goodsOrderService.delete(id);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.DELETE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *修改商品订单
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public MyResponse<Void> updateCity(@Valid @RequestBody GoodsOrder goodsOrder) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = goodsOrderService.update(goodsOrder);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.UPDATE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *通过条件分页查询商品订单
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public MyResponse<List<GoodsOrder>> findCityPageByCondition(GoodsOrderCondition condition) {
		MyResponse<List<GoodsOrder>> response = new MyResponse<List<GoodsOrder>>();
		try {
			/*初始化分页查询*/
			if(condition.getPageSize()>0){
				condition.init();
			}
			int count =  goodsOrderService.countByCondition(condition);
			if(count==0){
				response.setStatusResponse(CommStatusEnum.NOFIND);
				return response;
			}
			response.setToken(count);
			List<GoodsOrder> goodsOrderList = goodsOrderService.findPageByCondition(condition);
			logger.info(goodsOrderList);
			response.setData(goodsOrderList);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}
}
