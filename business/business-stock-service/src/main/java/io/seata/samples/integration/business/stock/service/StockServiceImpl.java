package io.seata.samples.integration.business.stock.service;

import javax.annotation.Resource;

import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.model.StockParam;
import io.seata.samples.integration.business.common.service.StockService;
import io.seata.samples.integration.business.stock.biz.StockAtBiz;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
@DubboService(version = "1.0.0")
public class StockServiceImpl implements StockService {

    @Resource
    private StockAtBiz stockAtBiz;

    @Override
    public ResponseCodeMsg decreaseStock(StockParam param) {
        return stockAtBiz.decreaseStock(param);
    }
}
