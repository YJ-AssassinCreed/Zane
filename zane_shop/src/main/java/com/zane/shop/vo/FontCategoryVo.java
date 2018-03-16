package com.zane.shop.vo;

import io.swagger.models.auth.In;
import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 * @create 2018-03-16 17:17
 * @desc 前台分类
 **/
@Data
public class FontCategoryVo {

    private Integer fcid;

    private String fcname;

    private String picUrl;

    private Integer parentId;

    private Integer isLeafnode;

    private Integer sortOrder;

    private List<FontCategoryVo> subCategoryList;
}
