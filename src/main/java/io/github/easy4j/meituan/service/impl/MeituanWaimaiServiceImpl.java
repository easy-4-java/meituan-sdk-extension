package io.github.easy4j.meituan.service.impl;

import com.meituan.sdk.MeituanResponse;
import com.meituan.sdk.model.waimaiNg.act.actDiscountActivityOrderLimit.ActDiscountActivityOrderLimitRequest;
import com.meituan.sdk.model.waimaiNg.act.actDiscountBatchsave.ActDiscountBatchsaveRequest;
import com.meituan.sdk.model.waimaiNg.act.actDiscountDelete.ActDiscountDeleteRequest;
import com.meituan.sdk.model.waimaiNg.act.actDiscountList.ActDiscountListRequest;
import com.meituan.sdk.model.waimaiNg.act.actDiscountStock.ActDiscountStockRequest;
import com.meituan.sdk.model.waimaiNg.card.queryCard.QueryCardRequest;
import com.meituan.sdk.model.waimaiNg.card.saveCard.SaveCardRequest;
import com.meituan.sdk.model.waimaiNg.comment.commentComplainReport.CommentComplainReportRequest;
import com.meituan.sdk.model.waimaiNg.comment.commentQueryScore.CommentQueryScoreRequest;
import com.meituan.sdk.model.waimaiNg.comment.poiCommentReply.PoiCommentReplyRequest;
import com.meituan.sdk.model.waimaiNg.comment.queryCommentList.QueryCommentListRequest;
import com.meituan.sdk.model.waimaiNg.decoration.bossRecommendCreate.BossRecommendCreateRequest;
import com.meituan.sdk.model.waimaiNg.decoration.bossRecommendQuery.BossRecommendQueryRequest;
import com.meituan.sdk.model.waimaiNg.decoration.deleteImgeForSingle.DeleteImgeForSingleRequest;
import com.meituan.sdk.model.waimaiNg.decoration.deleteShopPoster.DeleteShopPosterRequest;
import com.meituan.sdk.model.waimaiNg.decoration.postersCreate.PostersCreateRequest;
import com.meituan.sdk.model.waimaiNg.decoration.postersCreateForSpuId.PostersCreateForSpuIdRequest;
import com.meituan.sdk.model.waimaiNg.decoration.productsQuery.ProductsQueryRequest;
import com.meituan.sdk.model.waimaiNg.decoration.queryImageForSingle.QueryImageForSingleRequest;
import com.meituan.sdk.model.waimaiNg.decoration.queryPoster.QueryPosterRequest;
import com.meituan.sdk.model.waimaiNg.decoration.signageCreate.SignageCreateRequest;
import com.meituan.sdk.model.waimaiNg.decoration.updatePosterStatus.UpdatePosterStatusRequest;
import com.meituan.sdk.model.waimaiNg.delivery.syncEstimateArrivalTime.SyncEstimateArrivalTimeRequest;
import com.meituan.sdk.model.waimaiNg.diancan.diancanOrderConfirm.DiancanOrderConfirmRequest;
import com.meituan.sdk.model.waimaiNg.diancan.diancanOrderFullFillNotice.DiancanOrderFullFillNoticeRequest;
import com.meituan.sdk.model.waimaiNg.diancan.diancanOrderQuery.DiancanOrderQueryRequest;
import com.meituan.sdk.model.waimaiNg.diancan.diancanShopServeStatusUpdate.DiancanShopServeStatusUpdateRequest;
import com.meituan.sdk.model.waimaiNg.diancan.diancanShopStatusUpdate.DiancanShopStatusUpdateRequest;
import com.meituan.sdk.model.waimaiNg.diancan.diancanShopconfigQuery.DiancanShopconfigQueryRequest;
import com.meituan.sdk.model.waimaiNg.diancan.diancanSyncDealMapping.DiancanSyncDealMappingRequest;
import com.meituan.sdk.model.waimaiNg.dish.batchDelSpu.BatchDelSpuRequest;
import com.meituan.sdk.model.waimaiNg.dish.batchInitMarketPlaceFood.BatchInitMarketPlaceFoodRequest;
import com.meituan.sdk.model.waimaiNg.dish.batchQueryFoodDna.BatchQueryFoodDnaRequest;
import com.meituan.sdk.model.waimaiNg.dish.batchQuerySpuByIds.BatchQuerySpuByIdsRequest;
import com.meituan.sdk.model.waimaiNg.dish.batchUpdateSpubyId.BatchUpdateSpubyIdRequest;
import com.meituan.sdk.model.waimaiNg.dish.dishBatchUpload.DishBatchUploadRequest;
import com.meituan.sdk.model.waimaiNg.dish.dishComboBatchsave.DishComboBatchsaveRequest;
import com.meituan.sdk.model.waimaiNg.dish.dishComboSave.DishComboSaveRequest;
import com.meituan.sdk.model.waimaiNg.dish.dishDelete.DishDeleteRequest;
import com.meituan.sdk.model.waimaiNg.dish.dishDeleteCat.DishDeleteCatRequest;
import com.meituan.sdk.model.waimaiNg.dish.dishDeleteSku.DishDeleteSkuRequest;
import com.meituan.sdk.model.waimaiNg.dish.dishFoodListAll.DishFoodListAllRequest;
import com.meituan.sdk.model.waimaiNg.dish.dishGetDetail.DishGetDetailRequest;
import com.meituan.sdk.model.waimaiNg.dish.dishMapping.DishMappingRequest;
import com.meituan.sdk.model.waimaiNg.dish.dishQueryCatList.DishQueryCatListRequest;
import com.meituan.sdk.model.waimaiNg.dish.dishQueryListByEdishCodes.DishQueryListByEdishCodesRequest;
import com.meituan.sdk.model.waimaiNg.dish.dishQueryListByEpoiid.DishQueryListByEpoiidRequest;
import com.meituan.sdk.model.waimaiNg.dish.dishQueryPropertyList.DishQueryPropertyListRequest;
import com.meituan.sdk.model.waimaiNg.dish.dishSkuSellStatus.DishSkuSellStatusRequest;
import com.meituan.sdk.model.waimaiNg.dish.dishUpdateCat.DishUpdateCatRequest;
import com.meituan.sdk.model.waimaiNg.dish.dishUpdatePrice.DishUpdatePriceRequest;
import com.meituan.sdk.model.waimaiNg.dish.dishUpdateProperty.DishUpdatePropertyRequest;
import com.meituan.sdk.model.waimaiNg.dish.dishUpdateStock.DishUpdateStockRequest;
import com.meituan.sdk.model.waimaiNg.dish.foodBatchGet.FoodBatchGetRequest;
import com.meituan.sdk.model.waimaiNg.dish.foodBatchQueryList.FoodBatchQueryListRequest;
import com.meituan.sdk.model.waimaiNg.dish.foodCatDelete.FoodCatDeleteRequest;
import com.meituan.sdk.model.waimaiNg.dish.foodCatList.FoodCatListRequest;
import com.meituan.sdk.model.waimaiNg.dish.foodCatUpdate.FoodCatUpdateRequest;
import com.meituan.sdk.model.waimaiNg.dish.foodQueryList.FoodQueryListRequest;
import com.meituan.sdk.model.waimaiNg.dish.foodUpdateAppFoodCodeByOrigin.FoodUpdateAppFoodCodeByOriginRequest;
import com.meituan.sdk.model.waimaiNg.dish.foodUpdateAppfoodcodeByNameAndSpec.FoodUpdateAppfoodcodeByNameAndSpecRequest;
import com.meituan.sdk.model.waimaiNg.dish.listMarketPlaces.ListMarketPlacesRequest;
import com.meituan.sdk.model.waimaiNg.dish.queryCategoryList.QueryCategoryListRequest;
import com.meituan.sdk.model.waimaiNg.dish.queryCategoryProperties.QueryCategoryPropertiesRequest;
import com.meituan.sdk.model.waimaiNg.dish.queryFoodDna.QueryFoodDnaRequest;
import com.meituan.sdk.model.waimaiNg.dish.saveFoodDna.SaveFoodDnaRequest;
import com.meituan.sdk.model.waimaiNg.dish.toppingBatchInit.ToppingBatchInitRequest;
import com.meituan.sdk.model.waimaiNg.dish.toppingBatchQuery.ToppingBatchQueryRequest;
import com.meituan.sdk.model.waimaiNg.dish.toppingCodeBindByName.ToppingCodeBindByNameRequest;
import com.meituan.sdk.model.waimaiNg.dish.toppingDelete.ToppingDeleteRequest;
import com.meituan.sdk.model.waimaiNg.dish.toppingGroupBatchInit.ToppingGroupBatchInitRequest;
import com.meituan.sdk.model.waimaiNg.dish.toppingGroupBatchQuery.ToppingGroupBatchQueryRequest;
import com.meituan.sdk.model.waimaiNg.dish.toppingGroupDelete.ToppingGroupDeleteRequest;
import com.meituan.sdk.model.waimaiNg.dish.toppingGroupList.ToppingGroupListRequest;
import com.meituan.sdk.model.waimaiNg.dish.toppingList.ToppingListRequest;
import com.meituan.sdk.model.waimaiNg.dish.waimaiQueryBoxPricetypeAndDetail.WaimaiQueryBoxPricetypeAndDetailRequest;
import com.meituan.sdk.model.waimaiNg.dish.waimaiSaveBoxPriceTypeAndDetail.WaimaiSaveBoxPriceTypeAndDetailRequest;
import com.meituan.sdk.model.waimaiNg.govern.governAppealDetailQuery.GovernAppealDetailQueryRequest;
import com.meituan.sdk.model.waimaiNg.govern.governViolationQuery.GovernViolationQueryRequest;
import com.meituan.sdk.model.waimaiNg.govern.governViolationScoreQuery.GovernViolationScoreQueryRequest;
import com.meituan.sdk.model.waimaiNg.govern.governViolationScoreRecordQuery.GovernViolationScoreRecordQueryRequest;
import com.meituan.sdk.model.waimaiNg.govern.governWarningListQuery.GovernWarningListQueryRequest;
import com.meituan.sdk.model.waimaiNg.im.blockUser.BlockUserRequest;
import com.meituan.sdk.model.waimaiNg.im.cancelBlockUser.CancelBlockUserRequest;
import com.meituan.sdk.model.waimaiNg.im.createEnterCouponActivity.CreateEnterCouponActivityRequest;
import com.meituan.sdk.model.waimaiNg.im.createFansGroup.CreateFansGroupRequest;
import com.meituan.sdk.model.waimaiNg.im.createGroup.CreateGroupRequest;
import com.meituan.sdk.model.waimaiNg.im.getAutoSendConfigInfo.GetAutoSendConfigInfoRequest;
import com.meituan.sdk.model.waimaiNg.im.getConnectionToken.GetConnectionTokenRequest;
import com.meituan.sdk.model.waimaiNg.im.getConnectionTokenWithCount.GetConnectionTokenWithCountRequest;
import com.meituan.sdk.model.waimaiNg.im.getPoiImStatus.GetPoiImStatusRequest;
import com.meituan.sdk.model.waimaiNg.im.getReversionRateAndRightsList.GetReversionRateAndRightsListRequest;
import com.meituan.sdk.model.waimaiNg.im.msgRead.MsgReadRequest;
import com.meituan.sdk.model.waimaiNg.im.queryCoupon.QueryCouponRequest;
import com.meituan.sdk.model.waimaiNg.im.queryCouponDetail.QueryCouponDetailRequest;
import com.meituan.sdk.model.waimaiNg.im.queryEnterCouponActivity.QueryEnterCouponActivityRequest;
import com.meituan.sdk.model.waimaiNg.im.queryImSubscribeStatusByEpoi.QueryImSubscribeStatusByEpoiRequest;
import com.meituan.sdk.model.waimaiNg.im.queryStoreFansGroup.QueryStoreFansGroupRequest;
import com.meituan.sdk.model.waimaiNg.im.queryStoreHaveBuild.QueryStoreHaveBuildRequest;
import com.meituan.sdk.model.waimaiNg.im.remainCoupon.RemainCouponRequest;
import com.meituan.sdk.model.waimaiNg.im.revokeEnterCouponActivity.RevokeEnterCouponActivityRequest;
import com.meituan.sdk.model.waimaiNg.im.sendFansGroupCoupon.SendFansGroupCouponRequest;
import com.meituan.sdk.model.waimaiNg.im.sendImMsgWaimai.SendImMsgWaimaiRequest;
import com.meituan.sdk.model.waimaiNg.im.setAutoSendConfig.SetAutoSendConfigRequest;
import com.meituan.sdk.model.waimaiNg.im.setAutoSendConfigInfo.SetAutoSendConfigInfoRequest;
import com.meituan.sdk.model.waimaiNg.im.setPoiImStatus.SetPoiImStatusRequest;
import com.meituan.sdk.model.waimaiNg.im.subscribeImByEpoi.SubscribeImByEpoiRequest;
import com.meituan.sdk.model.waimaiNg.im.unsubscribeImByEpoi.UnsubscribeImByEpoiRequest;
import com.meituan.sdk.model.waimaiNg.im.waimaiImGetReadTime.WaimaiImGetReadTimeRequest;
import com.meituan.sdk.model.waimaiNg.kaidian.waimaiKaidianBizsettle.WaimaiKaidianBizsettleRequest;
import com.meituan.sdk.model.waimaiNg.order.batchPullPhoneNumber.BatchPullPhoneNumberRequest;
import com.meituan.sdk.model.waimaiNg.order.batchQuerySmsSendResult.BatchQuerySmsSendResultRequest;
import com.meituan.sdk.model.waimaiNg.order.businessMetricsReport.BusinessMetricsReportRequest;
import com.meituan.sdk.model.waimaiNg.order.cancelZbLogisticsByWmOrderId.CancelZbLogisticsByWmOrderIdRequest;
import com.meituan.sdk.model.waimaiNg.order.deliveringRiderPositionBatch.DeliveringRiderPositionBatchRequest;
import com.meituan.sdk.model.waimaiNg.order.deliveryCompletedRiderPositionBatch.DeliveryCompletedRiderPositionBatchRequest;
import com.meituan.sdk.model.waimaiNg.order.deliveryNoteAddTip.DeliveryNoteAddTipRequest;
import com.meituan.sdk.model.waimaiNg.order.getBatchOrderRefundInfo.GetBatchOrderRefundInfoRequest;
import com.meituan.sdk.model.waimaiNg.order.getDeliveryPath.GetDeliveryPathRequest;
import com.meituan.sdk.model.waimaiNg.order.getOrderBookerInformation.GetOrderBookerInformationRequest;
import com.meituan.sdk.model.waimaiNg.order.getOrderIdByDaySeq.GetOrderIdByDaySeqRequest;
import com.meituan.sdk.model.waimaiNg.order.getOrderMealStatus.GetOrderMealStatusRequest;
import com.meituan.sdk.model.waimaiNg.order.getOrderRecipientPrivacyInfo.GetOrderRecipientPrivacyInfoRequest;
import com.meituan.sdk.model.waimaiNg.order.getPreparationMealtime.GetPreparationMealtimeRequest;
import com.meituan.sdk.model.waimaiNg.order.getRiderInfoPhoneNumber.GetRiderInfoPhoneNumberRequest;
import com.meituan.sdk.model.waimaiNg.order.getTakeFoodCodeList.GetTakeFoodCodeListRequest;
import com.meituan.sdk.model.waimaiNg.order.getUnConfirmedOrders.GetUnConfirmedOrdersRequest;
import com.meituan.sdk.model.waimaiNg.order.innovativeOrderQuery.InnovativeOrderQueryRequest;
import com.meituan.sdk.model.waimaiNg.order.orderAgreeRefund.OrderAgreeRefundRequest;
import com.meituan.sdk.model.waimaiNg.order.orderApplyPartRefund.OrderApplyPartRefundRequest;
import com.meituan.sdk.model.waimaiNg.order.orderBatchFetchAbnormalOrder.OrderBatchFetchAbnormalOrderRequest;
import com.meituan.sdk.model.waimaiNg.order.orderCancel.OrderCancelRequest;
import com.meituan.sdk.model.waimaiNg.order.orderCancelDispatch.OrderCancelDispatchRequest;
import com.meituan.sdk.model.waimaiNg.order.orderConfirm.OrderConfirmRequest;
import com.meituan.sdk.model.waimaiNg.order.orderDelivered.OrderDeliveredRequest;
import com.meituan.sdk.model.waimaiNg.order.orderDelivering.OrderDeliveringRequest;
import com.meituan.sdk.model.waimaiNg.order.orderDispatchShip.OrderDispatchShipRequest;
import com.meituan.sdk.model.waimaiNg.order.orderEtaModifyAgree.OrderEtaModifyAgreeRequest;
import com.meituan.sdk.model.waimaiNg.order.orderEtaModifyRefuse.OrderEtaModifyRefuseRequest;
import com.meituan.sdk.model.waimaiNg.order.orderFoodslowAppeal.OrderFoodslowAppealRequest;
import com.meituan.sdk.model.waimaiNg.order.orderGetRealRecipientAddress.OrderGetRealRecipientAddressRequest;
import com.meituan.sdk.model.waimaiNg.order.orderKcReport.OrderKcReportRequest;
import com.meituan.sdk.model.waimaiNg.order.orderQueryByDaySeq.OrderQueryByDaySeqRequest;
import com.meituan.sdk.model.waimaiNg.order.orderQueryById.OrderQueryByIdRequest;
import com.meituan.sdk.model.waimaiNg.order.orderQueryPartRefundFoods.OrderQueryPartRefundFoodsRequest;
import com.meituan.sdk.model.waimaiNg.order.orderQueryZbShippingFee.OrderQueryZbShippingFeeRequest;
import com.meituan.sdk.model.waimaiNg.order.orderRefundIssueAppeal.OrderRefundIssueAppealRequest;
import com.meituan.sdk.model.waimaiNg.order.orderRejectRefund.OrderRejectRefundRequest;
import com.meituan.sdk.model.waimaiNg.order.orderRemindReply.OrderRemindReplyRequest;
import com.meituan.sdk.model.waimaiNg.order.orderUpdateZbDispatchTip.OrderUpdateZbDispatchTipRequest;
import com.meituan.sdk.model.waimaiNg.order.preparationMealComplete.PreparationMealCompleteRequest;
import com.meituan.sdk.model.waimaiNg.order.queryLogisticsInfo.QueryLogisticsInfoRequest;
import com.meituan.sdk.model.waimaiNg.order.queryOrderReceiptActivityInfo.QueryOrderReceiptActivityInfoRequest;
import com.meituan.sdk.model.waimaiNg.order.queryZbCancelDeliveryReason.QueryZbCancelDeliveryReasonRequest;
import com.meituan.sdk.model.waimaiNg.order.riderPosition.RiderPositionRequest;
import com.meituan.sdk.model.waimaiNg.order.sendSms.SendSmsRequest;
import com.meituan.sdk.model.waimaiNg.order.setPickCode.SetPickCodeRequest;
import com.meituan.sdk.model.waimaiNg.order.submitFoodSafetyOrderSolution.SubmitFoodSafetyOrderSolutionRequest;
import com.meituan.sdk.model.waimaiNg.order.waimaiGetAuthCode.WaimaiGetAuthCodeRequest;
import com.meituan.sdk.model.waimaiNg.order.wmQueryLogisticsStatus.WmQueryLogisticsStatusRequest;
import com.meituan.sdk.model.waimaiNg.order.zbDispatch.ZbDispatchRequest;
import com.meituan.sdk.model.waimaiNg.order.zbLogisticsPreview.ZbLogisticsPreviewRequest;
import com.meituan.sdk.model.waimaiNg.order.zhongbaoShippingfeebycode.ZhongbaoShippingfeebycodeRequest;
import com.meituan.sdk.model.waimaiNg.poi.getPoiExtendInfo.GetPoiExtendInfoRequest;
import com.meituan.sdk.model.waimaiNg.poi.getPoiScoreDetail.GetPoiScoreDetailRequest;
import com.meituan.sdk.model.waimaiNg.poi.queryStoreEvaluationBenefit.QueryStoreEvaluationBenefitRequest;
import com.meituan.sdk.model.waimaiNg.poi.waimaiPoiClose.WaimaiPoiCloseRequest;
import com.meituan.sdk.model.waimaiNg.poi.waimaiPoiOpen.WaimaiPoiOpenRequest;
import com.meituan.sdk.model.waimaiNg.poi.waimaiPoiQueryDelayDispatch.WaimaiPoiQueryDelayDispatchRequest;
import com.meituan.sdk.model.waimaiNg.poi.waimaiPoiQueryPoiInfo.WaimaiPoiQueryPoiInfoRequest;
import com.meituan.sdk.model.waimaiNg.poi.waimaiPoiUpdateDelayDispatch.WaimaiPoiUpdateDelayDispatchRequest;
import com.meituan.sdk.model.waimaiNg.poi.waimaiPoiUpdateOpenTime.WaimaiPoiUpdateOpenTimeRequest;
import com.meituan.sdk.model.waimaiNg.shipping.shippingBatchsave.ShippingBatchsaveRequest;
import com.meituan.sdk.model.waimaiNg.shipping.shippingDelete.ShippingDeleteRequest;
import com.meituan.sdk.model.waimaiNg.shipping.shippingFetch.ShippingFetchRequest;
import com.meituan.sdk.model.waimaiNg.shipping.shippingList.ShippingListRequest;
import com.meituan.sdk.model.waimaiNg.shipping.shippingResetSelfDeliveryArea.ShippingResetSelfDeliveryAreaRequest;
import com.meituan.sdk.model.waimaiNg.shipping.shippingSave.ShippingSaveRequest;
import com.meituan.sdk.model.waimaiNg.shipping.shippingSpecSave.ShippingSpecSaveRequest;
import com.meituan.sdk.model.waimaiNg.special.getProductCategoryNew.GetProductCategoryNewRequest;
import com.meituan.sdk.model.waimaiNg.special.specialFoodBatchDeleteProduct.SpecialFoodBatchDeleteProductRequest;
import com.meituan.sdk.model.waimaiNg.special.specialFoodBatchQuery.SpecialFoodBatchQueryRequest;
import com.meituan.sdk.model.waimaiNg.special.specialFoodBatchSetSellStatus.SpecialFoodBatchSetSellStatusRequest;
import com.meituan.sdk.model.waimaiNg.special.specialFoodBindSpuAndSkuCode.SpecialFoodBindSpuAndSkuCodeRequest;
import com.meituan.sdk.model.waimaiNg.special.specialFoodConditionQuery.SpecialFoodConditionQueryRequest;
import com.meituan.sdk.model.waimaiNg.special.specialFoodSaveBatchProducts.SpecialFoodSaveBatchProductsRequest;
import com.meituan.sdk.model.waimaiNg.special.specialFoodSaveComboMainProduct.SpecialFoodSaveComboMainProductRequest;
import com.meituan.sdk.model.waimaiNg.special.specialFoodUpdateSellStatus.SpecialFoodUpdateSellStatusRequest;
import com.meituan.sdk.model.waimaiNg.special.specialFoodUpdateStock.SpecialFoodUpdateStockRequest;
import com.meituan.sdk.model.waimaiNg.special.uploadPictureNew.UploadPictureNewRequest;
import com.meituan.sdk.model.waimaiNg.valueadded.getCustomLabels.GetCustomLabelsRequest;
import com.meituan.sdk.model.waimaiNg.valueadded.getSystemLabels.GetSystemLabelsRequest;
import com.meituan.sdk.model.waimaiNg.valueadded.queryCouponDetailExtraResult.QueryCouponDetailExtraResultRequest;
import com.meituan.sdk.model.waimaiNg.valueadded.queryCouponDetailResult.QueryCouponDetailResultRequest;
import com.meituan.sdk.model.waimaiNg.valueadded.queryCouponStock.QueryCouponStockRequest;
import com.meituan.sdk.model.waimaiNg.valueadded.queryCouponTotalResult.QueryCouponTotalResultRequest;
import com.meituan.sdk.model.waimaiNg.valueadded.taskResultQuery.TaskResultQueryRequest;
import com.meituan.sdk.model.waimaiNg.valueadded.taskSubmit.TaskSubmitRequest;
import com.meituan.sdk.model.wmoperNg.card.wmoperCardQuery.WmoperCardQueryRequest;
import com.meituan.sdk.model.wmoperNg.card.wmoperCardSave.WmoperCardSaveRequest;
import com.meituan.sdk.model.wmoperNg.card.wmoperNgCardQuery.WmoperNgCardQueryRequest;
import com.meituan.sdk.model.wmoperNg.card.wmoperNgCardSave.WmoperNgCardSaveRequest;
import com.meituan.sdk.model.wmoperNg.card.wmoperUploadCardImage.WmoperUploadCardImageRequest;
import com.meituan.sdk.model.wmoperNg.comment.wmoperCommentAddReply.WmoperCommentAddReplyRequest;
import com.meituan.sdk.model.wmoperNg.comment.wmoperCommentQueryScore.WmoperCommentQueryScoreRequest;
import com.meituan.sdk.model.wmoperNg.decoration.decorationBossRecommendQuery.DecorationBossRecommendQueryRequest;
import com.meituan.sdk.model.wmoperNg.decoration.decorationProductsQuery.DecorationProductsQueryRequest;
import com.meituan.sdk.model.wmoperNg.decoration.decorationQueryImageForSingle.DecorationQueryImageForSingleRequest;
import com.meituan.sdk.model.wmoperNg.decoration.decorationQueryPoster.DecorationQueryPosterRequest;
import com.meituan.sdk.model.wmoperNg.decoration.wmoperImageUploadNoWater.WmoperImageUploadNoWaterRequest;
import com.meituan.sdk.model.wmoperNg.decorationop.decorationBossRecommendCreate.DecorationBossRecommendCreateRequest;
import com.meituan.sdk.model.wmoperNg.decorationop.decorationDeleteImgeForSingle.DecorationDeleteImgeForSingleRequest;
import com.meituan.sdk.model.wmoperNg.decorationop.decorationDeleteShopPoster.DecorationDeleteShopPosterRequest;
import com.meituan.sdk.model.wmoperNg.decorationop.decorationPostersCreate.DecorationPostersCreateRequest;
import com.meituan.sdk.model.wmoperNg.decorationop.decorationSignageCreate.DecorationSignageCreateRequest;
import com.meituan.sdk.model.wmoperNg.decorationop.decorationUpdatePosterStatus.DecorationUpdatePosterStatusRequest;
import com.meituan.sdk.model.wmoperNg.delivery.getRecipientInfo.GetRecipientInfoRequest;
import com.meituan.sdk.model.wmoperNg.food.batchUpdateSpuById.BatchUpdateSpuByIdRequest;
import com.meituan.sdk.model.wmoperNg.food.bindToppingCodeByName.BindToppingCodeByNameRequest;
import com.meituan.sdk.model.wmoperNg.food.wmoperFoodBatchQueryFoodDna.WmoperFoodBatchQueryFoodDnaRequest;
import com.meituan.sdk.model.wmoperNg.food.wmoperFoodBatchQueryList.WmoperFoodBatchQueryListRequest;
import com.meituan.sdk.model.wmoperNg.food.wmoperFoodPropertyList.WmoperFoodPropertyListRequest;
import com.meituan.sdk.model.wmoperNg.food.wmoperFoodQueryCategoryList.WmoperFoodQueryCategoryListRequest;
import com.meituan.sdk.model.wmoperNg.food.wmoperFoodQueryCategoryProperty.WmoperFoodQueryCategoryPropertyRequest;
import com.meituan.sdk.model.wmoperNg.food.wmoperFoodQueryDetail.WmoperFoodQueryDetailRequest;
import com.meituan.sdk.model.wmoperNg.food.wmoperFoodQueryFoodDna.WmoperFoodQueryFoodDnaRequest;
import com.meituan.sdk.model.wmoperNg.food.wmoperFoodQueryFoodcatList.WmoperFoodQueryFoodcatListRequest;
import com.meituan.sdk.model.wmoperNg.food.wmoperFoodQueryList.WmoperFoodQueryListRequest;
import com.meituan.sdk.model.wmoperNg.food.wmoperQueryBoxPriceTypeAndDetail.WmoperQueryBoxPriceTypeAndDetailRequest;
import com.meituan.sdk.model.wmoperNg.food.wmoperSaveBoxPriceTypeAndDetail.WmoperSaveBoxPriceTypeAndDetailRequest;
import com.meituan.sdk.model.wmoperNg.foodop.foodBatchBulkSave.FoodBatchBulkSaveRequest;
import com.meituan.sdk.model.wmoperNg.foodop.foodBatchinitdata.FoodBatchinitdataRequest;
import com.meituan.sdk.model.wmoperNg.foodop.foodBindProperty.FoodBindPropertyRequest;
import com.meituan.sdk.model.wmoperNg.foodop.foodDelete.FoodDeleteRequest;
import com.meituan.sdk.model.wmoperNg.foodop.foodInitdata.FoodInitdataRequest;
import com.meituan.sdk.model.wmoperNg.foodop.foodSkuDelete.FoodSkuDeleteRequest;
import com.meituan.sdk.model.wmoperNg.foodop.foodSkuDescStock.FoodSkuDescStockRequest;
import com.meituan.sdk.model.wmoperNg.foodop.foodSkuIncStock.FoodSkuIncStockRequest;
import com.meituan.sdk.model.wmoperNg.foodop.foodSkuPrice.FoodSkuPriceRequest;
import com.meituan.sdk.model.wmoperNg.foodop.foodSkuSave.FoodSkuSaveRequest;
import com.meituan.sdk.model.wmoperNg.foodop.foodSkuSellStatus.FoodSkuSellStatusRequest;
import com.meituan.sdk.model.wmoperNg.foodop.foodSkuStock.FoodSkuStockRequest;
import com.meituan.sdk.model.wmoperNg.foodop.fooddnaSaveFooddna.FooddnaSaveFooddnaRequest;
import com.meituan.sdk.model.wmoperNg.foodop.imageUpload.ImageUploadRequest;
import com.meituan.sdk.model.wmoperNg.foodop.wmoperImageUpload.WmoperImageUploadRequest;
import com.meituan.sdk.model.wmoperNg.foodop.wmoperngImageUploadNoWater.WmoperngImageUploadNoWaterRequest;
import com.meituan.sdk.model.wmoperNg.im.imGetReadTime.ImGetReadTimeRequest;
import com.meituan.sdk.model.wmoperNg.im.sendImMsgWmoper.SendImMsgWmoperRequest;
import com.meituan.sdk.model.wmoperNg.order.wmoperGetAuthCode.WmoperGetAuthCodeRequest;
import com.meituan.sdk.model.wmoperNg.order.wmoperOrderQueryOrderDetail.WmoperOrderQueryOrderDetailRequest;
import com.meituan.sdk.model.wmoperNg.order.wmoperOrderQueryOrders.WmoperOrderQueryOrdersRequest;
import com.meituan.sdk.model.wmoperNg.order.wmoperZhongbaoShippingfeebycode.WmoperZhongbaoShippingfeebycodeRequest;
import com.meituan.sdk.model.wmoperNg.order.wmoperngGetOrderDetail.WmoperngGetOrderDetailRequest;
import com.meituan.sdk.model.wmoperNg.order.wmoperngOrderList.WmoperngOrderListRequest;
import com.meituan.sdk.model.wmoperNg.order.wmoperngQueryLogisticsStatus.WmoperngQueryLogisticsStatusRequest;
import com.meituan.sdk.model.wmoperNg.order.wmoperngQueryOrderDetail.WmoperngQueryOrderDetailRequest;
import com.meituan.sdk.model.wmoperNg.poi.poiTagList.PoiTagListRequest;
import com.meituan.sdk.model.wmoperNg.poi.wmoperBatchQueryPoi.WmoperBatchQueryPoiRequest;
import com.meituan.sdk.model.wmoperNg.poi.wmoperPoiWeightCanOpen.WmoperPoiWeightCanOpenRequest;
import com.meituan.sdk.model.wmoperNg.poi.wmoperngQueryPoiDetail.WmoperngQueryPoiDetailRequest;
import com.meituan.sdk.model.wmoperNg.poiop.poiSave.PoiSaveRequest;
import com.meituan.sdk.model.wmoperNg.poiop.poiUpdatepromoteinfo.PoiUpdatepromoteinfoRequest;
import com.meituan.sdk.model.wmoperNg.poiop.poiWeightOpen.PoiWeightOpenRequest;
import com.meituan.sdk.model.wmoperNg.poiop.shippingtimeUpdate.ShippingtimeUpdateRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.adAppBuyInfo.AdAppBuyInfoRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.adBalanceInfo.AdBalanceInfoRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.adDataDetail.AdDataDetailRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.adDataHistory.AdDataHistoryRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.adDataSource.AdDataSourceRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.adDmpQueryCrowdBid.AdDmpQueryCrowdBidRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.adPriceRange.AdPriceRangeRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.adStatusInfo.AdStatusInfoRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.adUpdatePlanBid.AdUpdatePlanBidRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.adUpdatePlanBudget.AdUpdatePlanBudgetRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.adUpdatePlanStatus.AdUpdatePlanStatusRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.appOrderList.AppOrderListRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.authAntiForceTry.AuthAntiForceTryRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.bizOrdCount.BizOrdCountRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.bizOrdList.BizOrdListRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.bizPoiAct.BizPoiActRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.bizPoiFood.BizPoiFoodRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.bizPoiTrade.BizPoiTradeRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.decrypt.DecryptRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.peerAdBidprice.PeerAdBidpriceRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.peerAdEffectdata.PeerAdEffectdataRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.poiAdEffectdata.PoiAdEffectdataRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.poipeerAdEffectdata.PoipeerAdEffectdataRequest;
import com.meituan.sdk.model.wmoperNg.waimaiad.waimaiPoiInfo.WaimaiPoiInfoRequest;
import io.github.easy4j.meituan.client.MeituanRequestExecutor;
import io.github.easy4j.meituan.service.MeituanWaimaiService;

