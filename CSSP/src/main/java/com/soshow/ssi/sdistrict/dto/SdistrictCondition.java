package com.soshow.ssi.sdistrict.dto;

import com.soshow.ssi.util.common.Paging;
/**
 * 县乡condition
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class SdistrictCondition extends Paging{

    /**  */
    private Long districtid;

    /**  */
    private String districtname;

    /**  */
    private Long cityid;



    public Long getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Long districtid) {
        this.districtid = districtid;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
    }

    public Long getCityid() {
        return cityid;
    }

    public void setCityid(Long cityid) {
        this.cityid = cityid;
    }
}

