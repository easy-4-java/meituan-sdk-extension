package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「下单预校验」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=92}，消息类型为 {@code msgType=9210009}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_a40c4fd2-2cee-432b-9877-6594015218ea">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderPrecheckMessage {

    /**
     * 报价单 ID，来自报价详情接口的返回。必填。
     */
    @JsonProperty("quoteId")
    private String quoteId;

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
     * 美团商家共担优惠信息。
     */
    @JsonProperty("coCouponInfo")
    private List<CoCouponInfo> coCouponInfo;
}