/**
 * 外卖餐饮默认实现。
 * <p>所有业务方法统一委托 {@link AbstractMeituanService} 执行官方 SDK request。</p>
 */
public class MeituanWaimaiServiceImpl extends AbstractMeituanService implements MeituanWaimaiService {

    /**
     * 创建默认业务 service 实现。
     *
     * @param requestExecutor 多租户请求执行器
     */
    public MeituanWaimaiServiceImpl(MeituanRequestExecutor requestExecutor) {
        super(requestExecutor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> actDiscountActivityOrderLimit(ActDiscountActivityOrderLimitRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> actDiscountBatchsave(ActDiscountBatchsaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> actDiscountDelete(ActDiscountDeleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> actDiscountList(ActDiscountListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> actDiscountStock(ActDiscountStockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryCard(QueryCardRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> saveCard(SaveCardRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgCommentComplainReport(CommentComplainReportRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> commentQueryScore(CommentQueryScoreRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> poiCommentReply(PoiCommentReplyRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgQueryCommentList(QueryCommentListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> bossRecommendCreate(BossRecommendCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> bossRecommendQuery(BossRecommendQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> deleteImgeForSingle(DeleteImgeForSingleRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> deleteShopPoster(DeleteShopPosterRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> postersCreate(PostersCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgPostersCreateForSpuId(PostersCreateForSpuIdRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> productsQuery(ProductsQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryImageForSingle(QueryImageForSingleRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryPoster(QueryPosterRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> signageCreate(SignageCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> updatePosterStatus(UpdatePosterStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgSyncEstimateArrivalTime(SyncEstimateArrivalTimeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> diancanOrderConfirm(DiancanOrderConfirmRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> diancanOrderFullFillNotice(DiancanOrderFullFillNoticeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> diancanOrderQuery(DiancanOrderQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> diancanShopServeStatusUpdate(DiancanShopServeStatusUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> diancanShopStatusUpdate(DiancanShopStatusUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> diancanShopconfigQuery(DiancanShopconfigQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> diancanSyncDealMapping(DiancanSyncDealMappingRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgBatchDelSpu(BatchDelSpuRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgBatchInitMarketPlaceFood(BatchInitMarketPlaceFoodRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchQueryFoodDna(BatchQueryFoodDnaRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgBatchQuerySpuByIds(BatchQuerySpuByIdsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchUpdateSpubyId(BatchUpdateSpubyIdRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dishBatchUpload(DishBatchUploadRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgDishComboBatchsave(DishComboBatchsaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgDishComboSave(DishComboSaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dishDelete(DishDeleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dishDeleteCat(DishDeleteCatRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dishDeleteSku(DishDeleteSkuRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgDishFoodListAll(DishFoodListAllRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dishGetDetail(DishGetDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dishMapping(DishMappingRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dishQueryCatList(DishQueryCatListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dishQueryListByEdishCodes(DishQueryListByEdishCodesRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dishQueryListByEpoiid(DishQueryListByEpoiidRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dishQueryPropertyList(DishQueryPropertyListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dishSkuSellStatus(DishSkuSellStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dishUpdateCat(DishUpdateCatRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dishUpdatePrice(DishUpdatePriceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dishUpdateProperty(DishUpdatePropertyRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> dishUpdateStock(DishUpdateStockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgFoodBatchGet(FoodBatchGetRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> foodBatchQueryList(FoodBatchQueryListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgFoodCatDelete(FoodCatDeleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgFoodCatList(FoodCatListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgFoodCatUpdate(FoodCatUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> foodQueryList(FoodQueryListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgFoodUpdateAppFoodCodeByOrigin(FoodUpdateAppFoodCodeByOriginRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgFoodUpdateAppfoodcodeByNameAndSpec(FoodUpdateAppfoodcodeByNameAndSpecRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgListMarketPlaces(ListMarketPlacesRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryCategoryList(QueryCategoryListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryCategoryProperties(QueryCategoryPropertiesRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryFoodDna(QueryFoodDnaRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> saveFoodDna(SaveFoodDnaRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgToppingBatchInit(ToppingBatchInitRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgToppingBatchQuery(ToppingBatchQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> toppingCodeBindByName(ToppingCodeBindByNameRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgToppingDelete(ToppingDeleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgToppingGroupBatchInit(ToppingGroupBatchInitRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgToppingGroupBatchQuery(ToppingGroupBatchQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgToppingGroupDelete(ToppingGroupDeleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgToppingGroupList(ToppingGroupListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgToppingList(ToppingListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiQueryBoxPricetypeAndDetail(WaimaiQueryBoxPricetypeAndDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiSaveBoxPriceTypeAndDetail(WaimaiSaveBoxPriceTypeAndDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGovernAppealDetailQuery(GovernAppealDetailQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGovernViolationQuery(GovernViolationQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGovernViolationScoreQuery(GovernViolationScoreQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGovernViolationScoreRecordQuery(GovernViolationScoreRecordQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGovernWarningListQuery(GovernWarningListQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgBlockUser(BlockUserRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgCancelBlockUser(CancelBlockUserRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgCreateEnterCouponActivity(CreateEnterCouponActivityRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgCreateFansGroup(CreateFansGroupRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgCreateGroup(CreateGroupRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGetAutoSendConfigInfo(GetAutoSendConfigInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGetConnectionToken(GetConnectionTokenRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGetConnectionTokenWithCount(GetConnectionTokenWithCountRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGetPoiImStatus(GetPoiImStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGetReversionRateAndRightsList(GetReversionRateAndRightsListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgMsgRead(MsgReadRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgQueryCoupon(QueryCouponRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgQueryCouponDetail(QueryCouponDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgQueryEnterCouponActivity(QueryEnterCouponActivityRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgQueryImSubscribeStatusByEpoi(QueryImSubscribeStatusByEpoiRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgQueryStoreFansGroup(QueryStoreFansGroupRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgQueryStoreHaveBuild(QueryStoreHaveBuildRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgRemainCoupon(RemainCouponRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgRevokeEnterCouponActivity(RevokeEnterCouponActivityRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgSendFansGroupCoupon(SendFansGroupCouponRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> sendImMsgWaimai(SendImMsgWaimaiRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgSetAutoSendConfig(SetAutoSendConfigRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgSetAutoSendConfigInfo(SetAutoSendConfigInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgSetPoiImStatus(SetPoiImStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgSubscribeImByEpoi(SubscribeImByEpoiRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgUnsubscribeImByEpoi(UnsubscribeImByEpoiRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiImGetReadTime(WaimaiImGetReadTimeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiKaidianBizsettle(WaimaiKaidianBizsettleRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchPullPhoneNumber(BatchPullPhoneNumberRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgBatchQuerySmsSendResult(BatchQuerySmsSendResultRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> businessMetricsReport(BusinessMetricsReportRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgCancelZbLogisticsByWmOrderId(CancelZbLogisticsByWmOrderIdRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgDeliveringRiderPositionBatch(DeliveringRiderPositionBatchRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgDeliveryCompletedRiderPositionBatch(DeliveryCompletedRiderPositionBatchRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> deliveryNoteAddTip(DeliveryNoteAddTipRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGetBatchOrderRefundInfo(GetBatchOrderRefundInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGetDeliveryPath(GetDeliveryPathRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGetOrderBookerInformation(GetOrderBookerInformationRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getOrderIdByDaySeq(GetOrderIdByDaySeqRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGetOrderMealStatus(GetOrderMealStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGetOrderRecipientPrivacyInfo(GetOrderRecipientPrivacyInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGetPreparationMealtime(GetPreparationMealtimeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getRiderInfoPhoneNumber(GetRiderInfoPhoneNumberRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getTakeFoodCodeList(GetTakeFoodCodeListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getUnConfirmedOrders(GetUnConfirmedOrdersRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgInnovativeOrderQuery(InnovativeOrderQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderAgreeRefund(OrderAgreeRefundRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderApplyPartRefund(OrderApplyPartRefundRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderBatchFetchAbnormalOrder(OrderBatchFetchAbnormalOrderRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderCancel(OrderCancelRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderCancelDispatch(OrderCancelDispatchRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderConfirm(OrderConfirmRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderDelivered(OrderDeliveredRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderDelivering(OrderDeliveringRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderDispatchShip(OrderDispatchShipRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderEtaModifyAgree(OrderEtaModifyAgreeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderEtaModifyRefuse(OrderEtaModifyRefuseRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderFoodslowAppeal(OrderFoodslowAppealRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderGetRealRecipientAddress(OrderGetRealRecipientAddressRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderKcReport(OrderKcReportRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderQueryByDaySeq(OrderQueryByDaySeqRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderQueryById(OrderQueryByIdRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderQueryPartRefundFoods(OrderQueryPartRefundFoodsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgOrderQueryZbShippingFee(OrderQueryZbShippingFeeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderRefundIssueAppeal(OrderRefundIssueAppealRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderRejectRefund(OrderRejectRefundRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> orderRemindReply(OrderRemindReplyRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgOrderUpdateZbDispatchTip(OrderUpdateZbDispatchTipRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgPreparationMealComplete(PreparationMealCompleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryLogisticsInfo(QueryLogisticsInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> queryOrderReceiptActivityInfo(QueryOrderReceiptActivityInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgQueryZbCancelDeliveryReason(QueryZbCancelDeliveryReasonRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgRiderPosition(RiderPositionRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgSendSms(SendSmsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> setPickCode(SetPickCodeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> submitFoodSafetyOrderSolution(SubmitFoodSafetyOrderSolutionRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiGetAuthCode(WaimaiGetAuthCodeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmQueryLogisticsStatus(WmQueryLogisticsStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgZbDispatch(ZbDispatchRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgZbLogisticsPreview(ZbLogisticsPreviewRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> zhongbaoShippingfeebycode(ZhongbaoShippingfeebycodeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGetPoiExtendInfo(GetPoiExtendInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGetPoiScoreDetail(GetPoiScoreDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgQueryStoreEvaluationBenefit(QueryStoreEvaluationBenefitRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiPoiClose(WaimaiPoiCloseRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiPoiOpen(WaimaiPoiOpenRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiPoiQueryDelayDispatch(WaimaiPoiQueryDelayDispatchRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiPoiQueryPoiInfo(WaimaiPoiQueryPoiInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiPoiUpdateDelayDispatch(WaimaiPoiUpdateDelayDispatchRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiPoiUpdateOpenTime(WaimaiPoiUpdateOpenTimeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgShippingBatchsave(ShippingBatchsaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgShippingDelete(ShippingDeleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgShippingFetch(ShippingFetchRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgShippingList(ShippingListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgShippingResetSelfDeliveryArea(ShippingResetSelfDeliveryAreaRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgShippingSave(ShippingSaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgShippingSpecSave(ShippingSpecSaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getProductCategoryNew(GetProductCategoryNewRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> specialFoodBatchDeleteProduct(SpecialFoodBatchDeleteProductRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgSpecialFoodBatchQuery(SpecialFoodBatchQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> specialFoodBatchSetSellStatus(SpecialFoodBatchSetSellStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgSpecialFoodBindSpuAndSkuCode(SpecialFoodBindSpuAndSkuCodeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgSpecialFoodConditionQuery(SpecialFoodConditionQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> specialFoodSaveBatchProducts(SpecialFoodSaveBatchProductsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> specialFoodSaveComboMainProduct(SpecialFoodSaveComboMainProductRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgSpecialFoodUpdateSellStatus(SpecialFoodUpdateSellStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgSpecialFoodUpdateStock(SpecialFoodUpdateStockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> uploadPictureNew(UploadPictureNewRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGetCustomLabels(GetCustomLabelsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgGetSystemLabels(GetSystemLabelsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgQueryCouponDetailExtraResult(QueryCouponDetailExtraResultRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgQueryCouponDetailResult(QueryCouponDetailResultRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgQueryCouponStock(QueryCouponStockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgQueryCouponTotalResult(QueryCouponTotalResultRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgTaskResultQuery(TaskResultQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiNgTaskSubmit(TaskSubmitRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperCardQuery(WmoperCardQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperCardSave(WmoperCardSaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgCardQuery(WmoperNgCardQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgCardSave(WmoperNgCardSaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperUploadCardImage(WmoperUploadCardImageRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgCommentComplainReport(com.meituan.sdk.model.wmoperNg.comment.commentComplainReport.CommentComplainReportRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgQueryCommentList(com.meituan.sdk.model.wmoperNg.comment.queryCommentList.QueryCommentListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperCommentAddReply(WmoperCommentAddReplyRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperCommentQueryScore(WmoperCommentQueryScoreRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> decorationBossRecommendQuery(DecorationBossRecommendQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> decorationProductsQuery(DecorationProductsQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> decorationQueryImageForSingle(DecorationQueryImageForSingleRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> decorationQueryPoster(DecorationQueryPosterRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperImageUploadNoWater(WmoperImageUploadNoWaterRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> decorationBossRecommendCreate(DecorationBossRecommendCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> decorationDeleteImgeForSingle(DecorationDeleteImgeForSingleRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> decorationDeleteShopPoster(DecorationDeleteShopPosterRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> decorationPostersCreate(DecorationPostersCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> decorationSignageCreate(DecorationSignageCreateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> decorationUpdatePosterStatus(DecorationUpdatePosterStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgPostersCreateForSpuId(com.meituan.sdk.model.wmoperNg.decorationop.postersCreateForSpuId.PostersCreateForSpuIdRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> getRecipientInfo(GetRecipientInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgSyncEstimateArrivalTime(com.meituan.sdk.model.wmoperNg.delivery.syncEstimateArrivalTime.SyncEstimateArrivalTimeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgBatchDelSpu(com.meituan.sdk.model.wmoperNg.food.batchDelSpu.BatchDelSpuRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgBatchInitMarketPlaceFood(com.meituan.sdk.model.wmoperNg.food.batchInitMarketPlaceFood.BatchInitMarketPlaceFoodRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgBatchQuerySpuByIds(com.meituan.sdk.model.wmoperNg.food.batchQuerySpuByIds.BatchQuerySpuByIdsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> batchUpdateSpuById(BatchUpdateSpuByIdRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> bindToppingCodeByName(BindToppingCodeByNameRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgDishComboBatchsave(com.meituan.sdk.model.wmoperNg.food.dishComboBatchsave.DishComboBatchsaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgDishComboSave(com.meituan.sdk.model.wmoperNg.food.dishComboSave.DishComboSaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgDishFoodListAll(com.meituan.sdk.model.wmoperNg.food.dishFoodListAll.DishFoodListAllRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgFoodBatchGet(com.meituan.sdk.model.wmoperNg.food.foodBatchGet.FoodBatchGetRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgFoodCatDelete(com.meituan.sdk.model.wmoperNg.food.foodCatDelete.FoodCatDeleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgFoodCatList(com.meituan.sdk.model.wmoperNg.food.foodCatList.FoodCatListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgFoodCatUpdate(com.meituan.sdk.model.wmoperNg.food.foodCatUpdate.FoodCatUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgListMarketPlaces(com.meituan.sdk.model.wmoperNg.food.listMarketPlaces.ListMarketPlacesRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgToppingBatchInit(com.meituan.sdk.model.wmoperNg.food.toppingBatchInit.ToppingBatchInitRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgToppingBatchQuery(com.meituan.sdk.model.wmoperNg.food.toppingBatchQuery.ToppingBatchQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgToppingDelete(com.meituan.sdk.model.wmoperNg.food.toppingDelete.ToppingDeleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgToppingGroupBatchInit(com.meituan.sdk.model.wmoperNg.food.toppingGroupBatchInit.ToppingGroupBatchInitRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgToppingGroupBatchQuery(com.meituan.sdk.model.wmoperNg.food.toppingGroupBatchQuery.ToppingGroupBatchQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgToppingGroupDelete(com.meituan.sdk.model.wmoperNg.food.toppingGroupDelete.ToppingGroupDeleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgToppingGroupList(com.meituan.sdk.model.wmoperNg.food.toppingGroupList.ToppingGroupListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgToppingList(com.meituan.sdk.model.wmoperNg.food.toppingList.ToppingListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperFoodBatchQueryFoodDna(WmoperFoodBatchQueryFoodDnaRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperFoodBatchQueryList(WmoperFoodBatchQueryListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperFoodPropertyList(WmoperFoodPropertyListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperFoodQueryCategoryList(WmoperFoodQueryCategoryListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperFoodQueryCategoryProperty(WmoperFoodQueryCategoryPropertyRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperFoodQueryDetail(WmoperFoodQueryDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperFoodQueryFoodDna(WmoperFoodQueryFoodDnaRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperFoodQueryFoodcatList(WmoperFoodQueryFoodcatListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperFoodQueryList(WmoperFoodQueryListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperQueryBoxPriceTypeAndDetail(WmoperQueryBoxPriceTypeAndDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperSaveBoxPriceTypeAndDetail(WmoperSaveBoxPriceTypeAndDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> foodBatchBulkSave(FoodBatchBulkSaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> foodBatchinitdata(FoodBatchinitdataRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> foodBindProperty(FoodBindPropertyRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgFoodCatDelete(com.meituan.sdk.model.wmoperNg.foodop.foodCatDelete.FoodCatDeleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgFoodCatUpdate(com.meituan.sdk.model.wmoperNg.foodop.foodCatUpdate.FoodCatUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> foodDelete(FoodDeleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> foodInitdata(FoodInitdataRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> foodSkuDelete(FoodSkuDeleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> foodSkuDescStock(FoodSkuDescStockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> foodSkuIncStock(FoodSkuIncStockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> foodSkuPrice(FoodSkuPriceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> foodSkuSave(FoodSkuSaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> foodSkuSellStatus(FoodSkuSellStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> foodSkuStock(FoodSkuStockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgFoodUpdateAppFoodCodeByOrigin(com.meituan.sdk.model.wmoperNg.foodop.foodUpdateAppFoodCodeByOrigin.FoodUpdateAppFoodCodeByOriginRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgFoodUpdateAppfoodcodeByNameAndSpec(com.meituan.sdk.model.wmoperNg.foodop.foodUpdateAppfoodcodeByNameAndSpec.FoodUpdateAppfoodcodeByNameAndSpecRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> fooddnaSaveFooddna(FooddnaSaveFooddnaRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> imageUpload(ImageUploadRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperImageUpload(WmoperImageUploadRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperngImageUploadNoWater(WmoperngImageUploadNoWaterRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGovernAppealDetailQuery(com.meituan.sdk.model.wmoperNg.govern.governAppealDetailQuery.GovernAppealDetailQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGovernViolationQuery(com.meituan.sdk.model.wmoperNg.govern.governViolationQuery.GovernViolationQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGovernViolationScoreQuery(com.meituan.sdk.model.wmoperNg.govern.governViolationScoreQuery.GovernViolationScoreQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGovernViolationScoreRecordQuery(com.meituan.sdk.model.wmoperNg.govern.governViolationScoreRecordQuery.GovernViolationScoreRecordQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGovernWarningListQuery(com.meituan.sdk.model.wmoperNg.govern.governWarningListQuery.GovernWarningListQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgBlockUser(com.meituan.sdk.model.wmoperNg.im.blockUser.BlockUserRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgCancelBlockUser(com.meituan.sdk.model.wmoperNg.im.cancelBlockUser.CancelBlockUserRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgCreateEnterCouponActivity(com.meituan.sdk.model.wmoperNg.im.createEnterCouponActivity.CreateEnterCouponActivityRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgCreateFansGroup(com.meituan.sdk.model.wmoperNg.im.createFansGroup.CreateFansGroupRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgCreateGroup(com.meituan.sdk.model.wmoperNg.im.createGroup.CreateGroupRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGetAutoSendConfigInfo(com.meituan.sdk.model.wmoperNg.im.getAutoSendConfigInfo.GetAutoSendConfigInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGetConnectionToken(com.meituan.sdk.model.wmoperNg.im.getConnectionToken.GetConnectionTokenRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGetConnectionTokenWithCount(com.meituan.sdk.model.wmoperNg.im.getConnectionTokenWithCount.GetConnectionTokenWithCountRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGetPoiImStatus(com.meituan.sdk.model.wmoperNg.im.getPoiImStatus.GetPoiImStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGetReversionRateAndRightsList(com.meituan.sdk.model.wmoperNg.im.getReversionRateAndRightsList.GetReversionRateAndRightsListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> imGetReadTime(ImGetReadTimeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgMsgRead(com.meituan.sdk.model.wmoperNg.im.msgRead.MsgReadRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgQueryCoupon(com.meituan.sdk.model.wmoperNg.im.queryCoupon.QueryCouponRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgQueryCouponDetail(com.meituan.sdk.model.wmoperNg.im.queryCouponDetail.QueryCouponDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgQueryEnterCouponActivity(com.meituan.sdk.model.wmoperNg.im.queryEnterCouponActivity.QueryEnterCouponActivityRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgQueryImSubscribeStatusByEpoi(com.meituan.sdk.model.wmoperNg.im.queryImSubscribeStatusByEpoi.QueryImSubscribeStatusByEpoiRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgQueryStoreFansGroup(com.meituan.sdk.model.wmoperNg.im.queryStoreFansGroup.QueryStoreFansGroupRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgQueryStoreHaveBuild(com.meituan.sdk.model.wmoperNg.im.queryStoreHaveBuild.QueryStoreHaveBuildRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgRemainCoupon(com.meituan.sdk.model.wmoperNg.im.remainCoupon.RemainCouponRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgRevokeEnterCouponActivity(com.meituan.sdk.model.wmoperNg.im.revokeEnterCouponActivity.RevokeEnterCouponActivityRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgSendFansGroupCoupon(com.meituan.sdk.model.wmoperNg.im.sendFansGroupCoupon.SendFansGroupCouponRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> sendImMsgWmoper(SendImMsgWmoperRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgSetAutoSendConfig(com.meituan.sdk.model.wmoperNg.im.setAutoSendConfig.SetAutoSendConfigRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgSetAutoSendConfigInfo(com.meituan.sdk.model.wmoperNg.im.setAutoSendConfigInfo.SetAutoSendConfigInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgSetPoiImStatus(com.meituan.sdk.model.wmoperNg.im.setPoiImStatus.SetPoiImStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgSubscribeImByEpoi(com.meituan.sdk.model.wmoperNg.im.subscribeImByEpoi.SubscribeImByEpoiRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgUnsubscribeImByEpoi(com.meituan.sdk.model.wmoperNg.im.unsubscribeImByEpoi.UnsubscribeImByEpoiRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgBatchQuerySmsSendResult(com.meituan.sdk.model.wmoperNg.order.batchQuerySmsSendResult.BatchQuerySmsSendResultRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgCancelZbLogisticsByWmOrderId(com.meituan.sdk.model.wmoperNg.order.cancelZbLogisticsByWmOrderId.CancelZbLogisticsByWmOrderIdRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgDeliveringRiderPositionBatch(com.meituan.sdk.model.wmoperNg.order.deliveringRiderPositionBatch.DeliveringRiderPositionBatchRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgDeliveryCompletedRiderPositionBatch(com.meituan.sdk.model.wmoperNg.order.deliveryCompletedRiderPositionBatch.DeliveryCompletedRiderPositionBatchRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGetBatchOrderRefundInfo(com.meituan.sdk.model.wmoperNg.order.getBatchOrderRefundInfo.GetBatchOrderRefundInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGetDeliveryPath(com.meituan.sdk.model.wmoperNg.order.getDeliveryPath.GetDeliveryPathRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGetOrderBookerInformation(com.meituan.sdk.model.wmoperNg.order.getOrderBookerInformation.GetOrderBookerInformationRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGetOrderMealStatus(com.meituan.sdk.model.wmoperNg.order.getOrderMealStatus.GetOrderMealStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGetOrderRecipientPrivacyInfo(com.meituan.sdk.model.wmoperNg.order.getOrderRecipientPrivacyInfo.GetOrderRecipientPrivacyInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGetPreparationMealtime(com.meituan.sdk.model.wmoperNg.order.getPreparationMealtime.GetPreparationMealtimeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgInnovativeOrderQuery(com.meituan.sdk.model.wmoperNg.order.innovativeOrderQuery.InnovativeOrderQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgOrderQueryZbShippingFee(com.meituan.sdk.model.wmoperNg.order.orderQueryZbShippingFee.OrderQueryZbShippingFeeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgOrderUpdateZbDispatchTip(com.meituan.sdk.model.wmoperNg.order.orderUpdateZbDispatchTip.OrderUpdateZbDispatchTipRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgPreparationMealComplete(com.meituan.sdk.model.wmoperNg.order.preparationMealComplete.PreparationMealCompleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgQueryZbCancelDeliveryReason(com.meituan.sdk.model.wmoperNg.order.queryZbCancelDeliveryReason.QueryZbCancelDeliveryReasonRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgRiderPosition(com.meituan.sdk.model.wmoperNg.order.riderPosition.RiderPositionRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgSendSms(com.meituan.sdk.model.wmoperNg.order.sendSms.SendSmsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperGetAuthCode(WmoperGetAuthCodeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperOrderQueryOrderDetail(WmoperOrderQueryOrderDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperOrderQueryOrders(WmoperOrderQueryOrdersRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperZhongbaoShippingfeebycode(WmoperZhongbaoShippingfeebycodeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperngGetOrderDetail(WmoperngGetOrderDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperngOrderList(WmoperngOrderListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperngQueryLogisticsStatus(WmoperngQueryLogisticsStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperngQueryOrderDetail(WmoperngQueryOrderDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgZbDispatch(com.meituan.sdk.model.wmoperNg.order.zbDispatch.ZbDispatchRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgZbLogisticsPreview(com.meituan.sdk.model.wmoperNg.order.zbLogisticsPreview.ZbLogisticsPreviewRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGetPoiExtendInfo(com.meituan.sdk.model.wmoperNg.poi.getPoiExtendInfo.GetPoiExtendInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGetPoiScoreDetail(com.meituan.sdk.model.wmoperNg.poi.getPoiScoreDetail.GetPoiScoreDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> poiTagList(PoiTagListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgQueryStoreEvaluationBenefit(com.meituan.sdk.model.wmoperNg.poi.queryStoreEvaluationBenefit.QueryStoreEvaluationBenefitRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperBatchQueryPoi(WmoperBatchQueryPoiRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperPoiWeightCanOpen(WmoperPoiWeightCanOpenRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperngQueryPoiDetail(WmoperngQueryPoiDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> poiSave(PoiSaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> poiUpdatepromoteinfo(PoiUpdatepromoteinfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> poiWeightOpen(PoiWeightOpenRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> shippingtimeUpdate(ShippingtimeUpdateRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgShippingFetch(com.meituan.sdk.model.wmoperNg.shipping.shippingFetch.ShippingFetchRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgShippingList(com.meituan.sdk.model.wmoperNg.shipping.shippingList.ShippingListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgShippingBatchsave(com.meituan.sdk.model.wmoperNg.shippingop.shippingBatchsave.ShippingBatchsaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgShippingDelete(com.meituan.sdk.model.wmoperNg.shippingop.shippingDelete.ShippingDeleteRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgShippingResetSelfDeliveryArea(com.meituan.sdk.model.wmoperNg.shippingop.shippingResetSelfDeliveryArea.ShippingResetSelfDeliveryAreaRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgShippingSave(com.meituan.sdk.model.wmoperNg.shippingop.shippingSave.ShippingSaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgShippingSpecSave(com.meituan.sdk.model.wmoperNg.shippingop.shippingSpecSave.ShippingSpecSaveRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgSpecialFoodBatchQuery(com.meituan.sdk.model.wmoperNg.special.specialFoodBatchQuery.SpecialFoodBatchQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgSpecialFoodBindSpuAndSkuCode(com.meituan.sdk.model.wmoperNg.special.specialFoodBindSpuAndSkuCode.SpecialFoodBindSpuAndSkuCodeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgSpecialFoodConditionQuery(com.meituan.sdk.model.wmoperNg.special.specialFoodConditionQuery.SpecialFoodConditionQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgSpecialFoodUpdateSellStatus(com.meituan.sdk.model.wmoperNg.special.specialFoodUpdateSellStatus.SpecialFoodUpdateSellStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgSpecialFoodUpdateStock(com.meituan.sdk.model.wmoperNg.special.specialFoodUpdateStock.SpecialFoodUpdateStockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGetCustomLabels(com.meituan.sdk.model.wmoperNg.valueadded.getCustomLabels.GetCustomLabelsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgGetSystemLabels(com.meituan.sdk.model.wmoperNg.valueadded.getSystemLabels.GetSystemLabelsRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgQueryCouponDetailExtraResult(com.meituan.sdk.model.wmoperNg.valueadded.queryCouponDetailExtraResult.QueryCouponDetailExtraResultRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgQueryCouponDetailResult(com.meituan.sdk.model.wmoperNg.valueadded.queryCouponDetailResult.QueryCouponDetailResultRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgQueryCouponStock(com.meituan.sdk.model.wmoperNg.valueadded.queryCouponStock.QueryCouponStockRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgQueryCouponTotalResult(com.meituan.sdk.model.wmoperNg.valueadded.queryCouponTotalResult.QueryCouponTotalResultRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgTaskResultQuery(com.meituan.sdk.model.wmoperNg.valueadded.taskResultQuery.TaskResultQueryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> wmoperNgTaskSubmit(com.meituan.sdk.model.wmoperNg.valueadded.taskSubmit.TaskSubmitRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> adAppBuyInfo(AdAppBuyInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> adBalanceInfo(AdBalanceInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> adDataDetail(AdDataDetailRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> adDataHistory(AdDataHistoryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> adDataSource(AdDataSourceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> adDmpQueryCrowdBid(AdDmpQueryCrowdBidRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> adPriceRange(AdPriceRangeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> adStatusInfo(AdStatusInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> adUpdatePlanBid(AdUpdatePlanBidRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> adUpdatePlanBudget(AdUpdatePlanBudgetRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> adUpdatePlanStatus(AdUpdatePlanStatusRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> appOrderList(AppOrderListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> authAntiForceTry(AuthAntiForceTryRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> bizOrdCount(BizOrdCountRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> bizOrdList(BizOrdListRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> bizPoiAct(BizPoiActRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> bizPoiFood(BizPoiFoodRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> bizPoiTrade(BizPoiTradeRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> decrypt(DecryptRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> peerAdBidprice(PeerAdBidpriceRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> peerAdEffectdata(PeerAdEffectdataRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> poiAdEffectdata(PoiAdEffectdataRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> poipeerAdEffectdata(PoipeerAdEffectdataRequest request, String tenantId) {
        return execute(request, tenantId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeituanResponse<?> waimaiPoiInfo(WaimaiPoiInfoRequest request, String tenantId) {
        return execute(request, tenantId);
    }
}
