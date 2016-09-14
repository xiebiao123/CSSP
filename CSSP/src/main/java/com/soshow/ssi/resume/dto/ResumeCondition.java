package com.soshow.ssi.resume.dto;

import com.soshow.ssi.util.common.Paging;
/**
 * 简历condition
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class ResumeCondition extends Paging{

    /**  */
    private Integer id;

    /**  */
    private Integer studentId;

    /**  */
    private String name;

    /**  */
    private Integer salary;

    /**  */
    private String workName;

    /**  */
    private Integer education;

    /**  */
    private String email;

    /**  */
    private Long tel;

    /**  */
    private Integer workTypeId;

    /**  */
    private String remark;

    /**  */
    private Integer age;



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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public Integer getWorkTypeId() {
        return workTypeId;
    }

    public void setWorkTypeId(Integer workTypeId) {
        this.workTypeId = workTypeId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

