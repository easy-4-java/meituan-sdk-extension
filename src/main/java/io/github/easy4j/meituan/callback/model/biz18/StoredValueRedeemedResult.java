package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「会员储值核销」回调的业务响应。
 *
 * <p>收银端响应示例将本对象置于 {@code data}，外层 {@code message} 为 {@code ok}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_4b56b8c3-8ea6-4d6c-848f-38847e3107ad">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoredValueRedeemedResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u4f1a\u5458\u50a8\u503c\u6838\u9500\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public StoredValueRedeemedResult() {
    }


    /**
     * 储值账户核销金额（分）。必填。
     */
    @JsonProperty("changeRechargeAmount")
    private Long changeRechargeAmount;

    /**
     * 赠送账户核销金额（分）。必填。
     */
    @JsonProperty("changeGiftAmount")
    private Long changeGiftAmount;
}
