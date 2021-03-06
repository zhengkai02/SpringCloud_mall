package com.zk.sell.DTO;

import com.zk.sell.DO.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ZhengKai
 * @data 2019-09-02 23:31
 */
@Data
public class OrderDTO {

    /**
     * 订单ID.
     */
    private String orderId;

    /**
     * 买家名字.
     */
    private String buyerName;

    /**
     * 买家手机号.
     */
    private String buyerPhone;

    /**
     * 买家地址.
     */
    private String buyerAddress;

    /**
     * 买家微信Openid.
     */
    private String buyerOpenId;

    /**
     * 订单总金额.
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态，默认0为新下单.
     */
    private Integer orderStatus;

    /**
     * 支付状态，默认0为未支付.
     */
    private Integer payStatus;

    private List<OrderDetail> orderDetailList;


}
