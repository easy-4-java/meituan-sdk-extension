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
     * 创建\u7f8e\u56e2\u300c\u67e5\u8be2\u4e09\u65b9\u623f\u95f4\u4fe1\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
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
