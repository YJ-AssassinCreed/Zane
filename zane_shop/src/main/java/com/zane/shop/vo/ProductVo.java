package com.zane.shop.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductVo {
    @JsonProperty("product_id")
    private String productId;
    @JsonProperty("category_id")
    private String categoryId;
    @JsonProperty("small_pic")
    private String smallPic;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("price")
    private BigDecimal price;
    @JsonProperty("origin_price")
    private BigDecimal originPrice;
}
