package io.github.easy4j.meituan.tenant;

/**
 * 线程级租户上下文。
 * <p>该类只提供轻量的 ThreadLocal 存取能力，适合在 Web filter、拦截器或任务入口写入当前租户。</p>
 */
public final class MeituanTenantContextHolder {

    /**
     * 当前线程绑定的租户标识。
     */
    private static final ThreadLocal<String> TENANT_ID = new ThreadLocal<>();

    /**
     * 工具类禁止实例化。
     */
    private MeituanTenantContextHolder() {
    }

    /**
     * 获取当前线程绑定的租户标识。
     *
     * @return 当前租户标识，未设置时返回 null
     */
    public static String getTenantId() {
        return TENANT_ID.get();
    }

    /**
     * 设置当前线程租户标识。
     *
     * @param tenantId 租户标识
     */
    public static void setTenantId(String tenantId) {
        TENANT_ID.set(tenantId);
    }

    /**
     * 清理当前线程租户标识，避免线程复用时发生租户串扰。
     */
    public static void clear() {
        TENANT_ID.remove();
    }
}
