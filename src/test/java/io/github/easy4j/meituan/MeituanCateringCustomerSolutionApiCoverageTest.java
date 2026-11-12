package io.github.easy4j.meituan;

import com.meituan.sdk.MeituanRequest;
import com.meituan.sdk.annotations.ApiMeta;
import com.meituan.sdk.model.solution2.csaccount.dcSrcollQueryTradeProfitDetail.DcSrcollQueryTradeProfitDetailRequest;
import com.meituan.sdk.model.solution2.csaccount.dcSrcollQueryTradeProfitDetailForOppoiid.DcSrcollQueryTradeProfitDetailForOppoiidRequest;
import com.meituan.sdk.model.solution2.dcpoidinfo.dcPageQueryTokenPoiList.DcPageQueryTokenPoiListRequest;
import com.meituan.sdk.model.solution2.mtcompany.wechatOrderSqtInfoBatchQuery.WechatOrderSqtInfoBatchQueryRequest;
import com.meituan.sdk.model.waimaiNg.im.getAutoSendConfigInfo.GetAutoSendConfigInfoRequest;
import com.meituan.sdk.model.waimaiNg.im.getPoiImStatus.GetPoiImStatusRequest;
import com.meituan.sdk.model.waimaiNg.im.msgRead.MsgReadRequest;
import com.meituan.sdk.model.waimaiNg.im.sendImMsgWaimai.SendImMsgWaimaiRequest;
import com.meituan.sdk.model.waimaiNg.im.setAutoSendConfigInfo.SetAutoSendConfigInfoRequest;
import com.meituan.sdk.model.waimaiNg.im.setPoiImStatus.SetPoiImStatusRequest;
import com.meituan.sdk.model.waimaiNg.im.waimaiImGetReadTime.WaimaiImGetReadTimeRequest;
import io.github.easy4j.meituan.callback.type.MeituanBusiness2MessageType;
import io.github.easy4j.meituan.service.MeituanStoreService;
import io.github.easy4j.meituan.service.MeituanWaimaiService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 餐饮客户解决方案清单的公开协议覆盖回归测试。
 */
class MeituanCateringCustomerSolutionApiCoverageTest {

    /**
     * 创建餐饮客户解决方案清单的公开协议覆盖回归测试。的空实例。
     */
    MeituanCateringCustomerSolutionApiCoverageTest() {
    }


    /**
     * 已有明确协议与门面映射的接口契约。
     */
    private static final List<ApiContract> COVERED_APIS = io.github.easy4j.meituan.TestCollections.listOf(
            api("游标查询交易结算流水", DcSrcollQueryTradeProfitDetailRequest.class,
                    MeituanStoreService.class, "/solution2/csaccount/scrollQueryTradeProfitDetail",
                    86, "10001", "dc_srcoll_query_trade_profit_detail", true),
            api("游标查询交易结算流水(服务商使用)", DcSrcollQueryTradeProfitDetailForOppoiidRequest.class,
                    MeituanStoreService.class, "/solution2/csaccount/scrollQueryTradeProfitDetailOpPoiId",
                    86, "10016", "dc_srcoll_query_trade_profit_detail_for_oppoiid", true),
            api("批量查询微信支付订单商企通信息", WechatOrderSqtInfoBatchQueryRequest.class,
                    MeituanStoreService.class, "/solution2/mtcompany/wechat/sqtInfo/batch/query",
                    86, "10002", "wechat_order_sqt_info_batch_query", true),
            api("适用门店查询", DcPageQueryTokenPoiListRequest.class,
                    MeituanStoreService.class, "/solution2/dcpoidinfo/pageQueryPoiList",
                    86, "10002", "dc_page_query_token_poi_list", true),
            api("设置智能掌柜开关状态", SetAutoSendConfigInfoRequest.class,
                    MeituanWaimaiService.class, "/waimai/ng/im/autosend/setAutoSendConfigInfo",
                    2, "10051", "set_auto_send_config_info", true),
            api("设置消息已读", MsgReadRequest.class,
                    MeituanWaimaiService.class, "/waimai/ng/im/msgRead",
                    2, "10001", "msg_read", false),
            api("商家给C端用户发消息", SendImMsgWaimaiRequest.class,
                    MeituanWaimaiService.class, "/waimai/ng/im/msg/send",
                    2, "10055", "send_im_msg_waimai", true),
            api("查询智能掌柜开关状态", GetAutoSendConfigInfoRequest.class,
                    MeituanWaimaiService.class, "/waimai/ng/im/autosend/getAutoSendConfigInfo",
                    2, "10051", "get_auto_send_config_info", true),
            api("获取会话最新已读时间", WaimaiImGetReadTimeRequest.class,
                    MeituanWaimaiService.class, "/waimai/ng/im/userReadTime",
                    2, "10008", "waimai_im_get_read_time", true),
            api("设置门店IM开通状态", SetPoiImStatusRequest.class,
                    MeituanWaimaiService.class, "/waimai/ng/im/setPoiIMStatus",
                    2, "10001", "set_poi_im_status", false),
            api("查询门店IM开通状态", GetPoiImStatusRequest.class,
                    MeituanWaimaiService.class, "/waimai/ng/im/getPoiIMStatus",
                    2, "10004", "get_poi_im_status", false)
    );
    /**
     * 仍缺少可核实官方协议的能力名称。
     */
    private static final Set<String> UNRESOLVED_APIS = io.github.easy4j.meituan.TestCollections.setOf(
            "美团门店混淆",
            "设置会话下所有消息已读"
    );

