package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.easy4j.meituan.callback.CallbackPayload;

/**
 * 美团「查询会员积分规则」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=18}，消息类型为 {@code msgType=1810077}。</p>
 * 官网的请求示例为 {@code {}}，未定义业务字段。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_92875d44-c27e-4c62-97d6-43b50372eb35">官网消息文档</a>
 */
@CallbackPayload
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberPointsRulesQueryMessage {
}
