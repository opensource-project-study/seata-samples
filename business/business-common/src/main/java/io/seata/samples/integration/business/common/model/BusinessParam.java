package io.seata.samples.integration.business.common.model;

import java.io.Serializable;
import lombok.Data;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
@Data
public class BusinessParam implements Serializable {

    private static final long serialVersionUID = -2544222975181433050L;

    private String userId;
    private String commodityCode;
    private String name;
    private Integer count;
    private Integer amount;

    /** 是否回滚，只用于测试 */
    private boolean rollback;
}
