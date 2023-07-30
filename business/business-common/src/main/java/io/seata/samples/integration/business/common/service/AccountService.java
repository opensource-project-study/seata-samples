package io.seata.samples.integration.business.common.service;

import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.model.AccountParam;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
public interface AccountService {

    /**
     * 从账户扣钱
     */
    ResponseCodeMsg decreaseAccount(AccountParam param);

    /**
     * 从账户扣钱，TCC模式
     */
    ResponseCodeMsg decreaseAccountTcc(AccountParam param);
}
