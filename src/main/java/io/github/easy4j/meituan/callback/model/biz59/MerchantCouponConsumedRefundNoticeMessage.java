package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「商家券已消费退通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910025}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_6b7209e5-f24f-4547-81a0-bb1f4fb21f7f">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantCouponConsumedRefundNoticeMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u5546\u5bb6\u5238\u5df2\u6d88\u8d39\u9000\u901a\u77e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public MerchantCouponConsumedRefundNoticeMessage() {
    }


    /**
     * 第三方团单 ID。必填。
     */
    @JsonProperty("appDealId")
    private String appDealId;

    /**
     * 统一订单号。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 退款申请 ID。必填。
     */
    @JsonProperty("refundId")
    private String refundId;

    /**
     * 券码列表，用逗号隔开。必填。
     */
    @JsonProperty("serialNumberList")
    private String serialNumberList;

    /**
     * 退券数量。必填。
     */
    @JsonProperty("refundCount")
    private Integer refundCount;

    /**
     * 退款申请渠道（1.用户申请退款，2.客服发起退款）。必填。
     */
    @JsonProperty("applyRefundChannel")
    private Integer applyRefundChannel;

    /**
     * 申请退款原因。必填。
     */
    @JsonProperty("applyRefundReason")
    private String applyRefundReason;

    /**
     * 审核人。
     */
    @JsonProperty("auditOperatorName")
    private String auditOperatorName;

    /**
     * 审核人类型（1.商家，2.系统，3.客服）。
     */
    @JsonProperty("auditOperatorType")
    private Integer auditOperatorType;

    /**
     * 审核结果（1.审核中，2.通过，3.拒绝）。
     */
    @JsonProperty("auditResult")
    private Integer auditResult;

    /**
     * 更新时间,发送通知的时间戳，三方可根据此字段对消息进行排序。
     */
    @JsonProperty("updateTime")
    private Long updateTime;

    /**
     * 是否需要审核（true: 需要审核 ； false ：不需要审核）。
     */
    @JsonProperty("needAudit")
    private Boolean needAudit;

    /**
     * 通知类型 （1.提交退款申请，2.取消退款申请，3.商家审核，4.退款完成）。必填。
     */
    @JsonProperty("refundNotifyType")
    private Integer refundNotifyType;

    /**
     * 是否快速退。
     */
    @JsonProperty("quickRefundFlag")
    private Boolean quickRefundFlag;
}
