package io.github.easy4j.meituan.debug;

import org.junit.jupiter.api.Tag;

import com.meituan.sdk.DefaultMeituanClient;
import com.meituan.sdk.MeituanClient;
import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.ddzhkh.dingdan.orderQueryorder.OrderQueryorderRequest;
import com.meituan.sdk.model.ddzhkh.dingdan.orderQueryorder.OrderQueryorderResponse;
import com.meituan.sdk.model.ddzhkh.dingdan.orderQueryorder.ResultSub;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

/**
 * 官方 MtOpJavaSDK 原始调用调试。
 * <p>该类不经过 meituan-sdk-extension 的多租户封装，只验证官方 SDK 直连调用。</p>
 */
@Tag("integration")
public class MeituanOfficialSdkOrderQueryorderDebugTest {

    /**
     * 创建官方 MtOpJavaSDK 原始调用调试。的空实例。
     */
    public MeituanOfficialSdkOrderQueryorderDebugTest() {
    }


    /**
     * 本地联调使用的美团开发者编号。
     */
    private static final Long DEVELOPER_ID = 100000L;
    /**
     * 本地联调使用的开发者签名密钥。
     */
    private static final String SIGN_KEY = "your-sign-key";
    /**
     * 本地联调使用的应用授权 token。
     */
    private static final String APP_AUTH_TOKEN = "xxxx";

    /**
     * 运行当前调试类的官方接口联调流程。
     *
     * @param args 命令行参数
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    public static void main(String[] args) throws Exception {
        new MeituanOfficialSdkOrderQueryorderDebugTest().queryOrder();
    }

    /**
     * 按调试配置查询官方订单，并输出返回结果。
     * @throws Exception 当请求读取、数据转换或接口检查失败时
     */
    @Test
    void queryOrder() throws Exception {
        MeituanClient meituanClient = DefaultMeituanClient.builder(DEVELOPER_ID, SIGN_KEY).build();

        OrderQueryorderRequest orderQueryorderRequest = new OrderQueryorderRequest();
        orderQueryorderRequest.setOrderType(1);
        orderQueryorderRequest.setAddTimeFrom(1765337402000L);
        orderQueryorderRequest.setAddTimeTo(1765337404000L);
        orderQueryorderRequest.setBuySuccessTimeFrom(1765338604000L);
        orderQueryorderRequest.setBuySuccessTimeTo(1765338605000L);
        orderQueryorderRequest.setPageNo(1);
        orderQueryorderRequest.setPageSize(20);

        MeituanResponse<OrderQueryorderResponse> response = meituanClient.invokeApi(
                orderQueryorderRequest,
                APP_AUTH_TOKEN
        );

        printResponse(response);
    }

    /**
     * 输出官方订单查询的状态码与业务数据。
     *
     * @param response 预设或实际接收到的接口响应
     */
    private void printResponse(MeituanResponse<OrderQueryorderResponse> response) {
        if (Objects.isNull(response)) {
            System.out.println("response is null");
            return;
        }

        System.out.println("success: " + response.isSuccess());
        System.out.println("code: " + response.getCode());
        System.out.println("msg: " + response.getMsg());
        System.out.println("traceId: " + response.getTraceId());
        System.out.println("data: " + response.getData());

        OrderQueryorderResponse data = response.getData();
        if (Objects.isNull(data) || Objects.isNull(data.getResult())) {
            return;
        }

        List<ResultSub> result = data.getResult();
        System.out.println("result size: " + result.size());
        result.forEach(System.out::println);
    }
}
