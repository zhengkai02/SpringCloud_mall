package com.zk.sell.controller;

import com.zk.sell.DO.ProductCategory;
import com.zk.sell.DO.ProductInfo;
import com.zk.sell.VO.ProductInfoVO;
import com.zk.sell.VO.ProductVO;
import com.zk.sell.VO.ResultVO;
import com.zk.sell.service.CategoryService;
import com.zk.sell.service.ProductService;
import com.zk.sell.utils.ResultVOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZhengKai
 * @data 2019-09-01 20:31
 */
@Api(value = "Product-API",description = "这是商品服务接口的描述")
@RestController
@RequestMapping(value = "/product", produces = "application/json")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "查询所有在架商品",notes = "根据商品状态查询所有在架的的商品。返回商品列表List")
    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        // 查询所有在架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 获取商品类目Type列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        // 从数据库中查询类目
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtils.success(productVOList);
    }

}
