package io.seata.samples.integration.business.common.model;

import java.io.Serializable;

import lombok.Data;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
@Data
public class StockParam implements Serializable {

    private static final long serialVersionUID = 5972405045471310929L;

    private String commodityCode;
    private Integer count;
}
