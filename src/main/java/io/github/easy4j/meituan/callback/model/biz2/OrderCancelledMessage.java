package io.github.easy4j.meituan.callback.model.biz2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「接收订单取消消息接口【必须】」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210003}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_6f40dc94-b808-4954-b478-bf0e4ac77693">官网消息文档</a>
 */
@CallbackPayload("")
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderCancelledMessage {

    /**
     * 创建美团「接收订单取消消息接口【必须】」回调的业务内容。的空实例。
     */
    public OrderCancelledMessage() {
    }


    /**
     * 服务商入驻技术合作中心得到的唯一身份表示。必填。
     */
    @JsonProperty("developerId")
    private Integer developerId;

    /**
     * ERP方门店 ID 最大长度100。必填。
     */
    @JsonProperty("ePoiId")
    private String ePoiId;

    /**
     * 数字签名。必填。
     */
    @JsonProperty("sign")
    private String sign;

    /**
     * 订单取消信息。必填。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("orderCancel")
    private OrderCancel orderCancel;

    /**
     * 订单取消信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderCancel {

        /**
         * 创建订单取消信息。的空实例。
         */
        public OrderCancel() {
        }


        /**
         * 标识订单是否为团餐定制菜单。1：团餐定制菜单；0或空：外卖菜单。
         */
        @JsonProperty("orderEntranceType")
        private Integer orderEntranceType;

        /**
         * 订单号。
         */
        @JsonProperty("orderId")
        private Long orderId;

        /**
         * 取消原因类型，参考【补充字段说明】。
         */
        @JsonProperty("reasonCode")
        private String reasonCode;

        /**
         * 取消原因描述。
         */
        @JsonProperty("reason")
        private String reason;

        /**
         * 订单业务打标枚举，即业务身份。16-拼好饭场景订单，19-团餐场景订单，1001-神抢手场景订单。
         */
        @JsonProperty("orderTagList")
        private String orderTagList;
    }
}
