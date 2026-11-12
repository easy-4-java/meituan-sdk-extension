package io.github.easy4j.meituan.callback.model.biz59;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询活动场次参与人接口」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzhkh_a7fabe92-48c6-4922-9575-f947a6d5e9dc">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClubActivityParticipantsQueriedResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u67e5\u8be2\u6d3b\u52a8\u573a\u6b21\u53c2\u4e0e\u4eba\u63a5\u53e3\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public ClubActivityParticipantsQueriedResult() {
    }


    /**
     * 参与人对象。参与人信息对象。必填。
     */
    @JsonProperty("result")
    private ParticipantObj result;

    /**
     * 参与人对象。参与人信息对象。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ParticipantObj {

        /**
         * 创建\u53c2\u4e0e\u4eba\u5bf9\u8c61\u3002\u53c2\u4e0e\u4eba\u4fe1\u606f\u5bf9\u8c61\u3002\u5fc5\u586b\u3002的空实例。
         */
        public ParticipantObj() {
        }


        /**
         * 参与人信息列表。必填。
         */
        @JsonProperty("participants")
        private List<Participant> participants;
    }

    /**
     * 参与人信息列表。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Participant {

        /**
         * 创建\u53c2\u4e0e\u4eba\u4fe1\u606f\u5217\u8868\u3002\u5fc5\u586b\u3002的空实例。
         */
        public Participant() {
        }


        /**
         * 用户id。必填。
         */
        @JsonProperty("id")
        private String id;

        /**
         * 用户头像。用户头像url。
         */
        @JsonProperty("avatar")
        private String avatar;

        /**
         * 用户昵称。必填。
         */
        @JsonProperty("nickName")
        private String nickName;

        /**
         * 用户等级。
         */
        @JsonProperty("userLevel")
        private String userLevel;

        /**
         * 用户性别。必填。
         */
        @JsonProperty("gender")
        private String gender;

        /**
         * 同行用户无其他用户信息。同行用户无其他用户信息，true-是，false-不是。
         */
        @JsonProperty("isPartner")
        private Boolean isPartner;

        /**
         * 同行人所跟随的主用户id。
         */
        @JsonProperty("followUserId")
        private String followUserId;
    }
}
