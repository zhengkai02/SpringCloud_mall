package com.zk.sell.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ZhengKai
 * @data 2019-09-01 21:54
 */
@Data
public class ResultVO<T> {
    /** 返回码. */
    @ApiModelProperty(value = "返回码",dataType = "Integer",example = "正确码")
    private Integer code;

    /** 提示信息. */
    private String message;

    /** 数据. */
    private T data;
}
