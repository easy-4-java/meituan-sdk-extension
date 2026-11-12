package io.github.easy4j.meituan.debug;

import org.junit.jupiter.api.Tag;

import com.meituan.sdk.DefaultMeituanClient;
import com.meituan.sdk.MeituanClient;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptConsume.ReceiptConsumeResult;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptConsume.TuangouReceiptConsumeRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptConsume.TuangouReceiptConsumeResponse;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptPrepare.TuangouReceiptPrepareRequest;
import com.meituan.sdk.model.ddzh.tuangou.tuangouReceiptPrepare.TuangouReceiptPrepareResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * 美团购券准备 + 核销调试测试。
 * <p>覆盖团购验券完整流程：prepare（输码验券校验）→ consume（验券核销）。</p>
 *
 * <h2>使用方法</h2>
 * <ol>
 *     <li>替换下方 {@code DEVELOPER_ID / SIGN_KEY / APP_AUTH_TOKEN} 为真实凭证</li>
 *     <li>替换 {@code RECEIPT_CODE} 为要验券的真实券码</li>
 *     <li>先运行 {@code main()} 或去掉 {@code @Disabled} 后运行 {@code prepareAndConsume()}</li>
 *     <li>prepare 成功后会自动调 consume 完成核销</li>
 * </ol>
 *
 * <h2>API 文档</h2>
 * <ul>
 *     <li>验券准备：https://developer.meituan.com/docs/api/ddzh-tuangou-receipt-prepare</li>
 *     <li>验券核销：https://developer.meituan.com/docs/api/ddzh-tuangou-receipt-consume</li>
 * </ul>
 *
 * <h2>验券流程说明</h2>
 * <pre>
 *   用户输入券码
 *       ↓
 *   ① prepare（输码验券校验）
 *       ├─ 返回：orderId、receiptCode、dealId、dealTitle、count、mobile 等
 *       └─ 若券码无效/已核销 → 返回错误码
 *       ↓
 *   ② consume（验券核销）
 *       ├─ requestId = prepare 返回的 orderId（幂等）
 *       ├─ appShopAccount / appShopAccountName 为操作员信息（仅记录）
 *       └─ 返回：flowId（流水号）、orderId、receiptCode、dealId 等
 * </pre>
 *
 * @author wandl
 */
@Tag("integration")
public class MeituanReceiptPrepareAndConsumeDebugTest {

    /**
     * 创建\u7f8e\u56e2\u8d2d\u5238\u51c6\u5907 + \u6838\u9500\u8c03\u8bd5\u6d4b\u8bd5\u3002的空实例。
     */
    public MeituanReceiptPrepareAndConsumeDebugTest() {
    }


    // ==================== 配置区 ====================
    // 替换为真实凭证
    /**
     * 本地联调使用的美团开发者编号。
     */
    private static final Long DEVELOPER_ID   = 100000L;
    /**
     * 本地联调使用的开发者签名密钥。
     */
    private static final String SIGN_KEY      = "your-sign-key";
    /**
     * 本地联调使用的应用授权 token。
     */
    private static final String APP_AUTH_TOKEN = "xxxx";
    // 要验券的券码（必填）
    /**
     * 本地联调使用的券码。
     */
    private static final String RECEIPT_CODE  = "替换为真实券码";
    // 操作员信息（仅记录用，不影响验券逻辑）
    /**
     * 本地联调使用的 ERP 标识。
     */
    private static final String ERP_ID   = "admin";
    /**
     * 本地联调使用的 ERP 名称。
     */
    private static final String ERP_NAME  = "管理员";
    // ==================== 配置区结束 ====================

