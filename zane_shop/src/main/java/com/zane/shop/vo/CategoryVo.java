package com.zane.shop.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 * @create 2018-03-16 17:17
 * @desc 前台分类
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CategoryVo {
    @JsonProperty("id")
    private Integer fcid;
    @JsonProperty("name")
    private String fcname;
    @JsonProperty("pic_url")
    private String picUrl;
    @JsonProperty("parent_id")
    private Integer parentId;
    @JsonProperty("is_leafnode")
    private Integer isLeafnode;
    @JsonProperty("sort_order")
    private Integer sortOrder;
    @JsonProperty("items")
    private List<CategoryVo> subCategoryList;
}
