package com.zane.shop.po;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class XylProductDescPicPO {
    private Integer id;

    private Integer productId;

    private Integer productDescId;

    private String pic;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;

    private String alt;

    public XylProductDescPicPO(Integer id, Integer productId, Integer productDescId, String pic, Integer sortOrder, Date createTime, Date updateTime, String alt) {
        this.id = id;
        this.productId = productId;
        this.productDescId = productDescId;
        this.pic = pic;
        this.sortOrder = sortOrder;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.alt = alt;
    }

    public XylProductDescPicPO() {
        super();
    }


}