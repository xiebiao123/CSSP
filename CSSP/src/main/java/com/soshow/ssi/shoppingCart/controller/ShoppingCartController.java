package com.soshow.ssi.shoppingCart.controller;

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

import com.soshow.ssi.shoppingCart.dto.ShoppingCart;
import com.soshow.ssi.shoppingCart.dto.ShoppingCartCondition;
import com.soshow.ssi.shoppingCart.service.ShoppingCartService;
import com.soshow.ssi.enums.CommStatusEnum;
import com.soshow.ssi.enums.CommErrorEnum;
import com.soshow.ssi.util.MyResponse;

/**
 * 购物车controller
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
@Controller
@RequestMapping(value = "shoppingCart")
public class ShoppingCartController extends BaseController{

    private final Logger logger = Logger.getLogger(ShoppingCartController.class);
	
	@Resource
	private ShoppingCartService shoppingCartService;
	
	/**
	 *通过id查找购物车
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MyResponse<ShoppingCart> findCityById(@PathVariable Integer id) {
		MyResponse<ShoppingCart> response = new MyResponse<ShoppingCart>();
		try {
			ShoppingCart shoppingCart= shoppingCartService.findById(id);
			response.setData(shoppingCart);
			logger.info(shoppingCart);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *添加购物车
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public MyResponse<Void> addCity(@Valid @RequestBody ShoppingCart shoppingCart) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			Integer id = shoppingCartService.add(shoppingCart);
			logger.info(id);
			response.setStatusResponse(CommStatusEnum.ADD);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *删除购物车
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MyResponse<Void> deleteCity(@PathVariable Integer id) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = shoppingCartService.delete(id);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.DELETE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *修改购物车
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public MyResponse<Void> updateCity(@Valid @RequestBody ShoppingCart shoppingCart) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = shoppingCartService.update(shoppingCart);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.UPDATE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *通过条件分页查询购物车
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public MyResponse<List<ShoppingCart>> findCityPageByCondition(ShoppingCartCondition condition) {
		MyResponse<List<ShoppingCart>> response = new MyResponse<List<ShoppingCart>>();
		try {
			/*初始化分页查询*/
			if(condition.getPageSize()>0){
				condition.init();
			}
			int count =  shoppingCartService.countByCondition(condition);
			if(count==0){
				response.setStatusResponse(CommStatusEnum.NOFIND);
				return response;
			}
			response.setToken(count);
			List<ShoppingCart> shoppingCartList = shoppingCartService.findPageByCondition(condition);
			logger.info(shoppingCartList);
			response.setData(shoppingCartList);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}
}
