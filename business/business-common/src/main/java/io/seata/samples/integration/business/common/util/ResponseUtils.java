package io.seata.samples.integration.business.common.util;

import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import io.seata.samples.integration.business.common.vo.ResponseVO;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
public class ResponseUtils {

    private ResponseUtils() {
    }

    public static <T> ResponseVO<T> success() {
        return success(null);
    }

    public static <T> ResponseVO<T> success(T data) {
        return buildResponse(ResponseCodeMsg.SUCCESS.getCode(), ResponseCodeMsg.SUCCESS.getMessage(), data);
    }

    public static ResponseVO<Object> fail() {
        return buildResponse(ResponseCodeMsg.FAIL.getCode(), ResponseCodeMsg.FAIL.getMessage(), null);
    }

    private static <T> ResponseVO<T> buildResponse(int code, String message, T data) {
        ResponseVO<T> response = new ResponseVO<>();
        response.setCode(code);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
