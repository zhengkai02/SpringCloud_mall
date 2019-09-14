package com.zk.sell.VO;

import lombok.Data;

/**
 * @author ZhengKai
 * @data 2019-09-09 17:09
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String message;

    private T data;
}
