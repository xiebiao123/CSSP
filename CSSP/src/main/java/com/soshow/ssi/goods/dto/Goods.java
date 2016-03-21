package com.soshow.ssi.goods.dto;
/**
 * 商品信息实体类
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class Goods{

    /**  */
    private Integer id;
    /**  */
    private String name;
    /**  */
    private Integer typeId;
    /**  */
    private String image;
    /**  */
    private String introduce;
    /**  */
    private Integer oldLevel;
    /**  */
    private Integer studentId;
    /**  */
    private Double price;
    /**  */
    private Integer number;
    /**  */
    private Integer hotLevel;
    /**  */
    private Double originalPrice;
    /**  */
    private Integer sortNum;
    /**  */
    private Integer status;
    /**  */
    private String remark;
    /**  */
    private Integer rank;


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


    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }


    public Integer getOldLevel() {
        return oldLevel;
    }

    public void setOldLevel(Integer oldLevel) {
        this.oldLevel = oldLevel;
    }


    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    public Integer getHotLevel() {
        return hotLevel;
    }

    public void setHotLevel(Integer hotLevel) {
        this.hotLevel = hotLevel;
    }


    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }


    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

}
