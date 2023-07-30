package io.seata.samples.integration.business.tcc.controller;

import javax.annotation.Resource;

import io.seata.samples.integration.business.common.model.BusinessParam;
import io.seata.samples.integration.business.common.vo.ResponseVO;
import io.seata.samples.integration.business.tcc.biz.BusinessTccBiz;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/29
 */
@RestController
@RequestMapping("/business/seata/tcc")
public class BusinessTccController {

    @Resource
    private BusinessTccBiz businessTccBiz;

    /**
     * 下单正常流程
     */
    @RequestMapping("/buy")
    public ResponseVO<Object> buy(@RequestBody BusinessParam param) {
        return businessTccBiz.handleBusiness(param);
    }

    /**
     * 分布式事务回滚
     */
    @RequestMapping("/buy2")
    public ResponseVO<Object> buy2(@RequestBody BusinessParam param) {
        param.setRollback(true);
        return businessTccBiz.handleBusiness(param);
    }
}
