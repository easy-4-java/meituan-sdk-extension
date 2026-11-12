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
     * 创建\u54c1\u724c\u5904\u7406\u7f8e\u56e2\u4f1a\u5458\u7b49\u7ea7\u53d8\u66f4\u540e\u5199\u5165\u54cd\u5e94 data \u7684\u4e1a\u52a1\u7ed3\u679c\u3002的空实例。
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
         * 创建\u54c1\u724c\u4fa7\u5b9e\u9645\u751f\u6548\u7684\u4f1a\u5458\u7b49\u7ea7\u4e0e\u6709\u6548\u671f\u3002的空实例。
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
