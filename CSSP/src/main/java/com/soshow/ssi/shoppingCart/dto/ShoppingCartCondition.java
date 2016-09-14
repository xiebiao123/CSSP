package com.soshow.ssi.shoppingCart.dto;

import com.soshow.ssi.util.common.Paging;
/**
 * 购物车condition
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class ShoppingCartCondition extends Paging{

    /**  */
    private Integer id;

    /**  */
    private Integer studentId;

    /**  */
    private Double sumPrice;



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

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }
}

