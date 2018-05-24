package com.zhijian.market.portal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return  "hello SpringBoot";
    }

}
