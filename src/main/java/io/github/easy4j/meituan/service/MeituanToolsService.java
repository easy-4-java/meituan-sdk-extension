package io.github.easy4j.meituan.service;

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

/**
 * 工具型服务业务能力门面。
 * <p>方法参数保持官方 MtOpJavaSDK request 类型，SDK 负责按租户执行授权调用。</p>
 */
public interface MeituanToolsService extends MeituanService {

    /**
     * 菜品标题诊断。
     * <p>官方接口：{@code /design/document/foodTextCheck}，API：{@code food_text_check}，版本：{@code 10005}，businessId：{@code 24}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> foodTextCheck(FoodTextCheckRequest request, String tenantId);

    /**
     * 菜品生成。
     * <p>官方接口：{@code /design/image/dish_generate}，API：{@code dish_generate}，版本：{@code 10030}，businessId：{@code 24}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dishGenerate(DishGenerateRequest request, String tenantId);

    /**
     * 图片虚景滤镜特效 对菜品等物体图片，添加虚景滤镜，对菜品等主要物体以外的背景进行虚化处理，突出菜品等主要物体本身。。
     * <p>官方接口：{@code /design/image/bokeh}，API：{@code image_bokeh}，版本：{@code 10018}，businessId：{@code 24}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> imageBokeh(ImageBokehRequest request, String tenantId);

    /**
     * 图片智能美化。
     * <p>官方接口：{@code /design/image/enhance}，API：{@code image_enhance}，版本：{@code 10020}，businessId：{@code 24}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> imageEnhance(ImageEnhanceRequest request, String tenantId);

    /**
     * 图像增强美化。
     * <p>官方接口：{@code /design/image/image_enhance_new}，API：{@code image_enhance_new}，版本：{@code 10031}，businessId：{@code 24}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> imageEnhanceNew(ImageEnhanceNewRequest request, String tenantId);

    /**
     * 图片添加滤镜效果，对图片整体进行定制化色彩调整。。
     * <p>官方接口：{@code /design/image/filter}，API：{@code image_filter}，版本：{@code 10019}，businessId：{@code 24}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> imageFilter(ImageFilterRequest request, String tenantId);

    /**
     * 图像标签识别。
     * <p>官方接口：{@code /design/image/tagsFoodScene}，API：{@code image_tags_food_scene}，版本：{@code 10020}，businessId：{@code 24}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> imageTagsFoodScene(ImageTagsFoodSceneRequest request, String tenantId);

    /**
     * 通用图像去水印。
     * <p>官方接口：{@code /design/image/waterMarkRemove}，API：{@code image_watermark_remove}，版本：{@code 10020}，businessId：{@code 24}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> imageWatermarkRemove(ImageWatermarkRemoveRequest request, String tenantId);

    /**
     * 智能抠图服务 可指定对菜品或商品进行智能抠图，并返回指定物品结果图片。
     * <p>官方接口：{@code /design/image/mattingPredict}，API：{@code matting_predict}，版本：{@code 10020}，businessId：{@code 24}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> mattingPredict(MattingPredictRequest request, String tenantId);

    /**
     * 菜品主体检测。
     * <p>官方接口：{@code /design/image/newFoodDet}，API：{@code new_image_food_det}，版本：{@code 10025}，businessId：{@code 24}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> newImageFoodDet(NewImageFoodDetRequest request, String tenantId);

    /**
     * 通用水印/文字涂鸦识别接口。
     * <p>官方接口：{@code /design/image/waterMark}，API：{@code water_mark}，版本：{@code 10022}，businessId：{@code 24}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waterMark(WaterMarkRequest request, String tenantId);

    /**
     * 菜单OCR识别 识别并结构化输出菜单图片中的菜名、价格和单位。。
     * <p>官方接口：{@code /design/ocr/recognizeMenu}，API：{@code recognize_menu}，版本：{@code 10004}，businessId：{@code 24}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> recognizeMenu(RecognizeMenuRequest request, String tenantId);

    /**
     * 粗粒度情感分析。
     * <p>官方接口：{@code /nlp/semantic/api/sentiment_analysis/coarse_grained}，API：{@code sentiment_analysis_coarse_grained}，版本：{@code 10005}，businessId：{@code 42}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> sentimentAnalysisCoarseGrained(SentimentAnalysisCoarseGrainedRequest request, String tenantId);

    /**
     * 细粒度情感分析。
     * <p>官方接口：{@code /nlp/semantic/api/sentiment_analysis/fine_grained}，API：{@code sentiment_analysis_fine_grained}，版本：{@code 10005}，businessId：{@code 42}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> sentimentAnalysisFineGrained(SentimentAnalysisFineGrainedRequest request, String tenantId);

    /**
     * 摩西机器人会话接口。
     * <p>官方接口：{@code /moses/dialog/trigger}，API：{@code trigger}，版本：{@code 10004}，businessId：{@code 28}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> trigger(TriggerRequest request, String tenantId);

    /**
     * 批量新增关键词定向。
     * <p>官方接口：{@code /ad/launch/batchAddKeywords}，API：{@code batch_add_keywords}，版本：{@code 10026}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchAddKeywords(BatchAddKeywordsRequest request, String tenantId);

    /**
     * 新建推广。
     * <p>官方接口：{@code /ad/launch/batchCreateCpcLaunchs}，API：{@code batch_create_cpc_launchs}，版本：{@code 10030}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchCreateCpcLaunchs(BatchCreateCpcLaunchsRequest request, String tenantId);

    /**
     * 修改推广出价。
     * <p>官方接口：{@code /ad/launch/batchEditCpcBidPrice}，API：{@code batch_edit_cpc_bidprice}，版本：{@code 10013}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchEditCpcBidprice(BatchEditCpcBidpriceRequest request, String tenantId);

    /**
     * 修改预算。
     * <p>官方接口：{@code /ad/launch/batchEditCpcPlanBudget}，API：{@code batch_edit_cpc_planbudget}，版本：{@code 10006}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchEditCpcPlanbudget(BatchEditCpcPlanbudgetRequest request, String tenantId);

    /**
     * 获取推广信息。
     * <p>官方接口：{@code /ad/launch/batchQueryCpcLaunchInfos}，API：{@code batch_query_cpc_launchinfos}，版本：{@code 10014}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchQueryCpcLaunchinfos(BatchQueryCpcLaunchinfosRequest request, String tenantId);

    /**
     * 更新推广状态。
     * <p>官方接口：{@code /ad/launch/batchUpdateCpcLaunchStatus}，API：{@code batch_update_cpclaunch_status}，版本：{@code 10005}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchUpdateCpclaunchStatus(BatchUpdateCpclaunchStatusRequest request, String tenantId);

    /**
     * 批量更新关键词定向。
     * <p>官方接口：{@code /ad/launch/batchUpdateKeywords}，API：{@code batch_update_keywords}，版本：{@code 10031}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchUpdateKeywords(BatchUpdateKeywordsRequest request, String tenantId);

    /**
     * 更新关键词出价。
     * <p>官方接口：{@code /ad/launch/batchUpdateKeywordBidPrice}，API：{@code batch_update_keywords_bit}，版本：{@code 10024}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchUpdateKeywordsBit(BatchUpdateKeywordsBitRequest request, String tenantId);

    /**
     * 批量更新投放每周时间段。
     * <p>官方接口：{@code /ad/launch/batchUpdateLaunchTimeSlot}，API：{@code batch_update_launch_timeslot}，版本：{@code 10016}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchUpdateLaunchTimeslot(BatchUpdateLaunchTimeslotRequest request, String tenantId);

    /**
     * 批量修改投放时间段。
     * <p>官方接口：{@code /ad/launch/batchUpdateLaunchTime}，API：{@code batch_update_launchtime}，版本：{@code 10017}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchUpdateLaunchtime(BatchUpdateLaunchtimeRequest request, String tenantId);

    /**
     * cpm批量创建投放。
     * <p>官方接口：{@code /ad/launch/cpm/batchCreateLaunch}，API：{@code cpm_batch_create_launch}，版本：{@code 10033}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> cpmBatchCreateLaunch(CpmBatchCreateLaunchRequest request, String tenantId);

    /**
     * cpm批量查询投放。
     * <p>官方接口：{@code /ad/launch/cpm/batchQueryLaunchInfo}，API：{@code cpm_batch_query_launches}，版本：{@code 10036}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> cpmBatchQueryLaunches(CpmBatchQueryLaunchesRequest request, String tenantId);

    /**
     * cpm批量更新出价。
     * <p>官方接口：{@code /ad/launch/cpm/batchUpdateBid}，API：{@code cpm_batch_update_bid}，版本：{@code 10039}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> cpmBatchUpdateBid(CpmBatchUpdateBidRequest request, String tenantId);

    /**
     * cpm批量修改预算。
     * <p>官方接口：{@code /ad/launch/cpm/batchUpdateBudget}，API：{@code cpm_batch_update_budget}，版本：{@code 10038}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> cpmBatchUpdateBudget(CpmBatchUpdateBudgetRequest request, String tenantId);

    /**
     * cpm批量修改投放状态。
     * <p>官方接口：{@code /ad/launch/cpm/batchUpdate}，API：{@code cpm_batch_update_launch_power}，版本：{@code 10037}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> cpmBatchUpdateLaunchPower(CpmBatchUpdateLaunchPowerRequest request, String tenantId);

    /**
     * cpm查询出价信息。
     * <p>官方接口：{@code /ad/launch/cpm/queryBidInfo}，API：{@code cpm_query_bid_info}，版本：{@code 10034}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> cpmQueryBidInfo(CpmQueryBidInfoRequest request, String tenantId);

    /**
     * cpm查询常用信息。
     * <p>官方接口：{@code /ad/launch/cpm/queryCommonInfo}，API：{@code cpm_query_common_info}，版本：{@code 10035}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> cpmQueryCommonInfo(CpmQueryCommonInfoRequest request, String tenantId);

    /**
     * 查询账号余额。
     * <p>官方接口：{@code /ad/launch/queryAdAccountBalance}，API：{@code query_adaccount_balance}，版本：{@code 10011}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryAdaccountBalance(QueryAdaccountBalanceRequest request, String tenantId);

    /**
     * 查询账号基本信息。
     * <p>官方接口：{@code /ad/launch/queryAdAccountInfo}，API：{@code query_adaccount_info}，版本：{@code 10015}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryAdaccountInfo(QueryAdaccountInfoRequest request, String tenantId);

    /**
     * 查询账号的子账号。
     * <p>官方接口：{@code /ad/launch/queryAdAccountSons}，API：{@code query_adaccount_sons}，版本：{@code 10009}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryAdaccountSons(QueryAdaccountSonsRequest request, String tenantId);

    /**
     * 获取推广id列表。
     * <p>官方接口：{@code /ad/launch/queryCpcLaunchIds}，API：{@code query_cpc_launchids}，版本：{@code 10008}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryCpcLaunchids(QueryCpcLaunchidsRequest request, String tenantId);

    /**
     * 查询关键词列表。
     * <p>官方接口：{@code /ad/launch/queryLaunchPremiumList}，API：{@code query_launch_premiumlist}，版本：{@code 10028}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryLaunchPremiumlist(QueryLaunchPremiumlistRequest request, String tenantId);

    /**
     * 查询门店的推荐关键词。
     * <p>官方接口：{@code /ad/launch/queryRecommendKeywords}，API：{@code query_recommend_keywords}，版本：{@code 10029}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryRecommendKeywords(QueryRecommendKeywordsRequest request, String tenantId);

    /**
     * 查询账号关联门店。
     * <p>官方接口：{@code /ad/launch/queryRelationShops}，API：{@code query_relation_shops}，版本：{@code 10004}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryRelationShops(QueryRelationShopsRequest request, String tenantId);

    /**
     * 批量查询广告位次出价。
     * <p>官方接口：{@code /ad/launch/querySuggestBid}，API：{@code query_suggest_bid}，版本：{@code 10027}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> querySuggestBid(QuerySuggestBidRequest request, String tenantId);

    /**
     * 判断门店是否可以投放广告。
     * <p>官方接口：{@code /ad/launch/queryValidShops}，API：{@code query_valid_shops}，版本：{@code 10012}，businessId：{@code 22}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryValidShops(QueryValidShopsRequest request, String tenantId);

    /**
     * cpc账户实时天数据。
     * <p>官方接口：{@code /ad/report/getCpcRtDataByAccount}，API：{@code cpc_rtdata_byaccount}，版本：{@code 10015}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> cpcRtdataByaccount(CpcRtdataByaccountRequest request, String tenantId);

    /**
     * cpc推广实时天数据。
     * <p>官方接口：{@code /ad/report/getCpcRtDataByLaunch}，API：{@code cpc_rtdata_bylaunch}，版本：{@code 10015}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> cpcRtdataBylaunch(CpcRtdataBylaunchRequest request, String tenantId);

    /**
     * cpc门店实时天数据。
     * <p>官方接口：{@code /ad/report/getCpcRtDataByShop}，API：{@code cpc_rtdata_byshop}，版本：{@code 10018}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> cpcRtdataByshop(CpcRtdataByshopRequest request, String tenantId);

    /**
     * getCpmRtData。
     * <p>官方接口：{@code /ad/report/getCpmRtData}，API：{@code cpm_rtdata}，版本：{@code 10015}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> cpmRtdata(CpmRtdataRequest request, String tenantId);

    /**
     * 账户分日报告。
     * <p>官方接口：{@code /ad/report/getDailyDataByAccountOffline}，API：{@code daily_account_report_offline}，版本：{@code 10022}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dailyAccountReportOffline(DailyAccountReportOfflineRequest request, String tenantId);

    /**
     * cpm离线分天数据。
     * <p>官方接口：{@code /ad/report/getDailyCpmData}，API：{@code daily_cpm_data}，版本：{@code 10015}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dailyCpmData(DailyCpmDataRequest request, String tenantId);

    /**
     * cpm离线分天分小时。
     * <p>官方接口：{@code /ad/report/getDailyHourlyCpmData}，API：{@code daily_hourly_cpm_data}，版本：{@code 10015}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dailyHourlyCpmData(DailyHourlyCpmDataRequest request, String tenantId);

    /**
     * 推广分日报告。
     * <p>官方接口：{@code /ad/report/getDailyDataByLaunchOffline}，API：{@code daily_launch_report_offline}，版本：{@code 10016}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dailyLaunchReportOffline(DailyLaunchReportOfflineRequest request, String tenantId);

    /**
     * 门店分日报告。
     * <p>官方接口：{@code /ad/report/getDailyDataByShopOffline}，API：{@code daily_shop_report_offline}，版本：{@code 10020}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dailyShopReportOffline(DailyShopReportOfflineRequest request, String tenantId);

    /**
     * 账户分时报告。
     * <p>官方接口：{@code /ad/report/getHourlyDataByAccountOffline}，API：{@code hourly_account_report_offline}，版本：{@code 10014}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> hourlyAccountReportOffline(HourlyAccountReportOfflineRequest request, String tenantId);

    /**
     * cpc账户实时分时数据。
     * <p>官方接口：{@code /ad/report/getHourlyCpcRtDataByAccount}，API：{@code hourly_cpc_rt_data_byaccount}，版本：{@code 10015}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> hourlyCpcRtDataByaccount(HourlyCpcRtDataByaccountRequest request, String tenantId);

    /**
     * cpc推广实时分时数据。
     * <p>官方接口：{@code /ad/report/getHourlyCpcRtDataByLaunch}，API：{@code hourly_cpc_rtdata_bylaunch}，版本：{@code 10015}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> hourlyCpcRtdataBylaunch(HourlyCpcRtdataBylaunchRequest request, String tenantId);

    /**
     * cpc门店实时分时数据。
     * <p>官方接口：{@code /ad/report/getHourlyCpcRtDataByShop}，API：{@code hourly_cpc_rtdata_byshop}，版本：{@code 10017}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> hourlyCpcRtdataByshop(HourlyCpcRtdataByshopRequest request, String tenantId);

    /**
     * getHourlyCpmRtData。
     * <p>官方接口：{@code /ad/report/getHourlyCpmRtData}，API：{@code hourly_cpm_rtdata}，版本：{@code 10015}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> hourlyCpmRtdata(HourlyCpmRtdataRequest request, String tenantId);

    /**
     * 推广分时报告。
     * <p>官方接口：{@code /ad/report/getHourlyDataByLaunchOffline}，API：{@code hourly_launch_report_offline}，版本：{@code 10014}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> hourlyLaunchReportOffline(HourlyLaunchReportOfflineRequest request, String tenantId);

    /**
     * 门店分时报告。
     * <p>官方接口：{@code /ad/report/getHourlyDataByShopOffline}，API：{@code hourly_shop_report_offline}，版本：{@code 10019}，businessId：{@code 22}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> hourlyShopReportOffline(HourlyShopReportOfflineRequest request, String tenantId);

    /**
     * 申请开通企业版开票能力。
     * <p>官方接口：{@code /enterprise/bill/sqtInvoiceRegister}，API：{@code ent_invoice_ablility_register}，版本：{@code 10004}，businessId：{@code 87}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> entInvoiceAblilityRegister(EntInvoiceAblilityRegisterRequest request, String tenantId);

    /**
     * 开票申请结果通知。
     * <p>官方接口：{@code /enterprise/bill/invoice/apply}，API：{@code invoice_apply_callback}，版本：{@code 10005}，businessId：{@code 87}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> invoiceApplyCallback(InvoiceApplyCallbackRequest request, String tenantId);
}
