package io.seata.samples.integration.business.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/29
 */
@Getter
@AllArgsConstructor
public enum OrderStatus {

    /** 初始状态 */
    INIT(0),
    /** 成功状态 */
    SUCCESS(1),
    /** 取消状态 */
    CANCEL(2),
    /** 删除状态 */
    DELETE(3)
    ;

    private final int code;
}
