package io.github.easy4j.meituan.callback.model.biz7;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「订单变更」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=7}，消息类型为 {@code msgType=710005}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_resv2_f89e564f-498c-4843-9d6f-ccb70d26f133">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationOrderChangedMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u8ba2\u5355\u53d8\u66f4\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public ReservationOrderChangedMessage() {
    }


    /**
     * 厂商门店 ID。必填。
     */
    @JsonProperty("ePoiId")
    private String ePoiId;

    /**
     * 业务参数。必填。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("data")
    private Order data;

    /**
     * 业务参数。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Order {

        /**
         * 创建\u4e1a\u52a1\u53c2\u6570\u3002的空实例。
         */
        public Order() {
        }


        /**
         * 预订订单号。必填。
         */
        @JsonProperty("orderSerializedId")
        private String orderSerializedId;

        /**
         * 变更后状态，20 - 撤单(接单前取消)；30 - 已拒单；40 - 已接单；50 - 已到店；60 - 未到店；70 - 已取消(接单后取消)；
         * 80 - 失败(自动拒单)。必填。
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
         * 手机号，status为10、20、30、80时为空；商家接单后提供完整手机号，解密参考订单接入指南。
         */
        @JsonProperty("phone")
        private String phone;

        /**
         * 附加要求。必填。
         */
        @JsonProperty("requirements")
        private Requirements requirements;

        /**
         * 下单时间，UNIX时间戳，单位秒。必填。
         */
        @JsonProperty("createTime")
        private Integer createTime;

        /**
         * 用户是否修改订单 0-用户未修改 1-用户修改。必填。
         */
        @JsonProperty("isUserModifyOrderErp")
        private Integer isUserModifyOrderErp;

        /**
         * 用户修改信息。
         */
        @JsonProperty("erbUserModifyOrderPushParam")
        private ErbUserModifyOrderPushParam erbUserModifyOrderPushParam;

        /**
         * 用户修改信息。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ErbUserModifyOrderPushParam {

            /**
             * 创建\u7528\u6237\u4fee\u6539\u4fe1\u606f\u3002的空实例。
             */
            public ErbUserModifyOrderPushParam() {
            }


            /**
             * 商家接单后提供完整手机号，解密参考订单接入指南。
             */
            @JsonProperty("newPhone")
            private String newPhone;

            /**
             * 修改后桌型名称，大厅/包间。
             */
            @JsonProperty("tableType")
            private String tableType;

            /**
             * 修改后姓名。
             */
            @JsonProperty("newName")
            private String newName;

            /**
             * 修改后就餐时间，UNIX时间戳，单位秒。
             */
            @JsonProperty("newBookingTime")
            private Integer newBookingTime;

            /**
             * 修改后就餐人数。
             */
            @JsonProperty("newNumber")
            private Integer newNumber;

            /**
             * 修改后性别，10-女士 20-先生。
             */
            @JsonProperty("newGender")
            private Integer newGender;

            /**
             * 修改后备注。
             */
            @JsonProperty("remark")
            private String remark;

            /**
             * 修改时间，UNIX时间戳，单位秒。
             */
            @JsonProperty("modifyTime")
            private Integer modifyTime;
        }
    }
}
