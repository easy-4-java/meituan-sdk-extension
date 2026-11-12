package io.github.easy4j.meituan.callback.model.biz58;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
     * 项目列表，不存在映射关系时返回空列表。
     */
    @JsonProperty("projectInfos")
    private List<ProjectInfo> projectInfos;


    /**
     * 创建美团「团购三方项目Id关联关系查询」回调的业务响应。的空实例。
     */
    public GroupDealProjectMappingQueryResult() {
    }

    /**
     * 项目列表，不存在映射关系时返回空列表。
     */
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ProjectInfo {

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

        /**
         * 创建项目列表，不存在映射关系时返回空列表。的空实例。
         */
        public ProjectInfo() {
        }
    }
}
