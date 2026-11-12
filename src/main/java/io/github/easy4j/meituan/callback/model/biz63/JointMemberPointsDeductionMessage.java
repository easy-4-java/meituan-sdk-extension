package io.github.easy4j.meituan.callback.model.biz63;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「联合会员-会员积分扣减」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=63}，消息类型为 {@code msgType=6310004}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_mtcdb_9b6c10c2-1f14-4466-afc7-f1211d4fcd53">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class JointMemberPointsDeductionMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u8054\u5408\u4f1a\u5458-\u4f1a\u5458\u79ef\u5206\u6263\u51cf\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public JointMemberPointsDeductionMessage() {
    }


    /**
     * 手机号。必填。
     */
    @JsonProperty("mobile")
    private String mobile;

    /**
     * 商场或者门店标识。
     */
    @JsonProperty("poiId")
    private String poiId;

    /**
     * 业务流水号。必填。
     */
    @JsonProperty("bizNo")
    private String bizNo;

    /**
     * 抵扣积分。必填。
     */
    @JsonProperty("deductNum")
    private Integer deductNum;
}
