package com.zk.sell.DO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ZhengKai
 * @data 2019-09-01 20:33
 */
@Entity
@Data
public class ProductInfo {
    /** 商品ID. */
    @Id
    @ApiModelProperty(value = "商品的唯一标识ID")
    private String productId;

    /** 商品名称. */
    @ApiModelProperty(value = "商品的名称")
    private  String productName;

    /** 商品价格. */
    @ApiModelProperty(value = "商品的价格")
    private BigDecimal productPrice;

    /** 商品库存. */
    @ApiModelProperty(value = "商品库存")
    private Integer productStock;

    /** 商品描述. */
    @ApiModelProperty("商品描述")
    private String productDescription;

    /** 商品小图. */
    @ApiModelProperty("商品小图")
    private String productIcon;

    /** 商品状态：0-上架，1-下架*/
    @ApiModelProperty("上下架")
    private Integer productStatus;

    /** 类目. */
    @ApiModelProperty("商品分类")
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
