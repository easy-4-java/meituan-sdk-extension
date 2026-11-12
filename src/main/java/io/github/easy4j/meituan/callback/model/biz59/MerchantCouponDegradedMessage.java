package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「商家券降级消息推送」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910139}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_48e46879-9c02-40f0-9e6e-de751d55714d">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantCouponDegradedMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u5546\u5bb6\u5238\u964d\u7ea7\u6d88\u606f\u63a8\u9001\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public MerchantCouponDegradedMessage() {
    }


    /**
     * 三方套餐 ID。必填。
     */
    @JsonProperty("appDealId")
    private String appDealId;

    /**
     * 套餐 ID。必填。
     */
    @JsonProperty("dealId")
    private Long dealId;

    /**
     * 团单 ID。必填。
     */
    @JsonProperty("dealGroupId")
    private Long dealGroupId;

    /**
     * 降级时间 {@code yyyy-MM-dd} hh:mm:ss。必填。
     */
    @JsonProperty("downgradeTime")
    private String downgradeTime;
}
