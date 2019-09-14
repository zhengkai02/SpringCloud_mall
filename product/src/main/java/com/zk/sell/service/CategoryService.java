package com.zk.sell.service;

import com.zk.sell.DO.ProductCategory;

import java.util.List;

/**
 * @author ZhengKai
 * @data 2019-09-01 21:42
 */
public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryList);
}
