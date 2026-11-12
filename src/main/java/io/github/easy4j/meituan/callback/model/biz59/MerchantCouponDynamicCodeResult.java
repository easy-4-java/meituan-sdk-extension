package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「商家券获取动态核销码」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_f14d537b-97e0-4bd0-b595-9f66a86e7d30">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantCouponDynamicCodeResult {

    /**
     * 创建美团「商家券获取动态核销码」回调的业务响应。的空实例。
     */
    public MerchantCouponDynamicCodeResult() {
    }


    /**
     * 动态核销码。必填。
     */
    @JsonProperty("dynamicCode")
    private String dynamicCode;

    /**
     * 动态核销码过期时间。动态核销码过期时间,时间戳单位S，默认缓存为2分钟，示例如： 172466100 （过期时间不要过长）。
     */
    @JsonProperty("expiryDate")
    private Long expiryDate;
}
