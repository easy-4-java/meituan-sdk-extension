package io.github.easy4j.meituan.debug;

import org.junit.jupiter.api.Tag;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptQuerylistbydate.ReceiptQueryBaseResult;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptQuerylistbydate.TuangouReceiptQuerylistbydateRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptQuerylistbydate.TuangouReceiptQuerylistbydateResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.easy4j.meituan.client.DefaultMeituanRequestExecutor;
import io.github.easy4j.meituan.client.MeituanClientFactory;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.config.MeituanConfig;
import io.github.easy4j.meituan.config.MeituanTenantConfig;
import io.github.easy4j.meituan.service.MeituanRetailService;
import io.github.easy4j.meituan.service.impl.MeituanRetailServiceImpl;
import io.github.easy4j.meituan.tenant.InMemoryMeituanTenantConfigStorage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 使用多租户 SDK 封装拉取美团验券记录。
 * <p>通过 {@link MeituanRetailService}（meituan-sdk-extension 封装）调用官方 API，
 * 演示完整的多租户配置 + 分页拉取 + 数据打印流程。</p>
 *
 * <h2>使用方法</h2>
 * <ol>
 *     <li>替换下方配置区的 {@code DEVELOPER_ID / SIGN_KEY / APP_AUTH_TOKEN}</li>
 *     <li>替换 {@code QUERY_DATE} 为要查询的日期</li>
 *     <li>运行 {@code main()} 或去掉 {@code @Disabled} 后运行测试方法</li>
 * </ol>
 *
 * <h2>该测试与 MeituanReceiptQuerylistbydateDebugTest 的区别</h2>
 * <p>本测试使用 SDK 封装层（MeituanRetailService），会经过 MeituanClientFactory →
 * MeituanRequestExecutor → MeituanRetailService 完整链路，验证多租户路由逻辑正确。</p>
 *
 * @author wandl
 */
@Tag("integration")
public class MeituanMultiTenantSdkReceiptDebugTest {

    /**
     * 创建使用多租户 SDK 封装拉取美团验券记录。的空实例。
     */
    public MeituanMultiTenantSdkReceiptDebugTest() {
    }


    // ==================== 配置区 ====================
    /**
     * 测试使用的租户标识。
     */
    private static final String TENANT_ID      = "debug-tenant";
    /**
     * 本地联调使用的美团开发者编号。
     */
    private static final Long DEVELOPER_ID     = 100000L;
    /**
     * 本地联调使用的开发者签名密钥。
     */
    private static final String SIGN_KEY        = "your-sign-key";
    /**
     * 本地联调使用的应用授权 token。
     */
    private static final String APP_AUTH_TOKEN  = "xxxx";
    /**
     * 本地联调查询的业务日期。
     */
    private static final String QUERY_DATE      = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    /**
     * 本地联调每次请求的分页大小。
     */
    private static final int PAGE_SIZE          = 300;
    // ==================== 配置区结束 ====================

