package com.soshow.ssi.clubActivity.dto;

import com.soshow.ssi.util.Paging;
/**
 * 社团活动关联condition
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class ClubActivityCondition extends Paging{

    /**  */
    private Integer id;

    /**  */
    private Integer activityId;

    /**  */
    private Integer clubId;

    /**  */
    private Integer count;

    /**  */
    private String remark;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

