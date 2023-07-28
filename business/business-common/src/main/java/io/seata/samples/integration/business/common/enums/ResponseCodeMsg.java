package io.seata.samples.integration.business.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
@Getter
@AllArgsConstructor
public enum ResponseCodeMsg {

    SUCCESS(200, "success"),
    FAIL(999, "failure"),
    SYSTEM_ERR(500, "system err");

    private int code;
    private String message;

}
