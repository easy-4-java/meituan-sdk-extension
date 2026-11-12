package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「商场会员无感积分授权通知」回调的业务内容。
 *
 * <p>业务标识为 {@code businessId=59}，消息类型为 {@code msgType=5910099}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_6c3b3f8e-f092-4815-8c75-ae427ab1b34c">官网消息文档</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MallMemberPointsAuthorizedMessage {

    /**
     * 创建\u7f8e\u56e2\u300c\u5546\u573a\u4f1a\u5458\u65e0\u611f\u79ef\u5206\u6388\u6743\u901a\u77e5\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u5185\u5bb9\u3002的空实例。
     */
    public MallMemberPointsAuthorizedMessage() {
    }


    /**
     * 混淆后平台用户 ID。必填。
     */
    @JsonProperty("opUserId")
    private String opUserId;

    /**
     * 三方会员卡号 ID。必填。
     */
    @JsonProperty("memberCard")
    private String memberCard;

    /**
     * 所属平台，美团：MT 点评：DP。必填。
     */
    @JsonProperty("source")
    private String source;

    /**
     * 会员卡方案适用美团门店 ID(混淆)。必填。
     */
    @JsonProperty("opPoiId")
    private String opPoiId;

    /**
     * 会员卡方案适用门店三方编码。
     */
    @JsonProperty("planShopExternalCode")
    private String planShopExternalCode;
}
