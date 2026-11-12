package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 美团「门店消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=18202}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_2eca15d6-1329-457f-80cd-60f9f89aaa75">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreInformationMessage {

    /**
     * 门店的组织机构 ID。
     */
    @JsonProperty("orgId")
    private Integer orgId;
    /**
     * 门店归属的品牌 ID。
     */
    @JsonProperty("brandId")
    private Integer brandId;
    /**
     * 门店名称。
     */
    @JsonProperty("poiName")
    private String poiName;
    /**
     * 修改时间。
     */
    @JsonProperty("modifyTime")
    private JsonNode modifyTime;
    /**
     * 门店状态,状态标识:0-正常，10-冻结中，11-已冻结，20-注销"。
     */
    @JsonProperty("poiStatus")
    private Integer poiStatus;
    /**
     * 营业状态1启用，2停用.营业状态:0-正常，1-暂停营业。
     */
    @JsonProperty("openStatus")
    private Integer openStatus;
    /**
     * 删除标识,0 未删除。其他，已删除。
     */
    @JsonProperty("deleted")
    private Integer deleted;
    /**
     * 美团品类结构。
     */
    @JsonProperty("cateHierarchy")
    private List<JsonNode> cateHierarchy;

    /**
     * 创建美团「门店消息」回调的业务内容。的空实例。
     */
    public StoreInformationMessage() {
    }
}
