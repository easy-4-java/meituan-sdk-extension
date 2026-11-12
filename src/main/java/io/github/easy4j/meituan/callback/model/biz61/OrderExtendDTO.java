package io.github.easy4j.meituan.callback.model.biz61;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * OrderExtendDTO，用于ORDER_SUBMIT等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderExtendDTO {

    /**
     * 创建OrderExtendDTO\uff0c\u7528\u4e8eORDER_SUBMIT\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public OrderExtendDTO() {
    }


    /**
     * openId。
     */
    @JsonProperty("thirdUserId")
    private String thirdUserId;

    /**
     * 渠道拓展自定义参数。
     */
    @JsonProperty("channelExtend")
    private String channelExtend;
}
