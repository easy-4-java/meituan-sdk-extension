package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.easy4j.meituan.callback.CallbackPayload;

/**
 * 美团「查询三方开发者货架插件授权门店数量」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=58}，消息类型为 {@code msgType=5810157}。</p>
 * 官网的请求示例为 {@code {}}，未定义业务字段。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_d17b551c-683e-4f94-a3ed-9e0c8dd09141">官网消息文档</a>
 */
@CallbackPayload
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorizedStoreCountQueryMessage {
}
