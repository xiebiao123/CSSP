package com.soshow.ssi.distribution.dto;

import com.soshow.ssi.util.common.Paging;
/**
 * 配送方式condition
 * @author xieb
 * @version 1.00
 * 2016/04/07
 */
public class DistributionCondition extends Paging{

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

