package com.zane.shop.controller;

import com.zane.shop.common.ServerResponse;
import com.zane.shop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 * @create 2018-03-19 14:14
 * @desc 商品信息
 **/
@Controller
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @RequestMapping("/baseInfo")
    @ResponseBody
    public ServerResponse getProductBaseInfo(@RequestParam(value = "productId",required = true) String productId){
        return iProductService.getProductBaseInfo(productId);
    }

}
