package io.seata.samples.integration.business.order.biz.impl;

import javax.annotation.Resource;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.samples.integration.business.common.bean.Order;
import io.seata.samples.integration.business.common.enums.OrderStatus;
import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.model.AccountParam;
import io.seata.samples.integration.business.common.model.OrderParam;
import io.seata.samples.integration.business.common.service.AccountService;
import io.seata.samples.integration.business.order.biz.OrderTccBiz;
import io.seata.samples.integration.business.order.dao.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/30
 */
@Service
@Slf4j
public class OrderTccBizImpl implements OrderTccBiz {

    @DubboReference(version = "1.0.0")
    private AccountService accountService;

    @Resource
    private OrderMapper orderMapper;

    @Override
    public ResponseCodeMsg prepare(BusinessActionContext businessActionContext, OrderParam param) {
        // 扣减账户余额
        AccountParam accountParam = new AccountParam();
        accountParam.setUserId(param.getUserId());
        accountParam.setAmount(param.getOrderAmount());
        ResponseCodeMsg accountRsp = accountService.decreaseAccountTcc(accountParam);
        // 生成订单
        Order order = new Order();
        BeanUtils.copyProperties(param, order);
        order.setOrderStatus(OrderStatus.INIT.getCode());
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

    @Override
    public boolean commit(BusinessActionContext businessActionContext) {
        OrderParam param = businessActionContext.getActionContext("param", OrderParam.class);
        // 更改订单状态为成功
        int ret = orderMapper.updateOrderStatus(param.getOrderNo(), OrderStatus.SUCCESS.getCode(), OrderStatus.INIT.getCode());
        if (ret > 0) {
            log.info("PhaseTwo Commit update order status {} -> {}", OrderStatus.INIT.getCode(), OrderStatus.SUCCESS.getCode());
        }
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext businessActionContext) {
        OrderParam param = businessActionContext.getActionContext("param", OrderParam.class);
        // 更改订单状态为删除
        int ret = orderMapper.updateOrderStatus(param.getOrderNo(), OrderStatus.DELETE.getCode(), OrderStatus.INIT.getCode());
        if (ret > 0) {
            log.info("PhaseTwo Rollback update order status {} -> {}", OrderStatus.INIT.getCode(), OrderStatus.DELETE.getCode());
        }
        return true;
    }
}
