package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「下单」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210011}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_77c13fc2-0902-4876-af97-a85d96a37692">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderPlacedMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u4e0b\u5355\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public OrderPlacedMessage() {
    }


    /**
     * 报价单 ID，来自报价详情接口的返回。必填。
     */
    @JsonProperty("quoteId")
    private String quoteId;

    /**
     * 美团订单号。必填。
     */
    @JsonProperty("mtOrderId")
    private Long mtOrderId;

    /**
     * 商家车型编码。必填。
     */
    @JsonProperty("thirdCarModelId")
    private String thirdCarModelId;

    /**
     * 驾驶人信息。必填。
     */
    @JsonProperty("driver")
    private Driver driver;

    /**
     * 取车信息。必填。
     */
    @JsonProperty("pickUpInfo")
    private RentalInfo pickUpInfo;

    /**
     * 还车信息。必填。
     */
    @JsonProperty("dropOffInfo")
    private DropOffInfoDetails dropOffInfo;

    /**
     * 订单总金额(优惠后总价格+附加保险费用)。必填。
     */
    @JsonProperty("totalAmount")
    private Integer totalAmount;

    /**
     * 用户选择的保险方案编码列表，来自报价详情接口返回的 insuranceCode。必填。
     */
    @JsonProperty("selectedInsurances")
    private List<String> selectedInsurances;

    /**
     * 共担优惠信息。
     */
    @JsonProperty("coCouponInfo")
    private List<CoCouponInfo> coCouponInfo;
}
