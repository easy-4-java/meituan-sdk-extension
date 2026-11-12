package io.github.easy4j.meituan.callback.model.biz15;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 美团「会员卡积分」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=15}，消息类型为 {@code msgType=15202}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_jmcard_d1db186e-08c5-4ad8-b28e-532c68a84314">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MembershipCardPointsMessage {

    /**
     * 事件类型。必填。
     */
    @JsonProperty("eventType")
    private String eventType;
    /**
     * 具体信息。必填。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("eventDetail")
    private Detail eventDetail;

    /**
     * 创建美团「会员卡积分」回调的业务内容。的空实例。
     */
    public MembershipCardPointsMessage() {
    }

    /**
     * 具体信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Detail {

        /**
         * 用户 ID。必填。
         */
        @JsonProperty("userOpenId")
        private String userOpenId;
        /**
         * 平台。必填。
         */
        @JsonProperty("platformType")
        private String platformType;
        /**
         * 积分数据。必填。
         */
        @JsonProperty("pointInfo")
        private PointItem pointInfo;

        /**
         * 创建具体信息。的空实例。
         */
        public Detail() {
        }

        /**
         * 积分数据。
         */
        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PointItem {

            /**
             * 积分唯一流水 ID。必填。
             */
            @JsonProperty("pointItemId")
            private String pointItemId;
            /**
             * 业务类型。必填。
             */
            @JsonProperty("bizType")
            private String bizType;
            /**
             * 业务产品 ID。
             */
            @JsonProperty("productId")
            private String productId;
            /**
             * 业务产品名称。
             */
            @JsonProperty("productName")
            private String productName;
            /**
             * 积分操作类型。必填。
             */
            @JsonProperty("opType")
            private String opType;
            /**
             * 促销类型。
             */
            @JsonProperty("promoType")
            private String promoType;
            /**
             * 用户支付金额。必填。
             */
            @JsonProperty("money")
            private BigDecimal money;
            /**
             * 交易时间。必填。
             */
            @JsonProperty("businessTime")
            private String businessTime;
            /**
             * 核销关联 ID。必填。
             */
            @JsonProperty("consumeAssociationId")
            private String consumeAssociationId;

            /**
             * 创建积分数据。的空实例。
             */
            public PointItem() {
            }
        }
    }
}
