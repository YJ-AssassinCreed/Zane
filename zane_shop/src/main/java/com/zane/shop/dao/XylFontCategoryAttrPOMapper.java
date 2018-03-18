package com.zane.shop.dao;

import com.zane.shop.po.XylFontCategoryAttrPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XylFontCategoryAttrPOMapper {

    List<XylFontCategoryAttrPO> queryCategoryAttrByBcidListAndFcid(@Param("bcidList") List<Integer> bcidList,@Param("fcid") Integer fcid);

}