package com.zk.sell.repository;

import com.zk.sell.DO.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZhengKai
 * @data 2019-09-01 23:11
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
