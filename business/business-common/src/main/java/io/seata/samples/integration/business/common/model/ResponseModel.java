package io.seata.samples.integration.business.common.model;

import lombok.Data;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
@Data
public class ResponseModel<T> {

    private T data;
    private int code;
    private String message;

}
