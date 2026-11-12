package io.github.easy4j.meituan.callback.model.biz46;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * DeliveryData，用于套餐配送接单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryData {

    /**
     * 是否仅支持自配,true代表不会走美团配送仅自配。
     */
    @JsonProperty("onlySupportSelfDelivery")
    private Boolean onlySupportSelfDelivery;

    /**
     * 配送类型,0/1 = 美团配送 2 = 商家自配送 3 = 美团青云聚合发配送 4 = 电商配送 5 = 自提 （目前仅面包蛋糕门店和少量测试门店有自提功能）。
     */
    @JsonProperty("deliveryType")
    private Integer deliveryType;

    /**
     * 配送单状态,骑手已接单:20 骑手已到店:25 骑手已取货:30 骑手已送达:50。
     */
    @JsonProperty("deliveryStatus")
    private Integer deliveryStatus;

    /**
     * 骑手姓名。
     */
    @JsonProperty("riderName")
    private String riderName;

    /**
     * 骑手隐私号。
     */
    @JsonProperty("riderPrivacyNumber")
    private String riderPrivacyNumber;

    /**
     * 骑手预计送达时间。
     */
    @JsonProperty("riderExpectDeliveredTime")
    private Long riderExpectDeliveredTime;

    /**
     * 配送异常原因。
     */
    @JsonProperty("deliveryErrorReason")
    private String deliveryErrorReason;
}
