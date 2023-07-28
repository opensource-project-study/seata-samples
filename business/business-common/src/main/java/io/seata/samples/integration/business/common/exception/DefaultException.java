/*
 *  Copyright 1999-2021 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.seata.samples.integration.business.common.exception;

import io.seata.samples.integration.business.common.enums.ResponseCodeMsg;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常
 */
@Getter
@Setter
public class DefaultException extends RuntimeException {

    private ResponseCodeMsg responseCodeMsg;

    public DefaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public DefaultException(ResponseCodeMsg responseCodeMsg) {
        super(responseCodeMsg.getMessage());
        this.responseCodeMsg = responseCodeMsg;
    }

    public DefaultException(ResponseCodeMsg responseCodeMsg, Throwable throwable) {
        super(responseCodeMsg.getMessage(), throwable);
        this.responseCodeMsg = responseCodeMsg;
    }

}
