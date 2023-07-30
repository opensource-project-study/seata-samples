package io.seata.samples.integration.business.account.dao;

import io.seata.samples.integration.business.common.bean.Account;

import org.apache.ibatis.annotations.Param;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
public interface AccountMapper {

    Account getByUid(@Param("userId") String userId);

    int queryBalance(@Param("userId") String userId);

    int decreaseAccount(@Param("userId") String userId, @Param("amount") int amount);

    int updateFrozenAmount(@Param("userId") String userId, @Param("amount") int amount);

    int update(@Param("userId") String userId, @Param("amount") int amount);

}
