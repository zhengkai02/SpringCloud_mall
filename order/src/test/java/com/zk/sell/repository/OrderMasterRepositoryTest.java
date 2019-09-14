package com.zk.sell.repository;

import com.zk.sell.DO.OrderMaster;
import com.zk.sell.OrderApplicationTests;
import com.zk.sell.enums.OrderStatusEnum;
import com.zk.sell.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


/**
 * @author ZhengKai
 * @data 2019-09-01 23:12
 */
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("商品订单");
        orderMaster.setBuyerAddress("上海浦东");
        orderMaster.setBuyerPhone("13482100000");
        orderMaster.setBuyerOpenId("110101");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null);
    }

}