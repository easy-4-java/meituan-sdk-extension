package io.github.easy4j.meituan.callback.model.biz7;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「推送新订单」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=7}，消息类型为 {@code msgType=710003}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_resv2_2db30e48-c7a1-4c08-b234-65ebf8e6638f">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationOrderCreatedMessage {

    /**
     * 创建美团「推送新订单」回调的业务内容。的空实例。
     */
    public ReservationOrderCreatedMessage() {
    }


    /**
     * 厂商门店 ID。必填。
     */
    @JsonProperty("ePoiId")
    private String ePoiId;

    /**
     * 预订订单详情。平台可将该对象作为 JSON 字符串推送。必填。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("data")
    private Order data;

    /**
     * 新预订订单的就餐时间、人数、联系人及桌位要求。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Order {

        /**
         * 创建新预订订单的就餐时间、人数、联系人及桌位要求。的空实例。
         */
        public Order() {
        }


        /**
         * 预订订单号。必填。
         */
        @JsonProperty("orderSerializedId")
        private String orderSerializedId;

        /**
         * 状态，10-新建。必填。
         */
        @JsonProperty("status")
        private Integer status;

        /**
         * 就餐时间，UNIX时间戳，单位秒。必填。
         */
        @JsonProperty("bookingTime")
        private Integer bookingTime;

        /**
         * 就餐人数。必填。
         */
        @JsonProperty("number")
        private Integer number;

        /**
         * 姓名。必填。
         */
        @JsonProperty("name")
        private String name;

        /**
         * 性别，10-女士 20-先生。必填。
         */
        @JsonProperty("gender")
        private Integer gender;

        /**
         * 手机号，status为10、20、30、80时为空商家接单后提供完整手机号，解密参考订单接入指南。
         */
        @JsonProperty("phone")
        private String phone;

        /**
         * 附加要求。必填。
         */
        @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
        @JsonProperty("requirements")
        private Requirements requirements;

        /**
         * 下单时间，UNIX时间戳，单位秒。必填。
         */
        @JsonProperty("createTime")
        private Integer createTime;
    }
}
