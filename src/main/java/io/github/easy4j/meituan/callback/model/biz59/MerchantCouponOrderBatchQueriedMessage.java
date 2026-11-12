package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「商家券批量查询三方订单信息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910105}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_ea80d356-994b-4460-831e-f6f2176425ff">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantCouponOrderBatchQueriedMessage {

    /**
     * 创建美团「商家券批量查询三方订单信息」回调的业务内容。的空实例。
     */
    public MerchantCouponOrderBatchQueriedMessage() {
    }


    /**
     * 美团订单 ID 列表。必填。
     */
    @JsonProperty("orderIdList")
    private List<Long> orderIdList;
}
