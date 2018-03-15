package com.zane.shop.controller;

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

    @RequestMapping("/index")
    @ResponseBody
    public  String index(){
        return "ok";
    }
}
