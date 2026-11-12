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
     * 创建\u7f8e\u56e2\u300c\u5546\u5bb6\u5238\u83b7\u53d6\u52a8\u6001\u6838\u9500\u7801\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
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
