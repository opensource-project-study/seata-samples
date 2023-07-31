package io.seata.samples.integration.business.account.biz.impl;

import javax.annotation.Resource;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.samples.integration.business.account.biz.AccountTccBiz;
import io.seata.samples.integration.business.account.dao.AccountMapper;
import io.seata.samples.integration.business.common.bean.Account;
import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.exception.DefaultException;
import io.seata.samples.integration.business.common.model.AccountParam;

import org.springframework.stereotype.Service;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/30
 */
@Service
public class AccountTccBizImpl implements AccountTccBiz {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public ResponseCodeMsg prepare(BusinessActionContext businessActionContext, AccountParam param) {
        Account accountFrom = accountMapper.getByUid(param.getUserId());
        if (accountFrom == null) {
            throw new DefaultException(String.format("账户[%s]不存在！！！", param.getUserId()));
        }

        if (accountFrom.getAmount() < param.getAmount()) {
            throw new DefaultException(String.format("账户余额不足，account=%s,param=%s", accountFrom, param));
        }

        // 冻结金额，也就是从可用余额里面冻结一部分金额，将其加入到冻结金额里面；即减少可用余额，增加冻结金额
        accountMapper.update(param.getUserId(), param.getAmount());
        return ResponseCodeMsg.SUCCESS;
    }

    @Override
    public boolean commit(BusinessActionContext businessActionContext) {
        AccountParam param = businessActionContext.getActionContext("param", AccountParam.class);
        // 扣减余额，直接从冻结金额里面进行扣减
        accountMapper.updateFrozenAmount(param.getUserId(), param.getAmount());
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext businessActionContext) {
        AccountParam param = businessActionContext.getActionContext("param", AccountParam.class);
        // 把try阶段冻结的那部分金额从冻结金额里面扣除，加回到可用余额里面
        accountMapper.update(param.getUserId(), -param.getAmount());
        return true;
    }
}
