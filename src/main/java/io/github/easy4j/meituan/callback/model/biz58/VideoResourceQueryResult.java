package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「查询视频资源」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_8ea56270-db80-4f0f-9e8c-60293f6e554d">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoResourceQueryResult {

    /**
     * 创建美团「查询视频资源」回调的业务响应。的空实例。
     */
    public VideoResourceQueryResult() {
    }


    /**
     * 视频资源列表。必填。
     */
    @JsonProperty("data")
    private List<PoiShowVideoBO> data;

    /**
     * 视频资源列表。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PoiShowVideoBO {

        /**
         * 创建视频资源列表。必填。的空实例。
         */
        public PoiShowVideoBO() {
        }


        /**
         * 美团门店id（混淆）。必填。
         */
        @JsonProperty("opPoiId")
        private String opPoiId;

        /**
         * 门店地址。必填。
         */
        @JsonProperty("address")
        private String address;

        /**
         * 开台时间，毫秒级时间戳。必填。
         */
        @JsonProperty("startTime")
        private Long startTime;

        /**
         * 精彩视频列表。必填。
         */
        @JsonProperty("showVideos")
        private List<ShowVideoBO> showVideos;
    }

    /**
     * 精彩视频列表。必填。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ShowVideoBO {

        /**
         * 创建精彩视频列表。必填。的空实例。
         */
        public ShowVideoBO() {
        }


        /**
         * 视频id。必填。
         */
        @JsonProperty("id")
        private Long id;

        /**
         * 时长，单位：秒。必填。
         */
        @JsonProperty("duration")
        private Long duration;

        /**
         * 视频流地址。必填。
         */
        @JsonProperty("streamUrl")
        private String streamUrl;
    }
}
