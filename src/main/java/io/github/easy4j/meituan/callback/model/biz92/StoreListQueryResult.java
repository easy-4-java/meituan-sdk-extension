package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「门店列表查询」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_b7e2df61-29e4-4e11-8fe6-85527aadecaf">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreListQueryResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u95e8\u5e97\u5217\u8868\u67e5\u8be2\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public StoreListQueryResult() {
    }


    /**
     * 业务状态码。必填。
     */
    @JsonProperty("bizCode")
    private Integer bizCode;

    /**
     * 业务错误描述。必填。
     */
    @JsonProperty("bizMessage")
    private String bizMessage;

    /**
     * 下一游标, null表示已经到最后一页。必填。
     */
    @JsonProperty("cursor")
    private Long cursor;

    /**
     * 是否还有下一页。必填。
     */
    @JsonProperty("hasMore")
    private Boolean hasMore;

    /**
     * 门店信息。必填。
     */
    @JsonProperty("stores")
    private List<Store> stores;

    /**
     * 门店信息。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Store {

        /**
         * 创建\u95e8\u5e97\u4fe1\u606f\u3002\u5fc5\u586b\u3002的空实例。
         */
        public Store() {
        }


        /**
         * 供应商门店编码，在该供应商下唯一。必填。
         */
        @JsonProperty("thirdStoreCode")
        private String thirdStoreCode;

        /**
         * 门店名称，如"北京首都机场T3航站楼店"。必填。
         */
        @JsonProperty("thirdStoreName")
        private String thirdStoreName;

        /**
         * 所属城市行政区划代码。与城市接口的 cityCode 对应。必填。
         */
        @JsonProperty("cityCode")
        private String cityCode;

        /**
         * 城市名称。必填。
         */
        @JsonProperty("cityName")
        private String cityName;

        /**
         * 门店详细地址，如"北京市顺义区首都机场T3航站楼到达层B1停车场"。必填。
         */
        @JsonProperty("address")
        private String address;

        /**
         * 经度，GCJ-02 坐标系（高德），保留6位小数。如"116.603039"。必填。
         */
        @JsonProperty("longitude")
        private String longitude;

        /**
         * 纬度，GCJ-02 坐标系，保留6位小数。如"40.072498"。必填。
         */
        @JsonProperty("latitude")
        private String latitude;

        /**
         * 门店类型详情见 门店类型枚举StoreType.。必填。
         */
        @JsonProperty("storeType")
        private String storeType;

        /**
         * 门店联系电话，用户取还车时可能需要联系门店。必填。
         */
        @JsonProperty("contactPhones")
        private List<String> contactPhones;

        /**
         * 营业时间。必填。
         */
        @JsonProperty("businessPeriodTime")
        private TimeRange businessPeriodTime;

        /**
         * 门店状态： 见ActiveStatus枚举。必填。
         */
        @JsonProperty("status")
        private String status;

        /**
         * 最后更新时间，格式 yyyy-MM-dd HH:mm:ss。配合入参 updatedAfter 实现增量同步。必填。
         */
        @JsonProperty("updatedAt")
        private String updatedAt;
    }

    /**
     * 营业时间。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TimeRange {

        /**
         * 创建\u8425\u4e1a\u65f6\u95f4\u3002\u5fc5\u586b\u3002的空实例。
         */
        public TimeRange() {
        }


        /**
         * 开始时间，格式 HH:mm，如"08:00"。必填。
         */
        @JsonProperty("startTime")
        private String startTime;

        /**
         * 结束时间，格式 HH:mm，如"22:00"。必填。
         */
        @JsonProperty("endTime")
        private String endTime;
    }
}
