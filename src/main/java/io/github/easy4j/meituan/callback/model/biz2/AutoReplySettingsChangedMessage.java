package io.github.easy4j.meituan.callback.model.biz2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「接收门店智能回复机器人开关变更消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210051}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_44784bc6-feb1-4d9f-ba9d-bfc0a67b2281">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutoReplySettingsChangedMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u63a5\u6536\u95e8\u5e97\u667a\u80fd\u56de\u590d\u673a\u5668\u4eba\u5f00\u5173\u53d8\u66f4\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public AutoReplySettingsChangedMessage() {
    }


    /**
     * 推送的方法。
     */
    @JsonProperty("method")
    private String method;

    /**
     * 业务内容。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("bizContent")
    private BizContent bizContent;

    /**
     * bizContent。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BizContent {

        /**
         * 创建bizContent\u3002的空实例。
         */
        public BizContent() {
        }


        /**
         * 开关类型。与查询接口type一致。
         */
        @JsonProperty("switchType")
        private Integer switchType;

        /**
         * 原开关状态。0关闭，1开启。
         */
        @JsonProperty("oldStatus")
        private Integer oldStatus;

        /**
         * 更新后的开关状态。0关闭，1开启。
         */
        @JsonProperty("newStatus")
        private Integer newStatus;

        /**
         * 变更时间戳。
         */
        @JsonProperty("utime")
        private Long utime;
    }
}
