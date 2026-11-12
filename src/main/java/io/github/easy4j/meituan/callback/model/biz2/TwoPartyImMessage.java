package io.github.easy4j.meituan.callback.model.biz2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「接收IM两方会话消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210069}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_0667a278-09c5-4d5d-98b3-6a92b5d3cfd8">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwoPartyImMessage {

    /**
     * 创建美团「接收IM两方会话消息」回调的业务内容。的空实例。
     */
    public TwoPartyImMessage() {
    }


    /**
     * 业务类型字段，此时为1：两方会话。
     */
    @JsonProperty("biz_type")
    private Integer bizType;

    /**
     * json格式的消息体，不同bizType时，字段不同，解析方式也不同。
     */
    @JsonProperty("push_content")
    private PushContent pushContent;

    /**
     * 扩展字段。
     */
    @JsonProperty("extended_field")
    private String extendedField;

    /**
     * json格式的消息体，不同bizType时，字段不同，解析方式也不同。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PushContent {

        /**
         * 创建json格式的消息体，不同bizType时，字段不同，解析方式也不同。的空实例。
         */
        public PushContent() {
        }


        /**
         * 消息 ID，确保消息唯一性，发送消息时，为三方的消息 ID，接收消息时，为美团的消息 ID。
         */
        @JsonProperty("msg_id")
        private Long msgId;

        /**
         * 加密后的消息内容。
         */
        @JsonProperty("msg_content")
        private String msgContent;

        /**
         * 消息类型。 bizType为1两方会话时，支持：1文本，2图片，3其他，17卡片。
         */
        @JsonProperty("msg_type")
        private Integer msgType;

        /**
         * 消息发送方 商家：1，用户：2。
         */
        @JsonProperty("msg_source")
        private Integer msgSource;

        /**
         * 消息发送时间,10位时间戳。
         */
        @JsonProperty("cts")
        private Long cts;

        /**
         * 应用标识。
         */
        @JsonProperty("app_id")
        private Long appId;

        /**
         * 门店标识。
         */
        @JsonProperty("app_poi_code")
        private String appPoiCode;

        /**
         * 订单 ID。
         */
        @JsonProperty("order_id")
        private Long orderId;

        /**
         * 用户 ID。
         */
        @JsonProperty("open_user_id")
        private Long openUserId;

        /**
         * 场景tag，-1时为普通消息，&gt;0时为场景消息： 9003："用户投诉商家，紧急消息" 3002："餐品质量投诉" 3001："餐品错送/少送" 9001："用户已尝试联系客服的消息" 2203："补充备注"。
         */
        @JsonProperty("scene_tag")
        private Integer sceneTag;

        /**
         * 场景名称，为空时时普通消息，不为空时是场景消息，取值同sceneTag。
         */
        @JsonProperty("scene_name")
        private String sceneName;

        /**
         * 0默认值，1未回复，2回复。
         */
        @JsonProperty("has_reply")
        private Integer hasReply;
    }
}
