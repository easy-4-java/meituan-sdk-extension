package io.github.easy4j.meituan.callback.model.biz18;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「会员搜索」回调的业务响应。
 *
 * <p>收银端响应示例将本对象置于 {@code data}，外层 {@code message} 为 {@code ok}。</p>
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_rms_f4c3c8ac-0457-48e4-993e-bed7df3dc8ba">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberSearchResult {

    /**
     * 创建美团「会员搜索」回调的业务响应。的空实例。
     */
    public MemberSearchResult() {
    }


    /**
     * 会员搜索结果。
     */
    @JsonProperty("cards")
    private List<Card> cards;

    /**
     * 会员搜索结果。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Card {

        /**
         * 创建会员搜索结果。的空实例。
         */
        public Card() {
        }


        /**
         * 会员头像。
         */
        @JsonProperty("avatar")
        private String avatar;

        /**
         * 用户id。必填。
         */
        @JsonProperty("memberId")
        private String memberId;

        /**
         * 会员卡id。必填。
         */
        @JsonProperty("cardId")
        private String cardId;

        /**
         * 会员姓名，默认 ""。必填。
         */
        @JsonProperty("memberName")
        private String memberName;

        /**
         * 卡等级名称，如：黄金VIP。
         */
        @JsonProperty("levelName")
        private String levelName;

        /**
         * 卡等级id。
         */
        @JsonProperty("levelId")
        private String levelId;

        /**
         * 手机号（密文），如：13012345678，默认 ""。必填。
         */
        @JsonProperty("mobile")
        private String mobile;

        /**
         * 卡号，如：123234123123123。
         */
        @JsonProperty("cardNo")
        private String cardNo;

        /**
         * 充值账户（分），默认0。必填。
         */
        @JsonProperty("mainBalance")
        private Long mainBalance;

        /**
         * 储值赠送帐户（分），默认0。必填。
         */
        @JsonProperty("giftBalance")
        private Long giftBalance;

        /**
         * 储值账户（分），充值帐户+储值账户。必填。
         */
        @JsonProperty("balance")
        private Long balance;

        /**
         * 积分数量，默认0。必填。
         */
        @JsonProperty("pointNum")
        private Long pointNum;
    }
}
