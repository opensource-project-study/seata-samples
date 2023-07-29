package io.seata.samples.integration.business.stock.biz;

import javax.annotation.Resource;

import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.model.StockParam;
import io.seata.samples.integration.business.stock.component.StockComponent;

import org.springframework.stereotype.Service;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/29
 */
@Service
public class StockAtBiz {

    @Resource
    private StockComponent stockComponent;

    public ResponseCodeMsg decreaseStock(StockParam param) {
        return stockComponent.decreaseStock(param);
    }
}
