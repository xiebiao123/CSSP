package com.soshow.ssi.student.dto;

import com.soshow.ssi.annotation.Excel;
import com.soshow.ssi.club.dto.Club;

/**
 * 学生信息实体类
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class Student extends Club{

    /**  */
    private Integer id;
    /**  */
    private String password;
    /**  */
    @Excel(name="姓名" , width=30)
    private String name;
    /**  */
    @Excel(name="年龄" , width=30)
    private Integer age;
    /**  */
    private String email;
    /**  */
    private Long tel;
    /**  */
    @Excel(name="性别" , width=30)
    private Integer sex;
    /**  */
    private String address;
    /**  */
    private String picture;
    /**  */
    private String remark;
    /**  */
    @Excel(name="状态" , width=30)
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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


    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
