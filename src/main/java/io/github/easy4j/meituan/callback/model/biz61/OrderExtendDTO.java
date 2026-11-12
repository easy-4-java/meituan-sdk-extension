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
     * openId。
     */
    @JsonProperty("thirdUserId")
    private String thirdUserId;
    /**
     * 渠道拓展自定义参数。
     */
    @JsonProperty("channelExtend")
    private String channelExtend;

    /**
     * 创建OrderExtendDTO，用于ORDER_SUBMIT等回调的业务字段。的空实例。
     */
    public OrderExtendDTO() {
    }
}
