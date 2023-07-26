/*
 *  Copyright 1999-2021 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.seata.samples.integration.account.springboot.service;

import io.seata.samples.integration.account.springboot.entity.TAccount;
import io.seata.samples.integration.account.springboot.mapper.TAccountMapper;
import io.seata.samples.integration.common.dto.AccountDTO;
import io.seata.samples.integration.common.enums.RspStatusEnum;
import io.seata.samples.integration.common.response.ObjectResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author heshouyou
 * @since 2019-01-13
 */
@Service
public class TAccountServiceImpl extends ServiceImpl<TAccountMapper, TAccount> implements ITAccountService {

    @Override
    @Transactional
    public ObjectResponse decreaseAccount(AccountDTO accountDTO) {
        double balance = baseMapper.queryBalanceByUserId(accountDTO.getUserId());
        if (balance < accountDTO.getAmount().doubleValue()) {
            return ObjectResponse.fail();
        }
        int ret = baseMapper.decreaseAccount(accountDTO.getUserId(), accountDTO.getAmount().doubleValue());
        ObjectResponse<Object> response = new ObjectResponse<>();
        if (ret > 0) {
            response.setStatus(RspStatusEnum.SUCCESS.getCode());
            response.setMessage(RspStatusEnum.SUCCESS.getMessage());
            return response;
        }

        return ObjectResponse.fail();
    }

//    @Override
//    @GlobalLock
//    @Transactional(rollbackFor = {Throwable.class})
//    public void testGlobalLock() {
//        baseMapper.testGlobalLock("1");
//        System.out.println("Hi, i got lock, i will do some thing with holding this lock.");
//    }
}
