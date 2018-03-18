package com.zane.shop.po;

public class XylProductAttrPO {
    private Integer id;

    private Integer bcid;

    private Integer productId;

    private Integer attrId;

    private String attrName;

    private String attrValueName;

    public XylProductAttrPO(Integer id, Integer bcid, Integer productId, Integer attrId, String attrName, String attrValueName) {
        this.id = id;
        this.bcid = bcid;
        this.productId = productId;
        this.attrId = attrId;
        this.attrName = attrName;
        this.attrValueName = attrValueName;
    }

    public XylProductAttrPO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBcid() {
        return bcid;
    }

    public void setBcid(Integer bcid) {
        this.bcid = bcid;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    public String getAttrValueName() {
        return attrValueName;
    }

    public void setAttrValueName(String attrValueName) {
        this.attrValueName = attrValueName == null ? null : attrValueName.trim();
    }
}