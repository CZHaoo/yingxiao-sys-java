package com.zhijian.market.core.dto.mobileinfo;

import com.zhijian.market.core.dto.ReqEntity;
import com.zhijian.market.core.pojo.MobileInfo;
import lombok.Data;

/**
 * 手机信息 数据传输
 */
public interface MobileInfoDto {
    /**
     * 添加请求
     */
    class AddReq extends MobileInfo {
       // private String name;
    }

    /**
     * 列表请求
     */
    @Data
    class ListReq extends ReqEntity {
        private Integer callStatus;
        private String mobile;


    }

    class CallStatus {
        public static final int NO_CALL = 0; // 未回访
        public static final int YES_CALL = 1; // 已回访
    }




}
