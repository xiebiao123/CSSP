package com.soshow.ssi.empAddress.dto;

import com.soshow.ssi.util.Paging;
/**
 * 员工地址condition
 * @author xieb
 * @version 1.00
 * 2016/03/19
 */
public class EmpAddressCondition extends Paging{

    /**  */
    private Integer id;

    /**  */
    private Integer userId;

    /**  */
    private String addressType;

    /**  */
    private String address;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

