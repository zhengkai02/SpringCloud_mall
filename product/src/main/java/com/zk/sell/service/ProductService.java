package com.zk.sell.service;

import com.zk.sell.DO.ProductInfo;

import java.util.List;

/**
 * @author ZhengKai
 * @data 2019-09-01 21:09
 */
public interface ProductService {
    List<ProductInfo> findUpAll();
}
