package com.zk.sell.service;

import com.zk.sell.DTO.OrderDTO;

/**
 * @author ZhengKai
 * @data 2019-09-02 23:31
 */
public interface OrderService {
    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    OrderDTO createOrder(OrderDTO orderDTO);
}
