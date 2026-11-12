package io.github.easy4j.meituan.callback.model.biz46;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * BillData，用于套餐配送接单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillData {

    /**
     * 创建BillData，用于套餐配送接单消息等回调的业务字段。的空实例。
     */
    public BillData() {
    }


    /**
     * 套餐总售价,当前订单所有套餐售价，单位元。
     */
    @JsonProperty("unitPrice")
    private String unitPrice;

    /**
     * 套餐原价,套餐面值价，单位元。注：未来会废弃，该字段与上面unitPrice值一致。
     */
    @JsonProperty("dealPrice")
    private String dealPrice;

    /**
     * 打包费,当前订单所有打包费总和，单位元。
     */
    @JsonProperty("packingFee")
    private String packingFee;

    /**
     * 佣金,当前订单所有打包费佣金+套餐佣金，单位元。
     */
    @JsonProperty("commission")
    private String commission;

    /**
     * 套餐份数,总份数。注：未来会废弃，推荐使用list 的份数求和。
     */
    @JsonProperty("dealCount")
    private Integer dealCount;

    /**
     * 商家承担配送服务费,单位元。
     */
    @JsonProperty("merchantDeliveryFee")
    private String merchantDeliveryFee;

    /**
     * 商家对顾客的配送费减免金额,单位元。
     */
    @JsonProperty("deliveryReductionFee")
    private String deliveryReductionFee;

    /**
     * 用户承担配送服务费,用户支付的配送费，强制自配场景下（如蛋糕配送），该值为商户收入，单位元。
     */
    @JsonProperty("customerDeliveryFee")
    private String customerDeliveryFee;

    /**
     * 商促金额,商家承担的促销优惠金额。
     */
    @JsonProperty("merchantPromotionFee")
    private String merchantPromotionFee;

    /**
     * 预计收入,计算公式：套餐售价+打包费-佣金-配送服务费-配送费减免金额+强制自配场景的用户承担配送服务费 单位元。 注：该字段仅用作展示，
     * 准确的收入信息以结算对账接口的账单数据为准。
     */
    @JsonProperty("income")
    private String income;
}
