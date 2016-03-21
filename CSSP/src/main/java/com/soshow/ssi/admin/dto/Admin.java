package com.soshow.ssi.admin.dto;
/**
 * 管理员实体类
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class Admin{

    /**  */
    private Integer id;
    /**  */
    private String adminPassword;
    /**  */
    private String adminName;
    /**  */
    private String email;
    /**  */
    private Long tel;
    /**  */
    private String picture;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }


    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
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


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}
