# meituan-sdk-extension

[English](./README.md) | [简体中文](./README.zh-CN.md)

[![Java](https://img.shields.io/badge/Java-17-orange)](https://github.com/easy-4-java/meituan-sdk-extension) [![License](https://img.shields.io/badge/license-Apache%202.0-green)](https://www.apache.org/licenses/LICENSE-2.0.txt)

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
- **Typed business facades** — 15 service interfaces (`MeituanWaimaiService`,
  `MeituanRetailService`, …) cover all 1,148 production requests in the pinned SDK.
  `MeituanApiCoverageTest` checks these against the official JAR and excludes the `corgiTest` package.
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
| Java | 17+ |
| Spring Boot | 3.x |
| Official SDK | `com.sankuai.sjst:MtOpJavaSDK:1.0-20261112` (proprietary, see below) |
| Build | Maven 3.9 (`./mvnw` wrapper included) |

The binary, sources and POM are published in the configured Aliyun Maven release repository. Configure read credentials for `2624322-release-6F6h6R` in Maven settings. For offline installation, use the JARs extracted from Meituan’s 20261112 distribution and `libs/MtOpJavaSDK-1.0-20261112.pom`.

Use `new MeituanPlatformService(clientFactory, tenantStorage)` for OAuth token exchange and refresh, unified authorization, per-call timeouts and `commonInvokeApi`. Supply the authorization fields required by the endpoint on the official common request.

## 4. Architecture & Modules

| Package | Responsibility |
| :--- | :--- |
| `io.github.easy4j.meituan` | framework-free core: config objects, client factory, executor, services |
| `io.github.easy4j.meituan.client` | Official client factory, tenant-aware `MeituanRequestExecutor` |
| `io.github.easy4j.meituan.config` | `MeituanConfig` (platform) / `MeituanTenantConfig` (tenant) |
| `io.github.easy4j.meituan.tenant` | Tenant storage SPI, in-memory impl, cacheable decorator, `MeituanTenantContextHolder`, loader |
| `io.github.easy4j.meituan.service` | 15 business service interfaces |
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
    <version>2.0.x.20260630-SNAPSHOT</version>
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

### Callback messages and payload models

Business models live in `io.github.easy4j.meituan.callback.model.biz<businessId>` and message type enums live in `io.github.easy4j.meituan.callback.type`. When upgrading, update imports and any fully qualified class names used for reflection, then recompile the caller.

Meituan callbacks use URL-encoded common parameters and carry
the business JSON in the `message` field. The SDK provides framework-neutral
parsing, signature verification, message-type resolution, and response models:

The message rows in [the interface lists](docs/) link to their Java payload classes.
For member creation, pass `io.github.easy4j.meituan.callback.model.biz59.MemberCreatedMessage.class`.
`CallbackUtil.parse(request)` and `CallbackUtil.parse(query, body)` return a `MeituanCallbackMessage<?>`
using both `businessId` and `msgType` (or the legacy `invokeType`). Unknown combinations retain the
decoded `message` or `param` text and signing parameters. If neither field exists, the payload is null.
Business 18 also dispatches member order coupon lookup (1810057), coupon redemption (1810061), and reverse orders (1810257).
Reservation payloads expose nested JSON strings as typed objects. Some legacy formats use
`param`, `params`, or named form fields instead of `message`.

`CallbackUtil.parse(request, Payload.class)` accepts a Jakarta Servlet request.
`CallbackUtil.parse(query, body, Payload.class)` accepts a query string and a form string,
JSON envelope, decoded map, or envelope object. Both return `MeituanCallbackMessage<Payload>`
and map the business message with Jackson 2. Body parameters take precedence over query parameters.
Unknown payload properties are ignored. Invalid or missing payloads for a known model throw `IllegalArgumentException`.
Use `getParameters()` for signature verification and `getRawMessage()` to access the original message.
Object-valued JSON messages are serialized into parameter values, so their original JSON formatting
is unavailable. Verify signatures against the actual form parameters sent by the platform.
The interface tables also link to typed response data. For standard synchronous callbacks,
`MeituanCallbackResponse.successData(result)` serializes an object or list into the string-valued
`data` field. Use `successJson(json)` when the result is already JSON text. For POS coupon redemption,
the official example uses a nested object: `MeituanCallbackResponse.of(0, "ok", result)`.
Use `MeituanCallbackResponse.flashOrderSuccess()` for the Flash Order acknowledgement `{"data":"ok"}`.
The single and batch inventory callbacks with a string status code and a `msg` field use `InventoryQueryResponse`.

Use `CallbackUtil.parse(request, String.class)` or `CallbackUtil.parse(null, body, String.class)` to read the decoded message text, including its original whitespace. An absent or blank payload is rejected by these typed overloads.
Use `MeituanCallbackResponse<String>` for a string-valued response and `MeituanCallbackResponse<Payload>` for a nested object. Recompile callers after migrating.

```java
MeituanCallbackMessage<String> callback = CallbackUtil.parse(null, requestBody, String.class);
if (!MeituanCallbackSigner.verify(signKey, callback.getParameters(), callback.getSign())) {
    return MeituanCallbackResponse.failure(-2, "invalid signature");
}

return MeituanBusiness58MessageType.resolve(callback)
        .map(messageType -> switch (messageType) {
            case OPERATE_DEVICE -> MeituanCallbackResponse.successJson(
                    handleOperateDevice(callback.getMessage()));
            case START_DEVICE_AND_CONSUME_DEAL -> MeituanCallbackResponse.successJson(
                    handleStartAndConsume(callback.getMessage())); // e.g. {"result":0}
            case ORDER_REFUND_INFO_PUSHED -> {
                handleRefundNotification(callback.getMessage());
                yield MeituanCallbackResponse.success();
            }
            default -> MeituanCallbackResponse.failure(-1, "unsupported msgType");
        })
        .orElseGet(() -> MeituanCallbackResponse.failure(-1, "unsupported msgType"));
```

The message type enums cover all 282 registered identifiers across 27 businesses in `MeituanCallbackModels`.
Each business has a `MeituanBusiness<businessId>MessageType` enum. `resolve(callback)` checks both identifiers,
and `fromMsgType(msgType)` looks up a type within that business.
Each enum entry defines its name, message ID, document URL and `messageClass`.
`MeituanCallbackModels` derives its immutable index from these entries, so adding a callback to an existing business requires one enum entry.
For a new business, connect its enum to the registry’s business catalogue. `MeituanCallbackModels.all()` exposes the registered definitions.

For consumption record changes (5910023), the capability directory confirms the ID.
The SDK returns the original `message` string because the linked page provides no field definitions.
`MeituanBusiness71MessageType` contains the documented Store Direct Connection
audit-result callback: capability `poi_openapi_msg_push`, `msgType=7110001`.
The five business 71 APIs are declared `needAuth=false`; `MeituanStoreService`
selects the tenant's developer credentials while invoking them without an
`appAuthToken`.
Custom `MeituanRequestExecutor` implementations must override
`executeWithoutAuth(request, tenantId)` to preserve tenant isolation; the
default method fails closed instead of silently ignoring `tenantId`.

The callback utilities cover the transport protocol, not business-side delivery
semantics. Consumers must persist and deduplicate `msgId` before executing
side effects, and enforce the callback timestamp window required by their
Meituan agreement. Domain payload validation, retry policy, and business actions
remain the application's responsibility.

## 9. Testing & Build

```bash
./mvnw -B clean verify
```

- Unit tests run with JUnit 6 + Mockito (38 tests).
- Live-API debug tests live in `io.github.easy4j.meituan.debug`, tagged
  `@Tag("integration")` and excluded from normal builds. Fill in your own
  credentials before enabling them — the committed values are placeholders.

## 10. Versioning & Branches

- Current line: `2.0.x` — `2.0.x.20260630-SNAPSHOT`.
- CI runs `./mvnw -B clean verify` on `feature/2.0.x` (JDK 17).

## 11. Contributing & License

This wrapper is licensed under [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0.txt).
The underlying `MtOpJavaSDK` remains proprietary to Meituan (三快科技) — you must
obtain it and your developer credentials from the Meituan Open Platform yourself.
Issues and PRs are welcome at
[github.com/easy-4-java/meituan-sdk-extension](https://github.com/easy-4-java/meituan-sdk-extension).


### Jakarta compatibility (2.0.x, 2026-10-21)

`2.0.x.20260630-SNAPSHOT` is the Java 17 / Jackson 2 / Jakarta Validation line,
consumed by `meituan-spring-boot-starter:3.5.x.20260630-SNAPSHOT`.
The existing extension artifact packages the official SDK after converting only
`javax.validation` references to `jakarta.validation`; its own DTOs also use Jakarta.
No additional business-service compatibility module is required. The 1.0.x extension
and 2.7.x starter retain javax; the separate 3.0.x / Jackson 3 line is unchanged.

The immutable build input is `com.sankuai.sjst:MtOpJavaSDK:1.0-20261112`
(SHA-256 `144ed5569a112b1c27de3b9b3d5a237781c593823a73268623832fb28863250c`).
Builds reject a mismatched input. Provenance is recorded in
`META-INF/easy4j/meituan-sdk-origin.properties`. Do not also depend on the raw SDK
or add javax Validation/Hibernate Validator 6 to a Jakarta application's runtime.
API coverage tests enumerate the original reference SDK and execute the transformed
classes; signature implementation and all original classes are preserved.

Run `mvn clean verify -DskipTests=false -Dmaven.test.skip=false` with JDK 17+.
`tools/verify_jakarta_artifact.py` accepts `--original-sdk`, `--sdk-artifact`
(the built extension JAR) and `--application-jar` (a consumer Boot JAR), and checks
class preservation, minimal conversion, signature bytes and a single runtime SDK.
