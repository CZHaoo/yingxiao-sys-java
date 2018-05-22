package com.zhijian.market.portal.service;

import com.zhijian.market.core.dto.RespEntity;
import com.zhijian.market.core.dto.mobileinfo.MobileInfoDto;
import com.zhijian.market.core.mapper.MobileInfoMapper;
import com.zhijian.market.core.util.IpUtil;
import com.zhijian.market.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * 手机信息service
 */
@Service
public class MobileInfoService {

    private static final String MOBILE_PATTERN = "0?(13|14|15|18)[0-9]{9}";



    @Autowired
    private MobileInfoMapper mobileInfoMapper;

    /**
     * 添加 手机信息
     *
     * @return
     */
    public RespEntity add(MobileInfoDto.AddReq addReq) {
        MobileInfoDto.AddReq mobileInfo = addReq;
        if (mobileInfo == null || mobileInfo.getMobile() == null) {
            throw new RuntimeException("手机号不能为空");
        }

        if(!isMobile(mobileInfo.getMobile())) {
            throw new RuntimeException("手机号不合法");
        }

        mobileInfo.setAccessIp(IpUtil.getClientIp());
        mobileInfoMapper.insertSelective(mobileInfo);
        return RespEntity.success(mobileInfo);
    }


    private boolean isMobile(String mobile) {
        if(StringUtil.isNull(mobile)) {
            return false;
        }
        return Pattern.compile(MOBILE_PATTERN).matcher(mobile).matches();
    }

}
