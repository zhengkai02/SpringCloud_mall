package com.zk.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author ZhengKai
 * @data 2019-09-09 17:35
 */
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家电话
     */
    @NotEmpty(message = "电话必填")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty
    private String address;

    /**
     * 买家微信
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
