package com.zane.shop.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductVo {
    @JsonProperty("product_id")
    private String productId;
    @JsonProperty("small_pic")
    private String smallPic;
    @JsonProperty("title")
    private String title;
    @JsonProperty("sub_title")
    private String subTitle;
    @JsonProperty("price")
    private BigDecimal price;
    @JsonProperty("origin_price")
    private BigDecimal originPrice;
    @JsonProperty("main_pic")
    private List<MainPic> mainPic;


    @JsonProperty("detail_info")
    private DetailInfo detailInfo;
    @Data
    @ToString
    public class MainPic{
        @JsonProperty("url")
        private String url;
        @JsonProperty("alt")
        private String alt;
    }

    @Data
    @ToString
    public class DetailInfo{
        @JsonProperty("detail_pic")
        private List<DetailPic> detailPic;
        @Data
        @ToString
        public class DetailPic{
            @JsonProperty("url")
            private String url;
            @JsonProperty("alt")
            private String alt;
        }
    }
}
