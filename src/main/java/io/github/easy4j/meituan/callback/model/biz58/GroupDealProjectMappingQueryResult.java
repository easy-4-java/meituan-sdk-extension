package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 美团「团购三方项目Id关联关系查询」回调的业务响应。
 *
 * @see <a href="https://developer.meituan.com/docs/msg/msg_ddzh_387e2d53-3f92-44b6-8236-ec795952b954">官网消息文档</a>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupDealProjectMappingQueryResult {

    /**
     * 创建\u7f8e\u56e2\u300c\u56e2\u8d2d\u4e09\u65b9\u9879\u76eeId\u5173\u8054\u5173\u7cfb\u67e5\u8be2\u300d\u56de\u8c03\u7684\u4e1a\u52a1\u54cd\u5e94\u3002的空实例。
     */
    public GroupDealProjectMappingQueryResult() {
    }


    /**
     * 项目列表，不存在映射关系时返回空列表。
     */
    @JsonProperty("projectInfos")
    private List<ProjectInfo> projectInfos;

    /**
     * 项目列表，不存在映射关系时返回空列表。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ProjectInfo {

        /**
         * 创建\u9879\u76ee\u5217\u8868\uff0c\u4e0d\u5b58\u5728\u6620\u5c04\u5173\u7cfb\u65f6\u8fd4\u56de\u7a7a\u5217\u8868\u3002的空实例。
         */
        public ProjectInfo() {
        }


        /**
         * 美团团购项目Id，与请求参数中的团购Id对应。必填。
         */
        @JsonProperty("mtDealGroupId")
        private Long mtDealGroupId;

        /**
         * 该团购关联的三方项目Id列表，当前只支持一个美团团购项目关联一个三方项目，因此该列表有且只能有一个元素。必填。
         */
        @JsonProperty("saasProjectIds")
        private List<String> saasProjectIds;
    }
}
