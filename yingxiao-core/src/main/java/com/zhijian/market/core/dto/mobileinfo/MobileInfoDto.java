package com.zhijian.market.core.dto.mobileinfo;

import com.zhijian.market.core.dto.ReqEntity;
import com.zhijian.market.core.pojo.MobileInfo;
import lombok.Data;

import java.util.Date;

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
        private Date[] rangeTime;
    }

    /**
     * 删除请求
     */
    @Data
    class DeleteReq extends ReqEntity {
        private Integer[] ids;
    }

    /**
     * 回访请求
     */
    @Data
    class CallReq extends ReqEntity {
        private Integer id;
        private Integer callStatus;
    }

    /**
     * 更新请求
     */
    class UpdateReq extends ReqEntity<MobileInfo> {

    }

    class CallStatus {
        public static final int NO_CALL = 0; // 未回访
        public static final int YES_CALL = 1; // 已回访
    }




}
