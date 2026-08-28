package io.github.easy4j.meituan.tenant;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link MeituanTenantContextHolder} 单元测试。
 *
 * @author wandl
 */
class MeituanTenantContextHolderTest {

    @AfterEach
    void cleanup() {
        MeituanTenantContextHolder.clear();
    }

    @Test
    void should_store_and_retrieve_tenant_id() {
        MeituanTenantContextHolder.setTenantId("tenant-A");
        assertEquals("tenant-A", MeituanTenantContextHolder.getTenantId());
    }

    @Test
    void should_return_null_when_unset() {
        assertNull(MeituanTenantContextHolder.getTenantId());
    }

    @Test
    void should_clear_tenant_id() {
        MeituanTenantContextHolder.setTenantId("tenant-B");
        MeituanTenantContextHolder.clear();
        assertNull(MeituanTenantContextHolder.getTenantId());
    }

    @Test
    void should_be_thread_isolated() throws Exception {
        MeituanTenantContextHolder.setTenantId("main-thread");
        Thread worker = new Thread(() -> {
            // 子线程应独立
            assertNull(MeituanTenantContextHolder.getTenantId());
            MeituanTenantContextHolder.setTenantId("worker-thread");
            assertEquals("worker-thread", MeituanTenantContextHolder.getTenantId());
            MeituanTenantContextHolder.clear();
        });
        worker.start();
        worker.join();
        // 主线程的值应不受影响
        assertEquals("main-thread", MeituanTenantContextHolder.getTenantId());
    }
}