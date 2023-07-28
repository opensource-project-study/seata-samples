package io.seata.samples.integration.business.common.model;

import java.io.Serializable;
import lombok.Data;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
@Data
public class AccountParam implements Serializable {

    private static final long serialVersionUID = -774231949007257877L;

    private String userId;
    private int amount;
}
