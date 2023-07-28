package io.seata.samples.integration.business.order.dao;

import io.seata.samples.integration.business.common.bean.Order;


/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
public interface OrderMapper {

    int createOrder(Order order);

}
