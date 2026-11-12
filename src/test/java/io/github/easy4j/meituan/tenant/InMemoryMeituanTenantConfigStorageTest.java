package io.github.easy4j.meituan.tenant;

import io.github.easy4j.meituan.config.MeituanTenantConfig;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link InMemoryMeituanTenantConfigStorage} 单元测试。
 *
 * @author wandl
 */
class InMemoryMeituanTenantConfigStorageTest {

    /**
     * 创建 单元测试。的空实例。
     */
    InMemoryMeituanTenantConfigStorageTest() {
    }


    /**
     * 验证未配置租户时返回空结果。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void should_return_empty_when_unset() throws Exception {
        InMemoryMeituanTenantConfigStorage storage = new InMemoryMeituanTenantConfigStorage(new HashMap<>());
        Optional<MeituanTenantConfig> result = storage.findByTenantId("nope");
        assertFalse(result.isPresent());
    }

    /**
     * 验证已配置租户时返回对应配置。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void should_return_config_when_present() throws Exception {
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

    /**
     * 验证空白租户标识返回空结果。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void should_return_empty_for_blank_tenant_id() throws Exception {
        InMemoryMeituanTenantConfigStorage storage = new InMemoryMeituanTenantConfigStorage(new HashMap<>());
        assertFalse(storage.findByTenantId(null).isPresent());
        assertFalse(storage.findByTenantId("").isPresent());
        assertFalse(storage.findByTenantId("   ").isPresent());
    }
}