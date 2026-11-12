package io.github.easy4j.meituan.callback.model.biz2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「接收门店状态变更接口」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210013}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_a827b96c-6ea1-4919-b91a-6629f7751662">官网消息文档</a>
 */
@CallbackPayload("")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreStatusChangedMessage {

    /**
     * 服务商入驻技术合作中心得到的唯一身份表示。
     */
    @JsonProperty("developerId")
    private Integer developerId;
    /**
     * 数字签名，签名方式与菜品类接口计算签名一致。
     */
    @JsonProperty("sign")
    private String sign;
    /**
     * 门店状态信息。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("poiStatus")
    private PoiStatus poiStatus;

    /**
     * 创建美团「接收门店状态变更接口」回调的业务内容。的空实例。
     */
    public StoreStatusChangedMessage() {
    }

    /**
     * 门店状态信息。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PoiStatus {

        /**
         * ERP方门店 ID，最大长度100。
         */
        @JsonProperty("ePoiId")
        private String ePoiId;
        /**
         * 门店状态，121-营业；120-休息；18-上线；19-下线。
         */
        @JsonProperty("poiStatus")
        private Integer poiStatus;
        /**
         * 操作方。BUSINESS或者MEITUAN。
         */
        @JsonProperty("operateUser")
        private String operateUser;
        /**
         * 状态变更原因，如字符串为非中文，按utf8转码即可。
         */
        @JsonProperty("reason")
        private String reason;
        /**
         * 发生时间【单位秒】。
         */
        @JsonProperty("operateTime")
        private Long operateTime;

        /**
         * 创建门店状态信息。的空实例。
         */
        public PoiStatus() {
        }
    }
}
