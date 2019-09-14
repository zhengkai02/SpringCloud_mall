package com.zk.sell.conveter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zk.sell.DO.OrderDetail;
import com.zk.sell.DTO.OrderDTO;
import com.zk.sell.enums.ResultEnum;
import com.zk.sell.exception.OrderException;
import com.zk.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengKai
 * @data 2019-09-09 22:17
 */
@Slf4j
public class OrderForm2OrderDTOConveter {

    public static OrderDTO conveter(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderDTO.getBuyerAddress());
        orderDTO.setBuyerOpenId(orderDTO.getBuyerOpenId());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
            new TypeToken<List<OrderDetail>>(){
            }.getType());
        }catch (Exception e){
            log.info("【json转换】错误，String = {}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
