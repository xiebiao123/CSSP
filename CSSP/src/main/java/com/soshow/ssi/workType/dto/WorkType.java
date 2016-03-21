package com.soshow.ssi.workType.dto;
/**
 * 职位类别实体类
 * @author xieb
 * @version 1.00
 * 2016/03/21
 */
public class WorkType{

    /**  */
    private Integer id;
    /**  */
    private String typeName;
    /**  */
    private String remark;
    /**  */
    private Integer parentTypeId;


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


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public Integer getParentTypeId() {
        return parentTypeId;
    }

    public void setParentTypeId(Integer parentTypeId) {
        this.parentTypeId = parentTypeId;
    }

}
