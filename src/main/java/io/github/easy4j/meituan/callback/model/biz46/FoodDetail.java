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
