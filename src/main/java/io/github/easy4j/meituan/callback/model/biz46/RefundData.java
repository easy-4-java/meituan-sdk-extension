package io.github.easy4j.meituan.callback.model.biz46;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * RefundData，用于接收商家转自配成功消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundData {

    /**
     * 创建RefundData\uff0c\u7528\u4e8e\u63a5\u6536\u5546\u5bb6\u8f6c\u81ea\u914d\u6210\u529f\u6d88\u606f\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public RefundData() {
    }


    /**
     * 退款申请状态,0=无申请 8=用户申请退款待商家审批 15=用户撤销退款 16=商家审批通过 17=商家审批拒绝 18=系统自动拒绝退款 32=退款中 64=退款完成。
     */
    @JsonProperty("refundStatus")
    private Integer refundStatus;

    /**
     * 退款来源,1=客户，商家同意 2=商家取消订单 3=客服 4=客户发起，商家审批超时，系统自动同意 5=24小时不出餐自动退款 6=超时未接单自动退款。
     */
    @JsonProperty("refundSource")
    private Integer refundSource;

    /**
     * 退款原因。
     */
    @JsonProperty("refundReason")
    private String refundReason;

    /**
     * 退款图片（用户上传的）。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("refundPictureUrls")
    private List<String> refundPictureUrls;

    /**
     * 申请退款时间。
     */
    @JsonProperty("applyRefundTime")
    private Long applyRefundTime;

    /**
     * 拒绝退款原因/拒绝接单原因/商家取消订单原因。
     */
    @JsonProperty("refuseReason")
    private String refuseReason;
}
