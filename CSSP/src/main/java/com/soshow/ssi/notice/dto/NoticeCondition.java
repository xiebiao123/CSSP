package com.soshow.ssi.notice.dto;

import java.sql.Timestamp;

import com.soshow.ssi.util.Paging;
/**
 * 公告condition
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class NoticeCondition extends Paging{

    /**  */
    private Integer id;

    /**  */
    private String content;

    /**  */
    private String title;

    /**  */
    private Timestamp createTime;

    /**  */
    private Integer adminId;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
}

