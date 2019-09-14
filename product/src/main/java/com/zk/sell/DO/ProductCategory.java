package com.zk.sell.DO;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author ZhengKai
 * @data 2019-09-01 21:01
 */
@Entity
@Data
public class ProductCategory {
    /** 类目ID. */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名称. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
