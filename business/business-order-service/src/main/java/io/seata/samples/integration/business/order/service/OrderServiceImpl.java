package io.seata.samples.integration.business.order.service;

import javax.annotation.Resource;

import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.model.OrderParam;
import io.seata.samples.integration.business.common.service.OrderService;
import io.seata.samples.integration.business.order.biz.OrderAtBiz;
import io.seata.samples.integration.business.order.biz.OrderTccBiz;

import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
@DubboService(version = "1.0.0")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderAtBiz orderAtBiz;
    @Resource
    private OrderTccBiz orderTccBiz;

    @Override
    public ResponseCodeMsg createOrder(OrderParam param) {
        return orderAtBiz.createOrder(param);
    }

    @Override
    public ResponseCodeMsg createOrderTcc(OrderParam param) {
        return orderTccBiz.prepare(null, param);
    }
}
