package com.zane.shop.po;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class XylProductPicPO {
    private Integer id;

    private Integer productId;

    private String pic;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;

    private String alt;

    public XylProductPicPO(Integer id, Integer productId, String pic, Integer sortOrder, Date createTime, Date updateTime, String alt) {
        this.id = id;
        this.productId = productId;
        this.pic = pic;
        this.sortOrder = sortOrder;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.alt = alt;
    }

    public XylProductPicPO() {
        super();
    }


}