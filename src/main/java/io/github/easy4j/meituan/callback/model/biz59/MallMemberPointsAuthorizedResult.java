package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「商场会员无感积分授权通知」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_6c3b3f8e-f092-4815-8c75-ae427ab1b34c">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MallMemberPointsAuthorizedResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u5546\u573a\u4f1a\u5458\u65e0\u611f\u79ef\u5206\u6388\u6743\u901a\u77e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public MallMemberPointsAuthorizedResult() {
    }


    /**
     * 会员积分总数。支持小数(按double解析)。必填。
     */
    @JsonProperty("points")
    private String points;
}
