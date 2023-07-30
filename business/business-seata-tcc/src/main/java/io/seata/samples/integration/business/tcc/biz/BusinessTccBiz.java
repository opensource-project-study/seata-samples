package io.seata.samples.integration.business.tcc.biz;

import io.seata.core.context.RootContext;
import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.exception.DefaultException;
import io.seata.samples.integration.business.common.model.BusinessParam;
import io.seata.samples.integration.business.common.model.OrderParam;
import io.seata.samples.integration.business.common.model.StockParam;
import io.seata.samples.integration.business.common.service.OrderService;
import io.seata.samples.integration.business.common.service.StockService;
import io.seata.samples.integration.business.common.util.ResponseUtils;
import io.seata.samples.integration.business.common.vo.ResponseVO;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/29
 */
@Service
@Slf4j
public class BusinessTccBiz {

    @DubboReference(version = "1.0.0")
    private StockService stockService;
    @DubboReference(version = "1.0.0")
    private OrderService orderService;

    /**
     * 处理业务逻辑 正常的业务逻辑
     */
    @GlobalTransactional(timeoutMills = 300000, name = "gts-business-seata-tcc")
    public ResponseVO<Object> handleBusiness(BusinessParam param) {
        log.info("开始全局事务，XID = " + RootContext.getXID());
        // 1、扣减库存
        StockParam stockParam = new StockParam();
        stockParam.setCommodityCode(param.getCommodityCode());
        stockParam.setCount(param.getCount());
        ResponseCodeMsg stockRsp = stockService.decreaseStockTcc(stockParam);
        // 2、创建订单
        OrderParam orderParam = new OrderParam();
        orderParam.setUserId(param.getUserId());
        orderParam.setCommodityCode(param.getCommodityCode());
        orderParam.setOrderCount(param.getCount());
        orderParam.setOrderAmount(param.getAmount());
        ResponseCodeMsg orderRsp = orderService.createOrderTcc(orderParam);

        if (stockRsp != ResponseCodeMsg.SUCCESS || orderRsp != ResponseCodeMsg.SUCCESS) {
            throw new DefaultException(ResponseCodeMsg.FAIL);
        }

        if (param.isRollback()) {
            throw new DefaultException("出现异常，分布式事务回滚！！！");
        }

        return ResponseUtils.success();
    }
}
