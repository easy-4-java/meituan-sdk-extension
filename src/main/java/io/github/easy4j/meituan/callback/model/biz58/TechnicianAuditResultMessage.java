package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「手艺人审核结果通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810105}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_885450f6-7010-4cc5-914a-571155ac982e">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TechnicianAuditResultMessage {

    /**
     * 手艺人Id。必填。
     */
    @JsonProperty("technicianId")
    private Integer technicianId;

    /**
     * 审核结果。必填。
     */
    @JsonProperty("auditPass")
    private Boolean auditPass;

    /**
     * 失败原因。
     */
    @JsonProperty("failDetail")
    private String failDetail;

    /**
     * 美团门店Id(混淆)。必填。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;
}
