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
        Stock stock = stockMapper.getByUniqueKey(param.getCommodityCode());
        if (stock == null) {
            throw new DefaultException(String.format("商品[{}]不存在", param.getCommodityCode()));
        }

        if (stock.getCount() - stock.getFrozenCount() < param.getCount()) {
            throw new DefaultException(String.format("库存[{}]不足，param=[{}]", stock, param));
        }

        // 冻结库存
        stockMapper.updateFrozenCount(param.getCommodityCode(), param.getCount());
        return ResponseCodeMsg.SUCCESS;
    }

    @Override
    public boolean commit(BusinessActionContext businessActionContext) {
        StockParam param = businessActionContext.getActionContext("param", StockParam.class);
        // 扣减库存，解除冻结的库存
        stockMapper.update(param.getCommodityCode(), param.getCount());
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext businessActionContext) {
        StockParam param = businessActionContext.getActionContext("param", StockParam.class);
        // 解除冻结的库存
        stockMapper.updateFrozenCount(param.getCommodityCode(), -param.getCount());
        return true;
    }
}
