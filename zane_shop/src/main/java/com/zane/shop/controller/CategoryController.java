package com.zane.shop.controller;

import com.zane.shop.common.ServerResponse;
import com.zane.shop.service.IFontCategoryService;
import com.zane.shop.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Administrator
 * @create 2018-03-15 16:03
 * @desc 首页
 **/
@Controller
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private IFontCategoryService iFontCategoryService;

    @RequestMapping("/navigation")
    @ResponseBody
    public ServerResponse<List<CategoryVo>> getNavigation(){
        return iFontCategoryService.getNavigation();
    }

    @RequestMapping("/list")
    @ResponseBody
    public ServerResponse<List<CategoryVo>> getCategoryList(@RequestParam(value = "categoryId") int categoryId){
        return iFontCategoryService.getCategoryList(categoryId);
    }

    @RequestMapping("/productList")
    @ResponseBody
    public ServerResponse getProductList(@RequestParam(value = "categoryId") int categoryId){
        return iFontCategoryService.getProductListByCategoryId(categoryId);
    }

}
