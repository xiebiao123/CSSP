package com.soshow.ssi.experience.dto;

import java.sql.Timestamp;

import com.soshow.ssi.util.Paging;
/**
 * 个人经验condition
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class ExperienceCondition extends Paging{

    /**  */
    private Integer id;

    /**  */
    private Timestamp startTime;

    /**  */
    private Timestamp endTime;

    /**  */
    private String remark;

    /**  */
    private Integer resumeId;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }
}

