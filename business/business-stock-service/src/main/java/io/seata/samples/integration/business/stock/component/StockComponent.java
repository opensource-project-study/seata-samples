package io.seata.samples.integration.business.stock.component;

import javax.annotation.Resource;

import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.model.StockParam;
import io.seata.samples.integration.business.stock.dao.StockMapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
@Component
@Slf4j
public class StockComponent {

    @Resource
    private StockMapper stockMapper;

    public ResponseCodeMsg decreaseStock(StockParam param) {
        int stock = stockMapper.queryStockByUniqueKey(param.getCommodityCode());
        if (stock < param.getCount()) {
            log.error("商品库存{}不足，param={}", stock, param);
            return ResponseCodeMsg.FAIL;
        }

        int result = stockMapper.decreaseStock(param.getCommodityCode(), param.getCount());
        if (result > 0) {
            return ResponseCodeMsg.SUCCESS;
        } else {
            return ResponseCodeMsg.FAIL;
        }
    }
}
