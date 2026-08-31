# meituan-sdk-extension

[English](./README.md) | [简体中文](./README.zh-CN.md)

[![Java](https://img.shields.io/badge/Java-8-orange)](https://github.com/easy-4-java/meituan-sdk-extension) [![License](https://img.shields.io/badge/license-Apache%202.0-green)](https://www.apache.org/licenses/LICENSE-2.0.txt)

> 美团开放平台的 Java 扩展 SDK：基于官方 `MtOpJavaSDK` 的多租户封装，提供类型化
> 业务门面、租户感知的请求执行与 Spring Boot 自动装配。

## 目录

- [1. 项目概述](#1-项目概述)
- [2. 功能与状态](#2-功能与状态)
- [3. 环境要求与兼容性](#3-环境要求与兼容性)
- [4. 架构与模块](#4-架构与模块)
- [5. 安装](#5-安装)
- [6. 快速开始](#6-快速开始)
- [7. 配置](#7-配置)
- [8. 核心用法 / API](#8-核心用法--api)
- [9. 测试与构建](#9-测试与构建)
- [10. 版本与分支](#10-版本与分支)
- [11. 贡献与许可](#11-贡献与许可)

## 1. 项目概述

`meituan-sdk-extension` 是在美团官方开放平台 SDK（`com.sankuai.sjst:MtOpJavaSDK`）
之上的 Java 扩展层，让一个服务端应用可以同时对接多个美团开发者账号 / 门店：

- **原生多租户** — 每个租户持有独立的 `developerId` / `signKey` /
  `appAuthToken`；官方 `MeituanClient` 按租户密钥创建并缓存
  （`ConcurrentHashMap`，缓存 key 为 `developerId:signKey哈希`，
  避免 `signKey` 原文泄露到日志）。
- **租户级执行** — 业务调用只需传 `tenantId`，执行器从可插拔的
  `MeituanTenantConfigStorage` 解析租户凭据后委托官方 client 发起请求。
- **类型化业务门面** — 14 个 service 接口（`MeituanWaimaiService`、
  `MeituanRetailService` 等），覆盖从官方 SDK 抽取的 1106 个强类型业务方法。
- **可选 Spring Boot starter** — 配套的
  [meituan-spring-boot-starter](https://github.com/easy-4-java/meituan-spring-boot-starter)
  完成配置绑定、租户存储、client 工厂、执行器与全部业务 service 的装配；
  本核心保持无框架依赖。

它不是：

- 不是官方 SDK 的替代品 — 底层直接使用 `com.meituan.sdk.*` 类型。
- 不绑定具体租户存储 — 默认内存实现，实现 `MeituanTenantConfigStorage`
  即可接入数据库或配置中心。

## 2. 功能与状态

| 能力 | 状态 |
| :--- | :--- |
| 多租户密钥模型（每租户独立 `developerId` / `signKey`） | ✅ |
| 按租户创建并缓存官方 client | ✅ |
| 租户存储 SPI + 内存实现 + 可缓存装饰器 | ✅ |
| 租户上下文（ThreadLocal `tenantId`） | ✅ |
| 业务门面：餐饮、到店餐饮、配送、分销、免费试、客满满、快驴、直播、支付、零售、门店、工具、酒旅、外卖 | ✅ |
| 可选 Spring Boot starter（`meituan-spring-boot-starter`，每个 Boot 2.3–4.1 版本线一条分支） | ✅ |
| 异常转换保留官方错误码 | ✅ |

## 3. 环境要求与兼容性

| 依赖 | 版本 |
| :--- | :--- |
| Java | 1.8+ |
| Spring Boot | 3.x（自动装配 API 兼容 Boot 2.7+） |
| 官方 SDK | `com.sankuai.sjst:MtOpJavaSDK:1.0-SNAPSHOT`（专有发行物，见下） |
| 构建 | Maven 3.9.16（已含 `./mvnw` wrapper） |

> **官方 SDK 获取** — `MtOpJavaSDK` 由美团技术服务合作中心发行
> （[SDK 下载](https://developer.meituan.com/sdk-download)），**未发布到
> Maven Central**。官方 jar 连同其官方 POM 已随仓库附带在 `libs/` 下，CI 构建
> 前会自动安装到本地仓库；本地开发也可通过 POM 声明的私有快照仓库解析（需白名单
> 凭据），或手动安装：
>
> ```bash
> mvn install:install-file -Dfile=libs/MtOpJavaSDK-1.0-SNAPSHOT.jar \
>     -DpomFile=libs/MtOpJavaSDK-1.0-SNAPSHOT.pom
> ```

## 4. 架构与模块

| Package | 职责 |
| :--- | :--- |
| `io.github.easy4j.meituan` | 无框架核心：配置对象、client 工厂、执行器、业务 service |
| `io.github.easy4j.meituan.client` | 官方 client 工厂、租户感知的 `MeituanRequestExecutor` |
| `io.github.easy4j.meituan.config` | `MeituanConfig`（平台级）/ `MeituanTenantConfig`（租户级） |
| `io.github.easy4j.meituan.tenant` | 租户存储 SPI、内存实现、缓存装饰器、`MeituanTenantContextHolder`、加载器 |
| `io.github.easy4j.meituan.service` | 14 个业务 service 接口 |
| `io.github.easy4j.meituan.service.impl` | 业务 service 实现 |
| `io.github.easy4j.meituan.exception` | `MeituanJavaException` 异常转换 |

调用链：

```
业务 service ──> MeituanRequestExecutor ──> MeituanTenantConfigStorage（解析租户）
                      │
                      └──> MeituanClientFactory（按租户缓存）──> com.meituan.sdk.MeituanClient
```

## 5. 安装

```xml
<dependency>
    <groupId>io.github.easy4j</groupId>
    <artifactId>meituan-sdk-extension</artifactId>
    <version>1.0.x.20260630-SNAPSHOT</version>
</dependency>
```

Spring Boot 服务请搭配 starter 使用
（[meituan-spring-boot-starter](https://github.com/easy-4-java/meituan-spring-boot-starter)），
一个依赖即可自动装配 `MeituanConfig`、`MeituanTenantConfigStorage`、
`MeituanClientFactory`、`MeituanRequestExecutor` 与全部 `Meituan*Service`。

## 6. 快速开始

1. 引入依赖（见上）。
2. 至少配置一个租户（见下）。
3. 注入 service 并携带租户标识调用：

```java
@Service
public class OrderService {

    private final MeituanWaimaiService waimaiService;

    public OrderService(MeituanWaimaiService waimaiService) {
        this.waimaiService = waimaiService;
    }

    public MeituanResponse<?> queryOrder(String orderId, String tenantId) {
        OrderQueryByIdRequest request = new OrderQueryByIdRequest();
        // ... 填充请求参数
        return waimaiService.orderQueryById(request, tenantId);
    }
}
```

## 7. 配置

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

顶层 key 是所有租户共享的客户端默认值；每个租户携带自己的开发者密钥与门店 token。

## 8. 核心用法 / API

携带租户标识调用业务 service：

```java
MeituanResponse<?> response = retailService.orderQueryorder(request, "tenant-a");
```

或直接使用通用执行器：

```java
MeituanResponse<Foo> response = executor.execute(request, "tenant-a");
MeituanResponse<Bar> anon = executor.executeWithoutAuth(noAuthRequest);
```

自定义租户存储（例如从数据库加载）：

```java
@Bean
MeituanTenantConfigStorage meituanTenantConfigStorage(TenantRepository repository) {
    return tenantId -> repository.findByTenantId(tenantId);
}
```

为远程存储叠加本地缓存：

```java
MeituanTenantConfigStorage cached = new CachedMeituanTenantConfigStorage(remoteStorage);
```

## 9. 测试与构建

```bash
./mvnw -B clean verify
```

- 单元测试基于 JUnit 6 + Mockito（15 个用例）。
- 真实联调 debug 测试位于 `io.github.easy4j.meituan.debug`，标注
  `@Tag("integration")`，常规构建自动排除。启用前请替换为你自己的凭据 ——
  仓库中提交的均为占位符。

## 10. 版本与分支

- 当前版本线：`1.0.x` — `1.0.x.20260630-SNAPSHOT`。
- CI 在 `feature/1.0.x` 分支执行 `./mvnw -B clean verify`（JDK 8）。

## 11. 贡献与许可

本封装层基于 [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0.txt)
开源。底层 `MtOpJavaSDK` 仍为美团（三快科技）专有软件 —— 请自行从美团开放平台
获取 jar 与开发者凭据。欢迎在
[github.com/easy-4-java/meituan-sdk-extension](https://github.com/easy-4-java/meituan-sdk-extension)
提交 Issue 与 PR。
