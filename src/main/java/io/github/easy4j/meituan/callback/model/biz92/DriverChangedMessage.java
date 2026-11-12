package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「驾驶员修改」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210029}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_50774f47-470d-4336-ae7a-0d23478d32e4">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DriverChangedMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u9a7e\u9a76\u5458\u4fee\u6539\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public DriverChangedMessage() {
    }


    /**
     * 美团订单 ID。必填。
     */
    @JsonProperty("mtOrderId")
    private Long mtOrderId;

    /**
     * 三方商家订单 ID。必填。
     */
    @JsonProperty("thirdOrderId")
    private String thirdOrderId;

    /**
     * 原驾驶员。必填。
     */
    @JsonProperty("originDriver")
    private Driver originDriver;

    /**
     * 新驾驶员。必填。
     */
    @JsonProperty("newDriver")
    private NewDriverDetails newDriver;

    /**
     * 新驾驶员。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class NewDriverDetails {

        /**
         * 创建\u65b0\u9a7e\u9a76\u5458\u3002的空实例。
         */
        public NewDriverDetails() {
        }


        /**
         * 姓名。必填。
         */
        @JsonProperty("name")
        private String name;

        /**
         * 证件类型，详情可见证件类型枚举。必填。
         */
        @JsonProperty("idType")
        private String idType;

        /**
         * 证件号码。必填。
         */
        @JsonProperty("idNumber")
        private String idNumber;

        /**
         * 手机号码。必填。
         */
        @JsonProperty("phone")
        private String phone;
    }
}
