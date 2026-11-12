package io.github.easy4j.meituan.callback.model.biz51;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
     * 创建美团「门店预计备餐时间和排队信息（必接）」回调的业务内容。的空实例。
     */
    public PreparationTimeAndQueueQueryMessage() {
    }

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
         * 厂商门店列表。必填。
         */
        @JsonProperty("app_poi_codes")
        private List<String> appPoiCodes;


        /**
         * 创建门店列表。的空实例。
         */
        public PredicatedQueryParam() {
        }
    }
}
