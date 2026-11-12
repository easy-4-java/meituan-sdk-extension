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
     * 创建OrderOperationData，用于套餐配送接单消息等回调的业务字段。的空实例。
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
