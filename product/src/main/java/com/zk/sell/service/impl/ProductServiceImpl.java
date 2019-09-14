package com.zk.sell.service.impl;

import com.zk.sell.DO.ProductInfo;
import com.zk.sell.Repository.ProductInfoRepository;
import com.zk.sell.enums.ProductStatus;
import com.zk.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhengKai
 * @data 2019-09-01 21:17
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatus.UP.getCode());
    }
}

