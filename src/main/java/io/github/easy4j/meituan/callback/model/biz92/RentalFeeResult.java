package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「报价详情查询」回调的业务数据（Fee）。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_165ca498-a7a7-49bf-9985-fdf0fee76891">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalFeeResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u62a5\u4ef7\u8be6\u60c5\u67e5\u8be2\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u6570\u636e\uff08Fee\uff09\u3002的空实例。
     */
    public RentalFeeResult() {
    }


    /**
     * 价格信息。必填。
     */
    @JsonProperty("priceInfo")
    private RentalPriceInfoResult priceInfo;

    /**
     * 费用明细。必填。
     */
    @JsonProperty("feeItems")
    private List<RentalFeeItemResult> feeItems;
}
