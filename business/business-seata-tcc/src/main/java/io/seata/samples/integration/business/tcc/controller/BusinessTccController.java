package io.seata.samples.integration.business.tcc.controller;

import javax.annotation.Resource;

import io.seata.samples.integration.business.tcc.biz.BusinessTccBiz;

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
}
