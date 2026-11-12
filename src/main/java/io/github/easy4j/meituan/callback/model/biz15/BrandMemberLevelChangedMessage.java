package io.github.easy4j.meituan.callback.model.biz15;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.easy4j.meituan.callback.CallbackPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团向品牌推送的联合会员等级变更事件（业务 15，消息 1510005）。
 *
 * @see <a href="https://developer.meituan.com/docs/biz/biz_jmcard_a37bb777-fedf-4732-b897-96d11a235d59">美团会员等级变化通知</a>
 */
@CallbackPayload
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandMemberLevelChangedMessage {

    /**
     * 等级变更事件 ID，品牌可用作业务幂等键。必填。
     */
    @JsonProperty("eventId")
    private Long eventId;
    /**
     * 保级期结束后的管理方式。{@code CONTINUE_MT_LEVEL_MAPPING} 表示继续按美团等级映射，
     * {@code BRAND_SELF_MANAGED} 表示从权益到期次日起由品牌自主管理。必填。
     */
    @JsonProperty("postExpiryMode")
    private String postExpiryMode;
    /**
     * 变更前的美团等级及其品牌映射。必填。
     */
    @JsonProperty("beforeLevel")
    private MappedLevel beforeLevel;
    /**
     * 变更后的美团等级及其品牌映射。必填。
     */
    @JsonProperty("newLevel")
    private MappedLevel newLevel;
    /**
     * 等级变更方向，{@code UPGRADE} 为升级，{@code DOWNGRADE} 为降级。必填。
     */
    @JsonProperty("changeType")
    private String changeType;
    /**
     * 用户在所属平台的唯一标识，美团与大众点评的标识不同。必填。
     */
    @JsonProperty("userOpenId")
    private String userOpenId;
    /**
     * 用户所在平台，{@code MEI_TUAN} 或 {@code DIAN_PING}。必填。
     */
    @JsonProperty("platformType")
    private String platformType;
    /**
     * 美团识别到等级变化的时间，Unix 时间戳，单位为秒。可用于处理乱序事件。必填。
     */
    @JsonProperty("levelChangeTime")
    private Long levelChangeTime;

    /**
     * 创建美团向品牌推送的联合会员等级变更事件（业务 15，消息 1510005）。的空实例。
     */
    public BrandMemberLevelChangedMessage() {
    }

    /**
     * 美团会员等级与品牌等级的映射。
     */
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MappedLevel {

        /**
         * 美团会员等级，范围为 L1 至 L6，L6 最高。必填。
         */
        @JsonProperty("mtLevel")
        private String mtLevel;
        /**
         * 配置的品牌等级编码。没有映射时平台传空字符串。必填。
         */
        @JsonProperty("mappingBrandLevel")
        private String mappingBrandLevel;

        /**
         * 创建美团会员等级与品牌等级的映射。的空实例。
         */
        public MappedLevel() {
        }
    }
}
