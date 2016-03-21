package com.soshow.ssi.studentClub.dto;

import com.soshow.ssi.util.Paging;
/**
 * 学生社团关联condition
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class StudentClubCondition extends Paging{

    /**  */
    private Integer id;

    /**  */
    private Integer clubId;

    /**  */
    private Integer studentId;

    /**  */
    private Integer position;

    /**  */
    private Integer status;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

