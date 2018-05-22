package com.zhijian.market.console.controller;

import com.zhijian.market.console.service.MobileInfoService;
import com.zhijian.market.core.dto.RespEntity;
import com.zhijian.market.core.dto.mobileinfo.MobileInfoDto;
import com.zhijian.market.core.pojo.MobileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/mobile")
@RestController
public class MobileInfoController {

    @Autowired
    private MobileInfoService mobileInfoService;

    @RequestMapping("/list")
    public RespEntity<List<MobileInfo>> list(MobileInfoDto.ListReq listReq) {
        return mobileInfoService.list(listReq);
    }

}
