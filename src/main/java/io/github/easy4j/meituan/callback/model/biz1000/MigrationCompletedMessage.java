package io.github.easy4j.meituan.callback.model.biz1000;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「迁移任务处理完成通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=1000}，消息类型为 {@code msgType=100010007}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_common_d7f87232-fe1f-491c-9dc1-c1c089263f53">官网消息文档</a>
 */
@CallbackPayload
@JsonIgnoreProperties(ignoreUnknown = true)
public class MigrationCompletedMessage extends ArrayList<MigrationCompletedMessage.Entry> {

    /**
     * 创建美团「迁移任务处理完成通知」回调的业务内容。的空实例。
     */
    public MigrationCompletedMessage() {
    }


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
         * 创建迁移处理条目。的空实例。
         */
        public Entry() {
        }


        /**
         * 原开发者的授权实体, 外卖/非接单下则为epoiId。
         */
        @JsonProperty("opBizCode")
        private String opBizCode;

        /**
         * 新开发者的授权实体, 外卖/非接单下则为epoiId。
         */
        @JsonProperty("newOpBizCode")
        private String newOpBizCode;

        /**
         * 处理状态：1：未处理，2：处理中，3：处理成功，4：处理失败, 5: 忽略(当目标开发者已存在此门店授权时)。
         */
        @JsonProperty("status")
        private Integer status;

        /**
         * 迁移失败时的失败原因。
         */
        @JsonProperty("msg")
        private String msg;

        /**
         * 授权token(即appAuthToken)。
         */
        @JsonProperty("accessToken")
        private String accessToken;

        /**
         * 刷新token(外卖/非接单无此字段）。
         */
        @JsonProperty("refreshToken")
        private String refreshToken;

        /**
         * 授权token过期时间(外卖/非接单无此字段）。
         */
        @JsonProperty("accessTokenExpiresIn")
        private Long accessTokenExpiresIn;

        /**
         * 刷新token的过期时间(外卖/非接单无此字段）。
         */
        @JsonProperty("refreshTokenExpiresIn")
        private Long refreshTokenExpiresIn;

        /**
         * 本次迁移操作，同时关闭推送开关的消息列表。
         */
        @JsonProperty("blockedMsgTypes")
        private List<Long> blockedMsgTypes;

        /**
         * 迁移出门店的原开发者 ID。
         */
        @JsonProperty("sourceDeveloperId")
        private Long sourceDeveloperId;

        /**
         * 迁移出门店的业务 ID。
         */
        @JsonProperty("sourceBusinessId")
        private Integer sourceBusinessId;

        /**
         * 迁移入门店的目标开发者 ID。
         */
        @JsonProperty("targetDeveloperId")
        private Long targetDeveloperId;

        /**
         * 迁移入门店的业务 ID。
         */
        @JsonProperty("targetBusinessId")
        private Integer targetBusinessId;
    }
}
