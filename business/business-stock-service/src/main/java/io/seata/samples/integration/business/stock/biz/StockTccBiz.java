package io.seata.samples.integration.business.stock.biz;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.model.StockParam;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/29
 */
@LocalTCC
public interface StockTccBiz {

    /**
     * 一阶段方法
     * @param businessActionContext 传递参数到二阶段中
     */
    @TwoPhaseBusinessAction(name = "stockTccPrepare", commitMethod = "commit", rollbackMethod = "rollback", useTCCFence = true)
    ResponseCodeMsg prepare(BusinessActionContext businessActionContext,
            @BusinessActionContextParameter(paramName = "param") StockParam param);

    /**
     * 二阶段提交
     * <p>一直重试，直到返回true
     */
    boolean commit(BusinessActionContext businessActionContext);

    /**
     * 二阶段回滚
     * <p>一直重试，直到返回true
     */
    boolean rollback(BusinessActionContext businessActionContext);
}
