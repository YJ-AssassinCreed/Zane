package com.zane.shop.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Banner {
    private Integer id;

    private String name;

    private String description;

    private Integer deleteTime;

    private Integer updateTime;

    public Banner(Integer id, String name, String description, Integer deleteTime, Integer updateTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deleteTime = deleteTime;
        this.updateTime = updateTime;
    }
    public Banner() {
        super();
    }
}