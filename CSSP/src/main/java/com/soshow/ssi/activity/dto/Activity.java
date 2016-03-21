package com.soshow.ssi.activity.dto;

import java.sql.Timestamp;

/**
 * 活动信息实体类
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class Activity{

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
