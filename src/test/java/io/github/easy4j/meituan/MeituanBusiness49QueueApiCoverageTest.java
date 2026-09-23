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
 * 到店餐饮排队清单（businessId=49）API 覆盖回归测试。
 * <p>路径集合绑定用户提供的 16 条清单和 MtOpJavaSDK 1.0.20260831；升级官方 SDK 时
 * 必须同步审查清单、18 条 SDK inventory、门面覆盖和鉴权路由；清单外能力单独核对，
 * 不混入 16/16 的清单覆盖结论。</p>
 */
class MeituanBusiness49QueueApiCoverageTest {

    private static final Set<String> BUSINESS_49_API_PATHS = io.github.easy4j.meituan.TestCollections.setOf(
            "/dcpd/approval/batchAuthorize",
            "/dcpd/queue/query/shop/state",
            "/dcpd/queue/shop/config/tableType/sync",
            "/dcpd/queue/shop/config/tableType/clear",
            "/dcpd/queue/shop/heartbeat/sync",
            "/dcpd/queue/shop/user/bind",
            "/dcpd/queue/shop/config/onlineQueue/update",
            "/dcpd/queue/shop/config/displayWaitTime/update",
            "/dcpd/queue/shop/config/tips/update",
            "/dcpd/queue/order/reset",
            "/dcpd/queue/order/index/sync",
            "/dcpd/queue/order/create/sync",
            "/dcpd/queue/order/status/update",
            "/dcpd/queue/order/create/callback",
            "/dcpd/queue/order/create/batchsync",
            "/dcpd/queue/order/clear",
            "/dcpd/queue/order/query",
            "/dcpd/queue/order/cancel/callback"
    );

    private static final Set<String> QUEUE_CHECKLIST_API_PATHS = io.github.easy4j.meituan.TestCollections.setOf(
            "/dcpd/queue/shop/config/tableType/sync",
            "/dcpd/queue/shop/config/tableType/clear",
            "/dcpd/queue/shop/heartbeat/sync",
            "/dcpd/queue/shop/user/bind",
            "/dcpd/queue/shop/config/onlineQueue/update",
            "/dcpd/queue/shop/config/displayWaitTime/update",
            "/dcpd/queue/shop/config/tips/update",
            "/dcpd/queue/order/reset",
            "/dcpd/queue/order/index/sync",
            "/dcpd/queue/order/create/sync",
            "/dcpd/queue/order/status/update",
            "/dcpd/queue/order/create/callback",
            "/dcpd/queue/order/create/batchsync",
            "/dcpd/queue/order/clear",
            "/dcpd/queue/order/query",
            "/dcpd/queue/order/cancel/callback"
    );

    @Test
    void shouldWrapEveryQueueChecklistApiInCateringFacade() throws Exception {
        Map<String, Class<?>> requestsByPath = business49RequestsByPath();
        Set<Class<?>> facadeRequestTypes = new HashSet<>();
        for (Method method : MeituanCateringService.class.getDeclaredMethods()) {
            if (method.getParameterCount() > 0) {
                facadeRequestTypes.add(method.getParameterTypes()[0]);
            }
        }

        assertThat(requestsByPath.keySet()).containsExactlyInAnyOrderElementsOf(BUSINESS_49_API_PATHS);
        Set<Class<?>> business49RequestTypes = new HashSet<>();
        for (String path : BUSINESS_49_API_PATHS) {
            Class<?> requestType = requestsByPath.get(path);
            ApiMeta apiMeta = requestType.getAnnotation(ApiMeta.class);
            assertThat(apiMeta.businessId()).as("businessId for %s", path).isEqualTo(49);
            assertThat(apiMeta.needAuth())
                    .as("needAuth for %s", path)
                    .isEqualTo(!"/dcpd/approval/batchAuthorize".equals(path));
            business49RequestTypes.add(requestType);
        }
        assertThat(requestsByPath).containsKeys(QUEUE_CHECKLIST_API_PATHS.toArray(new String[0]));
        assertThat(facadeRequestTypes).containsAll(business49RequestTypes);
    }

    private Map<String, Class<?>> business49RequestsByPath() throws Exception {
        Map<String, Class<?>> requestsByPath = new HashMap<>();
        File sdkJar = new File(com.meituan.sdk.MeituanClient.class
                .getProtectionDomain().getCodeSource().getLocation().toURI());
        try (JarFile jarFile = new JarFile(sdkJar)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                collectBusiness49Request(entries.nextElement(), requestsByPath);
            }
        }
        return requestsByPath;
    }

    private void collectBusiness49Request(JarEntry entry, Map<String, Class<?>> requestsByPath) {
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
            if (Objects.nonNull(apiMeta) && apiMeta.businessId() == 49) {
                requestsByPath.put(apiMeta.path(), requestType);
            }
        } catch (ClassNotFoundException exception) {
            throw new IllegalStateException("无法加载官方到店餐饮排队 Request: " + name, exception);
        }
    }
}
