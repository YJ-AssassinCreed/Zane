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
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
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

}