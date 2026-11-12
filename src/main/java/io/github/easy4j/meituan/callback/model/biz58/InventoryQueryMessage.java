package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「单个查询库存」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810021}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_952bd534-0b45-4cae-90b7-ba7790e7b978">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryQueryMessage {

    /**
     * 创建美团「单个查询库存」回调的业务内容。的空实例。
     */
    public InventoryQueryMessage() {
    }


    /**
     * 三方商户 ID。
     */
    @JsonProperty("appShopId")
    private String appShopId;

    /**
     * 三方的服务项目，未填写则拉取全部可用的第三方产品 ID，当填写时则拉取该服务项目 ID 的库存。
     */
    @JsonProperty("appProductId")
    private String appProductId;

    /**
     * 项目名称；
     */
    @JsonProperty("appProductName")
    private String appProductName;

    /**
     * 格式如 2016-05-24 12:00 ，数据精确到分钟，只支持整点和半点。必填。
     */
    @JsonProperty("beginTime")
    private String beginTime;

    /**
     * 预订的分钟数，一般半小时起定。 如果不填，表示不在意预订时长。必填。
     */
    @JsonProperty("duration")
    private Integer duration;

    /**
     * 美团侧服务项目 ID，适用于适用美团侧服务项目 ID 通信的业务。
     */
    @JsonProperty("productId")
    private Long productId;
}
