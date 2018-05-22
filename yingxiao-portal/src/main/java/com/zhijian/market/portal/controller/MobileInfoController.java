package com.zhijian.market.portal.controller;

import com.zhijian.market.core.dto.RespEntity;
import com.zhijian.market.core.dto.mobileinfo.MobileInfoDto;
import com.zhijian.market.core.pojo.MobileInfo;
import com.zhijian.market.portal.service.MobileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 手机信息 controller
 */
@RestController
@RequestMapping("/mobile")
public class MobileInfoController {

    @Autowired
    private MobileInfoService mobileInfoService;

    /**
     * 添加用户手机信息
     * @param addReq
     * @return
     */
    @PostMapping("/add")
    public RespEntity<MobileInfo> add(MobileInfoDto.AddReq addReq) {
        return mobileInfoService.add(addReq);
    }
}
