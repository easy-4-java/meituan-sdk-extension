package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「商户开关变更消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810277}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_fc1fba26-cdbd-42b5-932f-dbf35132d8fe">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantSettingsChangedMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u5546\u6237\u5f00\u5173\u53d8\u66f4\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public MerchantSettingsChangedMessage() {
    }


    /**
     * 业务线。必填。
     */
    @JsonProperty("bizLine")
    private Integer bizLine;

    /**
     * 租户 ID。必填。
     */
    @JsonProperty("tenantId")
    private Integer tenantId;

    /**
     * 变更设置。必填。
     */
    @JsonProperty("records")
    private List<MerchantSettingValueChange> records;

    /**
     * 变更设置。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MerchantSettingValueChange {

        /**
         * 创建\u53d8\u66f4\u8bbe\u7f6e\u3002的空实例。
         */
        public MerchantSettingValueChange() {
        }


        /**
         * 机构 ID。必填。
         */
        @JsonProperty("orgId")
        private Integer orgId;

        /**
         * 设置项列表 如果需要根据变更设置项判断 注意过滤。必填。
         */
        @JsonProperty("itemValues")
        private List<ItemValueChange> itemValues;

        /**
         * 修改时间 时间戳，单位毫秒。必填。
         */
        @JsonProperty("changeTime")
        private Long changeTime;

        /**
         * 修改人。必填。
         */
        @JsonProperty("operator")
        private Integer operator;

        /**
         * 设置项列表 如果需要根据变更设置项判断 注意过滤。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ItemValueChange {

            /**
             * 创建\u8bbe\u7f6e\u9879\u5217\u8868 \u5982\u679c\u9700\u8981\u6839\u636e\u53d8\u66f4\u8bbe\u7f6e\u9879\u5224\u65ad \u6ce8\u610f\u8fc7\u6ee4\u3002的空实例。
             */
            public ItemValueChange() {
            }


            /**
             * 设置key。必填。
             */
            @JsonProperty("settingKey")
            private String settingKey;

            /**
             * 设置项key。必填。
             */
            @JsonProperty("itemKey")
            private String itemKey;

            /**
             * 设置项旧值。必填。
             */
            @JsonProperty("oldValue")
            private String oldValue;

            /**
             * 设置项新值。必填。
             */
            @JsonProperty("newValue")
            private Integer newValue;
        }
    }
}
