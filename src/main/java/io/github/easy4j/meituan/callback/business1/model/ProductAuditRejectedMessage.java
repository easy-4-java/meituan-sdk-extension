package io.github.easy4j.meituan.callback.business1.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「审核驳回通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=1}，消息类型为 {@code msgType=110027}。</p>
 * 官网请求示例使用 {@code 110027}，消息列表使用 {@code 110017}。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_tuangoung_41822434-e339-4850-9e0e-1204af98e295">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductAuditRejectedMessage {

    /**
     * 维度，1-总部, 2-门店。必填。
     */
    @JsonProperty("scope")
    private Integer scope;

    /**
     * 总部code，当scope = 1时必填。
     */
    @JsonProperty("vendorChainId")
    private String vendorChainId;

    /**
     * 门店code，当scope = 2时必填。
     */
    @JsonProperty("vendorShopId")
    private String vendorShopId;

    /**
     * 审核驳回信息。必填。
     */
    @JsonAlias("auditMesage")
    @JsonProperty("auditMessage")
    private AuditRejectDetails auditMessage;

    /**
     * 审核驳回信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AuditRejectDetails {

        /**
         * 主体类型：10-spu，11-sku，20-加价属性，30-加料，40-餐盒，50-桌台 60-前台类目。必填。
         */
        @JsonProperty("subjectType")
        private Integer subjectType;

        /**
         * 主体 ID，根据subjectType确定，特殊：主体sku时，这个字段传spuId。必填。
         */
        @JsonProperty("subjectId")
        private String subjectId;

        /**
         * 子主体 ID，例如在spu场景下该字段需传skuId。
         */
        @JsonProperty("subSubjectId")
        private String subSubjectId;

        /**
         * 审核驳回原因。必填。
         */
        @JsonProperty("rejectReason")
        private String rejectReason;
    }
}
