# meituan-sdk-extension

[English](./README.md) | [简体中文](./README.zh-CN.md)

[![Java](https://img.shields.io/badge/Java-21-orange)](https://github.com/easy-4-java/meituan-sdk-extension) [![License](https://img.shields.io/badge/license-Apache%202.0-green)](https://www.apache.org/licenses/LICENSE-2.0.txt)

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
  `MeituanRetailService` 等），覆盖从官方 SDK 抽取的 1106 个强类型业务方法（官方测试包 `corgiTest` 按设计排除；覆盖度由 `MeituanApiCoverageTest` 自动断言）。
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
| Java | 21+ |
| Spring Boot | 4.x（自动装配 API 兼容 Boot 2.7+） |
| 官方 SDK | `com.sankuai.sjst:MtOpJavaSDK:1.0-20260923`（专有发行物，见下） |
| 构建 | Maven 4（已含 `./mvnw` wrapper） |

> **官方 SDK 获取** — `MtOpJavaSDK` 由美团技术服务合作中心发行
> （[SDK 下载](https://developer.meituan.com/sdk-download)），**未发布到
> Maven Central**。官方 jar 与不可变坐标 POM 已随仓库附带在 `libs/` 下，CI 构建
> 前会自动安装到本地仓库；本地开发也需要执行一次相同的安装：
>
> ```bash
> mvn install:install-file -Dfile=libs/MtOpJavaSDK-1.0-SNAPSHOT.jar \
>     -DpomFile=libs/MtOpJavaSDK-1.0-20260923.pom
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
    <version>3.0.x.20260831-SNAPSHOT</version>
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

为远程/配置中心存储叠加带 TTL 的本地缓存：

```java
// TTL 10 分钟：过期后从加载器重新加载
MeituanTenantConfigStorage cached = new CachedMeituanTenantConfigStorage(
        tenantId -> repository.findByTenantId(tenantId), Duration.ofMinutes(10));

// 授权回调后立即把最新凭据推入缓存
cachedStorage.put("tenant-a", freshConfig);   // 覆盖缓存
cachedStorage.refresh("tenant-a");            // 强制从加载器重载
cachedStorage.evict("tenant-a");              // 清除单个条目
```

> **token 生命周期责任** —— `appAuthToken` 的刷新由调用方负责：
> 实现 `MeituanTenantConfigLoader` 从你的存储返回**当前有效** token，
> 取一个短于 token 有效期的 TTL，或在 token 轮换任务里调用
> `put`/`refresh`。SDK 自身不做 token 刷新。

### 消息回调与业务模型

业务模型位于 `io.github.easy4j.meituan.callback.model.biz<业务ID>`，消息类型枚举位于 `io.github.easy4j.meituan.callback.type`。从旧版升级时，请更新引用这些类型的 import 和反射使用的全限定类名，并重新编译调用方。

businessId=58/59/71 的消息使用 URL-encoded 公共参数，并在 `message` 字段中携带业务 JSON。
SDK 使用 Jackson 3 将业务 JSON 转为 `MeituanCallbackMessage<T>`，可显式指定模型，也可按业务 ID 和消息类型自动选择模型。
Servlet 入口使用 `jakarta.servlet.http.HttpServletRequest`，由宿主 Web 容器提供 Servlet API。

```java
import io.github.easy4j.meituan.callback.model.biz59.MemberCreatedMessage;

MeituanCallbackMessage<MemberCreatedMessage> callback =
        CallbackUtil.parse(request, MemberCreatedMessage.class);
// 或将查询串与正文分别传入。正文支持表单字符串、JSON 信封、Map 和信封对象。
MeituanCallbackMessage<MemberCreatedMessage> parsed =
        CallbackUtil.parse(query, body, MemberCreatedMessage.class);
MemberCreatedMessage member = parsed.getMessage();
```

各业务的接口清单在消息行提供「消息模型」和已定义的「响应模型」源码链接。
`CallbackUtil.parse(request)` 和 `CallbackUtil.parse(query, body)` 返回 `MeituanCallbackMessage<?>`，
按 `businessId` 与 `msgType`（旧会员卡为 `invokeType`）共同匹配。
未登记的组合保留 `message` 或 `param` 原文及全部验签参数；没有这两个字段时业务内容为空。
餐饮系统智能版的会员订单可用券列表（1810057）、会员优惠券核销（1810061）和逆向单消息（1810257）均支持自动解析。
标准消息从 `message` 读取，历史会员卡从 `param` 读取。闪惠订单使用 `params`，部分外卖旧协议直接使用表单字段。
正文同名字段优先于查询串，未知业务字段会被忽略。
原始表单参数保留在 `getParameters()` 中，原始业务 JSON 可通过 `getRawMessage()` 获取，验签使用原始参数。
JSON 对象型 `message` 会被序列化为参数值，无法保留其输入 JSON 的空白与格式，应按平台实际发送的表单验签。
解析已知模型时，缺少消息、无效 JSON、类型转换失败或请求读取失败会抛出 `IllegalArgumentException`。
预订新订单模型将字符串形式的 `data` 和 `requirements` 映射为嵌套对象，可调用 `getData().getRequirements().getRemark()` 读取备注。使用自定义模型并声明为 `String` 时仍保留原文。

标准同步响应使用 `MeituanCallbackResponse.successData(result)`，Jackson 会将对象或列表写入外层的字符串字段 `data`。
已有 JSON 文本可传给 `successJson(json)`。例如预订拒单可按下面的方式返回。

```java
ReservationOrderDecision decision = new ReservationOrderDecision();
decision.setResult(2);
decision.setRejectReason(2); // 该桌型已订满
return MeituanCallbackResponse.successData(decision);
```

智能版会员券核销的官网示例直接嵌套业务对象，使用 `new MeituanObjectCallbackResponse<>(0, "ok", result)`。
闪惠接收订单推送使用 `MeituanCallbackResponse.flashOrderSuccess()`，返回 `{"data":"ok"}`。
服务零售「单个查询库存」和「批量获取库存」使用 `InventoryQueryResponse`，其返回码为字符串，说明字段名为 `msg`。

现有 `MeituanCallbackParser` 返回 `MeituanCallbackMessage<String>`，继续支持原始字符串处理方式。
`MeituanCallbackMessage` 已泛型化，显式声明为原始类型的调用方应补上 `<String>` 或业务类型，并重新编译。

```java
MeituanCallbackMessage<String> callback = MeituanCallbackParser.parseForm(requestBody);
if (!MeituanCallbackSigner.verify(signKey, callback.getParameters(), callback.getSign())) {
    return MeituanCallbackResponse.failure(-2, "invalid signature");
}

return MeituanBusiness58MessageType.resolve(callback)
        .map(messageType -> switch (messageType) {
            case OPERATE_DEVICE -> MeituanCallbackResponse.successJson(
                    handleOperateDevice(callback.getMessage()));
            case START_DEVICE_AND_CONSUME_DEAL -> MeituanCallbackResponse.successJson(
                    handleStartAndConsume(callback.getMessage())); // 例如 {"result":0}
            case ORDER_REFUND_INFO_PUSHED -> {
                handleRefundNotification(callback.getMessage());
                yield MeituanCallbackResponse.success();
            }
        })
        .orElseGet(() -> MeituanCallbackResponse.failure(-1, "unsupported msgType"));
```

`MeituanBusiness58MessageType` 保留原有 3 项枚举。其他已登记消息可通过 `MeituanCallbackModels` 查询，包括次月扣款查询（5810239）和取消连续包月通知（5810241）。
`MeituanBusiness59MessageType` 收录 34 项已核实编号的消息，解析时校验 `businessId=59`。
“消费流水变更”（5910023）的编号来自官网能力目录。消息详情未返回字段定义，SDK 保留 `message` 原文。
`MeituanBusiness71MessageType` 收录门店建店直连的“审核结果通知”：能力名称
`poi_openapi_msg_push`、`msgType=7110001`。四个 businessId=71 API 的官方元数据均为
`needAuth=false`；`MeituanStoreService` 会按租户选择开发者凭据，但调用时不携带
`appAuthToken`。
自定义 `MeituanRequestExecutor` 必须覆盖 `executeWithoutAuth(request, tenantId)`
以保证租户隔离；接口默认实现采用 fail-closed，不会静默忽略 `tenantId`。

上述工具覆盖的是传输协议，不替代业务侧的投递语义保障。调用方必须在执行设备启动、
核销、退款等副作用前持久化 `msgId` 并做幂等去重，同时按与美团约定的协议校验回调
时间窗口；业务消息体校验、重试策略和领域动作仍由接入应用负责。

## 9. 测试与构建

```bash
./mvnw -B clean verify
```

- 单元测试基于 JUnit 6 + Mockito（38 个用例）。
- 真实联调 debug 测试位于 `io.github.easy4j.meituan.debug`，标注
  `@Tag("integration")`，常规构建自动排除。启用前请替换为你自己的凭据 ——
  仓库中提交的均为占位符。

## 10. 版本与分支

- 当前版本线：`3.0.x` — `3.0.x.20260831-SNAPSHOT`。
- CI 在 `feature/3.0.x` 分支执行 `./mvnw -B clean verify`（JDK 21）。

## 11. 贡献与许可

本封装层基于 [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0.txt)
开源。底层 `MtOpJavaSDK` 仍为美团（三快科技）专有软件 —— 请自行从美团开放平台
获取 jar 与开发者凭据。欢迎在
[github.com/easy-4-java/meituan-sdk-extension](https://github.com/easy-4-java/meituan-sdk-extension)
提交 Issue 与 PR。
