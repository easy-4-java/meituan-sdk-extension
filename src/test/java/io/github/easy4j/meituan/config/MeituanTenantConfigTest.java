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

    @Test
    void should_default_all_fields_null() {
        MeituanTenantConfig cfg = new MeituanTenantConfig();
        assertNull(cfg.getTenantId());
        assertNull(cfg.getAppId());
        assertNull(cfg.getDeveloperId());
        assertNull(cfg.getSignKey());
        assertNull(cfg.getAppAuthToken());
        assertNull(cfg.getBusinessId());
    }

    @Test
    void should_store_all_setter_values() {
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