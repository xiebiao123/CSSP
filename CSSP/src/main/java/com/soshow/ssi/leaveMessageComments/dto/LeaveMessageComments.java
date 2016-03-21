package com.soshow.ssi.leaveMessageComments.dto;
/**
 * 留言评论实体类
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class LeaveMessageComments{

    /**  */
    private Integer id;
    /**  */
    private Integer leaveMessageId;
    /**  */
    private Integer studnetId;
    /**  */
    private String comments;
    /**  */
    private Integer sortNum;
    /**  */
    private Integer type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getLeaveMessageId() {
        return leaveMessageId;
    }

    public void setLeaveMessageId(Integer leaveMessageId) {
        this.leaveMessageId = leaveMessageId;
    }


    public Integer getStudnetId() {
        return studnetId;
    }

    public void setStudnetId(Integer studnetId) {
        this.studnetId = studnetId;
    }


    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
