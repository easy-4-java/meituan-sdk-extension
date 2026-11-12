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

    /**
     * 创建 单元测试。的空实例。
     */
    MeituanTenantContextHolderTest() {
    }


    /**
     * 清除当前线程的租户上下文，隔离后续测试。
     */
    @AfterEach
    void cleanup() {
        MeituanTenantContextHolder.clear();
    }

    /**
     * 验证当前线程可以保存并读取租户标识。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void should_store_and_retrieve_tenant_id() throws Exception {
        MeituanTenantContextHolder.setTenantId("tenant-A");
        assertEquals("tenant-A", MeituanTenantContextHolder.getTenantId());
    }

    /**
     * 验证未设置线程上下文时返回 null。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void should_return_null_when_unset() throws Exception {
        assertNull(MeituanTenantContextHolder.getTenantId());
    }

    /**
     * 验证清理操作会移除当前线程的租户标识。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void should_clear_tenant_id() throws Exception {
        MeituanTenantContextHolder.setTenantId("tenant-B");
        MeituanTenantContextHolder.clear();
        assertNull(MeituanTenantContextHolder.getTenantId());
    }

    /**
     * 验证不同线程的租户上下文相互隔离。
     *
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
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