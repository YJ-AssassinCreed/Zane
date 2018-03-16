package com.zane.shop.dao;

import com.zane.shop.po.XylFontCategoryPO;

import java.util.List;

public interface XylFontCategoryPOMapper {

    List<XylFontCategoryPO> selectCategoryChildrenByParentId(int parentId);
}