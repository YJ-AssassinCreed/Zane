package com.zane.shop.po;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class XylFontCategoryPO {
    private Integer fcid;

    private String fcname;

    private String picUrl;

    private Integer parentId;

    private Integer isLeafnode;

    private Integer sortOrder;

    private String operator;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public XylFontCategoryPO(Integer fcid, String fcname, String picUrl, Integer parentId, Integer isLeafnode, Integer sortOrder, String operator, Date createTime, Date updateTime) {
        this.fcid = fcid;
        this.fcname = fcname;
        this.picUrl = picUrl;
        this.parentId = parentId;
        this.isLeafnode = isLeafnode;
        this.sortOrder = sortOrder;
        this.operator = operator;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public XylFontCategoryPO() {
        super();
    }

    public Integer getFcid() {
        return fcid;
    }

    public void setFcid(Integer fcid) {
        this.fcid = fcid;
    }

    public String getFcname() {
        return fcname;
    }

    public void setFcname(String fcname) {
        this.fcname = fcname == null ? null : fcname.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getIsLeafnode() {
        return isLeafnode;
    }

    public void setIsLeafnode(Integer isLeafnode) {
        this.isLeafnode = isLeafnode;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}