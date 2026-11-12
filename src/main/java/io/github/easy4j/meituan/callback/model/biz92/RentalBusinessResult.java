package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 租车回调的通用业务状态，适用于仅返回业务码与说明的操作。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_3b5ec62b-dfc5-4028-ac8a-9a3259996029">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalBusinessResult {

    /**
     * 创建\u79df\u8f66\u56de\u8c03\u7684\u901a\u7528\u4e1a\u52a1\u72b6\u6001\uff0c\u9002\u7528\u4e8e\u4ec5\u8fd4\u56de\u4e1a\u52a1\u7801\u4e0e\u8bf4\u660e\u7684\u64cd\u4f5c\u3002的空实例。
     */
    public RentalBusinessResult() {
    }


    /**
     * 业务状态码。必填。
     */
    @JsonProperty("bizCode")
    private Integer bizCode;

    /**
     * 错误描述。必填。
     */
    @JsonProperty("bizMessage")
    private String bizMessage;
}
