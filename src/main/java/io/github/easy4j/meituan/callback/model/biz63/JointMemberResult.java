package io.github.easy4j.meituan.callback.model.biz63;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 联合会员查询和注册返回的会员信息。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_mtcdb_1e66e50a-4f85-4a2b-a039-4ed6c1152723">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JointMemberResult {

    /**
     * 手机号。必填。
     */
    @JsonProperty("mobile")
    private String mobile;
    /**
     * 会员等级。必填。
     */
    @JsonProperty("level")
    private Integer level;
    /**
     * 积分。必填。
     */
    @JsonProperty("credit")
    private Integer credit;
    /**
     * 用户标识。必填。
     */
    @JsonProperty("userId")
    private String userId;
    /**
     * 商场或者门店标识。
     */
    @JsonProperty("poiId")
    private String poiId;

    /**
     * 创建联合会员查询和注册返回的会员信息。的空实例。
     */
    public JointMemberResult() {
    }
}
