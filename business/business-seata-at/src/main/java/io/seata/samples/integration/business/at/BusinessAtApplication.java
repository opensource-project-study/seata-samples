package io.seata.samples.integration.business.at;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 事务管理器 TM，用于发起事务
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class }, scanBasePackages = {"io.seata.samples.integration.business"})
public class BusinessAtApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessAtApplication.class, args);
    }

}
