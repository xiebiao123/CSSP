package com.soshow.ssi.scity.dto;

import com.soshow.ssi.util.Paging;
/**
 * 城市condition
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class ScityCondition extends Paging{

    /**  */
    private Long cityid;

    /**  */
    private String cityname;

    /**  */
    private String zipcode;

    /**  */
    private Long provinceid;



    public Long getCityid() {
        return cityid;
    }

    public void setCityid(Long cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Long getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Long provinceid) {
        this.provinceid = provinceid;
    }
}

