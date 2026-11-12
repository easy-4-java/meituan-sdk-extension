package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「单个查询库存」回调的业务响应。
 *
 * <p>业务数据为数组，本类型表示其中一个元素。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_952bd534-0b45-4cae-90b7-ba7790e7b978">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryQueryResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u5355\u4e2a\u67e5\u8be2\u5e93\u5b58\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public InventoryQueryResult() {
    }


    /**
     * 预订服务项目id。必填。
     */
    @JsonProperty("appProductName")
    private String appProductName;

    /**
     * 美团侧服务项目id，适用于使用美团侧服务项目id通信的业务。
     */
    @JsonProperty("productId")
    private String productId;

    /**
     * 预订服务名称。
     */
    @JsonProperty("productName")
    private String productName;

    /**
     * 剩余库存数，可返回实际可用库存数，&gt;0代表可下单。必填。
     */
    @JsonProperty("remainCount")
    private Integer remainCount;
}
