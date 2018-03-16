package com.zane.shop.controller;

import com.zane.shop.dao.XylFontCategoryPOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 * @create 2018-03-15 16:03
 * @desc 首页
 **/
@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private XylFontCategoryPOMapper xylFontCategoryPOMapper;

    @RequestMapping("/index")
    @ResponseBody
    public  String index(){
        System.out.println(xylFontCategoryPOMapper.selectCategoryChildrenByParentId(0).size()+"====");
        System.out.println(xylFontCategoryPOMapper.selectCategoryChildrenByParentId(0).get(0));
        return "ok";
    }
}
