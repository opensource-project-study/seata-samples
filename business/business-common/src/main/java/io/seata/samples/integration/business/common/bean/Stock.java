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
    private Integer count;
}
