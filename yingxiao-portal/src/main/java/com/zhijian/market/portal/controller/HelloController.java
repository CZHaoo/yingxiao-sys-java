package com.zhijian.market.portal.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 测试接口
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return  "hello SpringBoot";
    }
    @RequestMapping("/person")
    public Person person() {
        Person p = new Person();
        p.setBorn(new Date());
        return p ;
    }

    @Data
    class Person {
        Date born;


    }
}
