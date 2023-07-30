package io.seata.samples.integration.business.common.bean;

import lombok.Data;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
@Data
public class Stock {

    private Integer id;
    private String commodityCode;
    private String name;
    /** 库存 */
    private Integer count;
    /** 冻结库存 */
    private Integer frozenCount;
}
