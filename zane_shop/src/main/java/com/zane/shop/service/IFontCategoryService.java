package com.zane.shop.service;

import com.zane.shop.common.ServerResponse;
import com.zane.shop.vo.CategoryVo;

import java.util.List;
/**
 * @author Administrator
 * @create 2018-03-20 11:48
 * @desc 前台类目服务接口
 **/
public interface IFontCategoryService {

    ServerResponse<List<CategoryVo>> getNavigation();

    ServerResponse<List<CategoryVo>> getCategoryList(Integer categoryId);

    ServerResponse getProductListByCategoryId(Integer categoryId);
}
