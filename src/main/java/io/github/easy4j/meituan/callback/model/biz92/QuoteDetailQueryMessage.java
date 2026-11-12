package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「报价详情查询」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210007}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_165ca498-a7a7-49bf-9985-fdf0fee76891">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteDetailQueryMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u62a5\u4ef7\u8be6\u60c5\u67e5\u8be2\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public QuoteDetailQueryMessage() {
    }


    /**
     * 报价Id。必填。
     */
    @JsonProperty("quoteId")
    private String quoteId;

    /**
     * 取车信息。必填。
     */
    @JsonProperty("pickUpInfo")
    private RentalInfo pickUpInfo;

    /**
     * 还车信息。必填。
     */
    @JsonProperty("dropOffInfo")
    private DropOffInfoDetails dropOffInfo;

    /**
     * 商家车型Id。必填。
     */
    @JsonProperty("thirdCarModelId")
    private String thirdCarModelId;

    /**
     * 取车信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RentalInfo {

        /**
         * 创建\u53d6\u8f66\u4fe1\u606f\u3002的空实例。
         */
        public RentalInfo() {
        }


        /**
         * 商家门店code。必填。
         */
        @JsonProperty("thirdStoreCode")
        private String thirdStoreCode;

        /**
         * 地址信息。必填。
         */
        @JsonProperty("address")
        private Address address;

        /**
         * 取还时间。必填。
         */
        @JsonProperty("time")
        private String time;

        /**
         * 取还方式，枚举值：STORE_SELF(到店自取/还)、DOOR_TO_DOOR(上门取送)、TRANSFER(门店接送)。必填。
         */
        @JsonProperty("type")
        private String type;
    }

    /**
     * 还车信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DropOffInfoDetails {

        /**
         * 创建\u8fd8\u8f66\u4fe1\u606f\u3002的空实例。
         */
        public DropOffInfoDetails() {
        }


        /**
         * 商家门店code。必填。
         */
        @JsonProperty("thirdStoreCode")
        private String thirdStoreCode;

        /**
         * 地址信息。必填。
         */
        @JsonProperty("address")
        private Address address;

        /**
         * 取还时间。必填。
         */
        @JsonProperty("time")
        private String time;

        /**
         * 取还方式，枚举值：STORE_SELF(到店自取/还)、DOOR_TO_DOOR(上门取送)、TRANSFER(门店接送)。必填。
         */
        @JsonProperty("type")
        private String type;
    }
}
