package io.seata.samples.integration.business.order.dao;

import io.seata.samples.integration.business.common.bean.Order;

import org.apache.ibatis.annotations.Param;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
public interface OrderMapper {

    Order getByOrderNo(@Param("orderNo") String orderNo);

    int createOrder(Order order);

    int updateOrderStatus(@Param("orderNo") String orderNo, @Param("newStatus") int newStatus, @Param("oldStatus") int oldStatus);

}
