package com.zhijian.market.console;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.zhijian.market.core.mapper")
public class MarketConsoleApplication {

    public static void main(String[] args) {
        System.out.println("启动成功");
        SpringApplication.run(MarketConsoleApplication.class, args);
    }


}
