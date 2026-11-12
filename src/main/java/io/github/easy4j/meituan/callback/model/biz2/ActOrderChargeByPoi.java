package io.github.easy4j.meituan.callback.model.biz2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * ActOrderChargeByPoi，用于接收订单数据接口【必须】等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActOrderChargeByPoi {

    /**
     * 备注。
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * 明细费用类型描述。
     */
    @JsonProperty("feeTypeDesc")
    private String feeTypeDesc;

    /**
     * 明细费用类型Id。
     */
    @JsonProperty("feeTypeId")
    private Integer feeTypeId;

    /**
     * 明细金额（分）。
     */
    @JsonProperty("moneyCent")
    private Integer moneyCent;
}
