package io.github.easy4j.meituan.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link MeituanTenantConfig} 单元测试：覆盖所有字段的默认/设置取值。
 *
 * @author wandl
 */
class MeituanTenantConfigTest {

    /**
     * 创建 \u5355\u5143\u6d4b\u8bd5\uff1a\u8986\u76d6\u6240\u6709\u5b57\u6bb5\u7684\u9ed8\u8ba4/\u8bbe\u7f6e\u53d6\u503c\u3002的空实例。
     */
    MeituanTenantConfigTest() {
    }


    /**
     * 验证新建租户配置的各字段初始值为空。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void should_default_all_fields_null() throws Exception {
        MeituanTenantConfig cfg = new MeituanTenantConfig();
        assertNull(cfg.getTenantId());
        assertNull(cfg.getAppId());
        assertNull(cfg.getDeveloperId());
        assertNull(cfg.getSignKey());
        assertNull(cfg.getAppAuthToken());
        assertNull(cfg.getBusinessId());
    }

    /**
     * 验证租户配置能够保存并返回各属性的设置值。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void should_store_all_setter_values() throws Exception {
        MeituanTenantConfig cfg = new MeituanTenantConfig();
        cfg.setTenantId("tenant-a");
        cfg.setAppId("app-001");
        cfg.setDeveloperId(12345L);
        cfg.setSignKey("sk_test_xxx");
        cfg.setAppAuthToken("token_yyy");
        cfg.setBusinessId(16);

        assertEquals("tenant-a", cfg.getTenantId());
        assertEquals("app-001", cfg.getAppId());
        assertEquals(Long.valueOf(12345L), cfg.getDeveloperId());
        assertEquals("sk_test_xxx", cfg.getSignKey());
        assertEquals("token_yyy", cfg.getAppAuthToken());
        assertEquals(Integer.valueOf(16), cfg.getBusinessId());
    }
}