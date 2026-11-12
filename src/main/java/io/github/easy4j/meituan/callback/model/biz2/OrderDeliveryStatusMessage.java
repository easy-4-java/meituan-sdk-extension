package io.github.easy4j.meituan.callback.model.biz2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「接收订单配送状态接口」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=2}，消息类型为 {@code msgType=210011}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_waimaing_4b789ca7-7215-4253-8c20-2863ab6b20d2">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDeliveryStatusMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u63a5\u6536\u8ba2\u5355\u914d\u9001\u72b6\u6001\u63a5\u53e3\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public OrderDeliveryStatusMessage() {
    }


    /**
     * 服务商入驻技术合作中心得到的唯一身份表示。必填。
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
     * 订单配送信息。必填。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("shippingStatus")
    private ShippingStatus shippingStatus;

    /**
     * 美团跑腿订单聚合平台可发配送状态，当前返回值只有0，收到此推送时商家可对当前订单发起配送。 0：可发配送。必填。
     */
    @JsonProperty("deliveryAvailable")
    private Integer deliveryAvailable;

    /**
     * 骑手取货时货品照片，多张图片以逗号隔开，最多支持三张图片。只有在配送状态仅为已取货时可传。
     */
    @JsonProperty("fetchPictures")
    private String fetchPictures;

    /**
     * 骑手送达时货品照片，多张图片以逗号隔开，最多支持三张图片。只有在配送状态仅为已送达时可传。
     */
    @JsonProperty("deliveryPictures")
    private String deliveryPictures;

    /**
     * 订单配送信息。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ShippingStatus {

        /**
         * 创建\u8ba2\u5355\u914d\u9001\u4fe1\u606f\u3002的空实例。
         */
        public ShippingStatus() {
        }


        /**
         * 订单 ID。
         */
        @JsonProperty("orderId")
        private Long orderId;

        /**
         * 配送状态。
         */
        @JsonProperty("shippingStatus")
        private Integer shippingStatus;

        /**
         * 发生时间【单位秒】。
         */
        @JsonProperty("time")
        private Long time;

        /**
         * 骑手姓名。
         */
        @JsonProperty("dispatcherName")
        private String dispatcherName;

        /**
         * 骑手电话。
         */
        @JsonProperty("dispatcherMobile")
        private String dispatcherMobile;

        /**
         * 订单业务打标枚举，即业务身份。16-拼好饭场景订单，1001-神抢手场景订单。
         */
        @JsonProperty("orderTagList")
        private String orderTagList;

        /**
         * 出餐考核时间。
         */
        @JsonProperty("poiMealAssessmentTime")
        private Long poiMealAssessmentTime;
    }
}
