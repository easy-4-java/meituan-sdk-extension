package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「包型包间审核结果通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810247}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_94957cd6-851a-4ab9-a5cc-94d18b431209">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomAuditResultMessage {

    /**
     * 三方包型 ID。必填。
     */
    @JsonProperty("roomTypeCode")
    private String roomTypeCode;

    /**
     * 三方包间 ID 列表。必填。
     */
    @JsonProperty("roomCodes")
    private List<Long> roomCodes;

    /**
     * 审核结果 1通过/2驳回。必填。
     */
    @JsonProperty("auditStatus")
    private Integer auditStatus;

    /**
     * 原因。
     */
    @JsonProperty("reason")
    private String reason;

    /**
     * 审核时间, 格式yyyy-MM-dd HH:mm:ss。必填。
     */
    @JsonProperty("auditTime")
    private String auditTime;
}
