package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询单个门店下指定设备状态」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_8fd1159c-e946-4749-8b3d-787f8e3f7143">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreDeviceStatusQueryResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u67e5\u8be2\u5355\u4e2a\u95e8\u5e97\u4e0b\u6307\u5b9a\u8bbe\u5907\u72b6\u6001\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public StoreDeviceStatusQueryResult() {
    }


    /**
     * 设备状态信息列表。必填。
     */
    @JsonProperty("deviceStatusInfos")
    private List<DeviceStatusInfo> deviceStatusInfos;

    /**
     * 设备状态信息列表。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DeviceStatusInfo {

        /**
         * 创建\u8bbe\u5907\u72b6\u6001\u4fe1\u606f\u5217\u8868\u3002\u5fc5\u586b\u3002的空实例。
         */
        public DeviceStatusInfo() {
        }


        /**
         * 三方设备ID。必填。
         */
        @JsonProperty("thirdPartyDeviceItemId")
        private String thirdPartyDeviceItemId;

        /**
         * 状态：-1-未知、0-下线、1-空闲、2-运行中、3-暂停。必填。
         */
        @JsonProperty("status")
        private Integer status;

        /**
         * 美团券ID。
         */
        @JsonProperty("mtCouponId")
        private String mtCouponId;

        /**
         * 预计履约结束时间，毫秒级时间戳，根据行业传递。 必传：按摩椅行业 不传：网吧行业。
         */
        @JsonProperty("occupyEndTime")
        private Long occupyEndTime;
    }
}
