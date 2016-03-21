package com.soshow.ssi.club.dto;

import java.sql.Timestamp;

import com.soshow.ssi.util.Paging;
/**
 * 社团信息condition
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class ClubCondition extends Paging{

    /**  */
    private Integer id;

    /**  */
    private Timestamp startTime;

    /**  */
    private String clubName;

    /**  */
    private String introduce;

    /**  */
    private String remark;

    /**  */
    private Integer studentId;



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

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}

