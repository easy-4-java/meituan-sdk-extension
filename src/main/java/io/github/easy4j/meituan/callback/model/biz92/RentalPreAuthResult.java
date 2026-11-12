package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「报价详情查询」回调的业务数据（PreAuth）。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_165ca498-a7a7-49bf-9985-fdf0fee76891">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalPreAuthResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u62a5\u4ef7\u8be6\u60c5\u67e5\u8be2\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u6570\u636e\uff08PreAuth\uff09\u3002的空实例。
     */
    public RentalPreAuthResult() {
    }


    /**
     * 是否支持使用免压。必填。
     */
    @JsonProperty("support")
    private Boolean support;

    /**
     * 详情见授权渠道枚举 DepositChannel。必填。
     */
    @JsonProperty("channel")
    private String channel;
}
