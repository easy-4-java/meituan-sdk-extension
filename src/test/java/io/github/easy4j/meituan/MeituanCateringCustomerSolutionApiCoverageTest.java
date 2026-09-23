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
import io.github.easy4j.meituan.callback.business2.MeituanBusiness2MessageType;
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

    private static final List<ApiContract> COVERED_APIS = io.github.easy4j.meituan.TestCollections.listOf(
            api("游标查询交易结算流水", DcSrcollQueryTradeProfitDetailRequest.class,
                    MeituanStoreService.class, "/solution2/csaccount/scrollQueryTradeProfitDetail",
                    86, "10001", "dc_srcoll_query_trade_profit_detail", true),
            api("游标查询交易结算流水(服务商使用)", DcSrcollQueryTradeProfitDetailForOppoiidRequest.class,
                    MeituanStoreService.class, "/solution2/csaccount/scrollQueryTradeProfitDetailOpPoiId",
                    86, "10010", "dc_srcoll_query_trade_profit_detail_for_oppoiid", true),
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
    private static final Set<String> UNRESOLVED_APIS = io.github.easy4j.meituan.TestCollections.setOf(
            "美团门店混淆",
            "设置会话下所有消息已读"
    );

    @Test
    void shouldMatchEveryCoveredApiToItsExactOfficialSdkContractAndFacade() {
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

    @Test
    void shouldKeepTheFourteenChecklistCapabilitiesPartitionedWithoutOverclaimingCoverage() {
        assertThat(UNRESOLVED_APIS).containsExactlyInAnyOrder(
                "美团门店混淆",
                "设置会话下所有消息已读"
        );
        assertThat(MeituanBusiness2MessageType.values())
                .containsExactly(MeituanBusiness2MessageType.TWO_PARTY_IM_MESSAGE);
        assertThat(COVERED_APIS.size() + UNRESOLVED_APIS.size()
                + MeituanBusiness2MessageType.values().length).isEqualTo(14);
        assertThat(COVERED_APIS.size() + MeituanBusiness2MessageType.values().length).isEqualTo(12);
    }

    private void assertFacadeMethodExists(ApiContract contract) {
        assertThat(io.github.easy4j.meituan.TestCollections.listOf(contract.facadeType().getDeclaredMethods()))
                .as("facade method for %s", contract.path())
                .anySatisfy(method -> assertMethodSignature(method, contract.requestType()));
    }

    private void assertMethodSignature(Method method, Class<?> requestType) {
        assertThat(method.getParameterTypes()).hasSize(2);
        assertThat(method.getParameterTypes()[0]).isEqualTo(requestType);
        assertThat(method.getParameterTypes()[1]).isEqualTo(String.class);
    }

    private static ApiContract api(
            String name,
            Class<? extends MeituanRequest<?>> requestType,
            Class<?> facadeType,
            String path,
            int businessId,
            String apiVersion,
            String apiName,
            boolean needAuth) {
        return new ApiContract(
                name, requestType, facadeType, path, businessId, apiVersion, apiName, needAuth
        );
    }

    private static final class ApiContract {
        private final String name;
        private final Class<? extends MeituanRequest<?>> requestType;
        private final Class<?> facadeType;
        private final String path;
        private final int businessId;
        private final String apiVersion;
        private final String apiName;
        private final boolean needAuth;

        private ApiContract(String name, Class<? extends MeituanRequest<?>> requestType,
                            Class<?> facadeType, String path, int businessId, String apiVersion,
                            String apiName, boolean needAuth) {
            this.name = name;
            this.requestType = requestType;
            this.facadeType = facadeType;
            this.path = path;
            this.businessId = businessId;
            this.apiVersion = apiVersion;
            this.apiName = apiName;
            this.needAuth = needAuth;
        }

        private String name() {
            return name;
        }

        private Class<? extends MeituanRequest<?>> requestType() {
            return requestType;
        }

        private Class<?> facadeType() {
            return facadeType;
        }

        private String path() {
            return path;
        }

        private int businessId() {
            return businessId;
        }

        private String apiVersion() {
            return apiVersion;
        }

        private String apiName() {
            return apiName;
        }

        private boolean needAuth() {
            return needAuth;
        }
    }
}
