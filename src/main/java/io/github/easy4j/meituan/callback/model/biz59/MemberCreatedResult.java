package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「创建会员」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_24aba593-6dfa-4391-9f10-84c3b2c7ea07">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberCreatedResult {

    /**
     * 是否新会员。true：新会员 false ： 老会员。必填。
     */
    @JsonProperty("newMember")
    private Boolean newMember;

    /**
     * 会员卡号。必填。
     */
    @JsonProperty("memberCard")
    private String memberCard;

    /**
     * 会员等级。互通的会员等级，三方与美团指定合作等级 传参时传对应等级1、2、3、4、5... 注意：最低等级是1 传参示例： 等级：普卡（传参：1） 等级：银卡（传参：2） 等级：金卡（传参：3）。必填。
     */
    @JsonProperty("memberLevel")
    private String memberLevel;

    /**
     * 过期时间。会员卡过期时间,时间戳（单位：毫秒）。必填。
     */
    @JsonProperty("expireDate")
    private Long expireDate;

    /**
     * 业务响应码。如果会员结果需要异步回传时，此参数必须传递12118-表示异步创建中，后续通过requestSeq回调传递本次会员结果。
     */
    @JsonProperty("businessCode")
    private Integer businessCode;

    /**
     * 会员名称。
     */
    @JsonProperty("memberName")
    private String memberName;
}
