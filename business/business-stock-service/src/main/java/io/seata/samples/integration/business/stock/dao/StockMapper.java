package io.seata.samples.integration.business.stock.dao;

import io.seata.samples.integration.business.common.bean.Stock;

import org.apache.ibatis.annotations.Param;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
public interface StockMapper {

    Stock queryStockForUpdate(@Param("commodityCode") String commodityCode);

    int updateFrozenCount(@Param("commodityCode") String commodityCode, @Param("cnt") Integer cnt);

    int update(@Param("commodityCode") String commodityCode, @Param("cnt") Integer cnt);

    /**
     * 扣减商品库存
     */
    int decreaseStock(@Param("commodityCode") String commodityCode, @Param("cnt") Integer cnt);
}
