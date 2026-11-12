package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「包型包间推送结果通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810162}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_2f06a02d-0ebf-40a4-9789-cddfd5b05403">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomPushResultMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u5305\u578b\u5305\u95f4\u63a8\u9001\u7ed3\u679c\u901a\u77e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public RoomPushResultMessage() {
    }


    /**
     * 包间同步结果列表。必填。
     */
    @JsonProperty("roomSyncResultList")
    private List<RoomSyncResultDTO> roomSyncResultList;

    /**
     * roomSyncResultList。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RoomSyncResultDTO {

        /**
         * 创建roomSyncResultList\u3002的空实例。
         */
        public RoomSyncResultDTO() {
        }


        /**
         * 三方房型 ID。必填。
         */
        @JsonProperty("roomTypeCode")
        private String roomTypeCode;

        /**
         * 三方房间 ID 列表。必填。
         */
        @JsonProperty("roomCodeList")
        private List<String> roomCodeList;

        /**
         * 是否推送成功：true-是，false-否。必填。
         */
        @JsonProperty("success")
        private Boolean success;

        /**
         * 失败信息。
         */
        @JsonProperty("errMsg")
        private String errMsg;
    }
}
