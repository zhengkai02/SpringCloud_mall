package com.zk.sell.exception;

import com.zk.sell.enums.ResultEnum;

/**
 * @author ZhengKai
 * @data 2019-09-09 22:05
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code , String message){
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
