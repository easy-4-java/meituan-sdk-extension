package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.ad.launch.batchAddKeywords.BatchAddKeywordsRequest;
import com.meituan.sdk.model.ad.launch.batchCreateCpcLaunchs.BatchCreateCpcLaunchsRequest;
import com.meituan.sdk.model.ad.launch.batchEditCpcBidprice.BatchEditCpcBidpriceRequest;
import com.meituan.sdk.model.ad.launch.batchEditCpcPlanbudget.BatchEditCpcPlanbudgetRequest;
import com.meituan.sdk.model.ad.launch.batchQueryCpcLaunchinfos.BatchQueryCpcLaunchinfosRequest;
import com.meituan.sdk.model.ad.launch.batchUpdateCpclaunchStatus.BatchUpdateCpclaunchStatusRequest;
import com.meituan.sdk.model.ad.launch.batchUpdateKeywords.BatchUpdateKeywordsRequest;
import com.meituan.sdk.model.ad.launch.batchUpdateKeywordsBit.BatchUpdateKeywordsBitRequest;
import com.meituan.sdk.model.ad.launch.batchUpdateLaunchTimeslot.BatchUpdateLaunchTimeslotRequest;
import com.meituan.sdk.model.ad.launch.batchUpdateLaunchtime.BatchUpdateLaunchtimeRequest;
import com.meituan.sdk.model.ad.launch.cpmBatchCreateLaunch.CpmBatchCreateLaunchRequest;
import com.meituan.sdk.model.ad.launch.cpmBatchQueryLaunches.CpmBatchQueryLaunchesRequest;
import com.meituan.sdk.model.ad.launch.cpmBatchUpdateBid.CpmBatchUpdateBidRequest;
import com.meituan.sdk.model.ad.launch.cpmBatchUpdateBudget.CpmBatchUpdateBudgetRequest;
import com.meituan.sdk.model.ad.launch.cpmBatchUpdateLaunchPower.CpmBatchUpdateLaunchPowerRequest;
import com.meituan.sdk.model.ad.launch.cpmQueryBidInfo.CpmQueryBidInfoRequest;
import com.meituan.sdk.model.ad.launch.cpmQueryCommonInfo.CpmQueryCommonInfoRequest;
import com.meituan.sdk.model.ad.launch.queryAdaccountBalance.QueryAdaccountBalanceRequest;
import com.meituan.sdk.model.ad.launch.queryAdaccountInfo.QueryAdaccountInfoRequest;
import com.meituan.sdk.model.ad.launch.queryAdaccountSons.QueryAdaccountSonsRequest;
import com.meituan.sdk.model.ad.launch.queryCpcLaunchids.QueryCpcLaunchidsRequest;
import com.meituan.sdk.model.ad.launch.queryLaunchPremiumlist.QueryLaunchPremiumlistRequest;
import com.meituan.sdk.model.ad.launch.queryRecommendKeywords.QueryRecommendKeywordsRequest;
import com.meituan.sdk.model.ad.launch.queryRelationShops.QueryRelationShopsRequest;
import com.meituan.sdk.model.ad.launch.querySuggestBid.QuerySuggestBidRequest;
import com.meituan.sdk.model.ad.launch.queryValidShops.QueryValidShopsRequest;
import com.meituan.sdk.model.ad.report.cpcRtdataByaccount.CpcRtdataByaccountRequest;
import com.meituan.sdk.model.ad.report.cpcRtdataBylaunch.CpcRtdataBylaunchRequest;
import com.meituan.sdk.model.ad.report.cpcRtdataByshop.CpcRtdataByshopRequest;
import com.meituan.sdk.model.ad.report.cpmRtdata.CpmRtdataRequest;
import com.meituan.sdk.model.ad.report.dailyAccountReportOffline.DailyAccountReportOfflineRequest;
import com.meituan.sdk.model.ad.report.dailyCpmData.DailyCpmDataRequest;
import com.meituan.sdk.model.ad.report.dailyHourlyCpmData.DailyHourlyCpmDataRequest;
import com.meituan.sdk.model.ad.report.dailyLaunchReportOffline.DailyLaunchReportOfflineRequest;
import com.meituan.sdk.model.ad.report.dailyShopReportOffline.DailyShopReportOfflineRequest;
import com.meituan.sdk.model.ad.report.hourlyAccountReportOffline.HourlyAccountReportOfflineRequest;
import com.meituan.sdk.model.ad.report.hourlyCpcRtDataByaccount.HourlyCpcRtDataByaccountRequest;
import com.meituan.sdk.model.ad.report.hourlyCpcRtdataBylaunch.HourlyCpcRtdataBylaunchRequest;
import com.meituan.sdk.model.ad.report.hourlyCpcRtdataByshop.HourlyCpcRtdataByshopRequest;
import com.meituan.sdk.model.ad.report.hourlyCpmRtdata.HourlyCpmRtdataRequest;
import com.meituan.sdk.model.ad.report.hourlyLaunchReportOffline.HourlyLaunchReportOfflineRequest;
import com.meituan.sdk.model.ad.report.hourlyShopReportOffline.HourlyShopReportOfflineRequest;
import com.meituan.sdk.model.design.document.foodTextCheck.FoodTextCheckRequest;
import com.meituan.sdk.model.design.image.dishGenerate.DishGenerateRequest;
import com.meituan.sdk.model.design.image.imageBokeh.ImageBokehRequest;
import com.meituan.sdk.model.design.image.imageEnhance.ImageEnhanceRequest;
import com.meituan.sdk.model.design.image.imageEnhanceNew.ImageEnhanceNewRequest;
import com.meituan.sdk.model.design.image.imageFilter.ImageFilterRequest;
import com.meituan.sdk.model.design.image.imageTagsFoodScene.ImageTagsFoodSceneRequest;
import com.meituan.sdk.model.design.image.imageWatermarkRemove.ImageWatermarkRemoveRequest;
import com.meituan.sdk.model.design.image.mattingPredict.MattingPredictRequest;
import com.meituan.sdk.model.design.image.newImageFoodDet.NewImageFoodDetRequest;
import com.meituan.sdk.model.design.image.waterMark.WaterMarkRequest;
import com.meituan.sdk.model.design.ocr.recognizeMenu.RecognizeMenuRequest;
import com.meituan.sdk.model.enterprise.bill.entInvoiceAblilityRegister.EntInvoiceAblilityRegisterRequest;
import com.meituan.sdk.model.enterprise.bill.invoiceApplyCallback.InvoiceApplyCallbackRequest;
import com.meituan.sdk.model.moses.dialog.trigger.TriggerRequest;
import com.meituan.sdk.model.nlp.semantic.sentimentAnalysisCoarseGrained.SentimentAnalysisCoarseGrainedRequest;
import com.meituan.sdk.model.nlp.semantic.sentimentAnalysisFineGrained.SentimentAnalysisFineGrainedRequest;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanToolsService;

