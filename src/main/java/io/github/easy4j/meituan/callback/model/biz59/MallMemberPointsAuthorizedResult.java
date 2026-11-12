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
     * 会员积分总数。支持小数(按double解析)。必填。
     */
    @JsonProperty("points")
    private String points;


    /**
     * 创建美团「商场会员无感积分授权通知」回调的业务响应。的空实例。
     */
    public MallMemberPointsAuthorizedResult() {
    }
}
