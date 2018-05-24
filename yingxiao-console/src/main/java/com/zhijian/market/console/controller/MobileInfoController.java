package com.zhijian.market.console.controller;

import com.zhijian.market.console.service.MobileInfoService;
import com.zhijian.market.core.dto.RespEntity;
import com.zhijian.market.core.dto.mobileinfo.MobileInfoDto;
import com.zhijian.market.core.pojo.MobileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Sapi/mobile")
@RestController
public class MobileInfoController {

    @Autowired
    private MobileInfoService mobileInfoService;

    @GetMapping("/list")
    public RespEntity<List<MobileInfo>> list(MobileInfoDto.ListReq listReq) {
        return mobileInfoService.list(listReq);
    }

    @PostMapping("/delete")
    public RespEntity delete(@RequestBody MobileInfoDto.DeleteReq deleteReq) {
        return  mobileInfoService.delete(deleteReq);
    }

    @PostMapping("/call")
    public RespEntity call(@RequestBody MobileInfoDto.CallReq callReq) {
        return mobileInfoService.call(callReq);
    }

    @GetMapping("/one")
    public RespEntity<MobileInfo> one(Integer id) {
        return mobileInfoService.one(id);
    }

    @PostMapping("/update")
    public RespEntity update(@RequestBody MobileInfoDto.UpdateReq updateReq) {
        return mobileInfoService.update(updateReq);
    }

}
