package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「接收原北极星session迁移完毕状态」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810083}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_23e7ff83-c8db-41ab-beb0-206c72b61520">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LegacySessionMigrationCompletedMessage {

    /**
     * 创建美团「接收原北极星session迁移完毕状态」回调的业务内容。的空实例。
     */
    public LegacySessionMigrationCompletedMessage() {
    }


    /**
     * 迁移的session。必填。
     */
    @JsonProperty("session")
    private String session;

    /**
     * 迁移完成时间戳，单位毫秒。必填。
     */
    @JsonProperty("completedTime")
    private Long completedTime;

    /**
     * 迁移子任务成功数量。必填。
     */
    @JsonProperty("successCount")
    private Long successCount;

    /**
     * 迁移子任务失败数量。必填。
     */
    @JsonProperty("failCount")
    private Long failCount;
}
