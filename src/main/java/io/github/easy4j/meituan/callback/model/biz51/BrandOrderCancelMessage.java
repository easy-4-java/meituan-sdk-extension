package io.github.easy4j.meituan.callback.model.biz51;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「品牌提供取消订单」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=51}，消息类型为 {@code msgType=5110029}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_foodmop_c2d61f12-5312-4717-8fef-1d4cbba36709">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandOrderCancelMessage {

    /**
     * 创建美团「品牌提供取消订单」回调的业务内容。的空实例。
     */
    public BrandOrderCancelMessage() {
    }


    /**
     * 推送数据来源，默认为mop（秒提）。必填。
     */
    @JsonProperty("source")
    private String source;

    /**
     * 业务参数。必填。
     */
    @JsonProperty("requestData")
    private CancelOrConfirmOrderPushDTO requestData;

    /**
     * 厂商门店 ID。必填。
     */
    @JsonProperty("ePoiId")
    private String ePoiId;

    /**
     * 业务参数。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CancelOrConfirmOrderPushDTO {

        /**
         * 创建业务参数。的空实例。
         */
        public CancelOrConfirmOrderPushDTO() {
        }


        /**
         * 使用外卖orderIdView字段。必填。
         */
        @JsonProperty("orderId")
        private Long orderId;

        /**
         * 10：取消订单（品牌只能反馈同意取消 OR 不同意取消） 20：接单超时强制取消 （品牌只能同步接单 OR 同意取消，注意：接口返回前品牌系统需处理好自己系统的订单）。必填。
         */
        @JsonProperty("operationType")
        private Integer operationType;
    }
}
