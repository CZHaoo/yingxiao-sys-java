package com.zhijian.market.console.service;

import com.zhijian.market.core.dto.RespEntity;
import com.zhijian.market.core.dto.mobileinfo.MobileInfoDto;
import com.zhijian.market.core.mapper.MobileInfoMapper;
import com.zhijian.market.core.pojo.MobileInfo;
import com.zhijian.market.core.pojo.MobileInfoExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Service
public class MobileInfoService {

    @Autowired
    private MobileInfoMapper mobileInfoMapper;

    /**
     * 获取 电话信息
     *
     * @param listReq
     * @return
     */
    public RespEntity<List<MobileInfo>> list(MobileInfoDto.ListReq listReq) {
        MobileInfoExample mobileInfoExample = new MobileInfoExample();
        MobileInfoExample.Criteria criteria = mobileInfoExample.createCriteria();

        if (listReq.getCallStatus() != null) {
            criteria.andCallStatusEqualTo(listReq.getCallStatus());
        }

        if (listReq.getRangeTime() != null && listReq.getRangeTime().length > 1) {
            if (listReq.getRangeTime()[0] != null && listReq.getRangeTime()[1] != null) {
                criteria.andCtimeGreaterThanOrEqualTo(listReq.getRangeTime()[0]);
                Calendar c = Calendar.getInstance();
                c.setTime(listReq.getRangeTime()[1]);
                c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
                criteria.andCtimeLessThan(c.getTime());
            }

        }

        if (listReq.getMobile() != null) {
            criteria.andMobileLike("%"+listReq.getMobile()+"%");
           // criteria.and
        }
        criteria.andIsDeleteEqualTo((byte) 0); //显示未删除
        List<MobileInfo> mobileInfos = mobileInfoMapper.selectByExample(mobileInfoExample);
        return RespEntity.success(mobileInfos);
    }

    /**
     * 删除电话信息(软删)
     *
     * @param deleteReq
     * @return
     */
    public RespEntity delete(MobileInfoDto.DeleteReq deleteReq) {
//        硬删
//        if(deleteReq.getIds() != null && deleteReq.getIds().length > 0) {
//            MobileInfoExample mobileInfoExample = new MobileInfoExample();
//            MobileInfoExample.Criteria criteria = mobileInfoExample.createCriteria();
//            criteria.andIdIn(Arrays.asList(deleteReq.getIds()));
//            mobileInfoMapper.deleteByExample(mobileInfoExample);
//            return RespEntity.success();
//        }
        if (deleteReq.getIds() != null && deleteReq.getIds().length > 0) {
            MobileInfoExample mobileInfoExample = new MobileInfoExample();
            MobileInfoExample.Criteria criteria = mobileInfoExample.createCriteria();
            criteria.andIdIn(Arrays.asList(deleteReq.getIds()));
            MobileInfo mobileInfo = new MobileInfo();
            mobileInfo.setIsDelete((byte) 1);
            mobileInfoMapper.updateByExampleSelective(mobileInfo, mobileInfoExample);
            return RespEntity.success();
        }
        return RespEntity.fail("请选择要删除的电话信息");
    }

    /**
     * 电话回访
     *
     * @param callReq
     * @return
     */
    public RespEntity call(MobileInfoDto.CallReq callReq) {
        if (callReq.getId() == null) {
            throw new RuntimeException("请选择要回访的电话信息");
        }

        MobileInfo mobileInfo = new MobileInfo();
        BeanUtils.copyProperties(mobileInfo, callReq);
        if (mobileInfo.getCallStatus() == null || mobileInfo.getCallStatus() == MobileInfoDto.CallStatus.NO_CALL) {
            mobileInfo.setCallStatus(MobileInfoDto.CallStatus.YES_CALL);
        }
        mobileInfoMapper.updateByPrimaryKeySelective(mobileInfo);
        return RespEntity.success();
    }

    /**
     * 更新 电话信息
     *
     * @param updateReq
     * @return
     */
    public RespEntity update(MobileInfoDto.UpdateReq updateReq) {
        MobileInfo mobileInfo = updateReq.getData();
        mobileInfoMapper.updateByPrimaryKeySelective(mobileInfo);
        return RespEntity.success();
    }

    /**
     * 获取电话信息
     *
     * @param id
     * @return
     */
    public RespEntity<MobileInfo> one(Integer id) {
        MobileInfoExample mobileInfoExample = new MobileInfoExample();
        MobileInfoExample.Criteria criteria = mobileInfoExample.createCriteria();
        criteria.andIdEqualTo(id).andIsDeleteEqualTo((byte) 0);
        List<MobileInfo> mobileInfos = mobileInfoMapper.selectByExample(mobileInfoExample);
        if (mobileInfos == null || mobileInfos.size() == 0) {
            throw new RuntimeException("电话信息不存在");
        }
        return RespEntity.success(mobileInfos.get(0));
    }

}