/**
 * 工具型服务默认实现。
 * <p>所有业务方法统一委托 {@link AbstractMeituanService} 执行官方 SDK request。</p>
 */
public class MeituanToolsServiceImpl extends AbstractMeituanService implements MeituanToolsService {

    /**
     * 创建默认业务 service 实现。
     *
     * @param requestExecutor 多租户请求执行器
     */
    public MeituanToolsServiceImpl(MeituanRequestExecutor requestExecutor) {
        super(requestExecutor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> foodTextCheck(FoodTextCheckRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dishGenerate(DishGenerateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> imageBokeh(ImageBokehRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> imageEnhance(ImageEnhanceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> imageEnhanceNew(ImageEnhanceNewRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> imageFilter(ImageFilterRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> imageTagsFoodScene(ImageTagsFoodSceneRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> imageWatermarkRemove(ImageWatermarkRemoveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> mattingPredict(MattingPredictRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> newImageFoodDet(NewImageFoodDetRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waterMark(WaterMarkRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> recognizeMenu(RecognizeMenuRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> sentimentAnalysisCoarseGrained(SentimentAnalysisCoarseGrainedRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> sentimentAnalysisFineGrained(SentimentAnalysisFineGrainedRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> trigger(TriggerRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchAddKeywords(BatchAddKeywordsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchCreateCpcLaunchs(BatchCreateCpcLaunchsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchEditCpcBidprice(BatchEditCpcBidpriceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchEditCpcPlanbudget(BatchEditCpcPlanbudgetRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchQueryCpcLaunchinfos(BatchQueryCpcLaunchinfosRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchUpdateCpclaunchStatus(BatchUpdateCpclaunchStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchUpdateKeywords(BatchUpdateKeywordsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchUpdateKeywordsBit(BatchUpdateKeywordsBitRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchUpdateLaunchTimeslot(BatchUpdateLaunchTimeslotRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchUpdateLaunchtime(BatchUpdateLaunchtimeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> cpmBatchCreateLaunch(CpmBatchCreateLaunchRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> cpmBatchQueryLaunches(CpmBatchQueryLaunchesRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> cpmBatchUpdateBid(CpmBatchUpdateBidRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> cpmBatchUpdateBudget(CpmBatchUpdateBudgetRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> cpmBatchUpdateLaunchPower(CpmBatchUpdateLaunchPowerRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> cpmQueryBidInfo(CpmQueryBidInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> cpmQueryCommonInfo(CpmQueryCommonInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryAdaccountBalance(QueryAdaccountBalanceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryAdaccountInfo(QueryAdaccountInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryAdaccountSons(QueryAdaccountSonsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryCpcLaunchids(QueryCpcLaunchidsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryLaunchPremiumlist(QueryLaunchPremiumlistRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryRecommendKeywords(QueryRecommendKeywordsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryRelationShops(QueryRelationShopsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> querySuggestBid(QuerySuggestBidRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryValidShops(QueryValidShopsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> cpcRtdataByaccount(CpcRtdataByaccountRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> cpcRtdataBylaunch(CpcRtdataBylaunchRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> cpcRtdataByshop(CpcRtdataByshopRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> cpmRtdata(CpmRtdataRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dailyAccountReportOffline(DailyAccountReportOfflineRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dailyCpmData(DailyCpmDataRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dailyHourlyCpmData(DailyHourlyCpmDataRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dailyLaunchReportOffline(DailyLaunchReportOfflineRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dailyShopReportOffline(DailyShopReportOfflineRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> hourlyAccountReportOffline(HourlyAccountReportOfflineRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> hourlyCpcRtDataByaccount(HourlyCpcRtDataByaccountRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> hourlyCpcRtdataBylaunch(HourlyCpcRtdataBylaunchRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> hourlyCpcRtdataByshop(HourlyCpcRtdataByshopRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> hourlyCpmRtdata(HourlyCpmRtdataRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> hourlyLaunchReportOffline(HourlyLaunchReportOfflineRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> hourlyShopReportOffline(HourlyShopReportOfflineRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> entInvoiceAblilityRegister(EntInvoiceAblilityRegisterRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> invoiceApplyCallback(InvoiceApplyCallbackRequest request, String tenantId) {
        return execute(request, tenantId);
    }
}
