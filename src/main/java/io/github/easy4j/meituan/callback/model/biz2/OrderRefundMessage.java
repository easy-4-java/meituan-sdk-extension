package io.github.easy4j.meituan.callback.model.biz2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「接收订单退款类消息接口【必须】」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210005}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_ec09b7af-7cc3-430b-95ce-d7be671e477b">官网消息文档</a>
 */
@CallbackPayload("")
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRefundMessage {

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
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
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
         * 订单号。
         */
        @JsonProperty("orderId")
        private Long orderId;

        /**
         * 退款消息类型，参考【补充字段说明】。
         */
        @JsonProperty("notifyType")
        private String notifyType;

        /**
         * 退款理由。
         */
        @JsonProperty("reason")
        private String reason;

        /**
         * 退款 ID。
         */
        @JsonProperty("refundId")
        private Long refundId;

        /**
         * 退款创建时间(秒级时间戳)。
         */
        @JsonProperty("ctime")
        private Integer ctime;

        /**
         * 订单业务打标枚举，即业务身份。16-拼好饭场景订单，1001-神抢手场景订单。
         */
        @JsonProperty("orderTagList")
        private String orderTagList;

        /**
         * 老退款流程中，用户申请客服介入后，值为1，否则为0。 新退款流程中，用户申请平台介入或二次申诉 后，值为1，否则为0。
         */
        @JsonProperty("isAppeal")
        private Integer isAppeal;

        /**
         * 售后发起人角色。 1用户发起售后，2客服帮助用户发起售后，3重复支付自动发起退款，6用户发起申诉，7商家发起售后。
         */
        @JsonProperty("applyRole")
        private Integer applyRole;

        /**
         * 商家是否可以申诉。1可以。
         */
        @JsonProperty("poiCanAppeal")
        private Integer poiCanAppeal;

        /**
         * 用户申请类型。 1用户申请，2用户一次申诉，3用户二次申诉。
         */
        @JsonProperty("userApplyType")
        private Integer userApplyType;

        /**
         * 0未处理， 1商家驳回退款请求， 2商家同意退款， 3客服驳回退款请求， 4客服帮商家同意退款， 5超过3小时自动同意， 6系统自动确认，
         *  7用户取消退款申请， 8用户取消退款申诉，。
         */
        @JsonProperty("resType")
        private Integer resType;

        /**
         * 退款图片。用户在申请退款时上传的退款图片，上限为9张图片。
         */
        @JsonProperty("pictures")
        private String pictures;

        /**
         * 退款金额。
         */
        @JsonProperty("money")
        private String money;
    }
}
