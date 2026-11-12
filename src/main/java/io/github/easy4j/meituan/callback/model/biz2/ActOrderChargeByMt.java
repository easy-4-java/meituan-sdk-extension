package io.github.easy4j.meituan.callback.model.biz2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * ActOrderChargeByMt，用于接收订单数据接口【必须】等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActOrderChargeByMt {

    /**
     * 创建ActOrderChargeByMt\uff0c\u7528\u4e8e\u63a5\u6536\u8ba2\u5355\u6570\u636e\u63a5\u53e3\u3010\u5fc5\u987b\u3011\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public ActOrderChargeByMt() {
    }


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
