package io.seata.samples.integration.business.tcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 事务管理器 TM，用于发起事务
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class }, scanBasePackages = {"io.seata.samples.integration.business"})
public class BusinessTccApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessTccApplication.class, args);
    }

}
