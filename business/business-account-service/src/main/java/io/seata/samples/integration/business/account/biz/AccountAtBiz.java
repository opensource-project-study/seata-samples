package io.seata.samples.integration.business.account.biz;

import javax.annotation.Resource;

import io.seata.samples.integration.business.account.component.AccountComponent;
import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.model.AccountParam;

import org.springframework.stereotype.Service;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/29
 */
@Service
public class AccountAtBiz {

    @Resource
    private AccountComponent accountComponent;

    public ResponseCodeMsg decreaseAccount(AccountParam param) {
        return accountComponent.decreaseAccount(param);
    }
}
