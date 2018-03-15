package com.zane.shop.common;

import lombok.Getter;

/**
 * @author Administrator
 * @create 2018-03-15 17:36
 * @desc 返回码
 **/
@Getter
public enum ResponseCode {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERR0R");

    private final int code;
    private final String desc;

    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }
}
