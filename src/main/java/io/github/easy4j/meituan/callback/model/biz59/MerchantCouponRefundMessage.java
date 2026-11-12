package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「商家券退券」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910029}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_593a32a9-0dbc-4ca4-abd9-750153ff3ec1">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantCouponRefundMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u5546\u5bb6\u5238\u9000\u5238\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public MerchantCouponRefundMessage() {
    }


    /**
     * 第三方团单 ID。必填。
     */
    @JsonProperty("appDealId")
    private String appDealId;

    /**
     * 开放平台上的订单 ID。必填。
     */
    @JsonProperty("orderId")
    private String orderId;

    /**
     * 退款 ID。必填。
     */
    @JsonProperty("refundId")
    private String refundId;

    /**
     * 券码,以逗号分隔。必填。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("serialNumberList")
    private List<String> serialNumberList;

    /**
     * 退券数目。必填。
     */
    @JsonProperty("refundCount")
    private String refundCount;
}
