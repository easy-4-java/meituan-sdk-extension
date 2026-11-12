package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.easy4j.meituan.callback.CallbackPayload;

/**
 * 美团「查询三方房间信息」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810019}。</p>
 * 官网的请求示例为 {@code {}}，未定义业务字段。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_154a5f56-e436-4aff-a124-5651bd1dc590">官网消息文档</a>
 */
@CallbackPayload
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomInformationQueryMessage {

    /**
     * 创建美团「查询三方房间信息」回调的业务内容。的空实例。
     */
    public RoomInformationQueryMessage() {
    }

}
