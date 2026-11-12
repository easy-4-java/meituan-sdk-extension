package io.github.easy4j.meituan;

import com.meituan.sdk.annotations.ApiMeta;
import com.meituan.sdk.model.jmcard.cards.createOrUpdate.CreateOrUpdateRequest;
import com.meituan.sdk.model.jmcard.members.memberQuery.MemberQueryRequest;
import com.meituan.sdk.model.jmcard.members.memberUpdate.MemberUpdateRequest;
import io.github.easy4j.meituan.model.jmcard.MeituanMemberClaimRequest;
import io.github.easy4j.meituan.service.MeituanKemanmanService;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 到店餐饮品牌会员卡（businessId=15）公开 API 覆盖回归测试。
 */
class MeituanBusiness15MembershipCardApiCoverageTest {

    /**
     * 创建\u5230\u5e97\u9910\u996e\u54c1\u724c\u4f1a\u5458\u5361\uff08businessId=15\uff09\u516c\u5f00 API \u8986\u76d6\u56de\u5f52\u6d4b\u8bd5\u3002的空实例。
     */
    MeituanBusiness15MembershipCardApiCoverageTest() {
    }


    /**
     * 当前接口清单中记录的官方接口路径。
     */
    private static final Set<String> DOCUMENTED_API_PATHS = io.github.easy4j.meituan.TestCollections.setOf(
            "/jmcard/members/update",
            "/jmcard/members/query",
            "/jmcard/members/claim",
            "/jmcard/cards/create-or-update"
    );

    /**
     * 官方 SDK 提供的接口路径集合。
     */
    private static final Set<String> OFFICIAL_SDK_API_PATHS = io.github.easy4j.meituan.TestCollections.setOf(
            "/jmcard/members/update",
            "/jmcard/members/query",
            "/jmcard/cards/create-or-update"
    );

    /**
     * 需要检查的官方请求类型集合。
     */
    private static final Set<Class<?>> REQUEST_TYPES = io.github.easy4j.meituan.TestCollections.setOf(
            MemberUpdateRequest.class,
            MemberQueryRequest.class,
            MeituanMemberClaimRequest.class,
            CreateOrUpdateRequest.class
    );

    /**
     * 验证当前业务的官方请求、接口元数据及业务门面完整对应。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void shouldExposeEveryDocumentedMembershipCardApiThroughKemanmanFacade() throws Exception {
        Map<String, Class<?>> officialRequestsByPath = officialBusiness15RequestsByPath();
        assertThat(officialRequestsByPath.keySet()).containsExactlyInAnyOrderElementsOf(OFFICIAL_SDK_API_PATHS);

        Map<String, Class<?>> requestTypesByPath = REQUEST_TYPES.stream()
                .collect(Collectors.toMap(
                        requestType -> requestType.getAnnotation(ApiMeta.class).path(),
                        Function.identity()
                ));
        Set<Class<?>> facadeRequestTypes = Arrays.stream(MeituanKemanmanService.class.getDeclaredMethods())
                .filter(method -> method.getParameterCount() > 0)
                .map(method -> method.getParameterTypes()[0])
                .collect(Collectors.toSet());

        assertThat(requestTypesByPath.keySet()).containsExactlyInAnyOrderElementsOf(DOCUMENTED_API_PATHS);
        for (Map.Entry<String, Class<?>> entry : requestTypesByPath.entrySet()) {
            ApiMeta apiMeta = entry.getValue().getAnnotation(ApiMeta.class);
            assertThat(apiMeta.businessId()).as("businessId for %s", entry.getKey()).isEqualTo(15);
            assertThat(apiMeta.needAuth()).as("needAuth for %s", entry.getKey()).isTrue();
        }
        ApiMeta claimApiMeta = MeituanMemberClaimRequest.class.getAnnotation(ApiMeta.class);
        assertThat(claimApiMeta.apiVersion()).isEmpty();
        assertThat(claimApiMeta.apiName()).isEqualTo("member_claim");
        assertThat(facadeRequestTypes).containsAll(REQUEST_TYPES);
    }

    /**
     * 扫描官方 SDK 并按接口路径索引当前业务的请求类型。
     *
     * @return 扫描官方 SDK 并按接口路径索引当前业务的请求类型的结果
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    private Map<String, Class<?>> officialBusiness15RequestsByPath() throws Exception {
        Map<String, Class<?>> requestsByPath = new HashMap<>();
        File sdkJar = new File(com.meituan.sdk.MeituanClient.class
                .getProtectionDomain().getCodeSource().getLocation().toURI());
        try (JarFile jarFile = new JarFile(sdkJar)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                collectBusiness15Request(entries.nextElement(), requestsByPath);
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
    private void collectBusiness15Request(JarEntry entry, Map<String, Class<?>> requestsByPath) {
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
            if (Objects.nonNull(apiMeta) && apiMeta.businessId() == 15) {
                requestsByPath.put(apiMeta.path(), requestType);
            }
        } catch (ClassNotFoundException exception) {
            throw new IllegalStateException("无法加载官方品牌会员卡 Request: " + name, exception);
        }
    }
}
