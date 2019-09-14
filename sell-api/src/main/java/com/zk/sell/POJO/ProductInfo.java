package com.zk.sell.POJO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ZhengKai
 * @data 2019-09-09 16:56
 */
@Data
public class ProductInfo {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Byte productStatus;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

}
