package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「商家券强制退券」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_12d0dc9e-ee01-42ac-ab05-1c0bf266c3df">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantCouponForcedRefundNoticeResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u5546\u5bb6\u5238\u5f3a\u5236\u9000\u5238\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public MerchantCouponForcedRefundNoticeResult() {
    }


    /**
     * 退款ID。必填。
     */
    @JsonProperty("refundId")
    private String refundId;
}
