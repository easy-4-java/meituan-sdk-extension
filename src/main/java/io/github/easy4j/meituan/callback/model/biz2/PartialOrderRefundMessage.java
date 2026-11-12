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
 * 美团「接收部分退款回调接口」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210017}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_3586d47e-e40d-4e02-b6b9-3ff92b5546b7">官网消息文档</a>
 */
@CallbackPayload("")
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PartialOrderRefundMessage {

    /**
     * 服务商入驻技术合作中心得到的唯一身份表示。
     */
    @JsonProperty("developerId")
    private Integer developerId;

    /**
     * ERP方门店 ID 最大长度100。
     */
    @JsonProperty("ePoiId")
    private String ePoiId;

    /**
     * 数字签名，签名方式与菜品类接口计算签名一致。
     */
    @JsonProperty("sign")
    private String sign;

    /**
     * 部分退款消息。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("partOrderRefund")
    private PartOrderRefund partOrderRefund;

    /**
     * 部分退款消息。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PartOrderRefund {

        /**
         * 订单号。
         */
        @JsonProperty("orderId")
        private Long orderId;

        /**
         * 通知类型。part：商家/用户发起部分退款 agree：商家同意部分退款 reject ：商家拒绝部分退款。
         */
        @JsonProperty("notifyType")
        private String notifyType;

        /**
         * 部分退款原因。
         */
        @JsonProperty("reason")
        private String reason;

        /**
         * 部分退款金额，是扣除商家的钱。单位元。注意：此字段和food信息中的refund_price字段是可能不同的。
         * refund_price表示退给用户的金额，两者差异是佣金和美团补贴的返还。
         */
        @JsonProperty("money")
        private String money;

        /**
         * 部分退款菜品信息，字段说明详见【查询部分退款商品】接口。
         */
        @JsonProperty("food")
        private String food;

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
         * 订单数据状态标记。当订单中部分字段的数据因内部交互异常或网络等原因延迟生成（超时），导致开发者当前获取的订单数据不完整，
         * 此时技术合作中心对订单数据缺失情况进行标记。如不完整，建议尝试重新查询。注意，
         * 技术合作中心仅对部分模块的数据完整性进行监察标记（参考incmp_modules字段）。参考值： -1：有数据降级 0：无数据降级。
         */
        @JsonProperty("incmpCode")
        private Integer incmpCode;

        /**
         * 有降级的数据模块的集合，
         * 参考值： 0：订单商品详情 1：订单优惠信息 2：商品优惠详情 3：订单用户会员信息 4：订单维度的商家对账信息 5：订单维度的商家对账信息(元) 6：订单收货人地址 7：订单配送方式 8：技术合作中心用户 ID 9：部分退款商品信息 10：退货退款物流信息 11：部分订单基本信息(包括订单优惠信息、订单商品详情、门店信息等) 12：sku信息 13：spu信息 14：商品信息(可能是sku或spu等商品相关信息获取时降级) 15：替换折扣价为原价。
         */
        @JsonProperty("incmpModules")
        private String incmpModules;

        /**
         * 老退款流程中，用户申请客服介入后，值为1，否则为0。 新退款流程中，用户申请平台介入或二次申诉 后，值为1，否则为0。
         */
        @JsonProperty("isAppeal")
        private Integer isAppeal;

        /**
         * 售后发起人角色。 1用户发起售后，2客服帮助用户发起售后，3重复支付自动发起退款，6用户发起申诉，7商家发起售后，非餐类的门店不返回此字段。例如：闪购门店不返回。
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
    }
}
