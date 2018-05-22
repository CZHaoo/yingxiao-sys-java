package com.zhijian.market.console.service;

import com.zhijian.market.core.dto.RespEntity;
import com.zhijian.market.core.dto.mobileinfo.MobileInfoDto;
import com.zhijian.market.core.mapper.MobileInfoMapper;
import com.zhijian.market.core.pojo.MobileInfo;
import com.zhijian.market.core.pojo.MobileInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileInfoService {

    @Autowired
    private MobileInfoMapper mobileInfoMapper;

    public RespEntity<List<MobileInfo>> list(MobileInfoDto.ListReq listReq) {
        MobileInfoExample mobileInfoExample = new MobileInfoExample();
        MobileInfoExample.Criteria criteria = mobileInfoExample.createCriteria();

        if (listReq.getCallStatus() != null) {
            criteria.andCallStatusEqualTo(listReq.getCallStatus());
        }

        if(listReq.getMobile() != null) {
            criteria.andMobileEqualTo(listReq.getMobile());
        }
        List<MobileInfo> mobileInfos = mobileInfoMapper.selectByExample(mobileInfoExample);
        return RespEntity.success(mobileInfos);
    }

}
