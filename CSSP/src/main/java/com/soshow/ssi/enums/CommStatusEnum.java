package com.soshow.ssi.enums;

public enum CommStatusEnum {
	ADD("1","添加成功！"),
	DELETE("2","删除成功！"),
	FIND("3","查找成功！"),
	UPDATE("4","更新成功！"),
	NOFIND("5","资源不存在！"),
	FAIL("0","操作失败！");
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
	private CommStatusEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
