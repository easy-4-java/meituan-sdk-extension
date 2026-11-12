package io.github.easy4j.meituan.callback.business59.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「商家券发券」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_59ffc833-1474-4f06-964f-42c5fd1b5647">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantCouponIssueResult {

    /**
     * 券码。用户券码，【 若需要发多张券时，只返回一张券码则为一码多用，该用户订单内的券都会是相同的券码 】 注：老应用仍可使用该字段传递券码，新三方请使用新券码字段receiptInfoList。
     */
    @JsonProperty("serialNumberList")
    private List<String> serialNumberList;

    /**
     * 券码信息列表。发券成功时，必传。
     */
    @JsonProperty("receiptInfoList")
    private List<ReceiptInfoObj> receiptInfoList;

    /**
     * 业务响应码。200-发券成功 12118-发券中( 接入该码必须要发券异步回调接口 ) xxx-其它失败业务码。
     */
    @JsonProperty("businessCode")
    private Integer businessCode;

    /**
     * 业务响应信息。
     */
    @JsonProperty("businessMsg")
    private String businessMsg;

    /**
     * 券码信息列表。发券成功时，必传。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ReceiptInfoObj {

        /**
         * 券码值。必填（注：对于一码多用的券类型，仅需传递一个券码即可，传递多个相同的则视为发券失败；另外列表内券码值不允许出现重复或空值，否则均视为发券失败！)。
         */
        @JsonProperty("receiptCode")
        private String receiptCode;

        /**
         * 商家二维码链接。商家码链接，选填(建议不传递，使用美团二维码)，如果商家扫码必须要用自己的二维码链接则可传入( 对于非合规格式链接，存在展示失败的场景，失败时默认会以美团码展示；另外一码多验场景不支持传入商家链接码 )。
         */
        @JsonProperty("receiptCodePic")
        private String receiptCodePic;
    }
}
