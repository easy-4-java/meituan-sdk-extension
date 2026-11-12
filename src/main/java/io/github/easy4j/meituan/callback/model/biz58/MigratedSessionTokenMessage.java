package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「接收session迁移后的合作中心token」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810079}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_41c5e119-c6a5-4a74-83cf-7719a6f7ffed">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MigratedSessionTokenMessage {

    /**
     * 创建美团「接收session迁移后的合作中心token」回调的业务内容。的空实例。
     */
    public MigratedSessionTokenMessage() {
    }


    /**
     * token归属业务 ID。必填。
     */
    @JsonProperty("businessId")
    private Integer businessId;

    /**
     * 开发者 ID。必填。
     */
    @JsonProperty("developerId")
    private Integer developerId;

    /**
     * 合作中心token。必填。
     */
    @JsonProperty("accessToken")
    private String accessToken;

    /**
     * 用于刷新token的凭证。必填。
     */
    @JsonProperty("refreshToken")
    private String refreshToken;

    /**
     * 北极星session。必填。
     */
    @JsonProperty("session")
    private String session;

    /**
     * 授权资源。如果是门店维度，返回加密后的门店id；如果是客户维度，返回加密后的客户 ID。必填。
     */
    @JsonProperty("opBizCode")
    private String opBizCode;

    /**
     * token有效期，单位秒。必填。
     */
    @JsonProperty("expireIn")
    private Integer expireIn;

    /**
     * 授权scope。必填。
     */
    @JsonProperty("scope")
    private String scope;

    /**
     * 原北极星bid，服务零售(客户)的业务会收到推送。
     */
    @JsonProperty("bid")
    private String bid;

    /**
     * 原北极星门店 ID，服务零售的业务会收到推送。
     */
    @JsonProperty("openShopUuid")
    private String openShopUuid;
}
