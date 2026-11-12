package io.github.easy4j.meituan;

import com.meituan.sdk.annotations.ApiMeta;
import io.github.easy4j.meituan.service.MeituanStoreService;
import io.github.easy4j.meituan.service.impl.MeituanStoreServiceImpl;
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
 * 门店建店直连（businessId=71）API 覆盖回归测试。
 */
class MeituanBusiness71ApiCoverageTest {

    /**
     * 创建\u95e8\u5e97\u5efa\u5e97\u76f4\u8fde\uff08businessId=71\uff09API \u8986\u76d6\u56de\u5f52\u6d4b\u8bd5\u3002的空实例。
     */
    MeituanBusiness71ApiCoverageTest() {
    }


    /**
     * 当前接口清单中记录的官方接口路径。
     */
    private static final Set<String> DOCUMENTED_API_PATHS = io.github.easy4j.meituan.TestCollections.setOf(
            "/mendianzhilian/test/map/poi/update",
            "/mendianzhilian/test/map/poi/bind",
            "/mendianzhilian/test/map/poi/create",
            "/mendianzhilian/test/map/poi/search",
            "/mendianzhilian/test/map/poi/page/search"
    );

    /**
     * 验证当前业务的官方请求、接口元数据及业务门面完整对应。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldWrapEveryDocumentedBusiness71ApiInStoreFacadeAndImplementation() throws Exception {
        Map<String, Class<?>> requestsByPath = documentedRequestsByPath();
        Set<Class<?>> facadeRequestTypes = firstParameterTypes(MeituanStoreService.class);
        Set<Class<?>> implementationRequestTypes = firstParameterTypes(MeituanStoreServiceImpl.class);

        assertThat(requestsByPath.keySet()).containsExactlyInAnyOrderElementsOf(DOCUMENTED_API_PATHS);
        assertThat(facadeRequestTypes).containsAll(requestsByPath.values());
        assertThat(implementationRequestTypes).containsAll(requestsByPath.values());
        assertThat(requestsByPath.values()).allSatisfy(requestClass ->
                assertThat(requestClass.getAnnotation(ApiMeta.class).needAuth()).isFalse());
    }

    /**
     * 收集业务门面方法第一个参数所声明的请求类型。
     *
     * @param type 声明的目标类型
     * @return 收集业务门面方法第一个参数所声明的请求类型的结果
     */
    private Set<Class<?>> firstParameterTypes(Class<?> type) {
        Set<Class<?>> requestTypes = new HashSet<>();
        for (Method method : type.getDeclaredMethods()) {
            if (method.getParameterCount() > 0) {
                requestTypes.add(method.getParameterTypes()[0]);
            }
        }
        return requestTypes;
    }

    /**
     * 扫描官方 SDK 并按接口路径索引当前业务的请求类型。
     *
     * @return 扫描官方 SDK 并按接口路径索引当前业务的请求类型的结果
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
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

    /**
     * 将当前业务的官方请求按接口路径加入覆盖检查索引。
     *
     * @param entry 待检查的官方 SDK JAR 条目
     * @param requestsByPath 以官方接口路径为键的请求类型索引
     */
    private void collectDocumentedRequest(JarEntry entry, Map<String, Class<?>> requestsByPath) {
        String name = entry.getName();
        if (!name.startsWith("com/meituan/sdk/model/") || !name.endsWith("Request.class")) {
            return;
        }
        try {
            Class<?> requestClass = Class.forName(name.replace('/', '.').replace(".class", ""),
                    false, getClass().getClassLoader());
            ApiMeta apiMeta = requestClass.getAnnotation(ApiMeta.class);
            if (Objects.nonNull(apiMeta)
                    && apiMeta.businessId() == 71
                    && DOCUMENTED_API_PATHS.contains(apiMeta.path())) {
                requestsByPath.put(apiMeta.path(), requestClass);
            }
        } catch (LinkageError | ClassNotFoundException ignored) {
            // 与全量覆盖测试一致：仅处理当前类路径能够加载的官方 Request。
        }
    }
}
