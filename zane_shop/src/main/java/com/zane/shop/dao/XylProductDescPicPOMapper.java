package com.zane.shop.dao;

import com.zane.shop.po.XylProductDescPicPO;

import java.util.List;

public interface XylProductDescPicPOMapper {

    List<XylProductDescPicPO> queryByProductId(String productId);

}