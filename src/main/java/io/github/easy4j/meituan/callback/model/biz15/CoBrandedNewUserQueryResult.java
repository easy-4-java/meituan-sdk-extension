package io.github.easy4j.meituan.callback.model.biz15;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「会员联名卡查询新客」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_jmcard_64a5fe93-48f2-49ca-86fe-f2a6a19cd172">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoBrandedNewUserQueryResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u4f1a\u5458\u8054\u540d\u5361\u67e5\u8be2\u65b0\u5ba2\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public CoBrandedNewUserQueryResult() {
    }


    /**
     * 是否为品牌会员卡的纯新会员。是否品牌纯新会员 如果该手机号已经是品牌会员，则返回false。 如果该手机号从未在任何渠道注册过品牌会员，则返回true。必填。
     */
    @JsonProperty("isPureNewUser")
    private Boolean isPureNewUser;
}
