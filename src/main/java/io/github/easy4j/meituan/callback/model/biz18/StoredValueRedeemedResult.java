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
     * 储值账户核销金额（分）。必填。
     */
    @JsonProperty("changeRechargeAmount")
    private Long changeRechargeAmount;
    /**
     * 赠送账户核销金额（分）。必填。
     */
    @JsonProperty("changeGiftAmount")
    private Long changeGiftAmount;

    /**
     * 创建美团「会员储值核销」回调的业务响应。的空实例。
     */
    public StoredValueRedeemedResult() {
    }
}
