package io.seata.samples.integration.business.common.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
@Data
public class OrderParam implements Serializable {

    private static final long serialVersionUID = -7812259011098609664L;

    private String orderNo;
    private String userId;
    private String commodityCode;
    private Integer orderCount;
    private int orderAmount;
}
