package com.zane.shop.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Image {
    private Integer id;

    private String url;

    private Byte from;

    private Integer deleteTime;

    private Integer updateTime;

    public Image(Integer id, String url, Byte from, Integer deleteTime, Integer updateTime) {
        this.id = id;
        this.url = url;
        this.from = from;
        this.deleteTime = deleteTime;
        this.updateTime = updateTime;
    }
    public Image() {
        super();
    }
}