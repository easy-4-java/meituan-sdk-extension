package io.github.easy4j.meituan.callback.model.biz15;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「会员卡消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=15}，消息类型为 {@code msgType=15201}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_jmcard_8ca2d5a1-96af-44b9-8e10-f1fb5212ffe3">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MembershipCardEventMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u4f1a\u5458\u5361\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public MembershipCardEventMessage() {
    }


    /**
     * 事件类型。必填。
     */
    @JsonProperty("eventType")
    private String eventType;

    /**
     * 具体信息。必填。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("eventDetail")
    private Detail eventDetail;

    /**
     * 具体信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Detail {

        /**
         * 创建\u5177\u4f53\u4fe1\u606f\u3002的空实例。
         */
        public Detail() {
        }


        /**
         * 会员卡号。必填。
         */
        @JsonProperty("cardNo")
        private String cardNo;

        /**
         * 用户 ID。必填。
         */
        @JsonProperty("userOpenId")
        private String userOpenId;

        /**
         * 平台。必填。
         */
        @JsonProperty("platformType")
        private String platformType;
    }
}
