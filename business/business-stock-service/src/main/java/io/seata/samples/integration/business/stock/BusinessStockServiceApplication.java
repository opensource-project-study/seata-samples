package io.seata.samples.integration.business.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"io.seata.samples.integration.business.**.dao"})
@SpringBootApplication
public class BusinessStockServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessStockServiceApplication.class, args);
    }

}
