package com.zane.shop.dao;

import com.zane.shop.po.XylProductPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XylProductPOMapper {

    List<XylProductPO> queryProductListByProductIds(@Param("productIdList") List<String> productIdList);
}