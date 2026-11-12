package io.github.easy4j.meituan.callback.model.biz2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「拼好饭-推送商品变更消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210027}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_5857a661-af40-442b-83ec-f0eca808c170">官网消息文档</a>
 */
@CallbackPayload("")
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupMealProductChangedMessage {

    /**
     * 创建美团「拼好饭-推送商品变更消息」回调的业务内容。的空实例。
     */
    public GroupMealProductChangedMessage() {
    }


    /**
     * 服务商入驻美团餐饮技术合作中心得到的唯一身份表示。必填。
     */
    @JsonProperty("developerId")
    private Integer developerId;

    /**
     * ERP方门店 ID 最大长度100。必填。
     */
    @JsonProperty("ePoiId")
    private String ePoiId;

    /**
     * 数字签名。必填。
     */
    @JsonProperty("sign")
    private String sign;

    /**
     * 商品变更消息详情。必填。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("bizMsg")
    private BizMsg bizMsg;

    /**
     * 商品变更消息详情。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BizMsg {

        /**
         * 创建商品变更消息详情。的空实例。
         */
        public BizMsg() {
        }


        /**
         * 门店code。
         */
        @JsonProperty("ePoiId")
        private String ePoiId;

        /**
         * 商品code。
         */
        @JsonProperty("eDishCode")
        private String eDishCode;

        /**
         * 美团SPUID。
         */
        @JsonProperty("mtSpuId")
        private Long mtSpuId;

        /**
         * 商品名称。
         */
        @JsonProperty("name")
        private String name;

        /**
         * 业务类型，1-拼好饭场景。
         */
        @JsonProperty("businessIdentify")
        private Integer businessIdentify;

        /**
         * 分类 ID。
         */
        @JsonProperty("mtTagId")
        private Long mtTagId;

        /**
         * 分类名称。
         */
        @JsonProperty("tagName")
        private String tagName;

        /**
         * 变更类型。1-insert，2-update，3-delete。
         */
        @JsonProperty("opType")
        private Integer opType;

        /**
         * 修改字段。1-商品信息变化，7-分类变化。
         */
        @JsonProperty("bizType")
        private Integer bizType;

        /**
         * 操作方名称。如商家端，先富等。
         */
        @JsonProperty("opName")
        private String opName;

        /**
         * 商品变更时间戳。
         */
        @JsonProperty("utime")
        private Long utime;

        /**
         * 物流编码。
         */
        @JsonProperty("logisticsCode")
        private String logisticsCode;

        /**
         * 物流状态。
         */
        @JsonProperty("logisticsStatus")
        private Long logisticsStatus;

        /**
         * 催单 ID。
         */
        @JsonProperty("remindId")
        private Long remindId;

        /**
         * 催单时间。
         */
        @JsonProperty("remindTime")
        private String remindTime;

        /**
         * 状态。
         */
        @JsonProperty("status")
        private Long status;
    }
}
