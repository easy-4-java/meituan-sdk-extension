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

    /**
     * 创建\u7f8e\u56e2\u300c\u67e5\u8be2\u4e09\u65b9\u5f00\u53d1\u8005\u8d27\u67b6\u63d2\u4ef6\u6388\u6743\u95e8\u5e97\u6570\u91cf\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public AuthorizedStoreCountQueryMessage() {
    }

}
