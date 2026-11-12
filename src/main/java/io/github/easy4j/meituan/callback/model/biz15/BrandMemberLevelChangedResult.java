package io.github.easy4j.meituan.callback.model.biz15;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 品牌处理美团会员等级变更后写入响应 data 的业务结果。
 *
 * @see <a href="https://developer.meituan.com/docs/biz/biz_jmcard_a37bb777-fedf-4732-b897-96d11a235d59">美团会员等级变化通知</a>
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrandMemberLevelChangedResult {

    /**
     * 创建品牌处理美团会员等级变更后写入响应 data 的业务结果。的空实例。
     */
    public BrandMemberLevelChangedResult() {
    }


    /**
     * 品牌等级调整结果码。200 表示业务成功，其他值表示品牌侧业务失败。必填。
     */
    @JsonProperty("resultCode")
    private Integer resultCode;

    /**
     * 业务处理失败时的原因，可省略。
     */
    @JsonProperty("errMsg")
    private String errMsg;

    /**
     * 品牌方会员 ID。必填。
     */
    @JsonProperty("brandMemberId")
    private String brandMemberId;

    /**
     * 调整后实际生效的品牌会员等级。必填。
     */
    @JsonProperty("brandLevel")
    private ActualLevel brandLevel;

    /**
     * 品牌侧实际生效的会员等级与有效期。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ActualLevel {

        /**
         * 创建品牌侧实际生效的会员等级与有效期。的空实例。
         */
        public ActualLevel() {
        }


        /**
         * 品牌会员实际等级。必填。
         */
        @JsonProperty("brandLevel")
        private String brandLevel;

        /**
         * 等级开始时间，Unix 秒，可省略。
         */
        @JsonProperty("levelBeginTime")
        private Long levelBeginTime;

        /**
         * 等级结束时间，Unix 秒；长期有效时省略。
         */
        @JsonProperty("levelEndTime")
        private Long levelEndTime;
    }
}
