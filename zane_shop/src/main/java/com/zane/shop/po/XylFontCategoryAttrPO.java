package com.zane.shop.po;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class XylFontCategoryAttrPO {
    private Integer id;

    private Integer fcid;

    private String fcname;

    private Integer bcid;

    private String bcname;

    private Integer attrId;

    private String attrName;

    private Integer attrValId;

    private String attrValName;

    public XylFontCategoryAttrPO(Integer id, Integer fcid, String fcname, Integer bcid, String bcname, Integer attrId, String attrName, Integer attrValId, String attrValName) {
        this.id = id;
        this.fcid = fcid;
        this.fcname = fcname;
        this.bcid = bcid;
        this.bcname = bcname;
        this.attrId = attrId;
        this.attrName = attrName;
        this.attrValId = attrValId;
        this.attrValName = attrValName;
    }

    public XylFontCategoryAttrPO() {
        super();
    }


}