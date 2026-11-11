package io.github.easy4j.meituan.callback.business92.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「报价列表查询」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210005}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_8fb4f32e-11c1-4e5c-a476-c50fec37d768">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteListQueryMessage {

    /**
     * 供应商门店编码。
     */
    @JsonProperty("thirdStoreCode")
    private String thirdStoreCode;

    /**
     * 取车时间。必填。
     */
    @JsonProperty("pickUpTime")
    private String pickUpTime;

    /**
     * 还车时间。必填。
     */
    @JsonProperty("dropOffTime")
    private String dropOffTime;

    /**
     * 取车地址。必填。
     */
    @JsonProperty("pickUpAddress")
    private Address pickUpAddress;

    /**
     * 还车地址。必填。
     */
    @JsonProperty("dropOffAddress")
    private DropOffAddressDetails dropOffAddress;

    /**
     * 是否测试账户，不传表示非测试账户。
     */
    @JsonProperty("isTest")
    private Boolean isTest;

    /**
     * 还车地址。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DropOffAddressDetails {

        /**
         * 纬度（GCJ-02 坐标系）。必填。
         */
        @JsonProperty("latitude")
        private String latitude;

        /**
         * 经度（GCJ-02 坐标系）。必填。
         */
        @JsonProperty("longitude")
        private String longitude;

        /**
         * 地址。必填。
         */
        @JsonProperty("locationName")
        private String locationName;

        /**
         * 城市编码。必填。
         */
        @JsonProperty("cityCode")
        private String cityCode;
    }
}
