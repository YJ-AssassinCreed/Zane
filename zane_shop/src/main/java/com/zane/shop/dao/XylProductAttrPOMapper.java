package com.zane.shop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XylProductAttrPOMapper {

    List<String> queryProductIdsByAttrAndBcidList(@Param("attrSql") String attrSql, @Param("bcidList") List<Integer>bcidList);

}