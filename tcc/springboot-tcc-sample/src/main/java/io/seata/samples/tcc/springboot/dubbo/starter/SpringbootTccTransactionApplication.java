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
package io.seata.samples.tcc.springboot.dubbo.starter;

import java.util.HashMap;
import java.util.Map;

import io.seata.common.util.StringUtils;
import io.seata.samples.tcc.springboot.dubbo.ApplicationKeeper;
import io.seata.samples.tcc.springboot.dubbo.service.TccTransactionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.util.Assert;

/**
 * The type Sofa rpc tcc transaction application.
 *
 * @author zhangsen
 */
@SpringBootApplication
@ImportResource("classpath:spring/*.xml")
public class SpringbootTccTransactionApplication {

    /**
     * The Tcc transaction service.
     */
    static TccTransactionService tccTransactionService = null;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {

        ApplicationContext applicationContext = SpringApplication.run(SpringbootTccTransactionApplication.class, args);

        tccTransactionService = (TccTransactionService)applicationContext.getBean("tccTransactionService");

        //分布式事务提交demo
        transactionCommitDemo();

        //分布式事务回滚demo
        transactionRollbackDemo();

        new ApplicationKeeper(null).keep();
    }

    private static void transactionCommitDemo() throws InterruptedException {
        String txId = tccTransactionService.doTransactionCommit();
        System.out.println(txId);
        Assert.isTrue(StringUtils.isNotBlank(txId), "事务开启失败");

        System.out.println("transaction commit demo finish.");
    }

    private static void transactionRollbackDemo() throws InterruptedException {
        Map map = new HashMap(16);
        try {
            tccTransactionService.doTransactionRollback(map);
            Assert.isTrue(false, "分布式事务未回滚");
        } catch (Throwable t) {
            Assert.isTrue(true, "分布式事务异常回滚");
        }
        String txId = (String)map.get("xid");

        System.out.println("transaction rollback demo finish.");
    }
}

