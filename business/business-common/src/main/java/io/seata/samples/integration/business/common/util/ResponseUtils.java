package io.seata.samples.integration.business.common.util;

import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.model.ResponseModel;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
public class ResponseUtils {

    private ResponseUtils() {
    }

    public static <T> ResponseModel<T> success() {
        return success(null);
    }

    public static <T> ResponseModel<T> success(T data) {
        return buildResponse(ResponseCodeMsg.SUCCESS.getCode(), ResponseCodeMsg.SUCCESS.getMessage(), data);
    }

    public static ResponseModel<Object> fail() {
        return buildResponse(ResponseCodeMsg.FAIL.getCode(), ResponseCodeMsg.FAIL.getMessage(), null);
    }

    private static <T> ResponseModel<T> buildResponse(int code, String message, T data) {
        ResponseModel<T> response = new ResponseModel<>();
        response.setCode(code);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
