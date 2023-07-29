package io.seata.samples.integration.business.common.vo;

import lombok.Data;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/29
 */
@Data
public class ResponseVO<T> {

    private T data;
    private Integer code;
    private String message;
}
