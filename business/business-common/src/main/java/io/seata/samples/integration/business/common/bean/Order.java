package io.seata.samples.integration.business.common.bean;

import lombok.Data;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/28
 */
@Data
public class Order {

    private Integer id;
    private String orderNo;
    /** {@link io.seata.samples.integration.business.common.enums.OrderStatus} */
    private Integer orderStatus;
    private String userId;
    private String commodityCode;
    /** 商品数量 */
    private Integer count;
    /** 订单金额 */
    private Integer amount;
}
