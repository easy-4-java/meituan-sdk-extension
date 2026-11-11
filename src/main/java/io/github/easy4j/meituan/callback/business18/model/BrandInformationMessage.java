package io.github.easy4j.meituan.callback.business18.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

/**
 * 美团「品牌消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=18204}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_295d53bc-b641-4a08-97ab-ba461bc395f7">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandInformationMessage {

    /**
     * 品牌 ID。必填。
     */
    @JsonProperty("brandId")
    private Integer brandId;

    /**
     * 品牌名称。必填。
     */
    @JsonProperty("brandName")
    private String brandName;

    /**
     * 修改时间。必填。
     */
    @JsonProperty("modifyTime")
    private JsonNode modifyTime;

    /**
     * 状态。必填。
     */
    @JsonProperty("brandStatus")
    private Integer brandStatus;

    /**
     * 是否删除。必填。
     */
    @JsonProperty("deleted")
    private Integer deleted;
}
