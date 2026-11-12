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
     * 创建\u7f8e\u56e2\u300c\u67e5\u8be2\u4e09\u65b9\u623f\u95f4\u4fe1\u606f\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public RoomInformationQueryMessage() {
    }

}
