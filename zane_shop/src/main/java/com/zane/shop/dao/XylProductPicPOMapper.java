package com.zane.shop.dao;

import com.zane.shop.po.XylProductPicPO;

import java.util.List;

public interface XylProductPicPOMapper {
    List<XylProductPicPO> queryByProductId(String productId);

}