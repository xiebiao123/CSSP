package com.soshow.ssi.goodsOrderDetailed.dto;
/**
 * 订单详细实体类
 * @author xieb
 * @version 1.00
 * 2016/03/31
 */
public class GoodsOrderDetailed{

    /**  */
    private Integer id;
    /**  */
    private Integer goodsId;
    /**  */
    private String goodsName;
    /**  */
    private String goodsPicture;
    /**  */
    private Integer goodsNum;
    /**  */
    private Double goodsUnitPrice;
    /**  */
    private Double goodsTotalPrice;
    /**  */
    private Integer shoppingCartId;
    /**  */
    private Integer goodsOrderId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }


    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }


    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }


    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }


    public Double getGoodsUnitPrice() {
        return goodsUnitPrice;
    }

    public void setGoodsUnitPrice(Double goodsUnitPrice) {
        this.goodsUnitPrice = goodsUnitPrice;
    }


    public Double getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(Double goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }


    public Integer getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Integer shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }


    public Integer getGoodsOrderId() {
        return goodsOrderId;
    }

    public void setGoodsOrderId(Integer goodsOrderId) {
        this.goodsOrderId = goodsOrderId;
    }

}
