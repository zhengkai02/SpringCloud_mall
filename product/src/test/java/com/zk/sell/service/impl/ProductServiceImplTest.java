package com.zk.sell.service.impl;

import com.zk.sell.DO.ProductInfo;
import com.zk.sell.ProductApplicationTests;
import com.zk.sell.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ZhengKai
 * @data 2019-09-01 21:19
 */
@Component
public class ProductServiceImplTest extends ProductApplicationTests {
    @Autowired
    private ProductService productService;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertTrue(productInfoList.size()>0);
    }
}