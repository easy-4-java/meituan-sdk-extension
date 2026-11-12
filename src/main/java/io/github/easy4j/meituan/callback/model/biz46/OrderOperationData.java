package io.github.easy4j.meituan.callback.model.biz46;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * OrderOperationData，用于套餐配送接单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderOperationData {

    /**
     * 创建OrderOperationData\uff0c\u7528\u4e8e\u5957\u9910\u914d\u9001\u63a5\u5355\u6d88\u606f\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public OrderOperationData() {
    }


    /**
     * 用户下单后系统自动拒绝接单时间,毫秒时间戳。
     */
    @JsonProperty("systemAutoRefuseOrderTime")
    private Long systemAutoRefuseOrderTime;

    /**
     * 退款审批超时系统自动退款时间,毫秒时间戳。
     */
    @JsonProperty("systemAutoRefundTime")
    private Long systemAutoRefundTime;
}
