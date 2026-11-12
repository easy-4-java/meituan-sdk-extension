package io.github.easy4j.meituan.callback.model.biz51;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询订单履约信息（必接）」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=51}，消息类型为 {@code msgType=5110021}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_c5d73602-79ab-4880-ba25-ef974c42f9d0">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderFulfillmentQueryMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u67e5\u8be2\u8ba2\u5355\u5c65\u7ea6\u4fe1\u606f\uff08\u5fc5\u63a5\uff09\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public OrderFulfillmentQueryMessage() {
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
     * 订单查询参数。必填。
     */
    @JsonProperty("requestData")
    private OrderQueryParam requestData;

    /**
     * 值为mop，传在query中。必填。
     */
    @JsonProperty("source")
    private String source;

    /**
     * 厂商门店 ID。必填。
     */
    @JsonProperty("ePoiId")
    private String ePoiId;

    /**
     * 订单查询参数。
     */
    @Getter
    @Setter
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
            isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderQueryParam {

        /**
         * 创建\u8ba2\u5355\u67e5\u8be2\u53c2\u6570\u3002的空实例。
         */
        public OrderQueryParam() {
        }


        /**
         * 订单 ID，wm_order_id_view。必填。
         */
        @JsonProperty("order_id")
        private String orderId;
    }
}
