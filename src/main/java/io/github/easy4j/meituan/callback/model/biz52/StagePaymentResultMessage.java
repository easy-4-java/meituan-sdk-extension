package io.github.easy4j.meituan.callback.model.biz52;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「收单开放平台支付结果通知（stage）」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=52}，消息类型为 {@code msgType=5210015}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_sdpt_2683a986-2715-4b18-a276-781b7ead252b">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StagePaymentResultMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u6536\u5355\u5f00\u653e\u5e73\u53f0\u652f\u4ed8\u7ed3\u679c\u901a\u77e5\uff08stage\uff09\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public StagePaymentResultMessage() {
    }


    /**
     * 门店 ID。
     */
    @JsonProperty("merchantId")
    private Long merchantId;

    /**
     * 支付单号。
     */
    @JsonProperty("outTradeNo")
    private String outTradeNo;

    /**
     * 支付时间，时间戳单位毫秒。
     */
    @JsonProperty("payTime")
    private Long payTime;

    /**
     * 渠道单号。
     */
    @JsonProperty("transactionId")
    private String transactionId;

    /**
     * 平台单号。
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
     * 动态二维码单号。
     */
    @JsonProperty("dynamicCodePaymentOrderId")
    private String dynamicCodePaymentOrderId;

    /**
     * 服务商单号。
     */
    @JsonProperty("outOrderNo")
    private String outOrderNo;

    /**
     * 平台单号。
     */
    @JsonProperty("platformOrderId")
    private String platformOrderId;

    /**
     * 渠道单号。
     */
    @JsonProperty("channelOrderId")
    private String channelOrderId;

    /**
     * 支付方式编码：0=美团/1=微信/2=支付宝/3=银行卡/4=云闪付/5=数字人民币。
     */
    @JsonProperty("payWay")
    private Integer payWay;
}
