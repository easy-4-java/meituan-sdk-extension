package io.github.easy4j.meituan.callback.model.biz2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「接收IM匿名评价群聊消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210071}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_05fc09bc-aef3-485d-90e7-a138336a4a7e">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnonymousReviewChatMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u63a5\u6536IM\u533f\u540d\u8bc4\u4ef7\u7fa4\u804a\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public AnonymousReviewChatMessage() {
    }


    /**
     * 业务类型字段，此时为4：评价匿名群聊。
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
         * 创建json\u683c\u5f0f\u7684\u6d88\u606f\u4f53\uff0c\u4e0d\u540cbizType\u65f6\uff0c\u5b57\u6bb5\u4e0d\u540c\uff0c\u89e3\u6790\u65b9\u5f0f\u4e5f\u4e0d\u540c\u3002的空实例。
         */
        public PushContent() {
        }


        /**
         * 消息 ID，确保消息唯一性，发送消息时，为三方的消息 ID，接收消息时，为美团的消息 ID。
         */
        @JsonProperty("msg_id")
        private Long msgId;

        /**
         * 加密后的消息内容。当前可通过获取多个长连接接口获取秘钥（imSecret字段）。 消息加密需使用AES加密，加密模式为CBC，
         * 填充使用pkcs5padding，数据块为128位，密码和偏移量为获取到的秘钥，输出为base64，字符集为utf8。
         * 在线加解密工具：http://tool.chacuo.net/cryptaes。
         */
        @JsonProperty("msg_content")
        private String msgContent;

        /**
         * 消息类型。bizType为4评价匿名群聊时，支持：0文本，2图片，和14中建群时的评价卡片消息，不支持14中的优惠券消息。
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
         * 评价 ID。
         */
        @JsonProperty("comment_id")
        private Long commentId;

        /**
         * 群 ID。
         */
        @JsonProperty("group_id")
        private Long groupId;
    }
}
