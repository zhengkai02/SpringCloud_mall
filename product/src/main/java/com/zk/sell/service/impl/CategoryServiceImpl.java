package com.zk.sell.service.impl;

import com.zk.sell.DO.ProductCategory;
import com.zk.sell.Repository.ProductCategoryRepository;
import com.zk.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhengKai
 * @data 2019-09-01 21:43
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryList);
    }
}
