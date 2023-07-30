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
    /** 订单取消 */
    CANCEL(1),
    /** 订单删除 */
    DELETE(2),
    /** 订单成功 */
    SUCCESS(3)
    ;

    private final int code;
}
