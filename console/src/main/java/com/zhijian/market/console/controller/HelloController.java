package com.zhijian.market.console.controller;


import com.zhijian.market.core.mapper.MenuMapper;
import com.zhijian.market.core.pojo.Menu;
import com.zhijian.market.core.pojo.MenuExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试接口
 */
@RestController
public class HelloController {

    @Autowired
    private MenuMapper menuMapper;

    @RequestMapping("/hello")
    public String hello() {
        return  "hello SpringBoot";
    }

    @RequestMapping("/list")
    public List<Menu> menuList() {
        MenuExample menuExample = new MenuExample();
        List<Menu> menus = menuMapper.selectByExample(menuExample);
        return menus;
    }
}
