package io.github.easy4j.meituan.tenant;

import io.github.easy4j.meituan.config.MeituanTenantConfig;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * {@link InMemoryMeituanTenantConfigStorage} 单元测试。
 *
 * @author wandl
 */
class InMemoryMeituanTenantConfigStorageTest {

    @Test
    void should_return_empty_when_unset() {
        InMemoryMeituanTenantConfigStorage storage = new InMemoryMeituanTenantConfigStorage(new HashMap<>());
        Optional<MeituanTenantConfig> result = storage.findByTenantId("nope");
        assertFalse(result.isPresent());
    }

    @Test
    void should_return_config_when_present() {
        MeituanTenantConfig cfg = new MeituanTenantConfig();
        cfg.setTenantId("t1");
        cfg.setAppId("app-1");
        cfg.setSignKey("sk-1");

        Map<String, MeituanTenantConfig> map = new HashMap<>();
        map.put("t1", cfg);
        InMemoryMeituanTenantConfigStorage storage = new InMemoryMeituanTenantConfigStorage(map);

        Optional<MeituanTenantConfig> result = storage.findByTenantId("t1");
        assertTrue(result.isPresent());
        assertEquals("t1", result.get().getTenantId());
        assertEquals("sk-1", result.get().getSignKey());
    }

    @Test
    void should_return_empty_for_blank_tenant_id() {
        InMemoryMeituanTenantConfigStorage storage = new InMemoryMeituanTenantConfigStorage(new HashMap<>());
        assertFalse(storage.findByTenantId(null).isPresent());
        assertFalse(storage.findByTenantId("").isPresent());
        assertFalse(storage.findByTenantId("   ").isPresent());
    }
}