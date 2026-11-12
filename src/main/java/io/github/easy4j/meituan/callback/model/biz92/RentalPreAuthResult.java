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
     * 是否支持使用免压。必填。
     */
    @JsonProperty("support")
    private Boolean support;
    /**
     * 详情见授权渠道枚举 DepositChannel。必填。
     */
    @JsonProperty("channel")
    private String channel;

    /**
     * 创建美团「报价详情查询」回调的业务数据（PreAuth）。的空实例。
     */
    public RentalPreAuthResult() {
    }
}
