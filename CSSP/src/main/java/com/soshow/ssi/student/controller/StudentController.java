package com.soshow.ssi.student.controller;

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

import com.soshow.ssi.student.dto.Student;
import com.soshow.ssi.student.dto.StudentCondition;
import com.soshow.ssi.student.service.StudentService;
import com.soshow.ssi.util.common.MyResponse;
import com.soshow.ssi.enums.CommStatusEnum;
import com.soshow.ssi.enums.CommErrorEnum;

/**
 * 学生信息controller
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
@Controller
@RequestMapping(value = "student")
public class StudentController extends BaseController{

    private final Logger logger = Logger.getLogger(StudentController.class);
	
	@Resource
	private StudentService studentService;
	
	/**
	 *通过id查找学生信息
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MyResponse<Student> findCityById(@PathVariable Integer id) {
		MyResponse<Student> response = new MyResponse<Student>();
		try {
			Student student= studentService.findById(id);
			response.setData(student);
			logger.info(student);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *添加学生信息
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public MyResponse<Void> addCity(@Valid @RequestBody Student student) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			Integer id = studentService.add(student);
			logger.info(id);
			response.setStatusResponse(CommStatusEnum.ADD);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *删除学生信息
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MyResponse<Void> deleteCity(@PathVariable Integer id) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = studentService.delete(id);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.DELETE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *修改学生信息
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public MyResponse<Void> updateCity(@Valid @RequestBody Student student) {
		MyResponse<Void> response = new MyResponse<Void>();
		try {
			int count = studentService.update(student);
			logger.info(count);
			response.setStatusResponse(CommStatusEnum.UPDATE);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}

	/**
	 *通过条件分页查询学生信息
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public MyResponse<List<Student>> findCityPageByCondition(StudentCondition condition) {
		MyResponse<List<Student>> response = new MyResponse<List<Student>>();
		try {
			/*初始化分页查询*/
			if(condition.getPageSize()>0){
				condition.init();
			}
			int count =  studentService.countByCondition(condition);
			if(count==0){
				response.setStatusResponse(CommStatusEnum.NOFIND);
				return response;
			}
			response.setToken(count);
			List<Student> studentList = studentService.findPageByCondition(condition);
			logger.info(studentList);
			response.setData(studentList);
			response.setStatusResponse(CommStatusEnum.FIND);
		} catch (Throwable t) {
			logger.error("系统错误", t);
			response.setErrorResponse(CommErrorEnum.Err03);
		}
		return response;
	}
}
