package com.soshow.ssi.log.dto;

import java.sql.Timestamp;

import com.soshow.ssi.util.common.Paging;

/**
 * 操作日志记录表
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class ActLogCondition extends Paging{
	
    private String id;
    private String name;
    private String userName;
    private Timestamp actTime;
    private Integer actType;
    private Integer modelType;
    private String actDesc;
    private String status;
    private String uip;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Timestamp getActTime() {
		return actTime;
	}
	public void setActTime(Timestamp actTime) {
		this.actTime = actTime;
	}
	public Integer getActType() {
		return actType;
	}
	public void setActType(Integer actType) {
		this.actType = actType;
	}
	public Integer getModelType() {
		return modelType;
	}
	public void setModelType(Integer modelType) {
		this.modelType = modelType;
	}
	public String getActDesc() {
		return actDesc;
	}
	public void setActDesc(String actDesc) {
		this.actDesc = actDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUip() {
		return uip;
	}
	public void setUip(String uip) {
		this.uip = uip;
	}
}
