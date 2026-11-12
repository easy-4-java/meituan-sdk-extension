package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「优惠券实例核销/撤销事件通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810243}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_2f495d7b-a57f-4b38-9c61-2a1e72e0eae5">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CouponRedemptionChangedMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u4f18\u60e0\u5238\u5b9e\u4f8b\u6838\u9500/\u64a4\u9500\u4e8b\u4ef6\u901a\u77e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public CouponRedemptionChangedMessage() {
    }


    /**
     * 事件类型。必填。
     */
    @JsonProperty("eventType")
    private Integer eventType;

    /**
     * 事件发生的时间，时间戳。必填。
     */
    @JsonProperty("eventTime")
    private Long eventTime;

    /**
     * 事件发生的orgId。必填。
     */
    @JsonProperty("orgId")
    private Long orgId;

    /**
     * 券信息列表。必填。
     */
    @JsonProperty("couponInfos")
    private List<CouponInfo> couponInfos;

    /**
     * couponInfos。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CouponInfo {

        /**
         * 创建couponInfos\u3002的空实例。
         */
        public CouponInfo() {
        }


        /**
         * 券码。必填。
         */
        @JsonProperty("couponCode")
        private String couponCode;

        /**
         * 券模板 ID。必填。
         */
        @JsonProperty("couponTemplateId")
        private Long couponTemplateId;

        /**
         * 券类型。必填。
         */
        @JsonProperty("couponType")
        private Integer couponType;

        /**
         * 券有效期结束时间，时间戳。必填。
         */
        @JsonProperty("startTime")
        private Long startTime;

        /**
         * 券有效期结束时间，时间戳。必填。
         */
        @JsonProperty("endTime")
        private Long endTime;

        /**
         * 券状态。必填。
         */
        @JsonProperty("status")
        private Integer status;

        /**
         * 发券时间，时间戳。必填。
         */
        @JsonProperty("sendTime")
        private Long sendTime;

        /**
         * 会员 ID。必填。
         */
        @JsonProperty("memberId")
        private Long memberId;
    }
}
