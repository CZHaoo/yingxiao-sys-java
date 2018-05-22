package com.zhijian.market.core.mapper;

import com.zhijian.market.core.pojo.MobileInfo;
import com.zhijian.market.core.pojo.MobileInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MobileInfoMapper {
    long countByExample(MobileInfoExample example);

    int deleteByExample(MobileInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MobileInfo record);

    int insertSelective(MobileInfo record);

    List<MobileInfo> selectByExample(MobileInfoExample example);

    MobileInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MobileInfo record, @Param("example") MobileInfoExample example);

    int updateByExample(@Param("record") MobileInfo record, @Param("example") MobileInfoExample example);

    int updateByPrimaryKeySelective(MobileInfo record);

    int updateByPrimaryKey(MobileInfo record);
}