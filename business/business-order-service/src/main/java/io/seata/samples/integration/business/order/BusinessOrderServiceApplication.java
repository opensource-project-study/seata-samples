package io.seata.samples.integration.business.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"io.seata.samples.integration.business.**.dao"})
@SpringBootApplication
public class BusinessOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessOrderServiceApplication.class, args);
    }

}
