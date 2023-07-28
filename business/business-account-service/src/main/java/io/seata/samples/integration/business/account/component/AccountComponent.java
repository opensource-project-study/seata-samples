package io.seata.samples.integration.business.account.component;

import javax.annotation.Resource;

import io.seata.samples.integration.business.account.dao.AccountMapper;
import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.model.AccountParam;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
@Component
@Slf4j
public class AccountComponent {

    @Resource
    private AccountMapper accountMapper;

    public ResponseCodeMsg decreaseAccount(AccountParam param) {
        int balance = accountMapper.queryBalance(param.getUserId());
        if (balance < param.getAmount()) {
            log.error("账户余额{}不足，扣减失败，param={}", balance, param);
            return ResponseCodeMsg.FAIL;
        }

        int result = accountMapper.decreaseAccount(param.getUserId(), param.getAmount());
        if (result < 0) {
            return ResponseCodeMsg.FAIL;
        }
        return ResponseCodeMsg.SUCCESS;
    }
}
