package com.zk.sell.enums;

import lombok.Getter;

/**
 * @author ZhengKai
 * @data 2019-09-01 21:06
 */
@Getter
public enum ProductStatus {
    UP(0,"上架"),
    DOWN(1,"下架");

    Integer code;

    String message;

    ProductStatus(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
