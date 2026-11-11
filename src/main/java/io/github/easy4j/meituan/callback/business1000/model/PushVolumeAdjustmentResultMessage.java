package io.github.easy4j.meituan.callback.business1000.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「开发者迁移消息调量结果通知消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=1000}，消息类型为 {@code msgType=100010009}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_common_baf66063-f311-471d-8392-01df3fce7d80">官网消息文档</a>
 */
@CallbackPayload
@JsonIgnoreProperties(ignoreUnknown = true)
public class PushVolumeAdjustmentResultMessage extends ArrayList<PushVolumeAdjustmentResultMessage.Entry> {

    /**
     * 序列化版本号。
     */
    private static final long serialVersionUID = 1L;

    /**
     * 迁移处理条目。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Entry {

        /**
         * 原开发者授权实体（外卖/非接单则为epoiId)。
         */
        @JsonProperty("opBizCode")
        private String opBizCode;

        /**
         * 新开发者授权实体（外卖/非接单则为epoiId)。
         */
        @JsonProperty("newOpBizCode")
        private String newOpBizCode;

        /**
         * 处理状态：1：未处理，2：处理中，3：处理成功，4：处理失败。
         */
        @JsonProperty("status")
        private Integer status;

        /**
         * 处理失败时的失败原因。
         */
        @JsonProperty("msg")
        private String msg;

        /**
         * 迁移的原开发者 ID。
         */
        @JsonProperty("sourceDeveloperId")
        private Long sourceDeveloperId;

        /**
         * 迁移出原开发者的业务 ID。
         */
        @JsonProperty("sourceBusinessId")
        private Integer sourceBusinessId;

        /**
         * 目标开发者 ID。
         */
        @JsonProperty("targetDeveloperId")
        private Long targetDeveloperId;

        /**
         * 迁移至目标开发者的业务 ID。
         */
        @JsonProperty("targetBusinessId")
        private Integer targetBusinessId;
    }
}