    /**
     * 运行当前调试类的官方接口联调流程。
     *
     * @param args 命令行参数
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    public static void main(String[] args) throws Exception {
        new MeituanReceiptPrepareAndConsumeDebugTest().prepareAndConsume();
    }

    /**
     * 完整验券流程：prepare → consume。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    @Disabled("手动运行：替换真实凭证和券码后去掉 @Disabled")
    void prepareAndConsume() throws Exception {
        System.out.println("========== 美团验券流程 ==========");
        System.out.println("券码: " + RECEIPT_CODE);
        System.out.println();

        MeituanClient client = DefaultMeituanClient.builder(DEVELOPER_ID, SIGN_KEY).build();

        // ====== Step 1: 验券准备 ======
        System.out.println(">>> Step 1: 验券准备（prepare）");
        TuangouReceiptPrepareResponse prepareResult = doPrepare(client);
        if (prepareResult == null) {
            System.err.println("prepare 失败，流程终止");
            return;
        }
        System.out.println();

        // ====== Step 2: 验券核销 ======
        System.out.println(">>> Step 2: 验券核销（consume）");
        String requestId = prepareResult.getOrderId();
        if (Objects.isNull(requestId) || requestId.isEmpty()) {
            requestId = UUID.randomUUID().toString();
            System.out.println("prepare 未返回 orderId，使用随机 UUID 作为 requestId: " + requestId);
        } else {
            System.out.println("使用 prepare 返回的 orderId 作为 requestId: " + requestId);
        }
        doConsume(client, requestId);

        System.out.println();
        System.out.println("========== 验券流程完成 ==========");
    }

    // ==================== Prepare ====================

    /**
     * 使用调试配置发起验券准备，并返回官方响应。
     *
     * @param client 为当前开发者创建的官方客户端
     * @return 使用调试配置发起验券准备，并返回官方响应的结果
     */
    private TuangouReceiptPrepareResponse doPrepare(MeituanClient client) {
        TuangouReceiptPrepareRequest request = new TuangouReceiptPrepareRequest();
        request.setReceiptCode(RECEIPT_CODE);

        MeituanResponse<TuangouReceiptPrepareResponse> response;
        try {
            response = client.invokeApi(request, APP_AUTH_TOKEN);
        } catch (Exception e) {
            System.err.println("  prepare 调用异常: " + e.getMessage());
            return null;
        }

        System.out.println("  success: " + response.isSuccess());
        System.out.println("  code:    " + response.getCode());
        System.out.println("  msg:     " + response.getMsg());
        System.out.println("  traceId: " + response.getTraceId());

        if (!response.isSuccess()) {
            System.err.println("  验券准备失败: " + response.getMsg());
            return null;
        }

        TuangouReceiptPrepareResponse data = response.getData();
        if (data == null) {
            System.err.println("  响应 data 为 null");
            return null;
        }

        System.out.println("  ----- 验券准备结果 -----");
        System.out.println("  orderId(订单ID):       " + data.getOrderId());
        System.out.println("  receiptCode(券码):     " + data.getReceiptCode());
        System.out.println("  count(可验证张数):     " + data.getCount());
        System.out.println("  dealId(套餐ID):        " + data.getDealId());
        System.out.println("  dealGroupId(团购ID):   " + data.getDealGroupId());
        System.out.println("  dealTitle(商品名):     " + data.getDealTitle());
        System.out.println("  dealPrice(售价/元):    " + data.getDealPrice());
        System.out.println("  dealMarketPrice(市场价): " + data.getDealMarketPrice());
        System.out.println("  mobile(手机号):        " + data.getMobile());
        System.out.println("  bizType(业务类型):     " + data.getBizType());
        System.out.println("  productType(商品类型): " + data.getProductType());
        System.out.println("  productItemId:         " + data.getProductItemId());
        System.out.println("  receiptEndDate(券过期): " + data.getReceiptEndDate());
        System.out.println("  verificationType(适用时间): " + data.getVerificationType());

        return data;
    }

    // ==================== Consume ====================

    /**
     * 使用验券准备返回的请求标识发起正式验券。
     *
     * @param client 为当前开发者创建的官方客户端
     * @param requestId 验券准备接口返回的请求标识
     */
    private void doConsume(MeituanClient client, String requestId) {
        TuangouReceiptConsumeRequest request = new TuangouReceiptConsumeRequest();
        request.setReceiptCode(RECEIPT_CODE);
        request.setCount(1);
        request.setRequestId(requestId);
        request.setAppShopAccount(ERP_ID);
        request.setAppShopAccountName(ERP_NAME);

        MeituanResponse<TuangouReceiptConsumeResponse> response;
        try {
            response = client.invokeApi(request, APP_AUTH_TOKEN);
        } catch (Exception e) {
            System.err.println("  consume 调用异常: " + e.getMessage());
            return;
        }

        System.out.println("  success: " + response.isSuccess());
        System.out.println("  code:    " + response.getCode());
        System.out.println("  msg:     " + response.getMsg());
        System.out.println("  traceId: " + response.getTraceId());

        if (!response.isSuccess()) {
            System.err.println("  验券核销失败: " + response.getMsg());
            return;
        }

        TuangouReceiptConsumeResponse data = response.getData();
        if (data == null || data.getResult() == null || data.getResult().isEmpty()) {
            System.err.println("  响应 data/result 为空");
            return;
        }

        List<ReceiptConsumeResult> results = data.getResult();
        System.out.println("  ----- 核销结果（共 " + results.size() + " 条）-----");
        for (int i = 0; i < results.size(); i++) {
            ReceiptConsumeResult r = results.get(i);
            System.out.println("  [" + (i + 1) + "]");
            System.out.println("    flowId(流水号):       " + r.getFlowId());
            System.out.println("    orderId(订单ID):      " + r.getOrderId());
            System.out.println("    receiptCode(券码):     " + r.getReceiptCode());
            System.out.println("    dealId(套餐ID):        " + r.getDealId());
            System.out.println("    dealGroupId(团购ID):   " + r.getDealGroupId());
            System.out.println("    dealTitle(商品名):     " + r.getDealTitle());
            System.out.println("    dealPrice(售价/元):    " + r.getDealPrice());
            System.out.println("    dealMarketPrice(市场价): " + r.getDealMarketPrice());
            System.out.println("    mobile(手机号):        " + r.getMobile());
            System.out.println("    bizType(业务类型):     " + r.getBizType());
            System.out.println("    productType(商品类型): " + r.getProductType());
            System.out.println("    productItemId:         " + r.getProductItemId());
            System.out.println("    buyTime(购买时间):     " + r.getBuyTime());
            System.out.println("    receiptEndDate(券过期): " + r.getReceiptEndDate());
        }
    }
}
