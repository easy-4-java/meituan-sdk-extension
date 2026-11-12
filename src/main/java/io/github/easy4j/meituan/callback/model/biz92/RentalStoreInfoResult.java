package io.github.easy4j.meituan.callback.model.biz92;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「报价详情查询」回调的业务数据（StoreInfo）。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rental_165ca498-a7a7-49bf-9985-fdf0fee76891">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalStoreInfoResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u62a5\u4ef7\u8be6\u60c5\u67e5\u8be2\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u6570\u636e\uff08StoreInfo\uff09\u3002的空实例。
     */
    public RentalStoreInfoResult() {
    }


    /**
     * 商家评分。必填。
     */
    @JsonProperty("score")
    private String score;

    /**
     * 所属车商名称：如开心车行。必填。
     */
    @JsonProperty("supplierName")
    private String supplierName;

    /**
     * 预授权信息。必填。
     */
    @JsonProperty("preAuth")
    private RentalPreAuthResult preAuth;

    /**
     * 门店分层标签，详情看分层标签枚举 StoreLevelTag。必填。
     */
    @JsonProperty("levelTags")
    private List<String> levelTags;
}
