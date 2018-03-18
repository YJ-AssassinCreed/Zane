package com.zane.shop.service;

import com.zane.shop.common.ServerResponse;
import com.zane.shop.vo.CategoryVo;

import java.util.List;

public interface IFontCategoryService {

    ServerResponse<List<CategoryVo>> getNavigation();

    ServerResponse<List<CategoryVo>> getCategoryList(Integer categoryId);

    ServerResponse getProductListByCategoryId(Integer categoryId);
}
