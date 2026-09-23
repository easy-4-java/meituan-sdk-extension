package io.github.easy4j.meituan;

import com.meituan.sdk.annotations.ApiMeta;
import io.github.easy4j.meituan.service.MeituanKuailvService;
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
 * 快驴清单（businessId=27）API 覆盖回归测试。
 * <p>路径集合绑定用户提供的 7 条公开 API 和 MtOpJavaSDK 1.0.20260831；升级官方 SDK 时
 * 必须同步审查清单、官方 inventory、门面覆盖和鉴权路由。</p>
 */
class MeituanBusiness27KuailvApiCoverageTest {

    private static final Set<String> KUAILV_CHECKLIST_API_PATHS = io.github.easy4j.meituan.TestCollections.setOf(
            "/kl/open/order/create",
            "/kl/open/order/create/sync",
            "/kl/open/order/detail",
            "/kl/open/order/cancel",
            "/kl/open/goods/page/spu",
            "/kl/open/goods/page/sku",
            "/kl/open/goods/sku/sales"
    );

    @Test
    void shouldWrapEveryDocumentedKuailvApiInFacade() throws Exception {
        Map<String, Class<?>> requestsByPath = business27RequestsByPath();
        Set<Class<?>> facadeRequestTypes = new HashSet<>();
        for (Method method : MeituanKuailvService.class.getDeclaredMethods()) {
            if (method.getParameterCount() > 0) {
                facadeRequestTypes.add(method.getParameterTypes()[0]);
            }
        }

        assertThat(requestsByPath.keySet()).containsExactlyInAnyOrderElementsOf(KUAILV_CHECKLIST_API_PATHS);
        assertThat(facadeRequestTypes)
                .containsExactlyInAnyOrderElementsOf(new HashSet<>(requestsByPath.values()));
        for (Map.Entry<String, Class<?>> entry : requestsByPath.entrySet()) {
            ApiMeta apiMeta = entry.getValue().getAnnotation(ApiMeta.class);
            assertThat(apiMeta.businessId()).as("businessId for %s", entry.getKey()).isEqualTo(27);
            assertThat(apiMeta.needAuth()).as("needAuth for %s", entry.getKey()).isTrue();
            assertThat(facadeRequestTypes).as("facade request for %s", entry.getKey()).contains(entry.getValue());
        }
    }

    private Map<String, Class<?>> business27RequestsByPath() throws Exception {
        Map<String, Class<?>> requestsByPath = new HashMap<>();
        File sdkJar = new File(com.meituan.sdk.MeituanClient.class
                .getProtectionDomain().getCodeSource().getLocation().toURI());
        try (JarFile jarFile = new JarFile(sdkJar)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                collectBusiness27Request(entries.nextElement(), requestsByPath);
            }
        }
        return requestsByPath;
    }

    private void collectBusiness27Request(JarEntry entry, Map<String, Class<?>> requestsByPath) {
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
            if (Objects.nonNull(apiMeta) && apiMeta.businessId() == 27) {
                Class<?> existingRequestType = requestsByPath.put(apiMeta.path(), requestType);
                if (Objects.nonNull(existingRequestType)) {
                    throw new IllegalStateException("官方快驴 Request 路径重复: " + apiMeta.path());
                }
            }
        } catch (ClassNotFoundException exception) {
            throw new IllegalStateException("无法加载官方快驴 Request: " + name, exception);
        }
    }
}