    /**
     * 验证接口路径、版本、业务编号、授权要求和门面签名与官方契约一致。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldMatchEveryCoveredApiToItsExactOfficialSdkContractAndFacade() throws Exception {
        assertThat(COVERED_APIS).hasSize(11);
        assertThat(COVERED_APIS).allSatisfy(contract -> {
            ApiMeta apiMeta = contract.requestType().getAnnotation(ApiMeta.class);
            assertThat(apiMeta.path()).as(contract.name()).isEqualTo(contract.path());
            assertThat(apiMeta.businessId()).as(contract.name()).isEqualTo(contract.businessId());
            assertThat(apiMeta.apiVersion()).as(contract.name()).isEqualTo(contract.apiVersion());
            assertThat(apiMeta.apiName()).as(contract.name()).isEqualTo(contract.apiName());
            assertThat(apiMeta.needAuth()).as(contract.name()).isEqualTo(contract.needAuth());
            assertFacadeMethodExists(contract);
        });
    }

    /**
     * 验证客户解决方案清单中的已覆盖接口、消息和待核实能力数量。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldKeepTheFourteenChecklistCapabilitiesPartitionedWithoutOverclaimingCoverage() throws Exception {
        assertThat(UNRESOLVED_APIS).containsExactlyInAnyOrder(
                "美团门店混淆",
                "设置会话下所有消息已读"
        );
        assertThat(MeituanBusiness2MessageType.fromMsgType("210069"))
                .contains(MeituanBusiness2MessageType.TWO_PARTY_IM_MESSAGE);
        int documentedCustomerSolutionMessages = 1;
        assertThat(COVERED_APIS.size() + UNRESOLVED_APIS.size()
                + documentedCustomerSolutionMessages).isEqualTo(14);
        assertThat(COVERED_APIS.size() + documentedCustomerSolutionMessages).isEqualTo(12);
    }

    /**
     * 检查官方请求是否具有对应的业务门面方法。
     *
     * @param contract 用于核对请求与门面的官方接口契约
     */
    private void assertFacadeMethodExists(ApiContract contract) {
        assertThat(io.github.easy4j.meituan.TestCollections.listOf(contract.facadeType().getDeclaredMethods()))
                .as("facade method for %s", contract.path())
                .anySatisfy(method -> assertMethodSignature(method, contract.requestType()));
    }

