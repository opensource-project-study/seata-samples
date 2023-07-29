package io.seata.samples.integration.business.order.biz;

import javax.annotation.Resource;

import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.model.OrderParam;
import io.seata.samples.integration.business.order.component.OrderComponent;

import org.springframework.stereotype.Service;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/29
 */
@Service
public class OrderAtBiz {

    @Resource
    private OrderComponent orderComponent;

    public ResponseCodeMsg createOrder(OrderParam param) {
        return orderComponent.createOrder(param);
    }
}