    /**
     * 处理业务 JSON 的线程安全映射器。
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 运行当前调试类的官方接口联调流程。
     *
     * @param args 命令行参数
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    public static void main(String[] args) throws Exception {
        new MeituanMultiTenantSdkReceiptDebugTest().pullReceiptRecords();
    }

    /**
     * 通过多租户 SDK 封装拉取验券记录。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void pullReceiptRecords() throws Exception {
        System.out.println("========== 多租户 SDK 拉取验券记录 ==========");
        System.out.println("租户: " + TENANT_ID + "，日期: " + QUERY_DATE);
        System.out.println();

        // 1. 构建多租户 SDK 实例
        MeituanRetailService retailService = buildRetailService();

        // 2. 分页拉取
        int offset = 0;
        int totalCount = 0;
        int fetchedCount = 0;

        do {
            TuangouReceiptQuerylistbydateRequest request = buildRequest(offset);
            MeituanResponse<?> response = retailService.tuangouReceiptQuerylistbydate(request, TENANT_ID);

            if (!response.isSuccess()) {
                System.err.println("拉取失败: code=" + response.getCode()
                        + ", msg=" + response.getMsg()
                        + ", traceId=" + response.getTraceId());
                return;
            }

            TuangouReceiptQuerylistbydateResponse data = (TuangouReceiptQuerylistbydateResponse) response.getData();
            if (Objects.isNull(data)) {
                System.err.println("响应 data 为 null");
                return;
            }

            totalCount = data.getTotalCount() != null ? data.getTotalCount() : 0;
            List<ReceiptQueryBaseResult> records = data.getRecords();
            if (Objects.isNull(records) || records.isEmpty()) {
                break;
            }

            System.out.println("第 " + (offset / PAGE_SIZE + 1) + " 页，本页 " + records.size() + " 条");
            for (ReceiptQueryBaseResult record : records) {
                printRecord(record);
                fetchedCount++;
            }
            offset += PAGE_SIZE;

        } while (offset < totalCount);

        System.out.println();
        System.out.println("========== 拉取完成 ==========");
        System.out.println("总记录数: " + totalCount + "，已拉取: " + fetchedCount);
    }

    /**
     * 演示：将一条验券记录转为 JSON Map（模拟 MeituanOrderPullJobHandler 的处理流程）。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void convertRecordToMap() throws Exception {
        ReceiptQueryBaseResult record = new ReceiptQueryBaseResult();
        record.setFlowId("12345678");
        record.setReceiptCode("ABC-DEF-GHI");
        record.setDealId(999L);
        record.setDealGroupId(888L);
        record.setDealTitle("团购套餐A");
        record.setDealPrice(99.0);
        record.setVerifyTime("2026-07-03 15:30:00");
        record.setBizType(0);
        record.setRefundStatus(1);

        // 转为 Map（与 JobHandler 中 toRawJson 一致）
        @SuppressWarnings("unchecked")
        Map<String, Object> map = MAPPER.convertValue(record, Map.class);
        System.out.println("record as Map:");
        System.out.println(MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(map));

        // 模拟 orderNo 解析（与 JobHandler.resolveOrderNo 一致）
        String orderNo = resolveOrderNo(map);
        System.out.println();
        System.out.println("解析出的 orderNo: " + orderNo);
    }

    /**
     * 按本地调试配置创建带租户授权的服务零售门面。
     *
     * @return 按本地调试配置创建带租户授权的服务零售门面的结果
     */
    private MeituanRetailService buildRetailService() {
        // 平台配置（超时等）
        MeituanConfig config = new MeituanConfig();
        config.setServerUrl("https://api-open-cater.meituan.com");
        config.setCharset("UTF-8");
        config.setVersion("2");

        // 租户配置
        MeituanTenantConfig tenantConfig = new MeituanTenantConfig();
        tenantConfig.setTenantId(TENANT_ID);
        tenantConfig.setDeveloperId(DEVELOPER_ID);
        tenantConfig.setSignKey(SIGN_KEY);
        tenantConfig.setAppAuthToken(APP_AUTH_TOKEN);

        // 构建链路
        MeituanClientFactory clientFactory = new MeituanClientFactory(config);
        InMemoryMeituanTenantConfigStorage storage = new InMemoryMeituanTenantConfigStorage(
                Collections.singletonMap(TENANT_ID, tenantConfig)
        );
        MeituanRequestExecutor executor = new DefaultMeituanRequestExecutor(clientFactory, storage);
        return new MeituanRetailServiceImpl(executor);
    }

    /**
     * 构造指定偏移量的已验券码分页查询请求。
     *
     * @param offset 本页数据的起始偏移量
     * @return 构造指定偏移量的已验券码分页查询请求的结果
     */
    private TuangouReceiptQuerylistbydateRequest buildRequest(int offset) {
        TuangouReceiptQuerylistbydateRequest request = new TuangouReceiptQuerylistbydateRequest();
        request.setDate(QUERY_DATE);
        request.setOffset(offset);
        request.setLimit(PAGE_SIZE);
        request.setType(0); // 0=验券记录
        return request;
    }

    /**
     * 解析订单号（与 MeituanOrderPullJobHandler.resolveOrderNo 一致）。
     * @param order 官方订单查询返回的单条订单明细
     * @return 与请求参数对应的处理结果
     */
    private String resolveOrderNo(Map<String, Object> order) {
        Object flowId = order.get("flowId");
        if (Objects.nonNull(flowId) && !String.valueOf(flowId).isEmpty()) {
            return String.valueOf(flowId);
        }
        Object receiptCode = order.get("receiptCode");
        Object dealId = order.get("dealId");
        if (Objects.nonNull(receiptCode) && !String.valueOf(receiptCode).isEmpty()) {
            if (Objects.nonNull(dealId) && !String.valueOf(dealId).isEmpty()) {
                return "MT-" + dealId + "-" + receiptCode;
            }
            return "MT-" + receiptCode;
        }
        return "MT-" + order.hashCode();
    }

    /**
     * 输出当前验券记录的主要字段，供本地接口联调核对。
     *
     * @param record 从官方响应中读取的验券记录
     */
    private void printRecord(ReceiptQueryBaseResult record) {
        System.out.println("  flowId=" + record.getFlowId()
                + ", receiptCode=" + record.getReceiptCode()
                + ", dealId=" + record.getDealId()
                + ", dealTitle=" + record.getDealTitle()
                + ", dealPrice=" + record.getDealPrice()
                + ", verifyTime=" + record.getVerifyTime()
                + ", bizType=" + record.getBizType()
                + ", refundStatus=" + record.getRefundStatus());
    }
}