    /**
     * 核对门面方法的请求类型和租户参数。
     *
     * @param method 待核对的门面方法
     * @param requestType 官方请求类型
     */
    private void assertMethodSignature(Method method, Class<?> requestType) {
        assertThat(method.getParameterTypes()).hasSize(2);
        assertThat(method.getParameterTypes()[0]).isEqualTo(requestType);
        assertThat(method.getParameterTypes()[1]).isEqualTo(String.class);
    }

    /**
     * 构造用于检查官方元数据与门面签名的接口契约。
     *
     * @param name 官网接口名称
     * @param requestType 官方请求类型
     * @param facadeType 暴露该接口的业务门面类型
     * @param path 官方接口路径
     * @param businessId 官方业务编号
     * @param apiVersion 官方接口版本
     * @param apiName 官方接口标识
     * @param needAuth 官方接口是否要求授权 token
     * @return 构造用于检查官方元数据与门面签名的接口契约的结果
     */
    private static ApiContract api(String name, Class<? extends MeituanRequest<?>> requestType, Class<?> facadeType, String path, int businessId, String apiVersion, String apiName, boolean needAuth) {
        return new ApiContract(
                name, requestType, facadeType, path, businessId, apiVersion, apiName, needAuth
        );
    }

    /**
     * 保存待核对的官方接口契约。
     */
    private static final class ApiContract {
        /**
         * 官网接口名称。
         */
        private final String name;
        /**
         * 官方请求类型。
         */
        private final Class<? extends MeituanRequest<?>> requestType;
        /**
         * 暴露该接口的业务门面类型。
         */
        private final Class<?> facadeType;
        /**
         * 官方接口路径。
         */
        private final String path;
        /**
         * 官方业务编号。
         */
        private final int businessId;
        /**
         * 官方接口版本。
         */
        private final String apiVersion;
        /**
         * 官方接口标识。
         */
        private final String apiName;
        /**
         * 官方接口是否要求授权 token。
         */
        private final boolean needAuth;

        /**
         * 保存用于核对官方接口元数据和门面签名的契约。
         *
         * @param name 官网接口名称
         * @param requestType 官方请求类型
         * @param facadeType 暴露该接口的业务门面类型
         * @param path 官方接口路径
         * @param businessId 官方业务编号
         * @param apiVersion 官方接口版本
         * @param apiName 官方接口标识
         * @param needAuth 官方接口是否要求授权 token
         */
        private ApiContract(String name, Class<? extends MeituanRequest<?>> requestType, Class<?> facadeType, String path, int businessId, String apiVersion, String apiName, boolean needAuth) {
            this.name = name;
            this.requestType = requestType;
            this.facadeType = facadeType;
            this.path = path;
            this.businessId = businessId;
            this.apiVersion = apiVersion;
            this.apiName = apiName;
            this.needAuth = needAuth;
        }

        /**
         * 读取官网接口名称。
         *
         * @return 读取官网接口名称的结果
         */
        private String name() {
            return name;
        }

        /**
         * 读取官方请求类型。
         *
         * @return 读取官方请求类型的结果
         */
        private Class<? extends MeituanRequest<?>> requestType() {
            return requestType;
        }

        /**
         * 读取暴露该接口的业务门面类型。
         *
         * @return 读取暴露该接口的业务门面类型的结果
         */
        private Class<?> facadeType() {
            return facadeType;
        }

        /**
         * 读取官方接口路径。
         *
         * @return 读取官方接口路径的结果
         */
        private String path() {
            return path;
        }

        /**
         * 读取标准字段或下划线字段中的业务编号。
         *
         * @return 读取标准字段或下划线字段中的业务编号的结果
         */
        private int businessId() {
            return businessId;
        }

        /**
         * 读取官方接口版本。
         *
         * @return 读取官方接口版本的结果
         */
        private String apiVersion() {
            return apiVersion;
        }

        /**
         * 读取官方接口标识。
         *
         * @return 读取官方接口标识的结果
         */
        private String apiName() {
            return apiName;
        }

        /**
         * 读取官方接口是否要求授权 token。
         *
         * @return 读取官方接口是否要求授权 token的结果
         */
        private boolean needAuth() {
            return needAuth;
        }
    }
}
