package com.zane.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class BannerItem {
    private Integer id;

    private Integer imgId;

    private String keyWord;

    private Byte type;

    private Integer deleteTime;

    private Integer bannerId;

    private Integer updateTime;

    public BannerItem(Integer id, Integer imgId, String keyWord, Byte type, Integer deleteTime, Integer bannerId, Integer updateTime) {
        this.id = id;
        this.imgId = imgId;
        this.keyWord = keyWord;
        this.type = type;
        this.deleteTime = deleteTime;
        this.bannerId = bannerId;
        this.updateTime = updateTime;
    }

    public BannerItem() {
        super();
    }

}