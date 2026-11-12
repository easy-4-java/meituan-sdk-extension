package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「结账方式变更消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810081}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_cd69c47a-d403-4b40-b938-51b50dead79e">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethodChangedMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u7ed3\u8d26\u65b9\u5f0f\u53d8\u66f4\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public PaymentMethodChangedMessage() {
    }


    /**
     * 组织机构 ID。必填。
     */
    @JsonProperty("orgId")
    private Long orgId;

    /**
     * 结账方式列表。必填。
     */
    @JsonProperty("payments")
    private List<PaymentModifyInfo> payments;

    /**
     * 结账方式列表。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PaymentModifyInfo {

        /**
         * 创建\u7ed3\u8d26\u65b9\u5f0f\u5217\u8868\u3002的空实例。
         */
        public PaymentModifyInfo() {
        }


        /**
         * 操作类型，1-创建，2-更新，3-启停，4-删除。必填。
         */
        @JsonProperty("operationType")
        private Integer operationType;

        /**
         * 一级编码。必填。
         */
        @JsonProperty("firstLevelCode")
        private String firstLevelCode;

        /**
         * 一级名称。必填。
         */
        @JsonProperty("firstLevelName")
        private String firstLevelName;

        /**
         * 二级编码。必填。
         */
        @JsonProperty("typeNo")
        private String typeNo;

        /**
         * 结账方式标识，可以作为唯一标识。必填。
         */
        @JsonProperty("type")
        private Integer type;

        /**
         * 名称，对应二级编码。必填。
         */
        @JsonProperty("secondLevelName")
        private String secondLevelName;

        /**
         * 状态，1-启用，2-停用。必填。
         */
        @JsonProperty("status")
        private Integer status;

        /**
         * 来源，1-自定义，2-系统默认，3-总部下发。必填。
         */
        @JsonProperty("custom")
        private Integer custom;

        /**
         * 修改时间，毫秒级时间戳。必填。
         */
        @JsonProperty("modifiedTime")
        private Long modifiedTime;

        /**
         * 记账规则。
         */
        @JsonProperty("incomeRule")
        private IncomeRule incomeRule;

        /**
         * 记账规则。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class IncomeRule {

            /**
             * 创建\u8bb0\u8d26\u89c4\u5219\u3002的空实例。
             */
            public IncomeRule() {
            }


            /**
             * 计收入规则，1-计入收入，2-计入优惠。
             */
            @JsonProperty("incomeFlag")
            private Integer incomeFlag;

            /**
             * 储值余额计收入规则，1-计入收入，2-计入优惠。
             */
            @JsonProperty("storeIncomeFlag")
            private Integer storeIncomeFlag;

            /**
             * 赠送余额计收入规则，1-计入收入，2-计入优惠。
             */
            @JsonProperty("givenIncomeFlag")
            private Integer givenIncomeFlag;
        }
    }
}
