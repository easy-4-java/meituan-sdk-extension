package io.github.easy4j.meituan;

import com.meituan.sdk.annotations.ApiMeta;
import io.github.easy4j.meituan.service.MeituanCateringService;
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
 * 到店餐饮预订（businessId=7）API 覆盖回归测试。
 * <p>路径集合绑定 MtOpJavaSDK 1.0.20260831；升级官方 SDK 时必须同步审查接口清单、
 * 门面覆盖和鉴权路由，不应直接放宽该精确集合断言。</p>
 */
class MeituanBusiness7ApiCoverageTest {

    private static final Set<String> RESERVATION_API_PATHS = io.github.easy4j.meituan.TestCollections.setOf(
            "/resv2/config/update",
            "/resv2/order/operation",
            "/resv2/order/batchQuery",
            "/resv2/order/queryById",
            "/resv2/rule/supply/query",
            "/resv2/rule/supply/save",
            "/resv2/rule/supply/saveBookingTimeRule",
            "/resv2/stock/supply/queryStock",
            "/resv2/stock/supply/updateStock",
            "/resv2/stock/supply/updateTableVisible",
            "/resv2/table/save",
            "/resv2/table/supply/saveOrUpdateTable",
            "/resv2/table/supply/deleteTable",
            "/resv2/table/supply/queryTable",
            "/resv2/table/delete",
            "/resv2/table/dining/time/update",
            "/resv2/table/future/status/update",
            "/resv2/table/status/erbpush",
            "/resv2/table/update",
            "/resv2/table/status/upload",
            "/resv2/table/status/update"
    );

    @Test
    void shouldWrapEveryBusiness7ApiInCateringFacade() throws Exception {
        Map<String, Class<?>> requestsByPath = reservationRequestsByPath();
        Set<Class<?>> facadeRequestTypes = new HashSet<>();
        for (Method method : MeituanCateringService.class.getDeclaredMethods()) {
            if (method.getParameterCount() > 0) {
                facadeRequestTypes.add(method.getParameterTypes()[0]);
            }
        }

        assertThat(requestsByPath.keySet()).containsExactlyInAnyOrderElementsOf(RESERVATION_API_PATHS);
        assertThat(requestsByPath.values()).allSatisfy(requestType -> {
            ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
            assertThat(apiMeta.businessId()).isEqualTo(7);
            assertThat(apiMeta.needAuth()).isTrue();
        });
        assertThat(facadeRequestTypes).containsAll(requestsByPath.values());
    }

    private Map<String, Class<?>> reservationRequestsByPath() throws Exception {
        Map<String, Class<?>> requestsByPath = new HashMap<>();
        File sdkJar = new File(com.meituan.sdk.MeituanClient.class
                .getProtectionDomain().getCodeSource().getLocation().toURI());
        try (JarFile jarFile = new JarFile(sdkJar)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                collectReservationRequest(entries.nextElement(), requestsByPath);
            }
        }
        return requestsByPath;
    }

    private void collectReservationRequest(JarEntry entry, Map<String, Class<?>> requestsByPath) {
        String name = entry.getName();
        if (!name.startsWith("com/meituan/sdk/model/resv2/") || !name.endsWith("Request.class")) {
            return;
        }
        try {
            Class<?> requestType = Class.forName(
                    name.replace('/', '.').replace(".class", ""),
                    false,
                    getClass().getClassLoader());
            ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
            if (Objects.nonNull(apiMeta)) {
                requestsByPath.put(apiMeta.path(), requestType);
            }
        } catch (ClassNotFoundException exception) {
            throw new IllegalStateException("无法加载官方到店餐饮预订 Request: " + name, exception);
        }
    }
}
