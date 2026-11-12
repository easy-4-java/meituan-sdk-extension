package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import io.github.easy4j.meituan.callback.EmbeddedJsonDeserializer;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * 美团「查询三方可用手艺人」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910033}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_0b4bf40c-5993-4897-a086-ff6cba0ed5cd">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AvailableTechnicianQueriedMessage {

    /**
     * 创建美团「查询三方可用手艺人」回调的业务内容。的空实例。
     */
    public AvailableTechnicianQueriedMessage() {
    }


    /**
     * 门店 ID。必填。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;

    /**
     * 库存查询开始日期，例如2023-05-01。必填。
     */
    @JsonProperty("startDay")
    private String startDay;

    /**
     * 库存查询结束日期，例如2023-05-01。
     */
    @JsonProperty("endDay")
    private String endDay;

    /**
     * 库存查询开始日期，例如2023-05-01 01:00:00。必填。
     */
    @JsonProperty("startTime")
    private String startTime;

    /**
     * 库存查询结束日期，例如2023-05-01 02:00:00。
     */
    @JsonProperty("endTime")
    private String endTime;

    /**
     * 项目名称。必填。
     */
    @JsonProperty("projectName")
    private String projectName;

    /**
     * 项目类型 1.自定义商品 2. 团购商品。
     */
    @JsonProperty("projectType")
    private String projectType;

    /**
     * 项目code（非必填项，为空的情况下即仅返回门店库存）。
     */
    @JsonProperty("projectCode")
    private String projectCode;

    /**
     * 项目、门店可管理的手艺人列表list。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("techIdList")
    private List<String> techIdList;

    /**
     * 扩展字段，Map类型。
     */
    @JsonDeserialize(using = EmbeddedJsonDeserializer.class)
    @JsonProperty("extraMap")
    private JsonNode extraMap;
}
