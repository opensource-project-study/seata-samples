package io.seata.samples.integration.business.account.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
public interface AccountMapper {

    int queryBalance(@Param("userId") String userId);

    int decreaseAccount(@Param("userId") String userId, @Param("amount") int amount);

}
