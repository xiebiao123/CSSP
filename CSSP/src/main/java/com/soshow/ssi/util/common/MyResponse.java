package com.soshow.ssi.util.common;

import java.util.List;

import com.soshow.ssi.enums.CommErrorEnum;
import com.soshow.ssi.enums.CommStatusEnum;

public class MyResponse<T> {
	
	private Integer token;
	private String code;
	private String message;
	private T data;
	private List<MyError> error;
	
	/*默认操作失败*/
	public MyResponse() {
		setStatusResponse(CommStatusEnum.FAIL);
	}
	
	public void setStatusResponse(CommStatusEnum statusEnum){
		this.code=statusEnum.getCode();
		this.message=statusEnum.getMessage();
	}
	public void setErrorResponse(CommErrorEnum errorEnum){
		this.code=errorEnum.getCode();
		this.message=errorEnum.getMessage();
	}
	public Integer getToken() {
		return token;
	}
	public void setToken(Integer token) {
		this.token = token;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<MyError> getError() {
		return error;
	}
	public void setError(List<MyError> error) {
		this.error = error;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
