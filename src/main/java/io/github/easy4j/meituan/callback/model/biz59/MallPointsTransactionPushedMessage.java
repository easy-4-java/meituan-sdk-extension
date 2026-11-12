package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「商场积分交易事件推送」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910093}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_e2e9abe0-68f2-48e7-bcce-e6dcacc978c5">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MallPointsTransactionPushedMessage {

    /**
     * 创建美团「商场积分交易事件推送」回调的业务内容。的空实例。
     */
    public MallPointsTransactionPushedMessage() {
    }


    /**
     * 积分事务 ID，三方CRM可使用该字段进行幂等校验，避免重复积分。必填。
     */
    @JsonProperty("transactionId")
    private String transactionId;

    /**
     * 积分关联事件类型（数字） 1：商场行业交易核销事件 2：商场行业交易撤销核销事件 3：商场行业交易退款事件。必填。
     */
    @JsonProperty("eventType")
    private String eventType;

    /**
     * 事件时间，时间格式：“yyyy-mm-dd HH:mm:ss”。必填。
     */
    @JsonProperty("eventTime")
    private String eventTime;

    /**
     * 平台用户 ID(混淆)。必填。
     */
    @JsonProperty("opUserId")
    private String opUserId;

    /**
     * 所属平台，美团：MT 点评：DP。必填。
     */
    @JsonProperty("source")
    private String source;

    /**
     * 三方会员卡号 ID。必填。
     */
    @JsonProperty("memberCard")
    private String memberCard;

    /**
     * 交易金额(单位分)。必填。
     */
    @JsonProperty("tradeAmount")
    private String tradeAmount;

    /**
     * 商品名称。
     */
    @JsonProperty("productName")
    private String productName;

    /**
     * 订单 ID。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 事件关联的美团混淆门店 ID（例如：商场行业即商场内子门店）。必填。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;

    /**
     * 事件关联的门店三方编码。
     */
    @JsonProperty("eventShopExternalCode")
    private String eventShopExternalCode;

    /**
     * 积分账户 ID。
     */
    @JsonProperty("pointsAccountId")
    private String pointsAccountId;

    /**
     * 积分账户三方编码。
     */
    @JsonProperty("pointsAccountExternalCode")
    private String pointsAccountExternalCode;

    /**
     * 会员卡方案适用的三方门店编码。
     */
    @JsonProperty("planShopExternalCode")
    private String planShopExternalCode;

    /**
     * 消费项 ID。
     */
    @JsonProperty("consumeItemId")
    private String consumeItemId;

    /**
     * 消费批次 ID，eventType=1或eventType=2时表示核销/撤销核销的批次 ID，品牌方按批次积分时，使用该值用于重复积分校验。必填。
     */
    @JsonProperty("consumeBatchId")
    private String consumeBatchId;

    /**
     * 退款流水号 ID，只有eventType=3时有值。
     */
    @JsonProperty("refundNumber")
    private String refundNumber;

    /**
     * 批次总交易金额(单位分)。eventType=1时表示本次核销总金额（批次内所有消费项加和）；
     * eventType=2时表示撤销核销批次的总金额（批次内所有消费项加和）；eventType=3时表示本次退款操作的总金额（批次内所有消费项加和）。
     * 品牌方按核销批次进行积分时，使用该值换算积分（也可使用该值+事件时间用于全渠道重复积分校验）。必填。
     */
    @JsonProperty("batchTotalTradeAmount")
    private String batchTotalTradeAmount;

    /**
     * 前序核销成功批次 ID（撤销/退款才有值，用于溯源正向单）。按批次积分场景，部分退时用于溯源正向单。
     */
    @JsonProperty("prevConsumeSuccessBatchId")
    private String prevConsumeSuccessBatchId;
}
