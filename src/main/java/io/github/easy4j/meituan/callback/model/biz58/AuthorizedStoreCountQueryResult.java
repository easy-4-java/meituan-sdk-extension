package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询三方开发者货架插件授权门店数量」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_d17b551c-683e-4f94-a3ed-9e0c8dd09141">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorizedStoreCountQueryResult {

    /**
     * 插件授权门店数量。必填。
     */
    @JsonProperty("pluginAuthShopCount")
    private Integer pluginAuthShopCount;
}
