package io.seata.samples.integration.business.account.service;

import javax.annotation.Resource;

import io.seata.samples.integration.business.account.component.AccountComponent;
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
    private AccountComponent accountComponent;

    @Override
    public ResponseCodeMsg decreaseAccount(AccountParam param) {
        return accountComponent.decreaseAccount(param);
    }
}
