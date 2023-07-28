package io.seata.samples.integration.business.common.bean;

import lombok.Data;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
@Data
public class Order {

    private Integer id;
    private String orderNo;
    private String userId;
    private String commodityCode;
    private Integer count;
    private Double amount;
}
