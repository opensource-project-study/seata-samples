package io.seata.samples.integration.business.common.service;

import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.model.StockParam;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
public interface StockService {

    /**
     * 扣减库存
     */
    ResponseCodeMsg decreaseStock(StockParam param);
}
