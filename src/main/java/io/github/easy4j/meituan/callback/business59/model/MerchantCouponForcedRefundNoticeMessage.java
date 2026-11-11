package io.github.easy4j.meituan.callback.business59.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「商家券强制退券」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910027}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_12d0dc9e-ee01-42ac-ab05-1c0bf266c3df">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantCouponForcedRefundNoticeMessage {

    /**
     * 第三方团单 ID。必填。
     */
    @JsonProperty("appDealId")
    private String appDealId;

    /**
     * 开放平台上的订单 ID。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 退款 ID。必填。
     */
    @JsonProperty("refundId")
    private String refundId;

    /**
     * 券码,以逗号隔开。必填。
     */
    @JsonProperty("serialNumberList")
    private String serialNumberList;

    /**
     * 退券数目。必填。
     */
    @JsonProperty("refundCount")
    private String refundCount;

    /**
     * 是否快速退，默认不推送，若需要可联系行业侧运营订阅。
     */
    @JsonProperty("quickRefundFlag")
    private Boolean quickRefundFlag;
}
