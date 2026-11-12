package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 智能版会员券、储值和积分核销或冲正的布尔结果。
 *
 * <p>收银端响应示例将本对象置于 {@code data}，外层 {@code message} 为 {@code ok}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_321e560e-f4c9-441f-8d56-ac3e391d87c2">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberOperationResult {

    /**
     * 创建\u667a\u80fd\u7248\u4f1a\u5458\u5238\u3001\u50a8\u503c\u548c\u79ef\u5206\u6838\u9500\u6216\u51b2\u6b63\u7684\u5e03\u5c14\u7ed3\u679c\u3002的空实例。
     */
    public MemberOperationResult() {
    }


    /**
     * 业务处理结果，成功为 true。
     */
    @JsonProperty("result")
    private Boolean result;
}
