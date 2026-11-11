package io.github.easy4j.meituan.callback.business59.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「查询库存」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910007}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_b0a7f77b-2480-431d-9bf2-0d1321e6d993">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryQueriedMessage {

    /**
     * 美团门店 ID，该字段是混淆字段，实际值类型为混淆后的字符串类型。必填。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;

    /**
     * 预约单 ID。
     */
    @JsonProperty("leadsId")
    private String leadsId;

    /**
     * 项目类型 1.团购 3.标品。
     */
    @JsonProperty("projectType")
    private String projectType;

    /**
     * 项目code（非必填项，为空的情况下即仅返回门店库存）。
     */
    @JsonProperty("projectCode")
    private String projectCode;

    /**
     * 库存查询开始日期，例如2023-05-01。必填。
     */
    @JsonProperty("startDate")
    private String startDate;

    /**
     * 库存查询结束日期，例如2023-05-01。必填。
     */
    @JsonProperty("endDate")
    private String endDate;

    /**
     * 库存间隔（单位为5分钟的整数倍） 体检业务：无需传该字段 丽人业务： 如果是间隔30分钟就传30，传5的整数倍即可。
     */
    @JsonProperty("timeSlot")
    private String timeSlot;

    /**
     * 扩展字段(json 字符串)。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("extraMap")
    private JsonNode extraMap;
}
