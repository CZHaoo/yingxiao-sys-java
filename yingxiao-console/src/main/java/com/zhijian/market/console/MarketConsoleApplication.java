package com.zhijian.market.console;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.zhijian.market.core.mapper")
public class MarketConsoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketConsoleApplication.class, args);
    }


}
