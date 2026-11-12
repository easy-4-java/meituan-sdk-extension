package io.github.easy4j.meituan.callback.model.biz18;

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
     * 创建\u7f8e\u56e2\u300c\u67e5\u8be2\u5546\u54c1\u4f1a\u5458\u4ef7\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public MemberPriceQueryResult() {
    }


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
         * 创建\u83dc\u54c1\u4f1a\u5458\u4ef7\u4fe1\u606f\u3002\u5fc5\u586b\u3002的空实例。
         */
        public MemberSku() {
        }


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
