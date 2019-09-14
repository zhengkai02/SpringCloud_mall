package com.zk.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author ZhengKai
 * @data 2019-09-01 22:03
 */
@Data
public class ProductVO {

    /** 类目名称. */
    @JsonProperty("name")
    private String categoryName;

    /** 类目类型. */
    @JsonProperty("type")
    private Integer categoryType;

    /** 类目编号. */
    @JsonProperty("foods")
    List<ProductInfoVO> productInfoVOList;
}
