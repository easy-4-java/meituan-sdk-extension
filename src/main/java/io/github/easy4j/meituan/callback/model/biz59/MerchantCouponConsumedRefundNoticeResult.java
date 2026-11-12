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
     * 创建\u7f8e\u56e2\u300c\u5546\u5bb6\u5238\u5df2\u6d88\u8d39\u9000\u901a\u77e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public MerchantCouponConsumedRefundNoticeResult() {
    }


    /**
     * 退款ID。必填。
     */
    @JsonProperty("refundId")
    private String refundId;
}
