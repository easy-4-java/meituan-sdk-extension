package io.github.easy4j.meituan.callback.model.biz51;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「退款申请推送（必接）」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=51}，消息类型为 {@code msgType=5110023}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_8ac18476-e862-4fb9-a767-1050f22689c7">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundApplicationPushMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u9000\u6b3e\u7533\u8bf7\u63a8\u9001\uff08\u5fc5\u63a5\uff09\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public RefundApplicationPushMessage() {
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
     * 退款消息。必填。
     */
    @JsonProperty("orderRefund")
    private OrderRefund orderRefund;

    /**
     * 退款消息。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderRefund {

        /**
         * 创建\u9000\u6b3e\u6d88\u606f\u3002的空实例。
         */
        public OrderRefund() {
        }


        /**
         * 订单 ID，外卖订单orderIdView。必填。
         */
        @JsonProperty("orderId")
        private Long orderId;

        /**
         * 通知类型：apply：发起退款；agree：确认退款。必填。
         */
        @JsonProperty("notifyType")
        private String notifyType;

        /**
         * 退款原因。必填。
         */
        @JsonProperty("reason")
        private String reason;

        /**
         * 秒提业务中，0：未处理，品牌侧不存在该订单或者未接单的订单需要系统自动同意退款；
         * 品牌侧要是拒绝退款&amp;未接单需要调用接单接口进行接单 当美团侧订单处于未接单状态时，超过接单时限5分钟，美团侧会主动发起退款申请通知，
         * 此时品牌需要针对该订单做发起退款操作或继续接单。 4：客服帮商家同意退款。必填。
         */
        @JsonProperty("resType")
        private Integer resType;

        /**
         * 退款创建时间(秒级时间戳)。必填。
         */
        @JsonProperty("ctime")
        private Integer ctime;

        /**
         * 秒提业务填0。必填。
         */
        @JsonProperty("isAppeal")
        private Integer isAppeal;

        /**
         * 图款图片：Json数组；用户在申请退款时秒提业务可填""。
         */
        @JsonProperty("pictures")
        private String pictures;

        /**
         * 秒提业务填""。
         */
        @JsonProperty("money")
        private String money;

        /**
         * 订单业务打标枚举，即业务身份。16-拼好饭场景订单。秒提业务填"[0]"。必填。
         */
        @JsonProperty("orderTagList")
        private String orderTagList;

        /**
         * 秒提业务：填： 1：用户发起售后 2：客服帮助用户发起售后。
         */
        @JsonProperty("applyRole")
        private Integer applyRole;

        /**
         * 退款申请单唯一标识（申诉入参 after_sale_id等价），秒提业务中未使用。必填。
         */
        @JsonProperty("refundId")
        private Long refundId;

        /**
         * 退款申请单唯一标识，到店在线核销业务必传。
         */
        @JsonProperty("refundNum")
        private String refundNum;

        /**
         * 商家是否可以申诉 1 可以， 0 不可以；秒提业务，填0：不可以。
         */
        @JsonProperty("poiCanAppeal")
        private Integer poiCanAppeal;

        /**
         * 用户申请退款类型 1：用户申请 ： 2：用户第一次申诉 ： 3：用户第二次申诉；秒提业务，填1：用户申请。
         */
        @JsonProperty("userApplyType")
        private Integer userApplyType;
    }
}
