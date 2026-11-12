package io.github.easy4j.meituan.callback.model.biz58;

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
     * 创建Product\uff0c\u7528\u4e8e\u8ba2\u5355\u4fe1\u606f\u63a8\u9001\u7b49\u56de\u8c03\u7684\u4e1a\u52a1\u5b57\u6bb5\u3002的空实例。
     */
    public Product() {
    }


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
