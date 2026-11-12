package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

/**
 * 美团「组织结构消息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=18203}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_f8275f64-fed3-4c86-b7ba-f632933683d9">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationStructureMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u7ec4\u7ec7\u7ed3\u6784\u6d88\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public OrganizationStructureMessage() {
    }


    /**
     * 组织机构 ID。
     */
    @JsonProperty("orgId")
    private Integer orgId;

    /**
     * 组织机构编码。
     */
    @JsonProperty("orgCode")
    private String orgCode;

    /**
     * 组织机构名称。
     */
    @JsonProperty("orgName")
    private String orgName;

    /**
     * 上级组织机构 ID。
     */
    @JsonProperty("parentId")
    private Integer parentId;

    /**
     * 总部orgId。
     */
    @JsonProperty("rootOrgId")
    private Integer rootOrgId;

    /**
     * 修改时间。
     */
    @JsonProperty("modifyTime")
    private JsonNode modifyTime;

    /**
     * org状态。
     */
    @JsonProperty("orgStatus")
    private Integer orgStatus;

    /**
     * 删除标识。
     */
    @JsonProperty("deleted")
    private Integer deleted;
}
