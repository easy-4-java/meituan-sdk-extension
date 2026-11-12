package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「多门店三方设备号批量查询设备状态」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_747ad6b5-8cca-4853-b84f-144fedd02750">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiStoreDeviceStatusQueryResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u591a\u95e8\u5e97\u4e09\u65b9\u8bbe\u5907\u53f7\u6279\u91cf\u67e5\u8be2\u8bbe\u5907\u72b6\u6001\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public MultiStoreDeviceStatusQueryResult() {
    }


    /**
     * 设备状态信息列表。必填。
     */
    @JsonProperty("deviceStatusInfoEntityList")
    private List<DeviceStatusInfo> deviceStatusInfoEntityList;

    /**
     * 数据毫秒时间戳。必填。
     */
    @JsonProperty("timestamp")
    private Long timestamp;

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
