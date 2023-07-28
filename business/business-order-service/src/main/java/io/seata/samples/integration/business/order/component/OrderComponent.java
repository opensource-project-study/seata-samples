package io.seata.samples.integration.business.order.component;

import java.util.UUID;

import javax.annotation.Resource;

import io.seata.samples.integration.business.common.bean.Order;
import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.model.AccountParam;
import io.seata.samples.integration.business.common.model.OrderParam;
import io.seata.samples.integration.business.common.service.AccountService;
import io.seata.samples.integration.business.order.dao.OrderMapper;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
@Component
public class OrderComponent {

    @DubboReference
    private AccountService accountService;

    @Resource
    private OrderMapper orderMapper;

    public ResponseCodeMsg createOrder(OrderParam param) {
        // 扣减账户余额
        AccountParam accountParam = new AccountParam();
        accountParam.setUserId(param.getUserId());
        accountParam.setAmount(param.getOrderAmount());
        ResponseCodeMsg accountRsp = accountService.decreaseAccount(accountParam);

        // 生成订单号
        String orderNo = UUID.randomUUID().toString().replace("-", "");
        // 生成订单
        Order order = new Order();
        BeanUtils.copyProperties(param, order);
        order.setOrderNo(orderNo);
        order.setCount(param.getOrderCount());
        order.setAmount(param.getOrderAmount());
        int result = 0;
        try {
            result = orderMapper.createOrder(order);
        } catch (Exception e) {
            return ResponseCodeMsg.FAIL;
        }

        if (accountRsp == ResponseCodeMsg.SUCCESS && result > 0) {
            return ResponseCodeMsg.SUCCESS;
        } else {
            return ResponseCodeMsg.FAIL;
        }
    }
}
