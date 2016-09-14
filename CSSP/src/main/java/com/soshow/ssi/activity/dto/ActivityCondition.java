package com.soshow.ssi.activity.dto;

import java.sql.Timestamp;

import com.soshow.ssi.util.common.Paging;
/**
 * 活动信息condition
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class ActivityCondition extends Paging{

    /**  */
    private Integer id;

    /**  */
    private String name;

    /**  */
    private Timestamp startTime;

    /**  */
    private Timestamp endTime;

    /**  */
    private String remark;

    /**  */
    private String reason;

    /**  */
    private String approver;

    /**  */
    private Integer studentId;

    /**  */
    private String address;

    /**  */
    private Integer status;
    
    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

