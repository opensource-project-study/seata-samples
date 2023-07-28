package io.seata.samples.integration.business.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"io.seata.samples.integration.business.**.dao"})
public class BusinessAcountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessAcountServiceApplication.class, args);
    }

}
