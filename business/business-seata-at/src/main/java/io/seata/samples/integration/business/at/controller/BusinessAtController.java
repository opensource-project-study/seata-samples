package io.seata.samples.integration.business.at.controller;

import javax.annotation.Resource;

import io.seata.samples.integration.business.at.biz.BusinessAtBiz;
import io.seata.samples.integration.business.common.model.BusinessParam;
import io.seata.samples.integration.business.common.vo.ResponseVO;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yyuweb@outlook.com
 * @date 2023/7/29
 */
@RestController
@RequestMapping("/business/seata/at")
public class BusinessAtController {

    @Resource
    private BusinessAtBiz businessAtBiz;

    /**
     * 下单正常流程
     */
    @RequestMapping("/buy")
    public ResponseVO<Object> buy(@RequestBody BusinessParam param) {
        return businessAtBiz.handleBusiness(param);
    }

    /**
     * 分布式事务回滚
     */
    @RequestMapping("/buy2")
    public ResponseVO<Object> buy2(@RequestBody BusinessParam param) {
        param.setRollback(true);
        return businessAtBiz.handleBusiness(param);
    }
}
