package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询商品会员价」回调的业务响应。
 *
 * <p>收银端响应示例将本对象置于 {@code data}，外层 {@code message} 为 {@code ok}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_42758627-f078-43fe-9420-73cc37c31cab">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberPriceQueryResult {

    /**
     * 菜品会员价信息。必填。
     */
    @JsonProperty("memberSkus")
    private List<MemberSku> memberSkus;

    /**
     * 菜品会员价信息。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MemberSku {

        /**
         * 菜品skuId。必填。
         */
        @JsonProperty("skuId")
        private Long skuId;

        /**
         * 菜品会员价。必填。
         */
        @JsonProperty("memberPrice")
        private Long memberPrice;
    }
}
