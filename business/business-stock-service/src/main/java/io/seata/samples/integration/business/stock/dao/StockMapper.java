package io.seata.samples.integration.business.stock.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
public interface StockMapper {

    int queryStockByUniqueKey(@Param("commodityCode") String commodityCode);

    /**
     * 扣减商品库存
     */
    int decreaseStock(@Param("commodityCode") String commodityCode, @Param("count") Integer count);
}
