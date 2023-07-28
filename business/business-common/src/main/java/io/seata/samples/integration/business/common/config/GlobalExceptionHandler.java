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
package io.seata.samples.integration.business.common.config;

import io.seata.samples.integration.business.common.exception.DefaultException;
import io.seata.samples.integration.business.common.model.ResponseModel;
import io.seata.samples.integration.business.common.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * @author yyuweb@outlook.com
 */
@Slf4j
@ControllerAdvice(basePackages = "io.seata.samples.integration.business")
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseModel<Object> exceptionHandler(Exception e) {
        LOGGER.error("[系统抛出{}异常] ", e.getClass().getSimpleName(), e);
        return ResponseUtils.fail();
    }

    @ExceptionHandler(DefaultException.class)
    @ResponseBody
    public ResponseModel<Object> defaultException(DefaultException e) {
        LOGGER.error("[系统抛出{}异常] ", e.getClass().getSimpleName(), e);
        return ResponseUtils.fail();
    }
}
