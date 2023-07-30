package io.seata.samples.integration.business.common.service;

import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.model.OrderParam;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
public interface OrderService {

    /**
     * 创建订单
     */
    ResponseCodeMsg createOrder(OrderParam param);

    ResponseCodeMsg createOrderTcc(OrderParam param);

}
