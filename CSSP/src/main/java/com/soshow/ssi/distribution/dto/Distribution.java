package com.soshow.ssi.distribution.dto;
/**
 * 配送方式实体类
 * @author xieb
 * @version 1.00
 * 2016/04/07
 */
public class Distribution{

    /**  */
    private Integer id;
    /**  */
    private String typeName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}
