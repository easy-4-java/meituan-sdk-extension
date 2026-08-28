package io.github.easy4j.meituan.service;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiBusinessPoiCommonProductApply.ZcmopenApiBusinessPoiCommonProductApplyRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiBusinessPoiCommonProductQuery.ZcmopenApiBusinessPoiCommonProductQueryRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiCommonBankAll.ZcmopenApiCommonBankAllRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiCommonBankBranch.ZcmopenApiCommonBankBranchRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiCommonCatelist.ZcmopenApiCommonCatelistRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiCommonCitylist.ZcmopenApiCommonCitylistRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiCommonImageUpload.ZcmopenApiCommonImageUploadRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiCommonLocation.ZcmopenApiCommonLocationRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiFinancePaychannelQuery.ZcmopenApiFinancePaychannelQueryRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiFinancePaymentQuery.ZcmopenApiFinancePaymentQueryRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiFinanceSettleQuery.ZcmopenApiFinanceSettleQueryRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiFinanceSettleQueryByid.ZcmopenApiFinanceSettleQueryByidRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiMerchantContractSign.ZcmopenApiMerchantContractSignRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiMerchantCreate.ZcmopenApiMerchantCreateRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiMerchantCreateQuery.ZcmopenApiMerchantCreateQueryRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiMerchantPoiChangeCard.ZcmopenApiMerchantPoiChangeCardRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiMerchantPoiChangeName.ZcmopenApiMerchantPoiChangeNameRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiMerchantPoiChangePhone.ZcmopenApiMerchantPoiChangePhoneRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiMerchantPoiChangeQualification.ZcmopenApiMerchantPoiChangeQualificationRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiMerchantPoiChangeRate.ZcmopenApiMerchantPoiChangeRateRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiMerchantPoiCreate.ZcmopenApiMerchantPoiCreateRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiMerchantPoiProtocolAccept.ZcmopenApiMerchantPoiProtocolAcceptRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiMerchantSettlementAuthorization.ZcmopenApiMerchantSettlementAuthorizationRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiMerchantVerifyCustomer.ZcmopenApiMerchantVerifyCustomerRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiTerminalBoundasync.ZcmopenApiTerminalBoundasyncRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiTerminalUnbind.ZcmopenApiTerminalUnbindRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenpayApiClose.ZcmopenpayApiCloseRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenpayApiPayMicropay.ZcmopenpayApiPayMicropayRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenpayApiPayQuery.ZcmopenpayApiPayQueryRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenpayApiPrecreate.ZcmopenpayApiPrecreateRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenpayApiRefund.ZcmopenpayApiRefundRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenpayApiRefundQuery.ZcmopenpayApiRefundQueryRequest;

/**
 * 美团收单业务能力门面。
 * <p>方法参数保持官方 MtOpJavaSDK request 类型，SDK 负责按租户执行授权调用。</p>
 */
public interface MeituanPayService extends MeituanService {

