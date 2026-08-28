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

    private static final Long DEVELOPER_ID = 100000L;
    private static final String SIGN_KEY = "your-sign-key";
    private static final String APP_AUTH_TOKEN = "xxxx";

    public static void main(String[] args) throws Exception {
        new MeituanOfficialSdkOrderQueryorderDebugTest().queryOrder();
    }

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
