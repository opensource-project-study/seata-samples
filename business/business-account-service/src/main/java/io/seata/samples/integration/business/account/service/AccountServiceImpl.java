package io.seata.samples.integration.business.account.service;

import javax.annotation.Resource;

import io.seata.samples.integration.business.account.biz.AccountAtBiz;
import io.seata.samples.integration.business.account.biz.AccountSogaBiz;
import io.seata.samples.integration.business.account.biz.AccountTccBiz;
import io.seata.samples.integration.business.account.biz.AccountXaBiz;
import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.model.AccountParam;
import io.seata.samples.integration.business.common.service.AccountService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
@DubboService(version = "1.0.0")
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountAtBiz accountAtBiz;
    @Resource
    private AccountTccBiz accountTccBiz;
    @Resource
    private AccountSogaBiz accountSogaBiz;
    @Resource
    private AccountXaBiz accountXaBiz;

    @Override
    public ResponseCodeMsg decreaseAccount(AccountParam param) {
        return accountAtBiz.decreaseAccount(param);
    }
}
