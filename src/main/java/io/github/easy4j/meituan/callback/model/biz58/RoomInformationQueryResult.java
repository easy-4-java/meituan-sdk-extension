package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询三方房间信息」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_154a5f56-e436-4aff-a124-5651bd1dc590">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomInformationQueryResult {

    /**
     * 创建美团「查询三方房间信息」回调的业务响应。的空实例。
     */
    public RoomInformationQueryResult() {
    }


    /**
     * 房间ID。必填。
     */
    @JsonProperty("roomId")
    private String roomId;

    /**
     * 房间名称。必填。
     */
    @JsonProperty("roomName")
    private String roomName;
}
