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

    /**
     * 创建快驴清单（businessId=27）API 覆盖回归测试。的空实例。
     */
    MeituanBusiness27KuailvApiCoverageTest() {
    }


    /**
     * 快驴接口清单需要覆盖的路径。
     */
    private static final Set<String> KUAILV_CHECKLIST_API_PATHS = io.github.easy4j.meituan.TestCollections.setOf(
            "/kl/open/order/create",
            "/kl/open/order/create/sync",
            "/kl/open/order/detail",
            "/kl/open/order/cancel",
            "/kl/open/goods/page/spu",
            "/kl/open/goods/page/sku",
            "/kl/open/goods/sku/sales"
    );

    /**
     * 验证当前业务的官方请求、接口元数据及业务门面完整对应。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
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

    /**
     * 扫描官方 SDK 并按接口路径索引当前业务的请求类型。
     *
     * @return 扫描官方 SDK 并按接口路径索引当前业务的请求类型的结果
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    private Map<String, Class<?>> business27RequestsByPath() throws Exception {
        Map<String, Class<?>> requestsByPath = new HashMap<>();
        File sdkJar = OfficialSdkTestInput.jar();
        try (JarFile jarFile = new JarFile(sdkJar)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                collectBusiness27Request(entries.nextElement(), requestsByPath);
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
