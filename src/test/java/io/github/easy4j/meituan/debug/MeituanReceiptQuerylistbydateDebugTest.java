package io.github.easy4j.meituan.debug;

import org.junit.jupiter.api.Tag;

import com.meituan.sdk.DefaultMeituanClient;
import com.meituan.sdk.MeituanClient;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptQuerylistbydate.ReceiptQueryBaseResult;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptQuerylistbydate.TuangouReceiptQuerylistbydateRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptQuerylistbydate.TuangouReceiptQuerylistbydateResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

/**
 * 美团验券记录拉取调试测试（真实凭证）。
 * <p>调用官方 SDK {@code ddzh/tuangou/receipt/querylistbydate} 接口，
 * 按日期分页拉取门店验券记录（即订单/团购券核销明细）。</p>
 *
 * <h3>诊断记录（已通过真实环境验证）</h3>
 * <ul>
 *     <li>SDK 内部使用 <b>GSON</b> 序列化 Request，GSON 默认跳过 {@code null} 字段，
 *         因此 {@code bizType} 字段（美团 API 字段名 {@code biz}）必须显式赋非空值（如 0）。</li>
 *     <li>所有业务接口必须使用 <b>POST</b> 方法（GET 会返回 OP_HTTP_UNSUPPORTED_METHOD_TYPE）。</li>
 *     <li>必须传入有效的 {@code appAuthToken}（门店授权 token），否则返回 OP_UNIAUTH_FAILED。</li>
 *     <li>签名算法：{@code signKey + 按字典序排序的 key1value1key2value2...} → SHA1 hex 小写。</li>
 * </ul>
 *
 * <h3>使用方法</h3>
 * <ol>
 *     <li>设置环境变量（推荐用 IntelliJ Run Configuration 或 shell export）：
 *         <pre>
 * export MEITUAN_DEVELOPER_ID=100000
 * export MEITUAN_SIGN_KEY=your-sign-key
 * export MEITUAN_BUSINESS_ID=16
 * export MEITUAN_APP_AUTH_TOKEN=&lt;从美团合作中心拿到的真实门店 token&gt;
 *         </pre>
 *     </li>
 *     <li>运行 {@code main()} 或去掉 {@code @Disabled} 后运行 {@code querylistbydate()}</li>
 *     <li>输出结果会写到控制台 + （如有）{@code /tmp/meituan-receipts.json}</li>
 * </ol>
 *
 * <h3>API 文档</h3>
 * <p>https://developer.meituan.com/docs/api/ddzh-tuangou-receipt-querylistbydate</p>
 *
 * @author wandl
 */
@Tag("integration")
public class MeituanReceiptQuerylistbydateDebugTest {

