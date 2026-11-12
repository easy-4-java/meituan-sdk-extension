package io.github.easy4j.meituan.callback.model.biz51;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 美团「商品审核失败通知（必接）」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=51}，消息类型为 {@code msgType=5110007}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_217803ab-efd3-47e2-bb94-bad7e887b645">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductAuditNoticeMessage {

    /**
     * 审核结果。必填。
     */
    @JsonProperty("auditResultList")
    private List<AuditResultDTO> auditResultList;


    /**
     * 创建美团「商品审核失败通知（必接）」回调的业务内容。的空实例。
     */
    public ProductAuditNoticeMessage() {
    }

    /**
     * 审核结果。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AuditResultDTO {

        /**
         * 审核对象 id。必填。
         */
        @JsonProperty("subjectId")
        private String subjectId;
        /**
         * 审核对象类型。必填。
         */
        @JsonProperty("subjectType")
        private Integer subjectType;
        /**
         * 审核结果。必填。
         */
        @JsonProperty("auditResultDetailList")
        private List<AuditResultDetailDTO> auditResultDetailList;

        /**
         * 创建审核结果。的空实例。
         */
        public AuditResultDTO() {
        }

        /**
         * 审核结果。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AuditResultDetailDTO {

            /**
             * 字段名。必填。
             */
            @JsonProperty("attributeName")
            private String attributeName;
            /**
             * 字段值。必填。
             */
            @JsonProperty("attributeValue")
            private String attributeValue;
            /**
             * 审核结果。必填。
             */
            @JsonProperty("result")
            private String result;

            /**
             * 创建审核结果。的空实例。
             */
            public AuditResultDetailDTO() {
            }
        }
    }
}
