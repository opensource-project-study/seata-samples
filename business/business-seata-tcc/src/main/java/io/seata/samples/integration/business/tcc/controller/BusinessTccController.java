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
     * <p>用ab命令模拟并发请求：ab -n 100 -c 10 -p data.txt -T application/json localhost:8111/business/seata/tcc/buy
     * <p>data.txt文件中的内容写请求参数，如{"userId":"1","commodityCode":"C001","name":"图书","count":50,"amount":100}
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