    /**
     * [产品]申请开通产品。
     * <p>官方接口：{@code /sdpt/acquiring/api/business/poi/common/product/apply}，API：{@code zcmopen_api_business_poi_common_product_apply}，版本：{@code 10107}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiBusinessPoiCommonProductApply(ZcmopenApiBusinessPoiCommonProductApplyRequest request, String tenantId);

    /**
     * [产品]产品开通状态查询。
     * <p>官方接口：{@code /sdpt/acquiring/api/business/poi/common/product/query}，API：{@code zcmopen_api_business_poi_common_product_query}，版本：{@code 10086}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiBusinessPoiCommonProductQuery(ZcmopenApiBusinessPoiCommonProductQueryRequest request, String tenantId);

    /**
     * [基础]查询银行信息。
     * <p>官方接口：{@code /sdpt/acquiring/api/common/bank/all}，API：{@code zcmopen_api_common_bank_all}，版本：{@code 10080}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiCommonBankAll(ZcmopenApiCommonBankAllRequest request, String tenantId);

    /**
     * [基础]查询分行ID。
     * <p>官方接口：{@code /sdpt/acquiring/api/common/bank/branch}，API：{@code zcmopen_api_common_bank_branch}，版本：{@code 10082}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiCommonBankBranch(ZcmopenApiCommonBankBranchRequest request, String tenantId);

    /**
     * [基础]获取品类ID。
     * <p>官方接口：{@code /sdpt/acquiring/api/common/catelist}，API：{@code zcmopen_api_common_catelist}，版本：{@code 10084}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiCommonCatelist(ZcmopenApiCommonCatelistRequest request, String tenantId);

    /**
     * [基础]获取城市ID。
     * <p>官方接口：{@code /sdpt/acquiring/api/common/citylist}，API：{@code zcmopen_api_common_citylist}，版本：{@code 10083}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiCommonCitylist(ZcmopenApiCommonCitylistRequest request, String tenantId);

    /**
     * [基础]图片上传接口。
     * <p>官方接口：{@code /sdpt/acquiring/api/business/poi/common/image/upload}，API：{@code zcmopen_api_common_image_upload}，版本：{@code 10110}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiCommonImageUpload(ZcmopenApiCommonImageUploadRequest request, String tenantId);

    /**
     * [基础]获取行政区ID。
     * <p>官方接口：{@code /sdpt/acquiring/api/common/location}，API：{@code zcmopen_api_common_location}，版本：{@code 10109}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiCommonLocation(ZcmopenApiCommonLocationRequest request, String tenantId);

    /**
     * [查询]查询商户通道信息。
     * <p>官方接口：{@code /sdpt/acquiring/api/get/paychannel}，API：{@code zcmopen_api_finance_paychannel_query}，版本：{@code 10096}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiFinancePaychannelQuery(ZcmopenApiFinancePaychannelQueryRequest request, String tenantId);

    /**
     * [结算]查询打款列表。
     * <p>官方接口：{@code /sdpt/acquiring/api/finance/payment/query}，API：{@code zcmopen_api_finance_payment_query}，版本：{@code 10117}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiFinancePaymentQuery(ZcmopenApiFinancePaymentQueryRequest request, String tenantId);

    /**
     * [结算]查询结算明细。
     * <p>官方接口：{@code /sdpt/acquiring/api/finance/settle/query}，API：{@code zcmopen_api_finance_settle_query}，版本：{@code 10122}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiFinanceSettleQuery(ZcmopenApiFinanceSettleQueryRequest request, String tenantId);

    /**
     * [结算]通过付款id查询结算明细。
     * <p>官方接口：{@code /sdpt/acquiring/api/finance/settle/query/byId}，API：{@code zcmopen_api_finance_settle_query_byid}，版本：{@code 10117}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiFinanceSettleQueryByid(ZcmopenApiFinanceSettleQueryByidRequest request, String tenantId);

    /**
     * [入件]电子合同签署接口。
     * <p>官方接口：{@code /sdpt/acquiring/api/merchant/contract/sign}，API：{@code zcmopen_api_merchant_contract_sign}，版本：{@code 10111}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiMerchantContractSign(ZcmopenApiMerchantContractSignRequest request, String tenantId);

    /**
     * [入件]新商户入件接口。
     * <p>官方接口：{@code /sdpt/acquiring/api/merchant/create}，API：{@code zcmopen_api_merchant_create}，版本：{@code 10106}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiMerchantCreate(ZcmopenApiMerchantCreateRequest request, String tenantId);

    /**
     * [入件]查询商户入件结果。
     * <p>官方接口：{@code /sdpt/acquiring/api/merchant/create/query}，API：{@code zcmopen_api_merchant_create_query}，版本：{@code 10094}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiMerchantCreateQuery(ZcmopenApiMerchantCreateQueryRequest request, String tenantId);

    /**
     * [费率]修改银行卡（请注意修改银行卡前需验卡）。
     * <p>官方接口：{@code /sdpt/acquiring/api/merchant/poi/change/card}，API：{@code zcmopen_api_merchant_poi_change_card}，版本：{@code 10118}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiMerchantPoiChangeCard(ZcmopenApiMerchantPoiChangeCardRequest request, String tenantId);

    /**
     * [变更]修改门店简称。
     * <p>官方接口：{@code /sdpt/acquiring/api/merchant/poi/change/name}，API：{@code zcmopen_api_merchant_poi_change_name}，版本：{@code 10123}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiMerchantPoiChangeName(ZcmopenApiMerchantPoiChangeNameRequest request, String tenantId);

    /**
     * [变更]修改联系方式。
     * <p>官方接口：{@code /sdpt/acquiring/api/merchant/poi/change/phone}，API：{@code zcmopen_api_merchant_poi_change_phone}，版本：{@code 10120}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiMerchantPoiChangePhone(ZcmopenApiMerchantPoiChangePhoneRequest request, String tenantId);

    /**
     * [变更]修改主体资质。
     * <p>官方接口：{@code /sdpt/acquiring/api/merchant/poi/change/qualification}，API：{@code zcmopen_api_merchant_poi_change_qualification}，版本：{@code 10121}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiMerchantPoiChangeQualification(ZcmopenApiMerchantPoiChangeQualificationRequest request, String tenantId);

    /**
     * [费率]费率修改。
     * <p>官方接口：{@code /sdpt/acquiring/api/merchant/poi/change/rate}，API：{@code zcmopen_api_merchant_poi_change_rate}，版本：{@code 10118}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiMerchantPoiChangeRate(ZcmopenApiMerchantPoiChangeRateRequest request, String tenantId);

    /**
     * [创建]创建美团虚拟门店。
     * <p>官方接口：{@code /sdpt/acquiring/api/merchant/poi/create}，API：{@code zcmopen_api_merchant_poi_create}，版本：{@code 10095}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiMerchantPoiCreate(ZcmopenApiMerchantPoiCreateRequest request, String tenantId);

    /**
     * [入件]签订电子协议接口。
     * <p>官方接口：{@code /sdpt/acquiring/api/merchant/poi/protocol/accept}，API：{@code zcmopen_api_merchant_poi_protocol_accept}，版本：{@code 10105}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiMerchantPoiProtocolAccept(ZcmopenApiMerchantPoiProtocolAcceptRequest request, String tenantId);

    /**
     * 授权函签署接口。
     * <p>官方接口：{@code /sdpt/acquiring/api/merchant/settlement/authorization}，API：{@code zcmopen_api_merchant_settlement_authorization}，版本：{@code 10112}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiMerchantSettlementAuthorization(ZcmopenApiMerchantSettlementAuthorizationRequest request, String tenantId);

    /**
     * [实名]实名验证。
     * <p>官方接口：{@code /sdpt/acquiring/api/merchant/verify/customer}，API：{@code zcmopen_api_merchant_verify_customer}，版本：{@code 10108}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiMerchantVerifyCustomer(ZcmopenApiMerchantVerifyCustomerRequest request, String tenantId);

    /**
     * 美团收单[设备]绑定设备接口。
     * <p>官方接口：{@code /sdpt/acquiring/api/terminal/boundasync}，API：{@code zcmopen_api_terminal_boundasync}，版本：{@code 10098}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiTerminalBoundasync(ZcmopenApiTerminalBoundasyncRequest request, String tenantId);

    /**
     * [设备]设备解绑。
     * <p>官方接口：{@code /sdpt/acquiring/api/terminal/unbind}，API：{@code zcmopen_api_terminal_unbind}，版本：{@code 10121}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenApiTerminalUnbind(ZcmopenApiTerminalUnbindRequest request, String tenantId);

    /**
     * 美团收单[扫码支付]订单关闭接口。
     * <p>官方接口：{@code /sdpt/acquiring/api/close}，API：{@code zcmopenpay_api_close}，版本：{@code 10115}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenpayApiClose(ZcmopenpayApiCloseRequest request, String tenantId);

    /**
     * 美团收单_二维码支付_B扫C。
     * <p>官方接口：{@code /sdpt/acquiring/api/pay/micropay}，API：{@code zcmopenpay_api_pay_micropay}，版本：{@code 10116}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenpayApiPayMicropay(ZcmopenpayApiPayMicropayRequest request, String tenantId);

    /**
     * 美团收单[扫码支付]订单查询接口。
     * <p>官方接口：{@code /sdpt/acquiring/api/pay/query}，API：{@code zcmopenpay_api_pay_query}，版本：{@code 10101}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenpayApiPayQuery(ZcmopenpayApiPayQueryRequest request, String tenantId);

    /**
     * 美团收单[扫码支付]扫码支付接口。
     * <p>官方接口：{@code /sdpt/acquiring/api/precreate}，API：{@code zcmopenpay_api_precreate}，版本：{@code 10104}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenpayApiPrecreate(ZcmopenpayApiPrecreateRequest request, String tenantId);

    /**
     * 美团收单[扫码支付]订单退款接口。
     * <p>官方接口：{@code /sdpt/acquiring/api/refund}，API：{@code zcmopenpay_api_refund}，版本：{@code 10102}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenpayApiRefund(ZcmopenpayApiRefundRequest request, String tenantId);

    /**
     * 美团收单[扫码支付]退款状态查询。
     * <p>官方接口：{@code /sdpt/acquiring/api/refund/query}，API：{@code zcmopenpay_api_refund_query}，版本：{@code 10103}，businessId：{@code 52}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zcmopenpayApiRefundQuery(ZcmopenpayApiRefundQueryRequest request, String tenantId);
}
