package com.soshow.ssi.goodsOrder.dto;

import java.sql.Timestamp;

import com.soshow.ssi.util.Paging;
/**
 * 商品订单condition
 * @author xieb
 * @version 1.00
 * 2016/03/31
 */
public class GoodsOrderCondition extends Paging{

    /**  */
    private Integer id;

    /**  */
    private Integer sellerId;

    /**  */
    private Integer buyersId;

    /**  */
    private Integer status;

    /**  */
    private Integer distribution;

    /**  */
    private String address;

    /**  */
    private String name;

    /**  */
    private Timestamp createTime;

    /**  */
    private String seller;

    /**  */
    private String buyer;

    /**  */
    private Long buyerPhone;

    /**  */
    private String email;

    /**  */
    private Double sumPrice;

    /**  */
    private String remark;

    /**  */
    private Long sellerPhone;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getBuyersId() {
        return buyersId;
    }

    public void setBuyersId(Integer buyersId) {
        this.buyersId = buyersId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDistribution() {
        return distribution;
    }

    public void setDistribution(Integer distribution) {
        this.distribution = distribution;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Long getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(Long buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(Long sellerPhone) {
        this.sellerPhone = sellerPhone;
    }
}

