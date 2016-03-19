package com.soshow.ssi.emp.dto;

import java.sql.Timestamp;

/**
 * 员工实体类
 * @author xieb
 * @version 1.00
 * 2016/03/19
 */
public class Emp{

    /**  */
    private Integer id;
    /**  */
    private String userName;
    /**  */
    private String password;
    /**  */
    private String trueName;
    /**  */
    private String sex;
    /**  */
    private Integer age;
    /**  */
    private Timestamp birthday;
    /**  */
    private String resume;
    /**  */
    private String remark;
    /**  */
    private String pictureName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }


    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

}
