package com.zane.shop.service;

import com.zane.shop.common.ServerResponse;
import com.zane.shop.vo.ProductVo;

/**
 * @author Administrator
 * @create 2018-03-20 11:48
 * @desc 商品服务接口
 **/
public interface IProductService {

    ServerResponse<ProductVo> getProductBaseInfo(String productId);


}
