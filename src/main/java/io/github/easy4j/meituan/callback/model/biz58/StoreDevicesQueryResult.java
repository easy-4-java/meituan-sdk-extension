package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询指定门店下全量设备信息」回调的业务响应。
 *
 * <p>业务数据为数组，本类型表示其中一个元素。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_18fa357c-fd6f-4a3c-aff7-f891be2c3c92">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreDevicesQueryResult {

    /**
     * 类目编码。必填。
     */
    @JsonProperty("categoryCode")
    private String categoryCode;

    /**
     * 三方设备ID，设备在商家侧的唯一标识。必填。
     */
    @JsonProperty("thirdPartyDeviceItemId")
    private String thirdPartyDeviceItemId;

    /**
     * 名称。必填。
     */
    @JsonProperty("deviceItemName")
    private String deviceItemName;

    /**
     * 描述列表。
     */
    @JsonProperty("deviceItemDescs")
    private List<String> deviceItemDescs;

    /**
     * 是否和门店绑定：true-是、false-否。必填。
     */
    @JsonProperty("isBound")
    private Boolean isBound;

    /**
     * 是否可远程操控：0-不可操控、1-可操控。必填。
     */
    @JsonProperty("isOperable")
    private Integer isOperable;

    /**
     * 状态信息。必填。
     */
    @JsonProperty("statusInfo")
    private DeviceStatusInfo statusInfo;

    /**
     * 铺设/就绪日期。
     */
    @JsonProperty("deviceReadyDate")
    private String deviceReadyDate;

    /**
     * 三方型号编码，设备型号在商家侧的唯一标识。
     */
    @JsonProperty("thirdPartyDeviceModelCode")
    private String thirdPartyDeviceModelCode;

    /**
     * 最近一次维护日志。
     */
    @JsonProperty("maintenanceLogs")
    private List<DeviceMaintenanceLog> maintenanceLogs;

    /**
     * 计费规则。
     */
    @JsonProperty("pricingInfo")
    private DevicePricingInfo pricingInfo;

    /**
     * 扩展信息列表。
     */
    @JsonProperty("attrs")
    private List<Attribute> attrs;

    /**
     * 特征标签列表。
     */
    @JsonProperty("deviceFeatureTags")
    private List<Integer> deviceFeatureTags;

    /**
     * 状态信息。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DeviceStatusInfo {

        /**
         * 三方设备ID，设备在商家侧的唯一标识。必填。
         */
        @JsonProperty("thirdPartyDeviceItemId")
        private String thirdPartyDeviceItemId;

        /**
         * 状态：-1-未知、0-下线、1-空闲、2-运行中、3-暂停。必填。
         */
        @JsonProperty("status")
        private Integer status;

        /**
         * 占用结束时间，毫秒级时间戳。
         */
        @JsonProperty("occupyEndTime")
        private Long occupyEndTime;

        /**
         * 美团券ID。
         */
        @JsonProperty("mtCouponId")
        private String mtCouponId;
    }

    /**
     * 最近一次维护日志。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DeviceMaintenanceLog {

        /**
         * 维护时间，毫秒级时间戳。必填。
         */
        @JsonProperty("maintenanceTimestamp")
        private Long maintenanceTimestamp;

        /**
         * 维护详情描述列表。必填。
         */
        @JsonProperty("serviceReports")
        private List<String> serviceReports;

        /**
         * 维护图片列表。
         */
        @JsonProperty("serviceImages")
        private List<String> serviceImages;
    }

    /**
     * 计费规则。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DevicePricingInfo {

        /**
         * 是否收费：1-收费、2-免费。必填。
         */
        @JsonProperty("enablePricing")
        private Integer enablePricing;

        /**
         * 收费规则描述列表。
         */
        @JsonProperty("pricingDesc")
        private List<String> pricingDesc;

        /**
         * 是否需要押金：0-不需要、1-需要。
         */
        @JsonProperty("depositRequired")
        private Integer depositRequired;

        /**
         * 押金金额。
         */
        @JsonProperty("depositAmount")
        private Double depositAmount;

        /**
         * 是否有最低消费：0-不需要、1-需要。
         */
        @JsonProperty("minConsumptionRequired")
        private Integer minConsumptionRequired;

        /**
         * 最低消费数量。
         */
        @JsonProperty("minConsumptionAmount")
        private Double minConsumptionAmount;

        /**
         * 最低消费的单位：h-小时、m-分钟、cny-人民币。
         */
        @JsonProperty("minConsumptionUnit")
        private String minConsumptionUnit;
    }

    /**
     * 扩展信息列表。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Attribute {

        /**
         * 信息名。必填。
         */
        @JsonProperty("key")
        private Integer key;

        /**
         * 信息值，如果valueType=1，按"aa,bb,cc"的形式传递。必填。
         */
        @JsonProperty("value")
        private String value;

        /**
         * 信息值形式：0-枚举，单选、1-枚举，多选、2-自定义输入。必填。
         */
        @JsonProperty("valueType")
        private Integer valueType;
    }
}
