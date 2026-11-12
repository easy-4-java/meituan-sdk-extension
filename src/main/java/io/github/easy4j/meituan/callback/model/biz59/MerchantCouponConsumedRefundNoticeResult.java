package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「商家券已消费退通知」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_6b7209e5-f24f-4547-81a0-bb1f4fb21f7f">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantCouponConsumedRefundNoticeResult {

    /**
     * 退款ID。必填。
     */
    @JsonProperty("refundId")
    private String refundId;
}
