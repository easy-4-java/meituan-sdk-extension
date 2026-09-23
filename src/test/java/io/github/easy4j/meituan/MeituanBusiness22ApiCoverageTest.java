package io.github.easy4j.meituan;

import com.meituan.sdk.annotations.ApiMeta;
import io.github.easy4j.meituan.service.MeituanToolsService;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 到店广告（businessId=22）有文档 API 覆盖回归测试。
 */
class MeituanBusiness22ApiCoverageTest {

    private static final Set<String> DOCUMENTED_API_PATHS = io.github.easy4j.meituan.TestCollections.setOf(
            "/ad/report/getDailyDataByLaunchOffline",
            "/ad/report/getDailyDataByShopOffline",
            "/ad/report/getDailyDataByAccountOffline",
            "/ad/report/getHourlyDataByShopOffline",
            "/ad/report/getHourlyDataByLaunchOffline",
            "/ad/report/getHourlyDataByAccountOffline",
            "/ad/report/getDailyHourlyCpmData",
            "/ad/report/getDailyCpmData",
            "/ad/report/getCpmRtData",
            "/ad/report/getHourlyCpmRtData",
            "/ad/report/getCpcRtDataByLaunch",
            "/ad/report/getHourlyCpcRtDataByLaunch",
            "/ad/report/getCpcRtDataByShop",
            "/ad/report/getHourlyCpcRtDataByShop",
            "/ad/report/getCpcRtDataByAccount",
            "/ad/report/getHourlyCpcRtDataByAccount",
            "/ad/launch/batchEditCpcBidPrice",
            "/ad/launch/batchUpdateCpcLaunchStatus",
            "/ad/launch/batchEditCpcPlanBudget",
            "/ad/launch/batchCreateCpcLaunchs",
            "/ad/launch/batchQueryCpcLaunchInfos",
            "/ad/launch/queryCpcLaunchIds",
            "/ad/launch/queryRelationShops",
            "/ad/launch/queryAdAccountSons",
            "/ad/launch/queryAdAccountInfo",
            "/ad/launch/queryAdAccountBalance",
            "/ad/launch/queryValidShops",
            "/ad/launch/batchUpdateLaunchTimeSlot",
            "/ad/launch/batchUpdateLaunchTime",
            "/ad/launch/batchUpdateKeywordBidPrice",
            "/ad/launch/batchUpdateKeywords",
            "/ad/launch/batchAddKeywords",
            "/ad/launch/querySuggestBid",
            "/ad/launch/queryLaunchPremiumList",
            "/ad/launch/queryRecommendKeywords",
            "/ad/launch/cpm/batchCreateLaunch",
            "/ad/launch/cpm/queryBidInfo",
            "/ad/launch/cpm/queryCommonInfo",
            "/ad/launch/cpm/batchQueryLaunchInfo",
            "/ad/launch/cpm/batchUpdate",
            "/ad/launch/cpm/batchUpdateBudget",
            "/ad/launch/cpm/batchUpdateBid"
    );

    @Test
    void shouldWrapEveryDocumentedBusiness22ApiInToolsFacade() throws Exception {
        Map<String, Class<?>> requestsByPath = documentedRequestsByPath();
        Set<Class<?>> facadeRequestTypes = new HashSet<>();
        for (Method method : MeituanToolsService.class.getDeclaredMethods()) {
            if (method.getParameterCount() > 0) {
                facadeRequestTypes.add(method.getParameterTypes()[0]);
            }
        }

        assertThat(requestsByPath.keySet()).containsExactlyInAnyOrderElementsOf(DOCUMENTED_API_PATHS);
        assertThat(facadeRequestTypes).containsAll(requestsByPath.values());
    }

    private Map<String, Class<?>> documentedRequestsByPath() throws Exception {
        Map<String, Class<?>> requestsByPath = new HashMap<>();
        File sdkJar = new File(com.meituan.sdk.MeituanClient.class
                .getProtectionDomain().getCodeSource().getLocation().toURI());
        try (JarFile jarFile = new JarFile(sdkJar)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                collectDocumentedRequest(entries.nextElement(), requestsByPath);
            }
        }
        return requestsByPath;
    }

    private void collectDocumentedRequest(JarEntry entry, Map<String, Class<?>> requestsByPath) {
        String name = entry.getName();
        if (!name.startsWith("com/meituan/sdk/model/ad/") || !name.endsWith("Request.class")) {
            return;
        }
        try {
            Class<?> requestClass = Class.forName(name.replace('/', '.').replace(".class", ""),
                    false, getClass().getClassLoader());
            ApiMeta apiMeta = requestClass.getAnnotation(ApiMeta.class);
            if (Objects.nonNull(apiMeta)
                    && apiMeta.businessId() == 22
                    && DOCUMENTED_API_PATHS.contains(apiMeta.path())) {
                requestsByPath.put(apiMeta.path(), requestClass);
            }
        } catch (LinkageError | ClassNotFoundException ignored) {
            // 仅处理当前类路径能够加载的官方 Request。
        }
    }
}
