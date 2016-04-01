package com.soshow.ssi.goods.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.soshow.ssi.base.BaseController;

import com.soshow.ssi.goods.dto.Goods;
import com.soshow.ssi.goods.dto.GoodsCondition;
import com.soshow.ssi.goods.service.GoodsService;
import com.soshow.ssi.enums.CommStatusEnum;
import com.soshow.ssi.enums.CommErrorEnum;
import com.soshow.ssi.util.MyResponse;

/**
 * 商品信息controller
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
@Controller
@RequestMapping(value = "goods")
public class GoodsController extends BaseController{

    private final Logger logger = Logger.getLogger(GoodsController.class);
	
	@Resource
	private GoodsService goodsService;
	
	/**
	 *通过id查找商品信息
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MyResponse<Goods> findCityById(@PathVariable Integer id) {
		MyResponse<Goods> response = new MyResponse<Goods>();
		try {
			Goods goods= goodsService.findById(id);
			response.setData(goods);
			logger.info(goods);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *添加商品信息
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public MyResponse<Void> addCity(@Valid @RequestBody Goods goods) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			Integer id = goodsService.add(goods);
			logger.info(id);
			response.setStatusResponse(CommStatusEnum.ADD);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *删除商品信息
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MyResponse<Void> deleteCity(@PathVariable Integer id) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = goodsService.delete(id);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.DELETE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *修改商品信息
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public MyResponse<Void> updateCity(@Valid @RequestBody Goods goods) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = goodsService.update(goods);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.UPDATE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *通过条件分页查询商品信息
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public MyResponse<List<Goods>> findCityPageByCondition(GoodsCondition condition) {
		MyResponse<List<Goods>> response = new MyResponse<List<Goods>>();
		try {
			/*初始化分页查询*/
			if(condition.getPageSize()>0){
				condition.init();
			}
			int count =  goodsService.countByCondition(condition);
			if(count==0){
				response.setStatusResponse(CommStatusEnum.NOFIND);
				return response;
			}
			response.setToken(count);
			List<Goods> goodsList = goodsService.findPageByCondition(condition);
			logger.info(goodsList);
			response.setData(goodsList);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}
	
	  /** 
	    * 上传图片 
	    * @param file 
	    * @return 
	    */ 
	   @ResponseBody 
	   @RequestMapping(value="/upload", method = RequestMethod.POST) 
	   public MyResponse<String> upload(@RequestParam(value="file") MultipartFile file){ 
	      MyResponse<String> response=new MyResponse<String>(); 
	      try { 
	      String url=goodsService.upload(file); 
	      response.setData(url); 
	      }catch(Throwable t){ 
	         logger.error("系统错误",t); 
	         response.setErrorResponse(CommErrorEnum.Err03); 
	      } 
	      return response; 
	   }
	   
}
