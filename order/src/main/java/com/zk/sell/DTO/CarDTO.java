package com.zk.sell.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZhengKai
 * @data 2019-09-09 17:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private String productId;

    private Integer productQuantity;
}
