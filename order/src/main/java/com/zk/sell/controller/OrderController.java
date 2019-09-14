package com.zk.sell.controller;

import com.zk.sell.DO.ProductInfo;
import com.zk.sell.DTO.CarDTO;
import com.zk.sell.DTO.OrderDTO;
import com.zk.sell.VO.ResultVO;
import com.zk.sell.client.ProductClient;
import com.zk.sell.conveter.OrderForm2OrderDTOConveter;
import com.zk.sell.enums.ResultEnum;
import com.zk.sell.exception.OrderException;
import com.zk.sell.form.OrderForm;
import com.zk.sell.service.OrderService;
import com.zk.sell.utils.ResultVOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhengKai
 * @data 2019-09-02 23:29
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductClient productClient;

    /**
     * 1、参数校验
     * 2、查询商品信息
     * 3、计算总价
     * 4、扣库存（调用商品服务）
     * 5、订单入库
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        // 校验参数
        if (bindingResult.hasErrors()) {
            log.info("【创建订单】参数不正确，orderForm = {}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        // orderForm -> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConveter.conveter(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CAR_EMPTY);
        }

        // 创建订单
        OrderDTO result = orderService.createOrder(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtils.success(map);

    }

    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder() {
        return productClient.listForOrder(Arrays.asList("157875196366160022", "157875227953464068"));
    }

    @PostMapping("/decrStock")
    public void decrStock() {
        productClient.decrStock(Arrays.asList(new CarDTO("164103465734242707",2)));
    }
}
