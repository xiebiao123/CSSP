package com.soshow.ssi.goodsLeaveMessage.dto;

import java.sql.Timestamp;

import com.soshow.ssi.util.Paging;
/**
 * 留言信息表condition
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class GoodsLeaveMessageCondition extends Paging{

    /**  */
    private Integer id;

    /**  */
    private Integer goodsId;

    /**  */
    private Integer studentId;

    /**  */
    private String leaveMessage;

    /**  */
    private Timestamp createTime;

    /**  */
    private Integer rank;



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

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getLeaveMessage() {
        return leaveMessage;
    }

    public void setLeaveMessage(String leaveMessage) {
        this.leaveMessage = leaveMessage;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}

