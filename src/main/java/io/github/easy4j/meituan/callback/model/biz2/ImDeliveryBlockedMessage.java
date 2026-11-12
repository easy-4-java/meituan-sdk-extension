package io.github.easy4j.meituan.callback.model.biz2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「接收IM发送消息被风控拦截的信息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210033}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_54686005-9c88-4cdc-bae2-7afc4973ffd4">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImDeliveryBlockedMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u63a5\u6536IM\u53d1\u9001\u6d88\u606f\u88ab\u98ce\u63a7\u62e6\u622a\u7684\u4fe1\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public ImDeliveryBlockedMessage() {
    }


    /**
     * 方法名。
     */
    @JsonProperty("method")
    private String method;

    /**
     * 敏感信息。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("bizContent")
    private BizContent bizContent;

    /**
     * 敏感信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BizContent {

        /**
         * 创建\u654f\u611f\u4fe1\u606f\u3002的空实例。
         */
        public BizContent() {
        }


        /**
         * 类型。
         */
        @JsonProperty("type")
        private Long type;

        /**
         * 透传的消息 ID。
         */
        @JsonProperty("msgId")
        private Long msgId;

        /**
         * 原因。
         */
        @JsonProperty("riskReason")
        private String riskReason;

        /**
         * 风控拦截的时间戳ms。
         */
        @JsonProperty("riskCts")
        private String riskCts;
    }
}
