package io.seata.samples.integration.business.common.bean;

import lombok.Data;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
@Data
public class Account {

    private Integer id;
    private String userId;
    /** 账户金额 */
    private Integer amount;
    /** 冻结金额 */
    private Integer frozenAmount;
}
