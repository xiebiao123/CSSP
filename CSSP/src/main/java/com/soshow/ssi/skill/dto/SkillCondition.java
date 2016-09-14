package com.soshow.ssi.skill.dto;

import java.sql.Timestamp;

import com.soshow.ssi.util.common.Paging;
/**
 * 个人技能condition
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class SkillCondition extends Paging{

    /**  */
    private Integer id;

    /**  */
    private String name;

    /**  */
    private Timestamp startTime;

    /**  */
    private Integer status;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