    // ==================== 配置区（支持环境变量覆盖） ====================
    /** 美团开发者 ID（如 100000）。 */
    private static final Long   DEVELOPER_ID   = readLong  ("MEITUAN_DEVELOPER_ID", 100000L);
    /** 美团签名密钥（ISV 后台获取）。 */
    private static final String SIGN_KEY      = readString("MEITUAN_SIGN_KEY",     "your-sign-key");
    /** 业务 ID（ISV 后台为不同业务分配，如 团购验券=59）。 */
    private static final Integer BIZ_TYPE     = readInt   ("MEITUAN_BUSINESS_ID",  59);
    /** 门店授权 token（美团合作中心门店授权回调下发）。 */
    private static final String APP_AUTH_TOKEN = readString("MEITUAN_APP_AUTH_TOKEN", "");
    /** 查询日期（格式 yyyy-MM-dd），默认昨天。 */
    private static final String QUERY_DATE    = System.getenv().getOrDefault(
            "MEITUAN_QUERY_DATE",
            LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE));
    /** 分页大小（美团最大 300）。 */
    private static final int    PAGE_SIZE     = 300;
    /** type: 0=验券记录  1=撤销验券记录。 */
    private static final int    TYPE_CONSUME  = 0;
    // ==================== 配置区结束 ====================

    public static void main(String[] args) throws Exception {
        new MeituanReceiptQuerylistbydateDebugTest().querylistbydate();
    }

    /**
     * 分页拉取指定日期的所有验券记录并打印。
     */
    @Test
    @Disabled("手动运行：设置环境变量或填入真实凭证后去掉 @Disabled")
    void querylistbydate() throws Exception {
        if (Objects.isNull(DEVELOPER_ID) || Objects.isNull(SIGN_KEY) || SIGN_KEY.isEmpty()) {
            System.err.println("错误：请设置 MEITUAN_DEVELOPER_ID / MEITUAN_SIGN_KEY / MEITUAN_APP_AUTH_TOKEN 环境变量");
            return;
        }
        if (APP_AUTH_TOKEN.isEmpty()) {
            System.err.println("警告：MEITUAN_APP_AUTH_TOKEN 为空，将无法通过鉴权（OP_UNIAUTH_FAILED）");
            System.err.println("请先在美团合作中心完成门店授权回调，让 meituan_shop.app_auth_token 有值");
        }

        System.out.println("========== 美团验券记录拉取 ==========");
        System.out.println("日期: " + QUERY_DATE);
        System.out.println("开发者ID: " + DEVELOPER_ID);
        System.out.println("业务ID: " + BIZ_TYPE);
        System.out.println("appAuthToken 长度: " + APP_AUTH_TOKEN.length());
        System.out.println();

        MeituanClient client = DefaultMeituanClient.builder(DEVELOPER_ID, SIGN_KEY).build();

        int offset = 0;
        int totalCount = 0;
        int fetchedCount = 0;
        boolean hasMore = true;

        while (hasMore) {
            TuangouReceiptQuerylistbydateRequest request = buildRequest(offset);
            MeituanResponse<TuangouReceiptQuerylistbydateResponse> response;
            try {
                response = client.invokeApi(request, APP_AUTH_TOKEN);
            } catch (Exception e) {
                System.err.println("调用异常: " + e.getMessage());
                return;
            }

            if (!response.isSuccess()) {
                System.err.println("调用失败: code=" + response.getCode()
                        + ", msg=" + response.getMsg()
                        + ", traceId=" + response.getTraceId());
                return;
            }

            TuangouReceiptQuerylistbydateResponse data = response.getData();
            if (Objects.isNull(data)) {
                System.err.println("响应 data 为 null");
                return;
            }

            totalCount = data.getTotalCount() != null ? data.getTotalCount() : 0;
            List<ReceiptQueryBaseResult> records = data.getRecords();
            if (Objects.isNull(records) || records.isEmpty()) {
                break;
            }

            System.out.println("第 " + (offset / PAGE_SIZE + 1) + " 页，本页 " + records.size() + " 条，总记录数: " + totalCount);
            for (ReceiptQueryBaseResult record : records) {
                printRecord(record);
                fetchedCount++;
            }
            offset += PAGE_SIZE;
            hasMore = offset < totalCount;
        }

        System.out.println();
        System.out.println("========== 拉取完成 ==========");
        System.out.println("总记录数: " + totalCount);
        System.out.println("已拉取: " + fetchedCount);
    }

    private TuangouReceiptQuerylistbydateRequest buildRequest(int offset) {
        TuangouReceiptQuerylistbydateRequest request = new TuangouReceiptQuerylistbydateRequest();
        request.setDate(QUERY_DATE);
        request.setOffset(offset);
        request.setLimit(PAGE_SIZE);
        request.setType(TYPE_CONSUME);
        // ★ 关键：bizType 必须显式赋非空值（GSON 默认跳过 null 字段 → 美团 API 会校验 biz 必填）
        request.setBizType(BIZ_TYPE);
        return request;
    }

    private void printRecord(ReceiptQueryBaseResult record) {
        System.out.println("--------------------------------------------------");
        System.out.println("  flowId(流水号):       " + record.getFlowId());
        System.out.println("  receiptCode(券码):     " + record.getReceiptCode());
        System.out.println("  dealId(套餐ID):        " + record.getDealId());
        System.out.println("  dealGroupId(团购ID):   " + record.getDealGroupId());
        System.out.println("  dealTitle(商品名):     " + record.getDealTitle());
        System.out.println("  dealPrice(售价/元):    " + record.getDealPrice());
        System.out.println("  dealMarketPrice(市场价): " + record.getDealMarketPrice());
        System.out.println("  verifyTime(核销时间):  " + record.getVerifyTime());
        System.out.println("  verifyAccount(核销账号): " + record.getVerifyAccount());
        System.out.println("  verifyChannel(验证方式): " + record.getVerifyChannel());
        System.out.println("  bizType(业务类型):     " + record.getBizType());
        System.out.println("  refundStatus(退款状态): " + record.getRefundStatus());
        System.out.println("  productType(商品类型): " + record.getProductType());
        System.out.println("  productItemId:         " + record.getProductItemId());
        System.out.println("  bookVerifyGroup(预订): " + record.getBookVerifyGroup());
    }

    // ==================== 环境变量读取工具 ====================
    private static String readString(String key, String def) {
        String v = System.getenv(key);
        return (v == null || v.isEmpty()) ? def : v;
    }
    private static Long readLong(String key, Long def) {
        String v = System.getenv(key);
        if (v == null || v.isEmpty()) return def;
        try { return Long.valueOf(v); } catch (NumberFormatException e) { return def; }
    }
    private static Integer readInt(String key, Integer def) {
        String v = System.getenv(key);
        if (v == null || v.isEmpty()) return def;
        try { return Integer.valueOf(v); } catch (NumberFormatException e) { return def; }
    }
}
