package io.github.easy4j.meituan.callback.model.biz2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「接收商家申诉结果消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210065}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_0dbe7497-249f-4403-b3e9-446d4acff3a1">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantAppealResultMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u63a5\u6536\u5546\u5bb6\u7533\u8bc9\u7ed3\u679c\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public MerchantAppealResultMessage() {
    }


    /**
     * 订单 ID。
     */
    @JsonProperty("orderId")
    private Long orderId;

    /**
     * 通知类型 1发起申诉 2申诉处理完成。
     */
    @JsonProperty("msgType")
    private Integer msgType;

    /**
     * 退款单 ID。
     */
    @JsonProperty("refundId")
    private Long refundId;

    /**
     * 商家申诉结果1通过：平台审核通过商家申诉 2通过：平台审核通过商家申诉 3拒绝：平台审核拒绝商家申诉 0默认值，发起时为0。
     */
    @JsonProperty("poiResult")
    private Integer poiResult;
}
