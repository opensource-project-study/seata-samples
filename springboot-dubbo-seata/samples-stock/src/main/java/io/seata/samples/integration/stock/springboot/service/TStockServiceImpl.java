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
package io.seata.samples.integration.stock.springboot.service;

import io.seata.samples.integration.common.springboot.dto.CommodityDTO;
import io.seata.samples.integration.common.springboot.enums.RspStatusEnum;
import io.seata.samples.integration.common.springboot.response.ObjectResponse;
import io.seata.samples.integration.stock.springboot.entity.TStock;
import io.seata.samples.integration.stock.springboot.mapper.TStockMapper;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * 库存服务实现类
 * </p>
 *
 * @author heshouyou
 * @since 2019-01-13
 */
@Service
public class TStockServiceImpl extends ServiceImpl<TStockMapper, TStock> implements ITStockService {

    @Override
    public ObjectResponse decreaseStock(CommodityDTO commodityDTO) {
        int stock = baseMapper.queryStockByUniqueKey(commodityDTO.getCommodityCode());
        if (stock < commodityDTO.getCount()) {
            return ObjectResponse.fail();
        }
        int ret = baseMapper.decreaseStock(commodityDTO.getCommodityCode(), commodityDTO.getCount());
        ObjectResponse<Object> response = new ObjectResponse<>();
        if (ret > 0) {
            response.setStatus(RspStatusEnum.SUCCESS.getCode());
            response.setMessage(RspStatusEnum.SUCCESS.getMessage());
            return response;
        }

        return ObjectResponse.fail();
    }
}
