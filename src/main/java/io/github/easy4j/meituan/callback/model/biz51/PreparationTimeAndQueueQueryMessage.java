package io.github.easy4j.meituan.callback.model.biz51;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「门店预计备餐时间和排队信息（必接）」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=51}，消息类型为 {@code msgType=5110019}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_8516072d-d9ba-40dd-bc43-ab46c1276b5d">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PreparationTimeAndQueueQueryMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u95e8\u5e97\u9884\u8ba1\u5907\u9910\u65f6\u95f4\u548c\u6392\u961f\u4fe1\u606f\uff08\u5fc5\u63a5\uff09\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public PreparationTimeAndQueueQueryMessage() {
    }


    /**
     * app_id。必填。
     */
    @JsonProperty("app_id")
    private Integer appId;

    /**
     * 合作中心签名，与外卖对接一致。必填。
     */
    @JsonProperty("sig")
    private String sig;

    /**
     * 调用接口时的时间戳。必填。
     */
    @JsonProperty("timestamp")
    private Long timestamp;

    /**
     * 门店列表。必填。
     */
    @JsonProperty("requestData")
    private PredicatedQueryParam requestData;

    /**
     * 门店列表。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PredicatedQueryParam {

        /**
         * 创建\u95e8\u5e97\u5217\u8868\u3002的空实例。
         */
        public PredicatedQueryParam() {
        }


        /**
         * 厂商门店列表。必填。
         */
        @JsonProperty("app_poi_codes")
        private List<String> appPoiCodes;
    }
}
