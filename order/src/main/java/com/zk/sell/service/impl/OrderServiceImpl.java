package com.zk.sell.service.impl;

import com.zk.sell.DO.OrderMaster;
import com.zk.sell.DTO.OrderDTO;
import com.zk.sell.enums.OrderStatusEnum;
import com.zk.sell.enums.PayStatusEnum;
import com.zk.sell.repository.OrderDetailRepository;
import com.zk.sell.repository.OrderMasterRepository;
import com.zk.sell.service.OrderService;
import com.zk.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author ZhengKai
 * @data 2019-09-02 23:41
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        // TODO 查询商品信息（调用商品服务）
        // TODO 计算总价
        // TODO 扣库存（调用商品服务）
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
