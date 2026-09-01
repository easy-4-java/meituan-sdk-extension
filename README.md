# meituan-sdk-extension

[English](./README.md) | [简体中文](./README.zh-CN.md)

[![Java](https://img.shields.io/badge/Java-8-orange)](https://github.com/easy-4-java/meituan-sdk-extension) [![License](https://img.shields.io/badge/license-Apache%202.0-green)](https://www.apache.org/licenses/LICENSE-2.0.txt)

> Extension SDK for the Meituan Open Platform: a multi-tenant wrapper on top of the
> official `MtOpJavaSDK` with typed business facades, tenant-aware request execution
> and Spring Boot auto-configuration.

## Table of Contents

- [1. Project Overview](#1-project-overview)
- [2. Features & Status](#2-features--status)
- [3. Requirements & Compatibility](#3-requirements--compatibility)
- [4. Architecture & Modules](#4-architecture--modules)
- [5. Installation](#5-installation)
- [6. Quick Start](#6-quick-start)
- [7. Configuration](#7-configuration)
- [8. Core Usage / API](#8-core-usage--api)
- [9. Testing & Build](#9-testing--build)
- [10. Versioning & Branches](#10-versioning--branches)
- [11. Contributing & License](#11-contributing--license)

## 1. Project Overview

`meituan-sdk-extension` is a Java extension layer on top of the official Meituan
Open Platform SDK (`com.sankuai.sjst:MtOpJavaSDK`). It lets one server-side
application serve many Meituan developer accounts / stores at the same time:

- **Multi-tenant by design** — every tenant carries its own `developerId` /
  `signKey` / `appAuthToken`; official `MeituanClient` instances are created per
  tenant key set and cached (`ConcurrentHashMap`, cache key is a
  `developerId:signKey-hash` pair so the raw `signKey` never leaks into logs).
- **Tenant-scoped execution** — business calls take a `tenantId`, the executor
  resolves the tenant credentials from a pluggable `MeituanTenantConfigStorage`
  and delegates to the official client.
- **Typed business facades** — 14 service interfaces (`MeituanWaimaiService`,
  `MeituanRetailService`, …) covering the strong-typed Request/Response models
  extracted from the official SDK (1106 typed methods) (official test package `corgiTest` excluded by design; coverage is enforced by `MeituanApiCoverageTest`).
- **Optional Spring Boot starter** — the pairing starter
  [meituan-spring-boot-starter](https://github.com/easy-4-java/meituan-spring-boot-starter)
  wires config binding, tenant storage, client factory, executor and all
  business services; this core stays framework-free.

What it is **not**:

- Not a replacement for the official SDK — `com.meituan.sdk.*` types are used
  underneath.
- Not bound to a specific tenant store — the default is in-memory; implement
  `MeituanTenantConfigStorage` to load tenants from a database or config center.

## 2. Features & Status

| Area | Status |
| :--- | :--- |
| Multi-tenant credential model (`developerId` / `signKey` per tenant) | ✅ |
| Per-tenant official client creation & caching | ✅ |
| Tenant storage SPI + in-memory + cacheable decorator | ✅ |
| Tenant context holder (thread-local `tenantId`) | ✅ |
| Business facades: catering, daocan (到店餐饮), delivery, distribution, freetry, kemanman, kuailv, live, pay, retail, store, tools, travel, waimai | ✅ |
| Optional Spring Boot starter (`meituan-spring-boot-starter`, one line per Boot 2.3–4.1) | ✅ |
| Exception translation preserving official error codes | ✅ |

## 3. Requirements & Compatibility

| Dependency | Version |
| :--- | :--- |
| Java | 1.8+ |
| Spring Boot | 2.7.x (auto-configuration API is Boot 2.7+ compatible) |
| Official SDK | `com.sankuai.sjst:MtOpJavaSDK:1.0-SNAPSHOT` (proprietary, see below) |
| Build | Maven 3.9.16 (`./mvnw` wrapper included) |

> **Official SDK availability** — `MtOpJavaSDK` is distributed by the Meituan
> Technical Service Cooperation Center ([sdk-download](https://developer.meituan.com/sdk-download))
> and is **not published to Maven Central**. A copy of the official jar (with
> its official POM) is vendored under `libs/`, and CI installs it before
> building. For local development it is resolved from the private snapshot
> repository declared in the POM (requires whitelisted access), or install the
> jar manually:
>
> ```bash
> mvn install:install-file -Dfile=libs/MtOpJavaSDK-1.0-SNAPSHOT.jar \
>     -DpomFile=libs/MtOpJavaSDK-1.0-SNAPSHOT.pom
> ```

## 4. Architecture & Modules

| Package | Responsibility |
| :--- | :--- |
| `io.github.easy4j.meituan` | framework-free core: config objects, client factory, executor, services |
| `io.github.easy4j.meituan.client` | Official client factory, tenant-aware `MeituanRequestExecutor` |
| `io.github.easy4j.meituan.config` | `MeituanConfig` (platform) / `MeituanTenantConfig` (tenant) |
| `io.github.easy4j.meituan.tenant` | Tenant storage SPI, in-memory impl, cacheable decorator, `MeituanTenantContextHolder`, loader |
| `io.github.easy4j.meituan.service` | 14 business service interfaces |
| `io.github.easy4j.meituan.service.impl` | Business service implementations |
| `io.github.easy4j.meituan.exception` | `MeituanJavaException` translation |

Call chain:

```
business service ──> MeituanRequestExecutor ──> MeituanTenantConfigStorage (resolve tenant)
                          │
                          └──> MeituanClientFactory (per-tenant cache) ──> com.meituan.sdk.MeituanClient
```

## 5. Installation

```xml
<dependency>
    <groupId>io.github.easy4j</groupId>
    <artifactId>meituan-sdk-extension</artifactId>
    <version>1.0.x.20260630-SNAPSHOT</version>
</dependency>
```

Spring Boot services should also add the starter
([meituan-spring-boot-starter](https://github.com/easy-4-java/meituan-spring-boot-starter)),
which auto-wires `MeituanConfig`, `MeituanTenantConfigStorage`,
`MeituanClientFactory`, `MeituanRequestExecutor` and all `Meituan*Service`
beans with one dependency.

## 6. Quick Start

1. Add the dependency (above).
2. Configure at least one tenant (below).
3. Inject a service and call it with the tenant id:

```java
@Service
public class OrderService {

    private final MeituanWaimaiService waimaiService;

    public OrderService(MeituanWaimaiService waimaiService) {
        this.waimaiService = waimaiService;
    }

    public MeituanResponse<?> queryOrder(String orderId, String tenantId) {
        OrderQueryByIdRequest request = new OrderQueryByIdRequest();
        // ... fill request
        return waimaiService.orderQueryById(request, tenantId);
    }
}
```

## 7. Configuration

```yaml
meituan:
  server-url: https://api-open-cater.meituan.com
  charset: UTF-8
  version: "2"
  connect-timeout: 5000
  read-timeout: 10000
  tenants:
    tenant-a:
      app-id: app-a
      developer-id: 100000
      sign-key: your-sign-key
      app-auth-token: token-a
      business-id: 16
    tenant-b:
      app-id: app-b
      developer-id: 200000
      sign-key: another-sign-key
      app-auth-token: token-b
      business-id: 16
```

Top-level keys are shared client defaults; each tenant carries its own
developer credentials and store token.

## 8. Core Usage / API

Call a business service for a specific tenant:

```java
MeituanResponse<?> response = retailService.orderQueryorder(request, "tenant-a");
```

Or use the generic executor directly:

```java
MeituanResponse<Foo> response = executor.execute(request, "tenant-a");
MeituanResponse<Bar> anon = executor.executeWithoutAuth(noAuthRequest);
```

Custom tenant storage (e.g. load from database):

```java
@Bean
MeituanTenantConfigStorage meituanTenantConfigStorage(TenantRepository repository) {
    return tenantId -> repository.findByTenantId(tenantId);
}
```

Cacheable storage with TTL for remote/config-center-backed tenants:

```java
// TTL 10 minutes: entry reloads from the loader after expiry
MeituanTenantConfigStorage cached = new CachedMeituanTenantConfigStorage(
        tenantId -> repository.findByTenantId(tenantId), Duration.ofMinutes(10));

// Push fresh credentials immediately after an authorization callback
cachedStorage.put("tenant-a", freshConfig);   // overwrite cache
cachedStorage.refresh("tenant-a");            // force reload from loader
cachedStorage.evict("tenant-a");              // drop one entry
```

> **Token lifecycle** — `appAuthToken` refresh is the caller's responsibility:
> implement `MeituanTenantConfigLoader` to return the *current* token from your
> store, pick a TTL shorter than the token lifetime, or call `put`/`refresh`
> from your token-rotation job. The SDK never refreshes tokens itself.

## 9. Testing & Build

```bash
./mvnw -B clean verify
```

- Unit tests run with JUnit 6 + Mockito (15 tests).
- Live-API debug tests live in `io.github.easy4j.meituan.debug`, tagged
  `@Tag("integration")` and excluded from normal builds. Fill in your own
  credentials before enabling them — the committed values are placeholders.

## 10. Versioning & Branches

- Current line: `1.0.x` — `1.0.x.20260630-SNAPSHOT`.
- CI runs `./mvnw -B clean verify` on `feature/1.0.x` (JDK 8).

## 11. Contributing & License

This wrapper is licensed under [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0.txt).
The underlying `MtOpJavaSDK` remains proprietary to Meituan (三快科技) — you must
obtain it and your developer credentials from the Meituan Open Platform yourself.
Issues and PRs are welcome at
[github.com/easy-4-java/meituan-sdk-extension](https://github.com/easy-4-java/meituan-sdk-extension).
