package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「商家券获取动态核销码」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910035}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_f14d537b-97e0-4bd0-b595-9f66a86e7d30">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantCouponDynamicCodeMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u5546\u5bb6\u5238\u83b7\u53d6\u52a8\u6001\u6838\u9500\u7801\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public MerchantCouponDynamicCodeMessage() {
    }


    /**
     * 订单 ID。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 三方团单 ID。必填。
     */
    @JsonProperty("appDealId")
    private String appDealId;

    /**
     * 券码。必填。
     */
    @JsonProperty("serialNumber")
    private String serialNumber;
}
