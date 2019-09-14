package com.zk.sell.Repository;

import com.zk.sell.DO.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ZhengKai
 * @data 2019-09-01 21:39
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
