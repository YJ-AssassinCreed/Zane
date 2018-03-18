package com.zane.shop.po;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
@Data
@ToString
public class XylProductPO {
    private Integer id;

    private String productId;

    private String bcid;

    private String name;

    private String subName;

    private String smallPic;

    private BigDecimal price;

    private BigDecimal originPrice;

    private Integer brandId;

    private String status;

    private String operator;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public XylProductPO(Integer id, String productId, String bcid, String name, String subName,String smallPic, BigDecimal price, BigDecimal originPrice, Integer brandId, String status, String operator, Date createTime, Date updateTime) {
        this.id = id;
        this.productId = productId;
        this.bcid = bcid;
        this.name = name;
        this.subName = subName;
        this.smallPic = smallPic;
        this.price = price;
        this.originPrice = originPrice;
        this.brandId = brandId;
        this.status = status;
        this.operator = operator;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public XylProductPO() {
        super();
    }

}