package io.seata.samples.integration.business.stock.biz.impl;

import javax.annotation.Resource;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.samples.integration.business.common.bean.Stock;
import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.exception.DefaultException;
import io.seata.samples.integration.business.common.model.StockParam;
import io.seata.samples.integration.business.stock.biz.StockTccBiz;
import io.seata.samples.integration.business.stock.dao.StockMapper;

import org.springframework.stereotype.Service;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/30
 */
@Service
public class StockTccBizImpl implements StockTccBiz {

    @Resource
    private StockMapper stockMapper;

    @Override
    public ResponseCodeMsg prepare(BusinessActionContext businessActionContext, StockParam param) {
        Stock stock = stockMapper.queryStockForUpdate(param.getCommodityCode());
        if (stock == null) {
            throw new DefaultException(String.format("商品[%s]不存在", param.getCommodityCode()));
        }

        if (stock.getCount() < param.getCount()) {
            throw new DefaultException(String.format("库存不足，stock=[%s],param=[%s]", stock, param));
        }

        // 冻结库存，也就是说从库存里拿出一部分库存，将其加到冻结库存里；即减少库存，增加冻结库存
        stockMapper.update(param.getCommodityCode(), param.getCount());
        return ResponseCodeMsg.SUCCESS;
    }

    @Override
    public boolean commit(BusinessActionContext businessActionContext) {
        StockParam param = businessActionContext.getActionContext("param", StockParam.class);
        // 扣减库存，直接从冻结库存里面扣减
        stockMapper.updateFrozenCount(param.getCommodityCode(), param.getCount());
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext businessActionContext) {
        StockParam param = businessActionContext.getActionContext("param", StockParam.class);
        // 把Try阶段冻结的那部分库存从冻结库存中扣除掉，加回到库存里面
        stockMapper.update(param.getCommodityCode(), -param.getCount());
        return true;
    }
}
