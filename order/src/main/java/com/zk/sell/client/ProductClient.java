package com.zk.sell.client;

import com.zk.sell.DO.ProductInfo;
import com.zk.sell.DTO.CarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author ZhengKai
 * @data 2019-09-09 16:29
 */
@FeignClient(name = "product")      // 访问微服务的名称
public interface ProductClient {

    @PostMapping("/product/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);

    /**
     * 扣减库存
     * @param carDTOList
     * @return
     */
    @PostMapping("/product/decrStock")
    String decrStock(@RequestBody List<CarDTO> carDTOList);

}
