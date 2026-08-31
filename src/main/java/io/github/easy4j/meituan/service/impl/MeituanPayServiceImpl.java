package io.github.easy4j.meituan.service.impl;

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
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiCommonFilePresignedUpload.ZcmopenApiCommonFilePresignedUploadRequest;
import com.meituan.sdk.model.sdpt.acquiring.zcmopenApiMerchantPoiChangeFlow.ZcmopenApiMerchantPoiChangeFlowRequest;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanPayService;

/**
 * 美团收单默认实现。
 * <p>所有业务方法统一委托 {@link AbstractMeituanService} 执行官方 SDK request。</p>
 */
public class MeituanPayServiceImpl extends AbstractMeituanService implements MeituanPayService {

    /**
     * 创建默认业务 service 实现。
     *
     * @param requestExecutor 多租户请求执行器
     */
    public MeituanPayServiceImpl(MeituanRequestExecutor requestExecutor) {
        super(requestExecutor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiBusinessPoiCommonProductApply(ZcmopenApiBusinessPoiCommonProductApplyRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiBusinessPoiCommonProductQuery(ZcmopenApiBusinessPoiCommonProductQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiCommonBankAll(ZcmopenApiCommonBankAllRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiCommonBankBranch(ZcmopenApiCommonBankBranchRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiCommonCatelist(ZcmopenApiCommonCatelistRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiCommonCitylist(ZcmopenApiCommonCitylistRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiCommonImageUpload(ZcmopenApiCommonImageUploadRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiCommonLocation(ZcmopenApiCommonLocationRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiFinancePaychannelQuery(ZcmopenApiFinancePaychannelQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiFinancePaymentQuery(ZcmopenApiFinancePaymentQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiFinanceSettleQuery(ZcmopenApiFinanceSettleQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiFinanceSettleQueryByid(ZcmopenApiFinanceSettleQueryByidRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiMerchantContractSign(ZcmopenApiMerchantContractSignRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiMerchantCreate(ZcmopenApiMerchantCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiMerchantCreateQuery(ZcmopenApiMerchantCreateQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiMerchantPoiChangeCard(ZcmopenApiMerchantPoiChangeCardRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiMerchantPoiChangeName(ZcmopenApiMerchantPoiChangeNameRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiMerchantPoiChangePhone(ZcmopenApiMerchantPoiChangePhoneRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiMerchantPoiChangeQualification(ZcmopenApiMerchantPoiChangeQualificationRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiMerchantPoiChangeRate(ZcmopenApiMerchantPoiChangeRateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiMerchantPoiCreate(ZcmopenApiMerchantPoiCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiMerchantPoiProtocolAccept(ZcmopenApiMerchantPoiProtocolAcceptRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiMerchantSettlementAuthorization(ZcmopenApiMerchantSettlementAuthorizationRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiMerchantVerifyCustomer(ZcmopenApiMerchantVerifyCustomerRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiTerminalBoundasync(ZcmopenApiTerminalBoundasyncRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiTerminalUnbind(ZcmopenApiTerminalUnbindRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenpayApiClose(ZcmopenpayApiCloseRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenpayApiPayMicropay(ZcmopenpayApiPayMicropayRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenpayApiPayQuery(ZcmopenpayApiPayQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenpayApiPrecreate(ZcmopenpayApiPrecreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenpayApiRefund(ZcmopenpayApiRefundRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenpayApiRefundQuery(ZcmopenpayApiRefundQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }
    /**
     * [基础]生成授权第三方文件上传预签名URL。
     * <p>官方接口：{@code /sdpt/acquiring/api/common/file/presigned/upload}，API：{@code zcmopen_api_common_file_presigned_upload}，版本：{@code 10124}，businessId：{@code 52}，需要授权：{@code false}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiCommonFilePresignedUpload(ZcmopenApiCommonFilePresignedUploadRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * [变更]修改银行卡结果查询。
     * <p>官方接口：{@code /sdpt/acquiring/api/merchant/poi/change/flow}，API：{@code zcmopen_api_merchant_poi_change_flow}，版本：{@code 10131}，businessId：{@code 52}，需要授权：{@code false}。</p>
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zcmopenApiMerchantPoiChangeFlow(ZcmopenApiMerchantPoiChangeFlowRequest request, String tenantId) {
        return execute(request, tenantId);
    }

}
