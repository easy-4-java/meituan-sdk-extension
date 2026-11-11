package io.github.easy4j.meituan.callback.business58.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Product，用于订单信息推送等回调的业务字段。
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    /**
     * 美团商品 ID。必填。
     */
    @JsonProperty("productId")
    private Long productId;

    /**
     * 商品名称。必填。
     */
    @JsonProperty("title")
    private String title;

    /**
     * skuId。必填。
     */
    @JsonProperty("skuId")
    private Long skuId;

    /**
     * 购买数量。必填。
     */
    @JsonProperty("quantity")
    private Long quantity;
}
