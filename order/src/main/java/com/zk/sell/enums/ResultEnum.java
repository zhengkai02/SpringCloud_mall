package com.zk.sell.enums;

import lombok.Getter;

/**
 * @author ZhengKai
 * @data 2019-09-09 22:08
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(0,"参数错误"),
    CAR_EMPTY(1,"购物车为空");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }


}
