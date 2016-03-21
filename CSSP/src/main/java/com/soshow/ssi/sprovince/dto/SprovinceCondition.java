package com.soshow.ssi.sprovince.dto;

import com.soshow.ssi.util.Paging;
/**
 * 省份condition
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class SprovinceCondition extends Paging{

    /**  */
    private Long provinceid;

    /**  */
    private String provincename;



    public Long getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Long provinceid) {
        this.provinceid = provinceid;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }
}

