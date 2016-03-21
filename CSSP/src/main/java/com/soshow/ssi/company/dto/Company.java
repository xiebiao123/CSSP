package com.soshow.ssi.company.dto;
/**
 * 公司信息实体类
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class Company{

    /**  */
    private Integer id;
    /**  */
    private String name;
    /**  */
    private String address;
    /**  */
    private String introduce;
    /**  */
    private Long tel;
    /**  */
    private String email;
    /**  */
    private String remark;
    /**  */
    private String contact;


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


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }


    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
