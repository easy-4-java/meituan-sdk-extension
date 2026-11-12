package io.github.easy4j.meituan.callback.model.biz52;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「收单开放平台支付结果通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=52}，消息类型为 {@code msgType=5210005}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_sdpt_14307110-59e4-4570-8f81-e589ae7d2b1a">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentResultMessage {

    /**
     * 门店 ID。
     */
    @JsonProperty("merchantId")
    private Long merchantId;
    /**
     * 商户订单号。
     */
    @JsonProperty("outTradeNo")
    private String outTradeNo;
    /**
     * 支付时间，时间戳单位毫秒。
     */
    @JsonProperty("payTime")
    private Long payTime;
    /**
     * 美团开放平台交易号。
     */
    @JsonProperty("transactionId")
    private String transactionId;
    /**
     * 第三方支付交易单号即微信支付宝交易号。
     */
    @JsonProperty("providerTradeNo")
    private String providerTradeNo;
    /**
     * 订单金额，单位分。
     */
    @JsonProperty("totalFee")
    private Long totalFee;
    /**
     * 交易状态，当前的有 TRADE_SUCCESS, 表示交易成功。
     */
    @JsonProperty("tradeStatus")
    private String tradeStatus;
    /**
     * 支付宝支付对应的用户Id。
     */
    @JsonProperty("openId")
    private String openId;
    /**
     * 微信支付对应的用户Id 当接入方的微信相关支付使用的是自己的微信wxSubAppId时，
     * 表示用户在该wxSubAppId下的用户Id 否则默认为美团智能支付公众号对应的用户Id。
     */
    @JsonProperty("subOpenId")
    private String subOpenId;

    /**
     * 创建美团「收单开放平台支付结果通知」回调的业务内容。的空实例。
     */
    public PaymentResultMessage() {
    }
}
