package io.github.easy4j.meituan.callback.model.biz87;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「开票申请接口」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_enterprise_6d838670-fab5-4342-a861-8cc433a82095">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceApplicationResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u5f00\u7968\u7533\u8bf7\u63a5\u53e3\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public InvoiceApplicationResult() {
    }


    /**
     * 开票申请ID。必填。
     */
    @JsonProperty("applyId")
    private String applyId;

    /**
     * 服务商开票受理流水号，用于查询进度。
     */
    @JsonProperty("batchNo")
    private String batchNo;
}
