package io.github.easy4j.meituan.callback.model.biz46;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * FoodDetail，用于套餐配送接单消息等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodDetail {

    /**
     * 创建FoodDetail\uff0c\u7528\u4e8e\u5957\u9910\u914d\u9001\u63a5\u5355\u6d88\u606f\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public FoodDetail() {
    }


    /**
     * 菜品价格,单位元。
     */
    @JsonProperty("foodPrice")
    private String foodPrice;

    /**
     * 菜品数量,用户选了几份该菜品。
     */
    @JsonProperty("foodCount")
    private Integer foodCount;

    /**
     * 菜品名称。
     */
    @JsonProperty("foodName")
    private String foodName;

    /**
     * 菜品单位,可能没有。需注意这里是带数量的。
     */
    @JsonProperty("foodUnit")
    private String foodUnit;

    /**
     * 三方菜品Id,仅套餐通过三方系统上单录入时有值。
     */
    @JsonProperty("foodId")
    private String foodId;

    /**
     * 菜品中心 ID。
     */
    @JsonProperty("fdcDishSkuId")
    private String fdcDishSkuId;
}
