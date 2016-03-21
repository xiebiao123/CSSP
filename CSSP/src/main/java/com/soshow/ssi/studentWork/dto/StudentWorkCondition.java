package com.soshow.ssi.studentWork.dto;

import com.soshow.ssi.util.Paging;
/**
 * 学生工作关联condition
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class StudentWorkCondition extends Paging{

    /**  */
    private Integer id;

    /**  */
    private Integer studentId;

    /**  */
    private Integer workId;

    /**  */
    private String remark;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

