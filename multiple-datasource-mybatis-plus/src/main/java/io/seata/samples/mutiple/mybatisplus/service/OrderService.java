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
package io.seata.samples.mutiple.mybatisplus.service;

import io.seata.samples.mutiple.mybatisplus.common.OperationResponse;
import io.seata.samples.mutiple.mybatisplus.common.order.PlaceOrderRequestVO;

/**
 * @author HelloWoodes
 */
public interface OrderService {

    /**
     * 下单
     *
     * @param placeOrderRequestVO 请求参数
     * @return 下单结果
     */
    OperationResponse placeOrder(PlaceOrderRequestVO placeOrderRequestVO) throws Exception;
}
