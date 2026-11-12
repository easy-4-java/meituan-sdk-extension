package io.github.easy4j.meituan;

import com.meituan.sdk.annotations.ApiMeta;
import io.github.easy4j.meituan.service.MeituanDeliveryService;
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
 * 团购配送（businessId=46）API 覆盖回归测试。
 */
class MeituanBusiness46GroupDeliveryApiCoverageTest {

    /**
     * 创建\u56e2\u8d2d\u914d\u9001\uff08businessId=46\uff09API \u8986\u76d6\u56de\u5f52\u6d4b\u8bd5\u3002的空实例。
     */
    MeituanBusiness46GroupDeliveryApiCoverageTest() {
    }


    /**
     * 当前业务接口清单需要覆盖的路径。
     */
    private static final Set<String> CHECKLIST_API_PATHS = io.github.easy4j.meituan.TestCollections.setOf(
            "/dcps/fulfill/poi/getPoiInfo",
            "/dcps/fulfill/poi/deliveryRule/create",
            "/dcps/fulfill/poi/deliveryRule/base/update",
            "/dcps/fulfill/poi/deliveryRule/feeDiscount/update",
            "/dcps/fulfill/poi/deliveryRule/reservation/update",
            "/dcps/fulfill/poi/deliveryRule/range/update",
            "/dcps/fulfill/poi/deliveryRule/change/query",
            "/dcps/fulfill/poi/deliveryRule/query",
            "/dcps/fulfill/reject/refund",
            "/dcps/fulfill/meal/call/rider",
            "/dcps/fulfill/agree/refund",
            "/dcps/fulfill/cancel/order",
            "/dcps/fulfill/reject/receive/order",
            "/dcps/fulfill/delivery/finish",
            "/dcps/fulfill/self/delivery",
            "/dcps/fulfill/order/detail",
            "/dcps/fulfill/order/logs",
            "/dcps/fulfill/receive/order",
            "/dcps/fulfill/poi/deal/query",
            "/dcps/fulfill/poi/deliveryRule/type/update",
            "/dcps/fulfill/poi/biz/deliveryRule/fee/update",
            "/dcps/fulfill/poi/biz/deliveryRule/range/update",
            "/dcps/fulfill/fill/tracking/number",
            "/dcps/fulfill/delivery/change/status"
    );
    /**
     * 仅在官方 SDK 中提供的接口路径。
     */
    private static final Set<String> SDK_ONLY_API_PATHS = io.github.easy4j.meituan.TestCollections.setOf(
            "/dcps/print/printer/status/update",
            "/dcps/settlement/querySettleResultForTGDeliver"
    );

    /**
     * 验证当前业务的官方请求、接口元数据及业务门面完整对应。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldWrapEveryOfficialBusiness46ApiAndCoverChecklist() throws Exception {
        Map<String, Class<?>> requestsByPath = business46RequestsByPath();
        Set<Class<?>> facadeRequestTypes = new HashSet<>();
        for (Method method : MeituanDeliveryService.class.getDeclaredMethods()) {
            if (method.getParameterCount() > 0 && isBusiness46Request(method.getParameterTypes()[0])) {
                facadeRequestTypes.add(method.getParameterTypes()[0]);
            }
        }

        assertThat(requestsByPath.keySet())
                .containsExactlyInAnyOrderElementsOf(union(CHECKLIST_API_PATHS, SDK_ONLY_API_PATHS));
        assertThat(requestsByPath.keySet()).containsAll(CHECKLIST_API_PATHS);
        assertThat(facadeRequestTypes)
                .containsExactlyInAnyOrderElementsOf(new HashSet<>(requestsByPath.values()));
        for (Map.Entry<String, Class<?>> entry : requestsByPath.entrySet()) {
            ApiMeta apiMeta = entry.getValue().getAnnotation(ApiMeta.class);
            assertThat(apiMeta.businessId()).as("businessId for %s", entry.getKey()).isEqualTo(46);
            assertThat(apiMeta.needAuth()).as("needAuth for %s", entry.getKey()).isTrue();
        }
    }

    /**
     * 扫描官方 SDK 并按接口路径索引当前业务的请求类型。
     *
     * @return 扫描官方 SDK 并按接口路径索引当前业务的请求类型的结果
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    private Map<String, Class<?>> business46RequestsByPath() throws Exception {
        Map<String, Class<?>> requestsByPath = new HashMap<>();
        File sdkJar = OfficialSdkTestInput.jar();
        try (JarFile jarFile = new JarFile(sdkJar)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                collectBusiness46Request(entries.nextElement(), requestsByPath);
            }
        }
        return requestsByPath;
    }

    /**
     * 将当前业务的官方请求按接口路径加入覆盖检查索引。
     *
     * @param entry 待检查的官方 SDK JAR 条目
     * @param requestsByPath 以官方接口路径为键的请求类型索引
     */
    private void collectBusiness46Request(JarEntry entry, Map<String, Class<?>> requestsByPath) {
        String name = entry.getName();
        if (!name.startsWith("com/meituan/sdk/model/") || !name.endsWith("Request.class")) {
            return;
        }
        try {
            Class<?> requestType = Class.forName(
                    name.replace('/', '.').replace(".class", ""),
                    false,
                    getClass().getClassLoader());
            ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
            if (Objects.nonNull(apiMeta) && apiMeta.businessId() == 46) {
                Class<?> existingRequestType = requestsByPath.put(apiMeta.path(), requestType);
                if (Objects.nonNull(existingRequestType)) {
                    throw new IllegalStateException("官方团购配送 Request 路径重复: " + apiMeta.path());
                }
            }
        } catch (ClassNotFoundException exception) {
            throw new IllegalStateException("无法加载官方团购配送 Request: " + name, exception);
        }
    }

    /**
     * 判断请求的官方元数据是否属于当前被检查的业务。
     *
     * @param requestType 官方请求类型
     * @return 判断请求的官方元数据是否属于当前被检查的业务的结果
     */
    private boolean isBusiness46Request(Class<?> requestType) {
        ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
        return Objects.nonNull(apiMeta) && apiMeta.businessId() == 46;
    }

    /**
     * 合并两个接口路径集合，消除重复路径。
     *
     * @param left 第一个接口路径集合
     * @param right 第二个接口路径集合
     * @return 合并两个接口路径集合，消除重复路径的结果
     */
    private Set<String> union(Set<String> left, Set<String> right) {
        Set<String> result = new HashSet<>(left);
        result.addAll(right);
        return result;
    }
}
