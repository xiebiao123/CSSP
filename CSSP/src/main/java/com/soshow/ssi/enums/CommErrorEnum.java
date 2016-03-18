package com.soshow.ssi.enums;

public enum CommErrorEnum {
	Err01("error01","操作失败"),
	Err02("error02","参数异常"),
	Err03("error03","系统错误");
	private String code;
	private String message;
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
	private CommErrorEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
