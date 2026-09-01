package io.github.easy4j.meituan.tenant;

import io.github.easy4j.meituan.config.MeituanTenantConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * CachedMeituanTenantConfigStorage 的缓存、TTL、主动刷新与并发防击穿测试。
 */
class CachedMeituanTenantConfigStorageTest {

    private static final String TENANT = "tenant-a";

    private MeituanTenantConfig newConfig(String token) {
        MeituanTenantConfig config = new MeituanTenantConfig();
        config.setTenantId(TENANT);
        config.setAppAuthToken(token);
        return config;
    }

    private final AtomicInteger loadCount = new AtomicInteger();

    private MeituanTenantConfigLoader countingLoader() {
        return tenantId -> {
            loadCount.incrementAndGet();
            return Optional.of(newConfig("token-" + loadCount.get()));
        };
    }

    @BeforeEach
    void setUp() {
        loadCount.set(0);
    }

    @Test
    void shouldCacheAfterFirstLoadAndNotReloadWhileFresh() {
        CachedMeituanTenantConfigStorage storage =
                new CachedMeituanTenantConfigStorage(countingLoader(), Duration.ofMinutes(5));
        Optional<MeituanTenantConfig> first = storage.findByTenantId(TENANT);
        Optional<MeituanTenantConfig> second = storage.findByTenantId(TENANT);
        assertTrue(first.isPresent());
        assertSame(first.get(), second.get());
        assertEquals(1, loadCount.get(), "缓存命中不应重复加载");
        assertEquals(1, storage.size());
    }

    @Test
    void shouldReloadAfterTtlExpires() {
        // 用可控时钟模拟过期
        final long[] now = {1000L};
        Clock clock = Clock.fixed(java.time.Instant.EPOCH, java.time.ZoneId.systemDefault());
        Clock mutableClock = new Clock() {
            @Override
            public java.time.ZoneId getZone() {
                return clock.getZone();
            }

            @Override
            public Clock withZone(java.time.ZoneId zone) {
                return this;
            }

            @Override
            public long millis() {
                return now[0];
            }

            @Override
            public java.time.Instant instant() {
                return java.time.Instant.ofEpochMilli(now[0]);
            }
        };
        CachedMeituanTenantConfigStorage storage =
                new CachedMeituanTenantConfigStorage(countingLoader(), Duration.ofMinutes(5), mutableClock);
        storage.findByTenantId(TENANT);
        now[0] += Duration.ofMinutes(6).toMillis();
        Optional<MeituanTenantConfig> after = storage.findByTenantId(TENANT);
        assertTrue(after.isPresent());
        assertEquals(2, loadCount.get(), "TTL 过期后应重新加载");
        assertEquals("token-2", after.get().getAppAuthToken());
    }

    @Test
    void zeroTtlMeansNeverExpire() {
        CachedMeituanTenantConfigStorage storage =
                new CachedMeituanTenantConfigStorage(countingLoader(), Duration.ZERO);
        storage.findByTenantId(TENANT);
        storage.findByTenantId(TENANT);
        assertEquals(1, loadCount.get());
    }

    @Test
    void putShouldOverwriteCacheAndRefreshShouldReload() {
        AtomicInteger count = new AtomicInteger();
        MeituanTenantConfigLoader loader = tenantId -> {
            count.incrementAndGet();
            return Optional.of(newConfig("loaded-" + count.get()));
        };
        CachedMeituanTenantConfigStorage storage =
                new CachedMeituanTenantConfigStorage(loader, Duration.ofMinutes(10));

        storage.put(TENANT, newConfig("manual-token"));
        assertEquals("manual-token", storage.findByTenantId(TENANT).get().getAppAuthToken());

        storage.refresh(TENANT);
        assertEquals("loaded-1", storage.findByTenantId(TENANT).get().getAppAuthToken());
    }

    @Test
    void evictAndClearShouldInvalidateCache() {
        CachedMeituanTenantConfigStorage storage =
                new CachedMeituanTenantConfigStorage(countingLoader(), Duration.ZERO);
        storage.findByTenantId(TENANT);
        storage.evict(TENANT);
        assertEquals(0, storage.size());
        storage.findByTenantId(TENANT);
        assertEquals(2, loadCount.get());
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    void shouldReturnEmptyForBlankTenantId() {
        CachedMeituanTenantConfigStorage storage =
                new CachedMeituanTenantConfigStorage(countingLoader());
        assertFalse(storage.findByTenantId("").isPresent());
        assertFalse(storage.findByTenantId(null).isPresent());
        assertEquals(0, loadCount.get());
    }

    @Test
    void concurrentMissShouldLoadOncePerTenant() throws Exception {
        // 慢加载器：放大并发窗口，验证租户级互斥锁防击穿
        List<String> calls = new ArrayList<>();
        MeituanTenantConfigLoader slowLoader = tenantId -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return Optional.of(newConfig("token-once"));
        };
        CachedMeituanTenantConfigStorage storage =
                new CachedMeituanTenantConfigStorage(slowLoader, Duration.ofMinutes(10));

        int threads = 8;
        ExecutorService pool = Executors.newFixedThreadPool(threads);
        CountDownLatch start = new CountDownLatch(1);
        List<java.util.concurrent.Future<Optional<MeituanTenantConfig>>> futures = new ArrayList<>();
        for (int i = 0; i < threads; i++) {
            futures.add(pool.submit(() -> {
                start.await();
                return storage.findByTenantId(TENANT);
            }));
        }
        start.countDown();
        pool.shutdown();
        assertTrue(pool.awaitTermination(10, TimeUnit.SECONDS));

        // 并发后只能有一个实例（锁内双检保证同一实例被复用）
        MeituanTenantConfig first = futures.get(0).get().orElse(null);
        assertTrue(first != null);
        for (int i = 1; i < threads; i++) {
            MeituanTenantConfig other = futures.get(i).get().orElse(null);
            assertSame(first, other, "并发加载应复用同一实例");
        }
        assertEquals("token-once", first.getAppAuthToken());
    }

    @Test
    void missingTenantShouldReturnEmptyAndNotCache() {
        MeituanTenantConfigLoader loader = tenantId -> Optional.empty();
        CachedMeituanTenantConfigStorage storage = new CachedMeituanTenantConfigStorage(loader);
        assertFalse(storage.findByTenantId("no-such").isPresent());
        assertEquals(0, storage.size());
    }
}
