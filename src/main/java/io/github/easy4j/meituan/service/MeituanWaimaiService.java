package io.github.easy4j.meituan.service;

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

/**
 * 外卖餐饮业务能力门面。
 * <p>方法参数保持官方 MtOpJavaSDK request 类型，SDK 负责按租户执行授权调用。</p>
 */
public interface MeituanWaimaiService extends MeituanService {

    /**
     * 更新折扣商品外卖门店维度每单限购数量。
     * <p>官方接口：{@code /waimai/ng/act/discount/activityOrderLimit}，API：{@code act_discount_activity_order_limit}，版本：{@code 10005}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> actDiscountActivityOrderLimit(ActDiscountActivityOrderLimitRequest request, String tenantId);

    /**
     * 批量创建或更新折扣商品。
     * <p>官方接口：{@code /waimai/ng/act/discount/batchsave}，API：{@code act_discount_batchsave}，版本：{@code 10000}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> actDiscountBatchsave(ActDiscountBatchsaveRequest request, String tenantId);

    /**
     * 批量删除折扣商品。
     * <p>官方接口：{@code /waimai/ng/act/discount/delete}，API：{@code act_discount_delete}，版本：{@code 10001}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> actDiscountDelete(ActDiscountDeleteRequest request, String tenantId);

    /**
     * 批量查询折扣商品。
     * <p>官方接口：{@code /waimai/ng/act/discount/list}，API：{@code act_discount_list}，版本：{@code 10003}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> actDiscountList(ActDiscountListRequest request, String tenantId);

    /**
     * 批量更新折扣商品当日活动库存。
     * <p>官方接口：{@code /waimai/ng/act/discount/stock}，API：{@code act_discount_stock}，版本：{@code 10002}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> actDiscountStock(ActDiscountStockRequest request, String tenantId);

    /**
     * 查询安心卡。
     * <p>官方接口：{@code /waimai/ng/card/query}，API：{@code query_card}，版本：{@code 10010}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryCard(QueryCardRequest request, String tenantId);

    /**
     * 保存安心卡。
     * <p>官方接口：{@code /waimai/ng/card/save}，API：{@code save_card}，版本：{@code 10011}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> saveCard(SaveCardRequest request, String tenantId);

    /**
     * 评价申诉接口。
     * <p>官方接口：{@code /waimai/ng/comment/complain/report}，API：{@code comment_complain_report}，版本：{@code 10008}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgCommentComplainReport(CommentComplainReportRequest request, String tenantId);

    /**
     * 查询门店评分。
     * <p>官方接口：{@code /waimai/ng/comment/queryScore}，API：{@code comment_query_score}，版本：{@code 10020}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> commentQueryScore(CommentQueryScoreRequest request, String tenantId);

    /**
     * 外卖评价回复。
     * <p>官方接口：{@code /waimai/poi/addReply}，API：{@code poi_comment_reply}，版本：{@code 10013}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> poiCommentReply(PoiCommentReplyRequest request, String tenantId);

    /**
     * 查询门店评价信息。
     * <p>官方接口：{@code /waimai/ng/comment/queryCommentList}，API：{@code query_comment_list}，版本：{@code 10018}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgQueryCommentList(QueryCommentListRequest request, String tenantId);

    /**
     * 商家开放平台创建、修改、删除老板推荐。
     * <p>官方接口：{@code /waimai/ng/decoration/bossRecommendCreate}，API：{@code boss_recommend_create}，版本：{@code 10001}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> bossRecommendCreate(BossRecommendCreateRequest request, String tenantId);

    /**
     * 商家开放平台查询老板推荐。
     * <p>官方接口：{@code /waimai/ng/decoration/bossRecommendQuery}，API：{@code boss_recommend_query}，版本：{@code 10001}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> bossRecommendQuery(BossRecommendQueryRequest request, String tenantId);

    /**
     * 商家开放平台删除招牌。
     * <p>官方接口：{@code /waimai/ng/decoration/deleteImgeForSingle}，API：{@code delete_imge_for_single}，版本：{@code 10001}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> deleteImgeForSingle(DeleteImgeForSingleRequest request, String tenantId);

    /**
     * 商家开放平台删除海报。
     * <p>官方接口：{@code /waimai/ng/decoration/deleteShopPoster}，API：{@code delete_shop_poster}，版本：{@code 10001}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> deleteShopPoster(DeleteShopPosterRequest request, String tenantId);

    /**
     * 商家开放平台创建海报。
     * <p>官方接口：{@code /waimai/ng/decoration/postersCreate}，API：{@code posters_create}，版本：{@code 10000}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> postersCreate(PostersCreateRequest request, String tenantId);

    /**
     * 门店装修-新建海报接口(通过spuid)。
     * <p>官方接口：{@code /waimai/ng/decoration/postersCreateForSpuId}，API：{@code posters_create_for_spu_id}，版本：{@code 10002}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgPostersCreateForSpuId(PostersCreateForSpuIdRequest request, String tenantId);

    /**
     * 商家开放平台商品查询。
     * <p>官方接口：{@code /waimai/ng/decoration/productsQuery}，API：{@code products_query}，版本：{@code 10001}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> productsQuery(ProductsQueryRequest request, String tenantId);

    /**
     * 商家开放平台查询招牌。
     * <p>官方接口：{@code /waimai/ng/decoration/queryImageForSingle}，API：{@code query_image_for_single}，版本：{@code 10001}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryImageForSingle(QueryImageForSingleRequest request, String tenantId);

    /**
     * 商家开放平台海报查询。
     * <p>官方接口：{@code /waimai/ng/decoration/queryPoster}，API：{@code query_poster}，版本：{@code 10001}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryPoster(QueryPosterRequest request, String tenantId);

    /**
     * 商家开放平台创建招牌。
     * <p>官方接口：{@code /waimai/ng/decoration/signageCreate}，API：{@code signage_create}，版本：{@code 10001}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> signageCreate(SignageCreateRequest request, String tenantId);

    /**
     * 商家开放平台使用海报。
     * <p>官方接口：{@code /waimai/ng/decoration/updatePosterStatus}，API：{@code update_poster_status}，版本：{@code 10001}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> updatePosterStatus(UpdatePosterStatusRequest request, String tenantId);

    /**
     * 自配订单同步预计送达时间信息。
     * <p>官方接口：{@code /waimai/ng/delivery/medicine/syncEstimateArrivalTime}，API：{@code sync_estimate_arrival_time}，版本：{@code 10002}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgSyncEstimateArrivalTime(SyncEstimateArrivalTimeRequest request, String tenantId);

    /**
     * 确认订单。
     * <p>官方接口：{@code /waimai/ng/diancan/order/confirm}，API：{@code diancan_order_confirm}，版本：{@code 10008}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> diancanOrderConfirm(DiancanOrderConfirmRequest request, String tenantId);

    /**
     * 品牌订单状态变更通知。
     * <p>官方接口：{@code /waimai/ng/diancan/order/fullFillNotice}，API：{@code diancan_order_full_fill_notice}，版本：{@code 10006}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> diancanOrderFullFillNotice(DiancanOrderFullFillNoticeRequest request, String tenantId);

    /**
     * 到店在线核销订单信息查询。
     * <p>官方接口：{@code /waimai/ng/diancan/order/query}，API：{@code diancan_order_query}，版本：{@code 10010}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> diancanOrderQuery(DiancanOrderQueryRequest request, String tenantId);

    /**
     * 营业时间开通接口。
     * <p>官方接口：{@code /waimai/ng/diancan/shop/serve/status/update}，API：{@code diancan_shop_serve_status_update}，版本：{@code 10003}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> diancanShopServeStatusUpdate(DiancanShopServeStatusUpdateRequest request, String tenantId);

    /**
     * 门店业务开通。
     * <p>官方接口：{@code /waimai/ng/diancan/shop/status/update}，API：{@code diancan_shop_status_update}，版本：{@code 10004}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> diancanShopStatusUpdate(DiancanShopStatusUpdateRequest request, String tenantId);

    /**
     * 门店配置查询。
     * <p>官方接口：{@code /waimai/ng/diancan/shop/queryShops}，API：{@code diancan_shopconfig_query}，版本：{@code 10009}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> diancanShopconfigQuery(DiancanShopconfigQueryRequest request, String tenantId);

    /**
     * 团购映射同步接口。
     * <p>官方接口：{@code /waimai/ng/diancan/synDealMapping}，API：{@code diancan_sync_deal_mapping}，版本：{@code 10005}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> diancanSyncDealMapping(DiancanSyncDealMappingRequest request, String tenantId);

    /**
     * 批量删除商品。
     * <p>官方接口：{@code /waimai/ng/dish/food/batchDelSpu}，API：{@code batch_del_spu}，版本：{@code 10123}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgBatchDelSpu(BatchDelSpuRequest request, String tenantId);

    /**
     * 创建场域商品。
     * <p>官方接口：{@code /waimai/ng/dish/food/batchInitMarketPlaceFood}，API：{@code batch_init_market_place_food}，版本：{@code 10123}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgBatchInitMarketPlaceFood(BatchInitMarketPlaceFoodRequest request, String tenantId);

    /**
     * 批量查询商品DNA。
     * <p>官方接口：{@code /waimai/ng/dish/batchQueryFoodDna}，API：{@code batch_query_food_dna}，版本：{@code 10030}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchQueryFoodDna(BatchQueryFoodDnaRequest request, String tenantId);

    /**
     * 美团真实spuid批量查询菜品信息。
     * <p>官方接口：{@code /waimai/ng/dish/batchQuerySpuByIds}，API：{@code batch_query_spu_by_ids}，版本：{@code 10126}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgBatchQuerySpuByIds(BatchQuerySpuByIdsRequest request, String tenantId);

    /**
     * 批量通过美团spuid修改商品部分信息。
     * <p>官方接口：{@code /waimai/ng/dish/batchUpdateSpuById}，API：{@code batch_update_spuby_id}，版本：{@code 10100}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchUpdateSpubyId(BatchUpdateSpubyIdRequest request, String tenantId);

    /**
     * 批量上传／更新菜品。
     * <p>官方接口：{@code /waimai/dish/batchUpload}，API：{@code dish_batch_upload}，版本：{@code 10143}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dishBatchUpload(DishBatchUploadRequest request, String tenantId);

    /**
     * 批量创建/更新套餐商品（仅支持套餐商品）。
     * <p>官方接口：{@code /waimai/ng/dish/combo/batchsave}，API：{@code dish_combo_batchsave}，版本：{@code 10124}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgDishComboBatchsave(DishComboBatchsaveRequest request, String tenantId);

    /**
     * 单个创建/更新套餐商品（仅支持套餐商品）。
     * <p>官方接口：{@code /waimai/ng/dish/combo/save}，API：{@code dish_combo_save}，版本：{@code 10125}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgDishComboSave(DishComboSaveRequest request, String tenantId);

    /**
     * 删除菜品。
     * <p>官方接口：{@code /waimai/dish/delete}，API：{@code dish_delete}，版本：{@code 10059}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dishDelete(DishDeleteRequest request, String tenantId);

    /**
     * 删除菜品分类。
     * <p>官方接口：{@code /waimai/dish/deleteCat}，API：{@code dish_delete_cat}，版本：{@code 10059}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dishDeleteCat(DishDeleteCatRequest request, String tenantId);

    /**
     * 删除菜品sku。
     * <p>官方接口：{@code /waimai/dish/deleteSku}，API：{@code dish_delete_sku}，版本：{@code 10059}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dishDeleteSku(DishDeleteSkuRequest request, String tenantId);

    /**
     * 查询门店菜品列表（包括门店的套餐商品和普通商品）。
     * <p>官方接口：{@code /waimai/ng/dish/food/listAll}，API：{@code dish_food_list_all}，版本：{@code 10132}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgDishFoodListAll(DishFoodListAllRequest request, String tenantId);

    /**
     * 查询菜品详情。
     * <p>官方接口：{@code /waimai/ng/dish/getDetail}，API：{@code dish_get_detail}，版本：{@code 10118}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dishGetDetail(DishGetDetailRequest request, String tenantId);

    /**
     * 建立菜品映射。
     * <p>官方接口：{@code /waimai/dish/mapping}，API：{@code dish_mapping}，版本：{@code 10074}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dishMapping(DishMappingRequest request, String tenantId);

    /**
     * 查询菜品分类。
     * <p>官方接口：{@code /waimai/dish/queryCatList}，API：{@code dish_query_cat_list}，版本：{@code 10068}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dishQueryCatList(DishQueryCatListRequest request, String tenantId);

    /**
     * 根据eDishCode批量查询外卖菜品信息。
     * <p>官方接口：{@code /waimai/dish/queryListByEdishCodes}，API：{@code dish_query_list_by_edish_codes}，版本：{@code 10120}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dishQueryListByEdishCodes(DishQueryListByEdishCodesRequest request, String tenantId);

    /**
     * 根据ERP的门店id查询门店下的菜品【不包含美团的菜品Id】。
     * <p>官方接口：{@code /waimai/dish/queryListByEPoiId}，API：{@code dish_query_list_by_epoiid}，版本：{@code 10118}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dishQueryListByEpoiid(DishQueryListByEpoiidRequest request, String tenantId);

    /**
     * 查询菜品属性。
     * <p>官方接口：{@code /waimai/dish/queryPropertyList}，API：{@code dish_query_property_list}，版本：{@code 10081}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dishQueryPropertyList(DishQueryPropertyListRequest request, String tenantId);

    /**
     * 批量更新菜品售卖状态。
     * <p>官方接口：{@code /waimai/ng/dish/sku/sellStatus}，API：{@code dish_sku_sell_status}，版本：{@code 10037}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dishSkuSellStatus(DishSkuSellStatusRequest request, String tenantId);

    /**
     * 新增／更新菜品分类。
     * <p>官方接口：{@code /waimai/dish/updateCat}，API：{@code dish_update_cat}，版本：{@code 10078}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dishUpdateCat(DishUpdateCatRequest request, String tenantId);

    /**
     * 更新菜品价格【sku的价格】。
     * <p>官方接口：{@code /waimai/dish/updatePrice}，API：{@code dish_update_price}，版本：{@code 10090}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dishUpdatePrice(DishUpdatePriceRequest request, String tenantId);

    /**
     * 批量创建/更新菜品属性。
     * <p>官方接口：{@code /waimai/dish/updateProperty}，API：{@code dish_update_property}，版本：{@code 10090}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dishUpdateProperty(DishUpdatePropertyRequest request, String tenantId);

    /**
     * 更新菜品库存【sku的库存】。
     * <p>官方接口：{@code /waimai/dish/updateStock}，API：{@code dish_update_stock}，版本：{@code 10090}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> dishUpdateStock(DishUpdateStockRequest request, String tenantId);

    /**
     * 批量查询门店菜品（包括查询套餐商品和普通商品）。
     * <p>官方接口：{@code /waimai/ng/dish/food/batchGet}，API：{@code food_batch_get}，版本：{@code 10126}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgFoodBatchGet(FoodBatchGetRequest request, String tenantId);

    /**
     * 批量查询外卖菜品。
     * <p>官方接口：{@code /waimai/ng/dish/batchQuery}，API：{@code food_batch_query_list}，版本：{@code 10126}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> foodBatchQueryList(FoodBatchQueryListRequest request, String tenantId);

    /**
     * 删除分组。
     * <p>官方接口：{@code /waimai/ng/dish/foodCat/delete}，API：{@code food_cat_delete}，版本：{@code 10123}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgFoodCatDelete(FoodCatDeleteRequest request, String tenantId);

    /**
     * 查询分组。
     * <p>官方接口：{@code /waimai/ng/dish/foodCat/list}，API：{@code food_cat_list}，版本：{@code 10123}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgFoodCatList(FoodCatListRequest request, String tenantId);

    /**
     * 保存更新分组。
     * <p>官方接口：{@code /waimai/ng/dish/foodCat/update}，API：{@code food_cat_update}，版本：{@code 10123}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgFoodCatUpdate(FoodCatUpdateRequest request, String tenantId);

    /**
     * 查询门店菜品列表。
     * <p>官方接口：{@code /waimai/ng/dish/queryFoodList}，API：{@code food_query_list}，版本：{@code 10126}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> foodQueryList(FoodQueryListRequest request, String tenantId);

    /**
     * 根据原商品编码更换新商品编码。
     * <p>官方接口：{@code /waimai/ng/dish/food/updateAppFoodCodeByOrigin}，API：{@code food_update_app_food_code_by_origin}，版本：{@code 10022}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgFoodUpdateAppFoodCodeByOrigin(FoodUpdateAppFoodCodeByOriginRequest request, String tenantId);

    /**
     * 根据商品名称和规格名称更换新的商品编码。
     * <p>官方接口：{@code /waimai/ng/dish/food/updateAppFoodCodeByNameAndSpec}，API：{@code food_update_appfoodcode_by_name_and_spec}，版本：{@code 10069}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgFoodUpdateAppfoodcodeByNameAndSpec(FoodUpdateAppfoodcodeByNameAndSpecRequest request, String tenantId);

    /**
     * 查询已有场域。
     * <p>官方接口：{@code /waimai/ng/dish/food/listMarketplaces}，API：{@code list_market_places}，版本：{@code 10123}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgListMarketPlaces(ListMarketPlacesRequest request, String tenantId);

    /**
     * 查询所有类目。
     * <p>官方接口：{@code /waimai/ng/dish/queryCategoryList}，API：{@code query_category_list}，版本：{@code 10016}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryCategoryList(QueryCategoryListRequest request, String tenantId);

    /**
     * 根据类目查询模板下所有属性。
     * <p>官方接口：{@code /waimai/ng/dish/queryCategoryProperties}，API：{@code query_category_properties}，版本：{@code 10126}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryCategoryProperties(QueryCategoryPropertiesRequest request, String tenantId);

    /**
     * 查询菜品DNA。
     * <p>官方接口：{@code /waimai/ng/dish/queryFoodDna}，API：{@code query_food_dna}，版本：{@code 10026}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryFoodDna(QueryFoodDnaRequest request, String tenantId);

    /**
     * 保存商品DNA。
     * <p>官方接口：{@code /waimai/ng/dish/saveFoodDna}，API：{@code save_food_dna}，版本：{@code 10036}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> saveFoodDna(SaveFoodDnaRequest request, String tenantId);

    /**
     * 新建/更新小料接口。
     * <p>官方接口：{@code /waimai/ng/dish/topping/batchInit}，API：{@code topping_batch_init}，版本：{@code 10113}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgToppingBatchInit(ToppingBatchInitRequest request, String tenantId);

    /**
     * 查询小料信息接口（根据小料code查询）。
     * <p>官方接口：{@code /waimai/ng/dish/topping/batchQuery}，API：{@code topping_batch_query}，版本：{@code 10113}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgToppingBatchQuery(ToppingBatchQueryRequest request, String tenantId);

    /**
     * 根据小料名称绑定小料code接口。
     * <p>官方接口：{@code /waimai/ng/dish/topping/bindToppingCodeByName}，API：{@code topping_code_bind_by_name}，版本：{@code 10113}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> toppingCodeBindByName(ToppingCodeBindByNameRequest request, String tenantId);

    /**
     * 删除小料信息接口。
     * <p>官方接口：{@code /waimai/ng/dish/topping/delete}，API：{@code topping_delete}，版本：{@code 10113}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgToppingDelete(ToppingDeleteRequest request, String tenantId);

    /**
     * 创建小料组接口。
     * <p>官方接口：{@code /waimai/ng/dish/toppingGroup/batchInit}，API：{@code topping_group_batch_init}，版本：{@code 10121}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgToppingGroupBatchInit(ToppingGroupBatchInitRequest request, String tenantId);

    /**
     * 查询小料组接口。
     * <p>官方接口：{@code /waimai/ng/dish/toppingGroup/batchQuery}，API：{@code topping_group_batch_query}，版本：{@code 10118}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgToppingGroupBatchQuery(ToppingGroupBatchQueryRequest request, String tenantId);

    /**
     * 删除小料组接口。
     * <p>官方接口：{@code /waimai/ng/dish/toppingGroup/delete}，API：{@code topping_group_delete}，版本：{@code 10113}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgToppingGroupDelete(ToppingGroupDeleteRequest request, String tenantId);

    /**
     * 查询小料组接口(分页)。
     * <p>官方接口：{@code /waimai/ng/dish/toppingGroup/list}，API：{@code topping_group_list}，版本：{@code 10118}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgToppingGroupList(ToppingGroupListRequest request, String tenantId);

    /**
     * 查询小料信息接口（分页）。
     * <p>官方接口：{@code /waimai/ng/dish/topping/list}，API：{@code topping_list}，版本：{@code 10113}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgToppingList(ToppingListRequest request, String tenantId);

    /**
     * 查询门店打包费。
     * <p>官方接口：{@code /waimai/ng/dish/queryBoxPriceTypeAndDetail}，API：{@code waimai_query_box_pricetype_and_detail}，版本：{@code 10133}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiQueryBoxPricetypeAndDetail(WaimaiQueryBoxPricetypeAndDetailRequest request, String tenantId);

    /**
     * 设置门店打包费。
     * <p>官方接口：{@code /waimai/ng/dish/saveBoxPriceTypeAndDetail}，API：{@code waimai_save_box_price_type_and_detail}，版本：{@code 10136}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiSaveBoxPriceTypeAndDetail(WaimaiSaveBoxPriceTypeAndDetailRequest request, String tenantId);

    /**
     * 申诉详情查询。
     * <p>官方接口：{@code /waimai/ng/govern/appeal/detail/query}，API：{@code govern_appeal_detail_query}，版本：{@code 10001}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGovernAppealDetailQuery(GovernAppealDetailQueryRequest request, String tenantId);

    /**
     * 违规列表查询。
     * <p>官方接口：{@code /waimai/ng/govern/violation/list/query}，API：{@code govern_violation_query}，版本：{@code 10001}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGovernViolationQuery(GovernViolationQueryRequest request, String tenantId);

    /**
     * 积分信息查询。
     * <p>官方接口：{@code /waimai/ng/govern/violation/score/query}，API：{@code govern_violation_score_query}，版本：{@code 10001}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGovernViolationScoreQuery(GovernViolationScoreQueryRequest request, String tenantId);

    /**
     * 积分记录查询。
     * <p>官方接口：{@code /waimai/ng/govern/violation/score/record/query}，API：{@code govern_violation_score_record_query}，版本：{@code 10001}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGovernViolationScoreRecordQuery(GovernViolationScoreRecordQueryRequest request, String tenantId);

    /**
     * 预警列表查询。
     * <p>官方接口：{@code /waimai/ng/govern/warning/list/query}，API：{@code govern_warning_list_query}，版本：{@code 10001}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGovernWarningListQuery(GovernWarningListQueryRequest request, String tenantId);

    /**
     * 商家屏蔽顾客。
     * <p>官方接口：{@code /waimai/ng/im/blockUser}，API：{@code block_user}，版本：{@code 10020}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgBlockUser(BlockUserRequest request, String tenantId);

    /**
     * 商家解除屏蔽顾客。
     * <p>官方接口：{@code /waimai/ng/im/cancelBlockUser}，API：{@code cancel_block_user}，版本：{@code 10021}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgCancelBlockUser(CancelBlockUserRequest request, String tenantId);

    /**
     * 创建进群领券活动。
     * <p>官方接口：{@code /waimai/ng/im/createEnterCouponActivity}，API：{@code create_enter_coupon_activity}，版本：{@code 10040}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgCreateEnterCouponActivity(CreateEnterCouponActivityRequest request, String tenantId);

    /**
     * 创建粉丝群。
     * <p>官方接口：{@code /waimai/ng/im/createFansGroup}，API：{@code create_fans_group}，版本：{@code 10040}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgCreateFansGroup(CreateFansGroupRequest request, String tenantId);

    /**
     * 创建群接口。
     * <p>官方接口：{@code /waimai/ng/im/createGroup}，API：{@code create_group}，版本：{@code 10017}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgCreateGroup(CreateGroupRequest request, String tenantId);

    /**
     * 查询门店“智能回复机器人”的开关状态。
     * <p>官方接口：{@code /waimai/ng/im/autosend/getAutoSendConfigInfo}，API：{@code get_auto_send_config_info}，版本：{@code 10051}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGetAutoSendConfigInfo(GetAutoSendConfigInfoRequest request, String tenantId);

    /**
     * 获取长连接的token【必接】。
     * <p>官方接口：{@code /waimai/ng/im/getConnectionToken}，API：{@code get_connection_token}，版本：{@code 10044}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGetConnectionToken(GetConnectionTokenRequest request, String tenantId);

    /**
     * 获取多个长连接。
     * <p>官方接口：{@code /waimai/ng/im/getConnectionTokenWithCount}，API：{@code get_connection_token_with_count}，版本：{@code 10048}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGetConnectionTokenWithCount(GetConnectionTokenWithCountRequest request, String tenantId);

    /**
     * 查询门店IM状态。
     * <p>官方接口：{@code /waimai/ng/im/getPoiIMStatus}，API：{@code get_poi_im_status}，版本：{@code 10004}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGetPoiImStatus(GetPoiImStatusRequest request, String tenantId);

    /**
     * 回复率及权益查询。
     * <p>官方接口：{@code /waimai/ng/im/getReversionRateAndRightsList}，API：{@code get_reversion_rate_and_rights_list}，版本：{@code 10022}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGetReversionRateAndRightsList(GetReversionRateAndRightsListRequest request, String tenantId);

    /**
     * 设置设置消息已读状态。
     * <p>官方接口：{@code /waimai/ng/im/msgRead}，API：{@code msg_read}，版本：{@code 10001}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgMsgRead(MsgReadRequest request, String tenantId);

    /**
     * 查询粉丝群发券信息。
     * <p>官方接口：{@code /waimai/ng/im/queryCoupon}，API：{@code query_coupon}，版本：{@code 10040}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgQueryCoupon(QueryCouponRequest request, String tenantId);

    /**
     * 查询发券的活动效果。
     * <p>官方接口：{@code /waimai/ng/im/queryReceiveCouponDetail}，API：{@code query_coupon_detail}，版本：{@code 10040}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgQueryCouponDetail(QueryCouponDetailRequest request, String tenantId);

    /**
     * 查询当前的进群领券活动。
     * <p>官方接口：{@code /waimai/ng/im/queryEnterCouponActivity}，API：{@code query_enter_coupon_activity}，版本：{@code 10040}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgQueryEnterCouponActivity(QueryEnterCouponActivityRequest request, String tenantId);

    /**
     * 查询门店外卖IM消息订阅状态。
     * <p>官方接口：{@code /waimai/ng/im/queryImSubscribeStatusByEpoi}，API：{@code query_im_subscribe_status_by_epoi}，版本：{@code 10047}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgQueryImSubscribeStatusByEpoi(QueryImSubscribeStatusByEpoiRequest request, String tenantId);

    /**
     * 查询门店的粉丝群。
     * <p>官方接口：{@code /waimai/ng/im/queryStoreFansGroup}，API：{@code query_store_fans_group}，版本：{@code 10040}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgQueryStoreFansGroup(QueryStoreFansGroupRequest request, String tenantId);

    /**
     * 查询门店是否有建群资格。
     * <p>官方接口：{@code /waimai/ng/im/queryStoreHaveBuild}，API：{@code query_store_have_build}，版本：{@code 10040}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgQueryStoreHaveBuild(QueryStoreHaveBuildRequest request, String tenantId);

    /**
     * 查询门店剩余发券数。
     * <p>官方接口：{@code /waimai/ng/im/remainCoupon}，API：{@code remain_coupon}，版本：{@code 10057}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgRemainCoupon(RemainCouponRequest request, String tenantId);

    /**
     * 停止当前的进群领券活动。
     * <p>官方接口：{@code /waimai/ng/im/revokeEnterCouponActivity}，API：{@code revoke_enter_coupon_activity}，版本：{@code 10040}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgRevokeEnterCouponActivity(RevokeEnterCouponActivityRequest request, String tenantId);

    /**
     * 在粉丝群内主动建券并发券。
     * <p>官方接口：{@code /waimai/ng/im/sendFansGroupCoupon}，API：{@code send_fans_group_coupon}，版本：{@code 10043}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgSendFansGroupCoupon(SendFansGroupCouponRequest request, String tenantId);

    /**
     * 发送IM消息（接单）。
     * <p>官方接口：{@code /waimai/ng/im/msg/send}，API：{@code send_im_msg_waimai}，版本：{@code 10055}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> sendImMsgWaimai(SendImMsgWaimaiRequest request, String tenantId);

    /**
     * 自动回复设置。
     * <p>官方接口：{@code /waimai/ng/im/setAutoSendConfig}，API：{@code set_auto_send_config}，版本：{@code 10019}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgSetAutoSendConfig(SetAutoSendConfigRequest request, String tenantId);

    /**
     * 设置门店“智能回复机器人”的开关状态。
     * <p>官方接口：{@code /waimai/ng/im/autosend/setAutoSendConfigInfo}，API：{@code set_auto_send_config_info}，版本：{@code 10051}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgSetAutoSendConfigInfo(SetAutoSendConfigInfoRequest request, String tenantId);

    /**
     * 设置门店IM状态。
     * <p>官方接口：{@code /waimai/ng/im/setPoiIMStatus}，API：{@code set_poi_im_status}，版本：{@code 10001}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgSetPoiImStatus(SetPoiImStatusRequest request, String tenantId);

    /**
     * 根据门店订阅外卖IM消息。
     * <p>官方接口：{@code /waimai/ng/im/subscribeImByEpoi}，API：{@code subscribe_im_by_epoi}，版本：{@code 10046}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgSubscribeImByEpoi(SubscribeImByEpoiRequest request, String tenantId);

    /**
     * 根据门店解除订阅外卖IM消息。
     * <p>官方接口：{@code /waimai/ng/im/unsubscribeImByEpoi}，API：{@code unsubscribe_im_by_epoi}，版本：{@code 10052}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgUnsubscribeImByEpoi(UnsubscribeImByEpoiRequest request, String tenantId);

    /**
     * 查询会话最新已读时间戳。
     * <p>官方接口：{@code /waimai/ng/im/userReadTime}，API：{@code waimai_im_get_read_time}，版本：{@code 10008}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiImGetReadTime(WaimaiImGetReadTimeRequest request, String tenantId);

    /**
     * 获取美团外卖开店绿色通道链接地址。
     * <p>官方接口：{@code /waimai/kaidian/bizsettle}，API：{@code waimai_kaidian_bizsettle}，版本：{@code 10002}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiKaidianBizsettle(WaimaiKaidianBizsettleRequest request, String tenantId);

    /**
     * 隐私号-批量拉取用户手机号。
     * <p>官方接口：{@code /waimai/order/batchPullPhoneNumber}，API：{@code batch_pull_phone_number}，版本：{@code 10056}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchPullPhoneNumber(BatchPullPhoneNumberRequest request, String tenantId);

    /**
     * 查询短信发送结果。
     * <p>官方接口：{@code /waimai/ng/order/batchQuerySMSSendResult}，API：{@code batch_query_sms_send_result}，版本：{@code 10161}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgBatchQuerySmsSendResult(BatchQuerySmsSendResultRequest request, String tenantId);

    /**
     * 商家上报业务指标。
     * <p>官方接口：{@code /waimai/ng/order/reportMetrics}，API：{@code business_metrics_report}，版本：{@code 10115}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> businessMetricsReport(BusinessMetricsReportRequest request, String tenantId);

    /**
     * 提交取消跑腿。
     * <p>官方接口：{@code /waimai/order/cancelZbLogisticsByWmOrderId}，API：{@code cancel_zb_logistics_by_wm_order_id}，版本：{@code 10154}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgCancelZbLogisticsByWmOrderId(CancelZbLogisticsByWmOrderIdRequest request, String tenantId);

    /**
     * 配送中批量回传轨迹点。
     * <p>官方接口：{@code /waimai/ng/order/delivering/riderPosition/batch}，API：{@code delivering_rider_position_batch}，版本：{@code 10142}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgDeliveringRiderPositionBatch(DeliveringRiderPositionBatchRequest request, String tenantId);

    /**
     * 完单后批量回传轨迹点。
     * <p>官方接口：{@code /waimai/ng/order/deliveryCompleted/riderPosition/batch}，API：{@code delivery_completed_rider_position_batch}，版本：{@code 10142}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgDeliveryCompletedRiderPositionBatch(DeliveryCompletedRiderPositionBatchRequest request, String tenantId);

    /**
     * 配送单加小费。
     * <p>官方接口：{@code /waimai/ng/order/deliveryNoteAddTip}，API：{@code delivery_note_add_tip}，版本：{@code 10019}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> deliveryNoteAddTip(DeliveryNoteAddTipRequest request, String tenantId);

    /**
     * 批量查询退款订单信息。
     * <p>官方接口：{@code /waimai/ng/order/getBatchOrderRefundInfo}，API：{@code get_batch_order_refund_info}，版本：{@code 10072}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGetBatchOrderRefundInfo(GetBatchOrderRefundInfoRequest request, String tenantId);

    /**
     * 查询众包骑手坐标。
     * <p>官方接口：{@code /waimai/ng/order/getDeliveryPath}，API：{@code get_delivery_path}，版本：{@code 10154}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGetDeliveryPath(GetDeliveryPathRequest request, String tenantId);

    /**
     * 查询订单预订人隐私信息。
     * <p>官方接口：{@code /waimai/ng/order/getOrderBookerInformation}，API：{@code get_order_booker_information}，版本：{@code 10035}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGetOrderBookerInformation(GetOrderBookerInformationRequest request, String tenantId);

    /**
     * 根据订单流水号获取订单号。
     * <p>官方接口：{@code /waimai/ng/order/getOrderIdByDaySeq}，API：{@code get_order_id_by_day_seq}，版本：{@code 10148}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getOrderIdByDaySeq(GetOrderIdByDaySeqRequest request, String tenantId);

    /**
     * 查询出餐超时的订单。
     * <p>官方接口：{@code /waimai/ng/order/getOrderMealStatus}，API：{@code get_order_meal_status}，版本：{@code 10090}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGetOrderMealStatus(GetOrderMealStatusRequest request, String tenantId);

    /**
     * 查询订单收餐人隐私信息。
     * <p>官方接口：{@code /waimai/ng/order/getOrderRecipientPrivacyInfo}，API：{@code get_order_recipient_privacy_info}，版本：{@code 10035}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGetOrderRecipientPrivacyInfo(GetOrderRecipientPrivacyInfoRequest request, String tenantId);

    /**
     * 商家获取备餐时间。
     * <p>官方接口：{@code /waimai/ng/order/getPreparationMealTime}，API：{@code get_preparation_mealtime}，版本：{@code 10069}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGetPreparationMealtime(GetPreparationMealtimeRequest request, String tenantId);

    /**
     * 隐私号-批量拉取骑手手机号。
     * <p>官方接口：{@code /waimai/order/getRiderInfoPhoneNumber}，API：{@code get_rider_info_phone_number}，版本：{@code 10053}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getRiderInfoPhoneNumber(GetRiderInfoPhoneNumberRequest request, String tenantId);

    /**
     * 获取取餐码标签。
     * <p>官方接口：{@code /waimai/ng/order/getTakeFoodCodeList}，API：{@code get_take_food_code_list}，版本：{@code 10014}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getTakeFoodCodeList(GetTakeFoodCodeListRequest request, String tenantId);

    /**
     * 获取未接单订单。
     * <p>官方接口：{@code /waimai/ng/order/getUnConfirmedOrders}，API：{@code get_un_confirmed_orders}，版本：{@code 10141}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getUnConfirmedOrders(GetUnConfirmedOrdersRequest request, String tenantId);

    /**
     * 订单查询。
     * <p>官方接口：{@code /waimai/ng/order/innovative/getInnovativeOrderDetail}，API：{@code innovative_order_query}，版本：{@code 10113}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgInnovativeOrderQuery(InnovativeOrderQueryRequest request, String tenantId);

    /**
     * 订单同意退款。
     * <p>官方接口：{@code /waimai/order/agreeRefund}，API：{@code order_agree_refund}，版本：{@code 10103}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderAgreeRefund(OrderAgreeRefundRequest request, String tenantId);

    /**
     * 部分退款-申请部分退款。
     * <p>官方接口：{@code /waimai/order/applyPartRefund}，API：{@code order_apply_part_refund}，版本：{@code 10036}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderApplyPartRefund(OrderApplyPartRefundRequest request, String tenantId);

    /**
     * 批量拉取异常订单。
     * <p>官方接口：{@code /waimai/ng/order/batchFetchAbnormalOrder}，API：{@code order_batch_fetch_abnormal_order}，版本：{@code 10006}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderBatchFetchAbnormalOrder(OrderBatchFetchAbnormalOrderRequest request, String tenantId);

    /**
     * 商家取消订单。
     * <p>官方接口：{@code /waimai/order/cancel}，API：{@code order_cancel}，版本：{@code 10103}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderCancel(OrderCancelRequest request, String tenantId);

    /**
     * 取消美团配送（除自配送场景）。
     * <p>官方接口：{@code /waimai/order/cancelDispatch}，API：{@code order_cancel_dispatch}，版本：{@code 10036}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderCancelDispatch(OrderCancelDispatchRequest request, String tenantId);

    /**
     * 商家确认接单。
     * <p>官方接口：{@code /waimai/order/confirm}，API：{@code order_confirm}，版本：{@code 10057}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderConfirm(OrderConfirmRequest request, String tenantId);

    /**
     * 自配送场景－订单已送达。
     * <p>官方接口：{@code /waimai/order/delivered}，API：{@code order_delivered}，版本：{@code 10052}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderDelivered(OrderDeliveredRequest request, String tenantId);

    /**
     * 自配送－配送状态。
     * <p>官方接口：{@code /waimai/order/delivering}，API：{@code order_delivering}，版本：{@code 10060}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderDelivering(OrderDeliveringRequest request, String tenantId);

    /**
     * 美团专送场景－发配送。
     * <p>官方接口：{@code /waimai/order/dispatchShip}，API：{@code order_dispatch_ship}，版本：{@code 10055}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderDispatchShip(OrderDispatchShipRequest request, String tenantId);

    /**
     * 同意ETA修改请求。
     * <p>官方接口：{@code /waimai/ng/order/eta/modify/agree}，API：{@code order_eta_modify_agree}，版本：{@code 10033}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderEtaModifyAgree(OrderEtaModifyAgreeRequest request, String tenantId);

    /**
     * 拒绝ETA修改请求。
     * <p>官方接口：{@code /waimai/ng/order/eta/modify/refuse}，API：{@code order_eta_modify_refuse}，版本：{@code 10033}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderEtaModifyRefuse(OrderEtaModifyRefuseRequest request, String tenantId);

    /**
     * 商家提交申诉。
     * <p>官方接口：{@code /waimai/ng/order/foodSlow/appeal}，API：{@code order_foodslow_appeal}，版本：{@code 10009}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderFoodslowAppeal(OrderFoodslowAppealRequest request, String tenantId);

    /**
     * 查询真实地址接口。
     * <p>官方接口：{@code /waimai/ng/order/getRealRecipientAddress}，API：{@code order_get_real_recipient_address}，版本：{@code 10017}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderGetRealRecipientAddress(OrderGetRealRecipientAddressRequest request, String tenantId);

    /**
     * 上报卡餐。
     * <p>官方接口：{@code /waimai/ng/order/kc/report}，API：{@code order_kc_report}，版本：{@code 10010}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderKcReport(OrderKcReportRequest request, String tenantId);

    /**
     * 根据流水号查询订单。
     * <p>官方接口：{@code /waimai/order/queryByDaySeq}，API：{@code order_query_by_day_seq}，版本：{@code 10173}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderQueryByDaySeq(OrderQueryByDaySeqRequest request, String tenantId);

    /**
     * 根据订单Id查询订单。
     * <p>官方接口：{@code /waimai/order/queryById}，API：{@code order_query_by_id}，版本：{@code 10179}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderQueryById(OrderQueryByIdRequest request, String tenantId);

    /**
     * 查询部分退款商品。
     * <p>官方接口：{@code /waimai/order/queryPartRefundFoods}，API：{@code order_query_part_refund_foods}，版本：{@code 10083}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderQueryPartRefundFoods(OrderQueryPartRefundFoodsRequest request, String tenantId);

    /**
     * 众包配送场景－查询配送费。
     * <p>官方接口：{@code /waimai/order/queryZbShippingFee}，API：{@code order_query_zb_shipping_fee}，版本：{@code 10059}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgOrderQueryZbShippingFee(OrderQueryZbShippingFeeRequest request, String tenantId);

    /**
     * 商家申诉接口。
     * <p>官方接口：{@code /waimai/ng/order/refund/issue/appeal}，API：{@code order_refund_issue_appeal}，版本：{@code 10031}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderRefundIssueAppeal(OrderRefundIssueAppealRequest request, String tenantId);

    /**
     * 订单拒绝退款。
     * <p>官方接口：{@code /waimai/order/rejectRefund}，API：{@code order_reject_refund}，版本：{@code 10103}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderRejectRefund(OrderRejectRefundRequest request, String tenantId);

    /**
     * 催单回复接口。
     * <p>官方接口：{@code /waimai/ng/order/remindReply}，API：{@code order_remind_reply}，版本：{@code 10005}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> orderRemindReply(OrderRemindReplyRequest request, String tenantId);

    /**
     * 众包配送场景－配送单加小费。
     * <p>官方接口：{@code /waimai/order/updateZbDispatchTip}，API：{@code order_update_zb_dispatch_tip}，版本：{@code 10152}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgOrderUpdateZbDispatchTip(OrderUpdateZbDispatchTipRequest request, String tenantId);

    /**
     * 商家确认已完成出餐。
     * <p>官方接口：{@code /waimai/order/preparationMealComplete}，API：{@code preparation_meal_complete}，版本：{@code 10062}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgPreparationMealComplete(PreparationMealCompleteRequest request, String tenantId);

    /**
     * 查询配送信息。
     * <p>官方接口：{@code /waimai/ng/order/queryLogisticsStatus}，API：{@code query_logistics_info}，版本：{@code 10154}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryLogisticsInfo(QueryLogisticsInfoRequest request, String tenantId);

    /**
     * 查询活动分摊接口。
     * <p>官方接口：{@code /waimai/ng/order/getOrderReceiptActivityInfo}，API：{@code query_order_receipt_activity_info}，版本：{@code 10004}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> queryOrderReceiptActivityInfo(QueryOrderReceiptActivityInfoRequest request, String tenantId);

    /**
     * 获取订单可以取消跑腿的原因。
     * <p>官方接口：{@code /waimai/order/queryZbCancelDeliveryReason}，API：{@code query_zb_cancel_delivery_reason}，版本：{@code 10154}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgQueryZbCancelDeliveryReason(QueryZbCancelDeliveryReasonRequest request, String tenantId);

    /**
     * 自配订单同步配送信息。
     * <p>官方接口：{@code /waimai/order/riderPosition}，API：{@code rider_position}，版本：{@code 10174}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgRiderPosition(RiderPositionRequest request, String tenantId);

    /**
     * 发送短信。
     * <p>官方接口：{@code /waimai/ng/order/sendSMS}，API：{@code send_sms}，版本：{@code 10161}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgSendSms(SendSmsRequest request, String tenantId);

    /**
     * 设置订单自取码。
     * <p>官方接口：{@code /waimai/ng/order/setPickCode}，API：{@code set_pick_code}，版本：{@code 10136}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> setPickCode(SetPickCodeRequest request, String tenantId);

    /**
     * 提交食安订单处理方案。
     * <p>官方接口：{@code /waimai/ng/order/foodSafe/submitSolution}，API：{@code submit_food_safety_order_solution}，版本：{@code 10177}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> submitFoodSafetyOrderSolution(SubmitFoodSafetyOrderSolutionRequest request, String tenantId);

    /**
     * 获取配送详情页面授权码。
     * <p>官方接口：{@code /waimai/ng/order/business_auth/code/generate}，API：{@code waimai_get_auth_code}，版本：{@code 10162}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiGetAuthCode(WaimaiGetAuthCodeRequest request, String tenantId);

    /**
     * 获取配送订单状态。
     * <p>官方接口：{@code /waimai/ng/order/logistics/status}，API：{@code wm_query_logistics_status}，版本：{@code 10166}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmQueryLogisticsStatus(WmQueryLogisticsStatusRequest request, String tenantId);

    /**
     * 众包配送-发配送。
     * <p>官方接口：{@code /waimai/order/zbDispatch}，API：{@code zb_dispatch}，版本：{@code 10150}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgZbDispatch(ZbDispatchRequest request, String tenantId);

    /**
     * 查询众包配送费。
     * <p>官方接口：{@code /waimai/ng/order/zbLogisticsPreview}，API：{@code zb_logistics_preview}，版本：{@code 10152}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgZbLogisticsPreview(ZbLogisticsPreviewRequest request, String tenantId);

    /**
     * 批量查询跑腿配送费。
     * <p>官方接口：{@code /waimai/ng/order/zhongbao/shippingFeeByCode}，API：{@code zhongbao_shippingfeebycode}，版本：{@code 10030}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> zhongbaoShippingfeebycode(ZhongbaoShippingfeebycodeRequest request, String tenantId);

    /**
     * 查询门店二维码。
     * <p>官方接口：{@code /waimai/ng/poi/getPoiExtendInfo}，API：{@code get_poi_extend_info}，版本：{@code 10006}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGetPoiExtendInfo(GetPoiExtendInfoRequest request, String tenantId);

    /**
     * 查询店铺分数据。
     * <p>官方接口：{@code /waimai/ng/poi/getPoiScoreDetail}，API：{@code get_poi_score_detail}，版本：{@code 10004}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGetPoiScoreDetail(GetPoiScoreDetailRequest request, String tenantId);

    /**
     * 查询门店实时评价权益。
     * <p>官方接口：{@code /waimai/ng/poi/queryStoreEvaluationBenefit}，API：{@code query_store_evaluation_benefit}，版本：{@code 10008}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgQueryStoreEvaluationBenefit(QueryStoreEvaluationBenefitRequest request, String tenantId);

    /**
     * 门店置休息。
     * <p>官方接口：{@code /waimai/poi/close}，API：{@code waimai_poi_close}，版本：{@code 10015}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiPoiClose(WaimaiPoiCloseRequest request, String tenantId);

    /**
     * 门店置营业。
     * <p>官方接口：{@code /waimai/poi/open}，API：{@code waimai_poi_open}，版本：{@code 10016}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiPoiOpen(WaimaiPoiOpenRequest request, String tenantId);

    /**
     * 查询门店是否延迟发配送。
     * <p>官方接口：{@code /waimai/poi/queryDelayDispatch}，API：{@code waimai_poi_query_delay_dispatch}，版本：{@code 10000}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiPoiQueryDelayDispatch(WaimaiPoiQueryDelayDispatchRequest request, String tenantId);

    /**
     * 查询门店信息。
     * <p>官方接口：{@code /waimai/poi/queryPoiInfo}，API：{@code waimai_poi_query_poi_info}，版本：{@code 10023}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiPoiQueryPoiInfo(WaimaiPoiQueryPoiInfoRequest request, String tenantId);

    /**
     * 设置延迟发配送时间。
     * <p>官方接口：{@code /waimai/poi/updateDelayDispatch}，API：{@code waimai_poi_update_delay_dispatch}，版本：{@code 10000}，businessId：{@code 2}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiPoiUpdateDelayDispatch(WaimaiPoiUpdateDelayDispatchRequest request, String tenantId);

    /**
     * 修改门店营业时间。
     * <p>官方接口：{@code /waimai/poi/updateOpenTime}，API：{@code waimai_poi_update_open_time}，版本：{@code 10015}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiPoiUpdateOpenTime(WaimaiPoiUpdateOpenTimeRequest request, String tenantId);

    /**
     * 批量创建/更新配送范围（自配）。
     * <p>官方接口：{@code /waimai/ng/shipping/batchsave}，API：{@code shipping_batchsave}，版本：{@code 10016}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgShippingBatchsave(ShippingBatchsaveRequest request, String tenantId);

    /**
     * 删除门店配送范围（自配）。
     * <p>官方接口：{@code /waimai/ng/shipping/delete}，API：{@code shipping_delete}，版本：{@code 10000}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgShippingDelete(ShippingDeleteRequest request, String tenantId);

    /**
     * 查询门店配送范围（混合送）。
     * <p>官方接口：{@code /waimai/ng/shipping/fetch}，API：{@code shipping_fetch}，版本：{@code 10000}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgShippingFetch(ShippingFetchRequest request, String tenantId);

    /**
     * 查询门店配送范围。
     * <p>官方接口：{@code /waimai/ng/shipping/list}，API：{@code shipping_list}，版本：{@code 10000}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgShippingList(ShippingListRequest request, String tenantId);

    /**
     * 重置门店配送范围（自配）。
     * <p>官方接口：{@code /waimai/ng/shipping/resetSelfDeliveryArea}，API：{@code shipping_reset_self_delivery_area}，版本：{@code 10000}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgShippingResetSelfDeliveryArea(ShippingResetSelfDeliveryAreaRequest request, String tenantId);

    /**
     * 创建/更新门店配送范围（自配）。
     * <p>官方接口：{@code /waimai/ng/shipping/save}，API：{@code shipping_save}，版本：{@code 10000}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgShippingSave(ShippingSaveRequest request, String tenantId);

    /**
     * 创建/更新特殊时段配送范围（自配）。
     * <p>官方接口：{@code /waimai/ng/shipping/spec/save}，API：{@code shipping_spec_save}，版本：{@code 10000}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgShippingSpecSave(ShippingSpecSaveRequest request, String tenantId);

    /**
     * 获取后台类目。
     * <p>官方接口：{@code /waimai/ng/special/phf/product/category}，API：{@code get_product_category_new}，版本：{@code 10008}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getProductCategoryNew(GetProductCategoryNewRequest request, String tenantId);

    /**
     * 单门店下批量删除商品(拼好饭)。
     * <p>官方接口：{@code /waimai/ng/special/phf/product/batchDeleteSpu}，API：{@code special_food_batch_delete_product}，版本：{@code 10007}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> specialFoodBatchDeleteProduct(SpecialFoodBatchDeleteProductRequest request, String tenantId);

    /**
     * 批量查询商品(拼好饭)。
     * <p>官方接口：{@code /waimai/ng/special/food/batchQuery}，API：{@code special_food_batch_query}，版本：{@code 10012}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgSpecialFoodBatchQuery(SpecialFoodBatchQueryRequest request, String tenantId);

    /**
     * 单门店下批量上下架商品（拼好饭）。
     * <p>官方接口：{@code /waimai/ng/special/phf/product/batchSetSellStatus}，API：{@code special_food_batch_set_sell_status}，版本：{@code 10007}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> specialFoodBatchSetSellStatus(SpecialFoodBatchSetSellStatusRequest request, String tenantId);

    /**
     * 建立拼好饭场景菜品映射。
     * <p>官方接口：{@code /waimai/ng/special/food/bindSpuAndSkuCode}，API：{@code special_food_bind_spu_and_sku_code}，版本：{@code 10012}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgSpecialFoodBindSpuAndSkuCode(SpecialFoodBindSpuAndSkuCodeRequest request, String tenantId);

    /**
     * 查询单个商品(拼好饭)。
     * <p>官方接口：{@code /waimai/ng/special/food/conditionQuery}，API：{@code special_food_condition_query}，版本：{@code 10012}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgSpecialFoodConditionQuery(SpecialFoodConditionQueryRequest request, String tenantId);

    /**
     * 单门店下批量保存商品(拼好饭)。
     * <p>官方接口：{@code /waimai/ng/special/phf/product/batchSaveProduct}，API：{@code special_food_save_batch_products}，版本：{@code 10007}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> specialFoodSaveBatchProducts(SpecialFoodSaveBatchProductsRequest request, String tenantId);

    /**
     * 保存套餐商品接口(拼好饭)。
     * <p>官方接口：{@code /waimai/ng/special/phf/product/batchSaveComboMainProduct}，API：{@code special_food_save_combo_main_product}，版本：{@code 10007}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> specialFoodSaveComboMainProduct(SpecialFoodSaveComboMainProductRequest request, String tenantId);

    /**
     * 修改商品上下架状态(拼好饭)。
     * <p>官方接口：{@code /waimai/ng/special/food/updateSellStatus}，API：{@code special_food_update_sell_status}，版本：{@code 10012}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgSpecialFoodUpdateSellStatus(SpecialFoodUpdateSellStatusRequest request, String tenantId);

    /**
     * 修改商品库存(拼好饭)。
     * <p>官方接口：{@code /waimai/ng/special/food/updateStock}，API：{@code special_food_update_stock}，版本：{@code 10012}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgSpecialFoodUpdateStock(SpecialFoodUpdateStockRequest request, String tenantId);

    /**
     * 上传图片。
     * <p>官方接口：{@code /waimai/ng/special/phf/product/image/upload}，API：{@code upload_picture_new}，版本：{@code 10008}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> uploadPictureNew(UploadPictureNewRequest request, String tenantId);

    /**
     * 获取自定义标签。
     * <p>官方接口：{@code /waimai/ng/valueadded/getCustomLabels}，API：{@code get_custom_labels}，版本：{@code 10017}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGetCustomLabels(GetCustomLabelsRequest request, String tenantId);

    /**
     * 获取系统标签。
     * <p>官方接口：{@code /waimai/ng/valueadded/getSystemLabels}，API：{@code get_system_labels}，版本：{@code 10002}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgGetSystemLabels(GetSystemLabelsRequest request, String tenantId);

    /**
     * 精准营销-活动效果汇总查询接口（含券使用时间）。
     * <p>官方接口：{@code /waimai/ng/valueadded/queryCouponDetailExtraResult}，API：{@code query_coupon_detail_extra_result}，版本：{@code 10014}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgQueryCouponDetailExtraResult(QueryCouponDetailExtraResultRequest request, String tenantId);

    /**
     * 根据发券任务ID查询发券活动效果明细。
     * <p>官方接口：{@code /waimai/ng/valueadded/queryCouponDetailResult}，API：{@code query_coupon_detail_result}，版本：{@code 10010}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgQueryCouponDetailResult(QueryCouponDetailResultRequest request, String tenantId);

    /**
     * 查询商家当前剩余可发券数量。
     * <p>官方接口：{@code /waimai/ng/valueadded/queryCouponStock}，API：{@code query_coupon_stock}，版本：{@code 10007}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgQueryCouponStock(QueryCouponStockRequest request, String tenantId);

    /**
     * 活动效果汇总查询接口。
     * <p>官方接口：{@code /waimai/ng/valueadded/queryCouponTotalResult}，API：{@code query_coupon_total_result}，版本：{@code 10011}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgQueryCouponTotalResult(QueryCouponTotalResultRequest request, String tenantId);

    /**
     * 查询任务结果。
     * <p>官方接口：{@code /waimai/ng/valueadded/async/taskResultQuery}，API：{@code task_result_query}，版本：{@code 10012}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgTaskResultQuery(TaskResultQueryRequest request, String tenantId);

    /**
     * 任务提交。
     * <p>官方接口：{@code /waimai/ng/valueadded/async/taskSubmit}，API：{@code task_submit}，版本：{@code 10013}，businessId：{@code 2}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiNgTaskSubmit(TaskSubmitRequest request, String tenantId);

    /**
     * 非接单查询安心卡。
     * <p>官方接口：{@code /wmoper/card/queryCard}，API：{@code wmoper_card_query}，版本：{@code 10000}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperCardQuery(WmoperCardQueryRequest request, String tenantId);

    /**
     * 非接单安心卡。
     * <p>官方接口：{@code /wmoper/card/save}，API：{@code wmoper_card_save}，版本：{@code 10000}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperCardSave(WmoperCardSaveRequest request, String tenantId);

    /**
     * 安心卡查询。
     * <p>官方接口：{@code /wmoper/ng/card/queryCard}，API：{@code wmoper_ng_card_query}，版本：{@code 10001}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgCardQuery(WmoperNgCardQueryRequest request, String tenantId);

    /**
     * 保存安心卡。
     * <p>官方接口：{@code /wmoper/ng/card/save}，API：{@code wmoper_ng_card_save}，版本：{@code 10000}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgCardSave(WmoperNgCardSaveRequest request, String tenantId);

    /**
     * 上传安心卡图片。
     * <p>官方接口：{@code /wmoper/card/uploadCardImage}，API：{@code wmoper_upload_card_image}，版本：{@code 10000}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperUploadCardImage(WmoperUploadCardImageRequest request, String tenantId);

    /**
     * 评价申诉接口。
     * <p>官方接口：{@code /wmoper/ng/comment/complain/report}，API：{@code comment_complain_report}，版本：{@code 10009}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgCommentComplainReport(com.meituan.sdk.model.wmoperNg.comment.commentComplainReport.CommentComplainReportRequest request, String tenantId);

    /**
     * 查询门店评价信息。
     * <p>官方接口：{@code /wmoper/ng/comment/queryCommentList}，API：{@code query_comment_list}，版本：{@code 10015}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgQueryCommentList(com.meituan.sdk.model.wmoperNg.comment.queryCommentList.QueryCommentListRequest request, String tenantId);

    /**
     * 根据评价id添加商家回复。
     * <p>官方接口：{@code /wmoper/ng/comment/addReply}，API：{@code wmoper_comment_add_reply}，版本：{@code 10002}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperCommentAddReply(WmoperCommentAddReplyRequest request, String tenantId);

    /**
     * 获取门店评分。
     * <p>官方接口：{@code /wmoper/ng/comment/queryScore}，API：{@code wmoper_comment_query_score}，版本：{@code 10017}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperCommentQueryScore(WmoperCommentQueryScoreRequest request, String tenantId);

    /**
     * 商家开放平台查询老板推荐。
     * <p>官方接口：{@code /wmoper/ng/decoration/bossRecommendQuery}，API：{@code decoration_boss_recommend_query}，版本：{@code 10000}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> decorationBossRecommendQuery(DecorationBossRecommendQueryRequest request, String tenantId);

    /**
     * 商家开放平台商品查询。
     * <p>官方接口：{@code /wmoper/ng/decoration/productsQuery}，API：{@code decoration_products_query}，版本：{@code 10000}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> decorationProductsQuery(DecorationProductsQueryRequest request, String tenantId);

    /**
     * 商家开放平台查询招牌。
     * <p>官方接口：{@code /wmoper/ng/decoration/queryImageForSingle}，API：{@code decoration_query_image_for_single}，版本：{@code 10000}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> decorationQueryImageForSingle(DecorationQueryImageForSingleRequest request, String tenantId);

    /**
     * 商家开放平台海报查询。
     * <p>官方接口：{@code /wmoper/ng/decoration/queryPoster}，API：{@code decoration_query_poster}，版本：{@code 10000}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> decorationQueryPoster(DecorationQueryPosterRequest request, String tenantId);

    /**
     * 上传门店装修图片。
     * <p>官方接口：{@code /wmoper/image/uploadNoWater}，API：{@code wmoper_image_upload_no_water}，版本：{@code 10004}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperImageUploadNoWater(WmoperImageUploadNoWaterRequest request, String tenantId);

    /**
     * 商家开放平台创建、修改、删除老板推荐。
     * <p>官方接口：{@code /wmoper/ng/decorationop/bossRecommendCreate}，API：{@code decoration_boss_recommend_create}，版本：{@code 10000}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> decorationBossRecommendCreate(DecorationBossRecommendCreateRequest request, String tenantId);

    /**
     * 商家开放平台删除招牌。
     * <p>官方接口：{@code /wmoper/ng/decorationop/deleteImgeForSingle}，API：{@code decoration_delete_imge_for_single}，版本：{@code 10000}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> decorationDeleteImgeForSingle(DecorationDeleteImgeForSingleRequest request, String tenantId);

    /**
     * 商家开放平台删除海报。
     * <p>官方接口：{@code /wmoper/ng/decorationop/deleteShopPoster}，API：{@code decoration_delete_shop_poster}，版本：{@code 10000}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> decorationDeleteShopPoster(DecorationDeleteShopPosterRequest request, String tenantId);

    /**
     * 商家开放平台创建海报。
     * <p>官方接口：{@code /wmoper/ng/decorationop/postersCreate}，API：{@code decoration_posters_create}，版本：{@code 10000}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> decorationPostersCreate(DecorationPostersCreateRequest request, String tenantId);

    /**
     * 商家开放平台创建招牌。
     * <p>官方接口：{@code /wmoper/ng/decorationop/signageCreate}，API：{@code decoration_signage_create}，版本：{@code 10000}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> decorationSignageCreate(DecorationSignageCreateRequest request, String tenantId);

    /**
     * 商家开放平台使用海报。
     * <p>官方接口：{@code /wmoper/ng/decorationop/updatePosterStatus}，API：{@code decoration_update_poster_status}，版本：{@code 10009}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> decorationUpdatePosterStatus(DecorationUpdatePosterStatusRequest request, String tenantId);

    /**
     * 门店装修-新建海报接口(通过spuid)。
     * <p>官方接口：{@code /wmoper/ng/decorationop/postersCreateForSpuId}，API：{@code posters_create_for_spu_id}，版本：{@code 10008}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgPostersCreateForSpuId(com.meituan.sdk.model.wmoperNg.decorationop.postersCreateForSpuId.PostersCreateForSpuIdRequest request, String tenantId);

    /**
     * 配送类服务商提供收货人的信息。
     * <p>官方接口：{@code /wmoper/ng/delivery/getRecipientInfo}，API：{@code get_recipient_info}，版本：{@code 10004}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> getRecipientInfo(GetRecipientInfoRequest request, String tenantId);

    /**
     * 自配订单同步预计送达时间信息。
     * <p>官方接口：{@code /wmoper/ng/delivery/medicine/syncEstimateArrivalTime}，API：{@code sync_estimate_arrival_time}，版本：{@code 10006}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgSyncEstimateArrivalTime(com.meituan.sdk.model.wmoperNg.delivery.syncEstimateArrivalTime.SyncEstimateArrivalTimeRequest request, String tenantId);

    /**
     * 批量删除商品。
     * <p>官方接口：{@code /wmoper/ng/food/food/batchDelSpu}，API：{@code batch_del_spu}，版本：{@code 10052}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgBatchDelSpu(com.meituan.sdk.model.wmoperNg.food.batchDelSpu.BatchDelSpuRequest request, String tenantId);

    /**
     * 创建场域商品。
     * <p>官方接口：{@code /wmoper/ng/food/food/batchInitMarketPlaceFood}，API：{@code batch_init_market_place_food}，版本：{@code 10052}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgBatchInitMarketPlaceFood(com.meituan.sdk.model.wmoperNg.food.batchInitMarketPlaceFood.BatchInitMarketPlaceFoodRequest request, String tenantId);

    /**
     * 美团真实spuid批量查询菜品信息。
     * <p>官方接口：{@code /wmoper/ng/food/batchQuerySpuByIds}，API：{@code batch_query_spu_by_ids}，版本：{@code 10055}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgBatchQuerySpuByIds(com.meituan.sdk.model.wmoperNg.food.batchQuerySpuByIds.BatchQuerySpuByIdsRequest request, String tenantId);

    /**
     * 批量通过美团spuid修改商品部分信息。
     * <p>官方接口：{@code /wmoper/ng/food/batchUpdateSpuById}，API：{@code batch_update_spu_by_id}，版本：{@code 10027}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> batchUpdateSpuById(BatchUpdateSpuByIdRequest request, String tenantId);

    /**
     * 根据小料名称绑定小料code接口。
     * <p>官方接口：{@code /wmoper/ng/food/topping/bindToppingCodeByName}，API：{@code bind_topping_code_by_name}，版本：{@code 10043}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> bindToppingCodeByName(BindToppingCodeByNameRequest request, String tenantId);

    /**
     * 批量创建/更新套餐商品（仅支持套餐商品）。
     * <p>官方接口：{@code /wmoper/ng/food/combo/batchsave}，API：{@code dish_combo_batchsave}，版本：{@code 10053}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgDishComboBatchsave(com.meituan.sdk.model.wmoperNg.food.dishComboBatchsave.DishComboBatchsaveRequest request, String tenantId);

    /**
     * 单个创建/更新套餐商品（仅支持套餐商品）。
     * <p>官方接口：{@code /wmoper/ng/food/combo/save}，API：{@code dish_combo_save}，版本：{@code 10054}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgDishComboSave(com.meituan.sdk.model.wmoperNg.food.dishComboSave.DishComboSaveRequest request, String tenantId);

    /**
     * 查询门店菜品列表（包括门店的套餐商品和普通商品）。
     * <p>官方接口：{@code /wmoper/ng/food/dish/food/listAll}，API：{@code dish_food_list_all}，版本：{@code 10055}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgDishFoodListAll(com.meituan.sdk.model.wmoperNg.food.dishFoodListAll.DishFoodListAllRequest request, String tenantId);

    /**
     * 批量查询门店菜品（包括查询套餐商品和普通商品）。
     * <p>官方接口：{@code /wmoper/ng/food/food/batchGet}，API：{@code food_batch_get}，版本：{@code 10055}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgFoodBatchGet(com.meituan.sdk.model.wmoperNg.food.foodBatchGet.FoodBatchGetRequest request, String tenantId);

    /**
     * 删除分组。
     * <p>官方接口：{@code /wmoper/ng/food/foodCat/delete}，API：{@code food_cat_delete}，版本：{@code 10052}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgFoodCatDelete(com.meituan.sdk.model.wmoperNg.food.foodCatDelete.FoodCatDeleteRequest request, String tenantId);

    /**
     * 查询分组。
     * <p>官方接口：{@code /wmoper/ng/food/foodCat/list}，API：{@code food_cat_list}，版本：{@code 10052}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgFoodCatList(com.meituan.sdk.model.wmoperNg.food.foodCatList.FoodCatListRequest request, String tenantId);

    /**
     * 保存更新分组。
     * <p>官方接口：{@code /wmoper/ng/food/foodCat/update}，API：{@code food_cat_update}，版本：{@code 10052}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgFoodCatUpdate(com.meituan.sdk.model.wmoperNg.food.foodCatUpdate.FoodCatUpdateRequest request, String tenantId);

    /**
     * 查询已有场域。
     * <p>官方接口：{@code /wmoper/ng/food/food/listMarketplaces}，API：{@code list_market_places}，版本：{@code 10052}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgListMarketPlaces(com.meituan.sdk.model.wmoperNg.food.listMarketPlaces.ListMarketPlacesRequest request, String tenantId);

    /**
     * 新建/更新小料接口。
     * <p>官方接口：{@code /wmoper/ng/food/topping/batchInit}，API：{@code topping_batch_init}，版本：{@code 10043}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgToppingBatchInit(com.meituan.sdk.model.wmoperNg.food.toppingBatchInit.ToppingBatchInitRequest request, String tenantId);

    /**
     * 查询小料信息接口（根据小料code查询）。
     * <p>官方接口：{@code /wmoper/ng/food/topping/batchQuery}，API：{@code topping_batch_query}，版本：{@code 10043}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgToppingBatchQuery(com.meituan.sdk.model.wmoperNg.food.toppingBatchQuery.ToppingBatchQueryRequest request, String tenantId);

    /**
     * 删除小料信息接口。
     * <p>官方接口：{@code /wmoper/ng/food/topping/delete}，API：{@code topping_delete}，版本：{@code 10043}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgToppingDelete(com.meituan.sdk.model.wmoperNg.food.toppingDelete.ToppingDeleteRequest request, String tenantId);

    /**
     * 创建小料组接口。
     * <p>官方接口：{@code /wmoper/ng/food/toppingGroup/batchInit}，API：{@code topping_group_batch_init}，版本：{@code 10050}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgToppingGroupBatchInit(com.meituan.sdk.model.wmoperNg.food.toppingGroupBatchInit.ToppingGroupBatchInitRequest request, String tenantId);

    /**
     * 查询小料组接口。
     * <p>官方接口：{@code /wmoper/ng/food/toppingGroup/batchQuery}，API：{@code topping_group_batch_query}，版本：{@code 10047}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgToppingGroupBatchQuery(com.meituan.sdk.model.wmoperNg.food.toppingGroupBatchQuery.ToppingGroupBatchQueryRequest request, String tenantId);

    /**
     * 删除小料组接口。
     * <p>官方接口：{@code /wmoper/ng/food/toppingGroup/delete}，API：{@code topping_group_delete}，版本：{@code 10043}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgToppingGroupDelete(com.meituan.sdk.model.wmoperNg.food.toppingGroupDelete.ToppingGroupDeleteRequest request, String tenantId);

    /**
     * 查询小料组接口(分页)。
     * <p>官方接口：{@code /wmoper/ng/food/toppingGroup/list}，API：{@code topping_group_list}，版本：{@code 10047}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgToppingGroupList(com.meituan.sdk.model.wmoperNg.food.toppingGroupList.ToppingGroupListRequest request, String tenantId);

    /**
     * 查询小料信息接口（分页）。
     * <p>官方接口：{@code /wmoper/ng/food/topping/list}，API：{@code topping_list}，版本：{@code 10043}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgToppingList(com.meituan.sdk.model.wmoperNg.food.toppingList.ToppingListRequest request, String tenantId);

    /**
     * 批量查询商品DNA。
     * <p>官方接口：{@code /wmoper/ng/food/batchQueryFoodDna}，API：{@code wmoper_food_batch_query_food_dna}，版本：{@code 10008}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperFoodBatchQueryFoodDna(WmoperFoodBatchQueryFoodDnaRequest request, String tenantId);

    /**
     * 批量查询外卖菜品。
     * <p>官方接口：{@code /wmoper/ng/food/batchQuery}，API：{@code wmoper_food_batch_query_list}，版本：{@code 10055}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperFoodBatchQueryList(WmoperFoodBatchQueryListRequest request, String tenantId);

    /**
     * 获取菜品属性。
     * <p>官方接口：{@code /wmoper/ng/food/queryFoodPropertyList}，API：{@code wmoper_food_property_list}，版本：{@code 10001}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperFoodPropertyList(WmoperFoodPropertyListRequest request, String tenantId);

    /**
     * 查询所有类目，对应商家后台标准分类。
     * <p>官方接口：{@code /wmoper/ng/food/queryCategoryList}，API：{@code wmoper_food_query_category_list}，版本：{@code 10001}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperFoodQueryCategoryList(WmoperFoodQueryCategoryListRequest request, String tenantId);

    /**
     * 根据类目查询模板下所有属性。
     * <p>官方接口：{@code /wmoper/ng/food/queryCategoryProperties}，API：{@code wmoper_food_query_category_property}，版本：{@code 10057}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperFoodQueryCategoryProperty(WmoperFoodQueryCategoryPropertyRequest request, String tenantId);

    /**
     * 查询菜品详情。
     * <p>官方接口：{@code /wmoper/ng/food/detail}，API：{@code wmoper_food_query_detail}，版本：{@code 10049}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperFoodQueryDetail(WmoperFoodQueryDetailRequest request, String tenantId);

    /**
     * 查询商品DNA。
     * <p>官方接口：{@code /wmoper/ng/food/queryFoodDna}，API：{@code wmoper_food_query_food_dna}，版本：{@code 10001}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperFoodQueryFoodDna(WmoperFoodQueryFoodDnaRequest request, String tenantId);

    /**
     * 查询门店菜品分类列表。
     * <p>官方接口：{@code /wmoper/ng/food/queryFoodCatList}，API：{@code wmoper_food_query_foodcat_list}，版本：{@code 10007}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperFoodQueryFoodcatList(WmoperFoodQueryFoodcatListRequest request, String tenantId);

    /**
     * 查询门店菜品列表。
     * <p>官方接口：{@code /wmoper/ng/food/queryFoodList}，API：{@code wmoper_food_query_list}，版本：{@code 10055}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperFoodQueryList(WmoperFoodQueryListRequest request, String tenantId);

    /**
     * 查询门店打包费。
     * <p>官方接口：{@code /wmoper/ng/food/queryBoxPriceTypeAndDetail}，API：{@code wmoper_query_box_price_type_and_detail}，版本：{@code 10032}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperQueryBoxPriceTypeAndDetail(WmoperQueryBoxPriceTypeAndDetailRequest request, String tenantId);

    /**
     * 设置门店打包费。
     * <p>官方接口：{@code /wmoper/ng/food/saveBoxPriceTypeAndDetail}，API：{@code wmoper_save_box_price_type_and_detail}，版本：{@code 10032}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperSaveBoxPriceTypeAndDetail(WmoperSaveBoxPriceTypeAndDetailRequest request, String tenantId);

    /**
     * 批量创建或更新菜品。
     * <p>官方接口：{@code /wmoper/ng/foodop/food/batchbulksave}，API：{@code food_batch_bulk_save}，版本：{@code 10036}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> foodBatchBulkSave(FoodBatchBulkSaveRequest request, String tenantId);

    /**
     * 批量创建或更新菜品（新版）。
     * <p>官方接口：{@code /wmoper/ng/foodop/food/batchinitdata}，API：{@code food_batchinitdata}，版本：{@code 10044}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> foodBatchinitdata(FoodBatchinitdataRequest request, String tenantId);

    /**
     * 绑定菜品属性。
     * <p>官方接口：{@code /wmoper/ng/foodop/food/bind/property}，API：{@code food_bind_property}，版本：{@code 10003}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> foodBindProperty(FoodBindPropertyRequest request, String tenantId);

    /**
     * 删除菜品分类。
     * <p>官方接口：{@code /wmoper/ng/foodop/foodCat/delete}，API：{@code food_cat_delete}，版本：{@code 10004}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgFoodCatDelete(com.meituan.sdk.model.wmoperNg.foodop.foodCatDelete.FoodCatDeleteRequest request, String tenantId);

    /**
     * 创建或更新菜品分类。
     * <p>官方接口：{@code /wmoper/ng/foodop/foodCat/update}，API：{@code food_cat_update}，版本：{@code 10011}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgFoodCatUpdate(com.meituan.sdk.model.wmoperNg.foodop.foodCatUpdate.FoodCatUpdateRequest request, String tenantId);

    /**
     * 删除菜品。
     * <p>官方接口：{@code /wmoper/ng/foodop/food/delete}，API：{@code food_delete}，版本：{@code 10004}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> foodDelete(FoodDeleteRequest request, String tenantId);

    /**
     * 创建或更新菜品（新版）。
     * <p>官方接口：{@code /wmoper/ng/foodop/food/initdata}，API：{@code food_initdata}，版本：{@code 10039}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> foodInitdata(FoodInitdataRequest request, String tenantId);

    /**
     * 删除SKU信息。
     * <p>官方接口：{@code /wmoper/ng/foodop/food/sku/delete}，API：{@code food_sku_delete}，版本：{@code 10004}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> foodSkuDelete(FoodSkuDeleteRequest request, String tenantId);

    /**
     * 减少SKU库存。
     * <p>官方接口：{@code /wmoper/ng/foodop/food/sku/desc_stock}，API：{@code food_sku_desc_stock}，版本：{@code 10003}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> foodSkuDescStock(FoodSkuDescStockRequest request, String tenantId);

    /**
     * 增加SKU库存。
     * <p>官方接口：{@code /wmoper/ng/foodop/food/sku/inc_stock}，API：{@code food_sku_inc_stock}，版本：{@code 10004}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> foodSkuIncStock(FoodSkuIncStockRequest request, String tenantId);

    /**
     * 更新SKU价格。
     * <p>官方接口：{@code /wmoper/ng/foodop/food/sku/price}，API：{@code food_sku_price}，版本：{@code 10004}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> foodSkuPrice(FoodSkuPriceRequest request, String tenantId);

    /**
     * 创建/更新SKU信息。
     * <p>官方接口：{@code /wmoper/ng/foodop/food/sku/save}，API：{@code food_sku_save}，版本：{@code 10007}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> foodSkuSave(FoodSkuSaveRequest request, String tenantId);

    /**
     * 批量更新售卖状态。
     * <p>官方接口：{@code /wmoper/ng/foodop/food/sku/sellStatus}，API：{@code food_sku_sell_status}，版本：{@code 10003}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> foodSkuSellStatus(FoodSkuSellStatusRequest request, String tenantId);

    /**
     * 更新SKU库存。
     * <p>官方接口：{@code /wmoper/ng/foodop/food/sku/stock}，API：{@code food_sku_stock}，版本：{@code 10004}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> foodSkuStock(FoodSkuStockRequest request, String tenantId);

    /**
     * 根据原商品编码更换新商品编码。
     * <p>官方接口：{@code /wmoper/ng/foodop/food/updateAppFoodCodeByOrigin}，API：{@code food_update_app_food_code_by_origin}，版本：{@code 10003}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgFoodUpdateAppFoodCodeByOrigin(com.meituan.sdk.model.wmoperNg.foodop.foodUpdateAppFoodCodeByOrigin.FoodUpdateAppFoodCodeByOriginRequest request, String tenantId);

    /**
     * 根据商品名称和规格名称更换新的商品编码。
     * <p>官方接口：{@code /wmoper/ng/foodop/food/updateAppFoodCodeByNameAndSpec}，API：{@code food_update_appfoodcode_by_name_and_spec}，版本：{@code 10003}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgFoodUpdateAppfoodcodeByNameAndSpec(com.meituan.sdk.model.wmoperNg.foodop.foodUpdateAppfoodcodeByNameAndSpec.FoodUpdateAppfoodcodeByNameAndSpecRequest request, String tenantId);

    /**
     * 保存商品DNA。
     * <p>官方接口：{@code /wmoper/ng/foodop/foodDna/saveFoodDna}，API：{@code fooddna_save_fooddna}，版本：{@code 10003}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> fooddnaSaveFooddna(FooddnaSaveFooddnaRequest request, String tenantId);

    /**
     * 上传菜品图片。
     * <p>官方接口：{@code /wmoper/ng/foodop/image/upload}，API：{@code image_upload}，版本：{@code 10009}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> imageUpload(ImageUploadRequest request, String tenantId);

    /**
     * 上传菜品图片。
     * <p>官方接口：{@code /wmoper/image/upload}，API：{@code wmoper_image_upload}，版本：{@code 10028}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperImageUpload(WmoperImageUploadRequest request, String tenantId);

    /**
     * 上传无水印图片。
     * <p>官方接口：{@code /wmoper/ng/foodop/image/uploadNoWater}，API：{@code wmoperng_image_upload_no_water}，版本：{@code 10008}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperngImageUploadNoWater(WmoperngImageUploadNoWaterRequest request, String tenantId);

    /**
     * 申诉详情查询。
     * <p>官方接口：{@code /wmoper/ng/govern/appeal/detail/query}，API：{@code govern_appeal_detail_query}，版本：{@code 10001}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGovernAppealDetailQuery(com.meituan.sdk.model.wmoperNg.govern.governAppealDetailQuery.GovernAppealDetailQueryRequest request, String tenantId);

    /**
     * 违规列表查询。
     * <p>官方接口：{@code /wmoper/ng/govern/violation/list/query}，API：{@code govern_violation_query}，版本：{@code 10001}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGovernViolationQuery(com.meituan.sdk.model.wmoperNg.govern.governViolationQuery.GovernViolationQueryRequest request, String tenantId);

    /**
     * 积分信息查询。
     * <p>官方接口：{@code /wmoper/ng/govern/violation/score/query}，API：{@code govern_violation_score_query}，版本：{@code 10001}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGovernViolationScoreQuery(com.meituan.sdk.model.wmoperNg.govern.governViolationScoreQuery.GovernViolationScoreQueryRequest request, String tenantId);

    /**
     * 积分记录查询。
     * <p>官方接口：{@code /wmoper/ng/govern/violation/score/record/query}，API：{@code govern_violation_score_record_query}，版本：{@code 10001}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGovernViolationScoreRecordQuery(com.meituan.sdk.model.wmoperNg.govern.governViolationScoreRecordQuery.GovernViolationScoreRecordQueryRequest request, String tenantId);

    /**
     * 预警列表查询。
     * <p>官方接口：{@code /wmoper/ng/govern/warning/list/query}，API：{@code govern_warning_list_query}，版本：{@code 10001}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGovernWarningListQuery(com.meituan.sdk.model.wmoperNg.govern.governWarningListQuery.GovernWarningListQueryRequest request, String tenantId);

    /**
     * 商家屏蔽顾客。
     * <p>官方接口：{@code /wmoper/ng/im/blockUser}，API：{@code block_user}，版本：{@code 10018}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgBlockUser(com.meituan.sdk.model.wmoperNg.im.blockUser.BlockUserRequest request, String tenantId);

    /**
     * 商家解除屏蔽顾客。
     * <p>官方接口：{@code /wmoper/ng/im/cancelBlockUser}，API：{@code cancel_block_user}，版本：{@code 10017}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgCancelBlockUser(com.meituan.sdk.model.wmoperNg.im.cancelBlockUser.CancelBlockUserRequest request, String tenantId);

    /**
     * 创建进群领券活动。
     * <p>官方接口：{@code /wmoper/ng/im/createEnterCouponActivity}，API：{@code create_enter_coupon_activity}，版本：{@code 10039}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgCreateEnterCouponActivity(com.meituan.sdk.model.wmoperNg.im.createEnterCouponActivity.CreateEnterCouponActivityRequest request, String tenantId);

    /**
     * 创建粉丝群。
     * <p>官方接口：{@code /wmoper/ng/im/createFansGroup}，API：{@code create_fans_group}，版本：{@code 10039}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgCreateFansGroup(com.meituan.sdk.model.wmoperNg.im.createFansGroup.CreateFansGroupRequest request, String tenantId);

    /**
     * 创建群接口。
     * <p>官方接口：{@code /wmoper/ng/im/createGroup}，API：{@code create_group}，版本：{@code 10021}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgCreateGroup(com.meituan.sdk.model.wmoperNg.im.createGroup.CreateGroupRequest request, String tenantId);

    /**
     * 查询门店“智能回复机器人”的开关状态。
     * <p>官方接口：{@code /wmoper/ng/im/autosend/getAutoSendConfigInfo}，API：{@code get_auto_send_config_info}，版本：{@code 10051}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGetAutoSendConfigInfo(com.meituan.sdk.model.wmoperNg.im.getAutoSendConfigInfo.GetAutoSendConfigInfoRequest request, String tenantId);

    /**
     * 获取长连接的token。
     * <p>官方接口：{@code /wmoper/ng/im/getConnectionToken}，API：{@code get_connection_token}，版本：{@code 10044}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGetConnectionToken(com.meituan.sdk.model.wmoperNg.im.getConnectionToken.GetConnectionTokenRequest request, String tenantId);

    /**
     * 获取多个长连接。
     * <p>官方接口：{@code /wmoper/ng/im/getConnectionTokenWithCount}，API：{@code get_connection_token_with_count}，版本：{@code 10043}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGetConnectionTokenWithCount(com.meituan.sdk.model.wmoperNg.im.getConnectionTokenWithCount.GetConnectionTokenWithCountRequest request, String tenantId);

    /**
     * 查询门店IM状态。
     * <p>官方接口：{@code /wmoper/ng/im/getPoiIMStatus}，API：{@code get_poi_im_status}，版本：{@code 10008}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGetPoiImStatus(com.meituan.sdk.model.wmoperNg.im.getPoiImStatus.GetPoiImStatusRequest request, String tenantId);

    /**
     * 回复率及权益查询。
     * <p>官方接口：{@code /wmoper/ng/im/getReversionRateAndRightsList}，API：{@code get_reversion_rate_and_rights_list}，版本：{@code 10016}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGetReversionRateAndRightsList(com.meituan.sdk.model.wmoperNg.im.getReversionRateAndRightsList.GetReversionRateAndRightsListRequest request, String tenantId);

    /**
     * 查询会话最新已读时间戳。
     * <p>官方接口：{@code /wmoper/ng/im/userReadTime}，API：{@code im_get_read_time}，版本：{@code 10008}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> imGetReadTime(ImGetReadTimeRequest request, String tenantId);

    /**
     * 设置设置消息已读状态。
     * <p>官方接口：{@code /wmoper/ng/im/msgRead}，API：{@code msg_read}，版本：{@code 10008}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgMsgRead(com.meituan.sdk.model.wmoperNg.im.msgRead.MsgReadRequest request, String tenantId);

    /**
     * 查询粉丝群发券信息。
     * <p>官方接口：{@code /wmoper/ng/im/queryCoupon}，API：{@code query_coupon}，版本：{@code 10039}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgQueryCoupon(com.meituan.sdk.model.wmoperNg.im.queryCoupon.QueryCouponRequest request, String tenantId);

    /**
     * 查询发券的活动效果。
     * <p>官方接口：{@code /wmoper/ng/im/queryReceiveCouponDetail}，API：{@code query_coupon_detail}，版本：{@code 10039}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgQueryCouponDetail(com.meituan.sdk.model.wmoperNg.im.queryCouponDetail.QueryCouponDetailRequest request, String tenantId);

    /**
     * 查询当前的进群领券活动。
     * <p>官方接口：{@code /wmoper/ng/im/queryEnterCouponActivity}，API：{@code query_enter_coupon_activity}，版本：{@code 10039}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgQueryEnterCouponActivity(com.meituan.sdk.model.wmoperNg.im.queryEnterCouponActivity.QueryEnterCouponActivityRequest request, String tenantId);

    /**
     * 查询门店外卖非接单M消息订阅状态。
     * <p>官方接口：{@code /wmoper/ng/im/queryImSubscribeStatusByEpoi}，API：{@code query_im_subscribe_status_by_epoi}，版本：{@code 10047}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgQueryImSubscribeStatusByEpoi(com.meituan.sdk.model.wmoperNg.im.queryImSubscribeStatusByEpoi.QueryImSubscribeStatusByEpoiRequest request, String tenantId);

    /**
     * 查询门店的粉丝群。
     * <p>官方接口：{@code /wmoper/ng/im/queryStoreFansGroup}，API：{@code query_store_fans_group}，版本：{@code 10039}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgQueryStoreFansGroup(com.meituan.sdk.model.wmoperNg.im.queryStoreFansGroup.QueryStoreFansGroupRequest request, String tenantId);

    /**
     * 查询门店是否有建群资格。
     * <p>官方接口：{@code /wmoper/ng/im/queryStoreHaveBuild}，API：{@code query_store_have_build}，版本：{@code 10039}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgQueryStoreHaveBuild(com.meituan.sdk.model.wmoperNg.im.queryStoreHaveBuild.QueryStoreHaveBuildRequest request, String tenantId);

    /**
     * 查询门店剩余发券数。
     * <p>官方接口：{@code /wmoper/ng/im/remainCoupon}，API：{@code remain_coupon}，版本：{@code 10055}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgRemainCoupon(com.meituan.sdk.model.wmoperNg.im.remainCoupon.RemainCouponRequest request, String tenantId);

    /**
     * 停止当前的进群领券活动。
     * <p>官方接口：{@code /wmoper/ng/im/revokeEnterCouponActivity}，API：{@code revoke_enter_coupon_activity}，版本：{@code 10039}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgRevokeEnterCouponActivity(com.meituan.sdk.model.wmoperNg.im.revokeEnterCouponActivity.RevokeEnterCouponActivityRequest request, String tenantId);

    /**
     * 在粉丝群内主动建券并发券。
     * <p>官方接口：{@code /wmoper/ng/im/sendFansGroupCoupon}，API：{@code send_fans_group_coupon}，版本：{@code 10042}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgSendFansGroupCoupon(com.meituan.sdk.model.wmoperNg.im.sendFansGroupCoupon.SendFansGroupCouponRequest request, String tenantId);

    /**
     * 发送IM消息（非接单）。
     * <p>官方接口：{@code /wmoper/ng/im/msg/send}，API：{@code send_im_msg_wmoper}，版本：{@code 10053}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> sendImMsgWmoper(SendImMsgWmoperRequest request, String tenantId);

    /**
     * 自动回复设置。
     * <p>官方接口：{@code /wmoper/ng/im/setAutoSendConfig}，API：{@code set_auto_send_config}，版本：{@code 10019}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgSetAutoSendConfig(com.meituan.sdk.model.wmoperNg.im.setAutoSendConfig.SetAutoSendConfigRequest request, String tenantId);

    /**
     * 设置门店“智能回复机器人”的开关状态。
     * <p>官方接口：{@code /wmoper/ng/im/autosend/setAutoSendConfigInfo}，API：{@code set_auto_send_config_info}，版本：{@code 10051}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgSetAutoSendConfigInfo(com.meituan.sdk.model.wmoperNg.im.setAutoSendConfigInfo.SetAutoSendConfigInfoRequest request, String tenantId);

    /**
     * 设置门店IM状态。
     * <p>官方接口：{@code /wmoper/ng/im/setPoiIMStatus}，API：{@code set_poi_im_status}，版本：{@code 10008}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgSetPoiImStatus(com.meituan.sdk.model.wmoperNg.im.setPoiImStatus.SetPoiImStatusRequest request, String tenantId);

    /**
     * 根据门店订阅外卖非接单IM消息。
     * <p>官方接口：{@code /wmoper/ng/im/subscribeImByEpoi}，API：{@code subscribe_im_by_epoi}，版本：{@code 10046}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgSubscribeImByEpoi(com.meituan.sdk.model.wmoperNg.im.subscribeImByEpoi.SubscribeImByEpoiRequest request, String tenantId);

    /**
     * 根据门店解除订阅外卖非接单IM消息。
     * <p>官方接口：{@code /wmoper/ng/im/unsubscribeImByEpoi}，API：{@code unsubscribe_im_by_epoi}，版本：{@code 10045}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgUnsubscribeImByEpoi(com.meituan.sdk.model.wmoperNg.im.unsubscribeImByEpoi.UnsubscribeImByEpoiRequest request, String tenantId);

    /**
     * 查询短信发送结果。
     * <p>官方接口：{@code /wmoper/ng/order/batchQuerySMSSendResult}，API：{@code batch_query_sms_send_result}，版本：{@code 10088}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgBatchQuerySmsSendResult(com.meituan.sdk.model.wmoperNg.order.batchQuerySmsSendResult.BatchQuerySmsSendResultRequest request, String tenantId);

    /**
     * 提交取消跑腿。
     * <p>官方接口：{@code /wmoper/ng/order/cancelZbLogisticsByWmOrderId}，API：{@code cancel_zb_logistics_by_wm_order_id}，版本：{@code 10085}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgCancelZbLogisticsByWmOrderId(com.meituan.sdk.model.wmoperNg.order.cancelZbLogisticsByWmOrderId.CancelZbLogisticsByWmOrderIdRequest request, String tenantId);

    /**
     * 配送中批量回传轨迹点。
     * <p>官方接口：{@code /wmoper/ng/order/delivering/riderPosition/batch}，API：{@code delivering_rider_position_batch}，版本：{@code 10078}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgDeliveringRiderPositionBatch(com.meituan.sdk.model.wmoperNg.order.deliveringRiderPositionBatch.DeliveringRiderPositionBatchRequest request, String tenantId);

    /**
     * 完单后批量回传轨迹点。
     * <p>官方接口：{@code /wmoper/ng/order/deliveryCompleted/riderPosition/batch}，API：{@code delivery_completed_rider_position_batch}，版本：{@code 10078}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgDeliveryCompletedRiderPositionBatch(com.meituan.sdk.model.wmoperNg.order.deliveryCompletedRiderPositionBatch.DeliveryCompletedRiderPositionBatchRequest request, String tenantId);

    /**
     * 批量查询退款订单信息。
     * <p>官方接口：{@code /wmoper/ng/order/getBatchOrderRefundInfo}，API：{@code get_batch_order_refund_info}，版本：{@code 10041}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGetBatchOrderRefundInfo(com.meituan.sdk.model.wmoperNg.order.getBatchOrderRefundInfo.GetBatchOrderRefundInfoRequest request, String tenantId);

    /**
     * 查询众包骑手坐标。
     * <p>官方接口：{@code /wmoper/ng/order/getDeliveryPath}，API：{@code get_delivery_path}，版本：{@code 10085}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGetDeliveryPath(com.meituan.sdk.model.wmoperNg.order.getDeliveryPath.GetDeliveryPathRequest request, String tenantId);

    /**
     * 查询订单预订人隐私信息。
     * <p>官方接口：{@code /wmoper/ng/order/getOrderBookerInformation}，API：{@code get_order_booker_information}，版本：{@code 10031}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGetOrderBookerInformation(com.meituan.sdk.model.wmoperNg.order.getOrderBookerInformation.GetOrderBookerInformationRequest request, String tenantId);

    /**
     * 查询出餐超时的订单。
     * <p>官方接口：{@code /wmoper/ng/order/getOrderMealStatus}，API：{@code get_order_meal_status}，版本：{@code 10050}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGetOrderMealStatus(com.meituan.sdk.model.wmoperNg.order.getOrderMealStatus.GetOrderMealStatusRequest request, String tenantId);

    /**
     * 查询订单收餐人隐私信息。
     * <p>官方接口：{@code /wmoper/ng/order/getOrderRecipientPrivacyInfo}，API：{@code get_order_recipient_privacy_info}，版本：{@code 10031}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGetOrderRecipientPrivacyInfo(com.meituan.sdk.model.wmoperNg.order.getOrderRecipientPrivacyInfo.GetOrderRecipientPrivacyInfoRequest request, String tenantId);

    /**
     * 商家获取备餐时间。
     * <p>官方接口：{@code /wmoper/ng/order/getPreparationMealTime}，API：{@code get_preparation_mealtime}，版本：{@code 10035}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGetPreparationMealtime(com.meituan.sdk.model.wmoperNg.order.getPreparationMealtime.GetPreparationMealtimeRequest request, String tenantId);

    /**
     * 食光机-查询订单详情。
     * <p>官方接口：{@code /wmoper/ng/order/innovative/getInnovativeOrderDetail}，API：{@code innovative_order_query}，版本：{@code 10056}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgInnovativeOrderQuery(com.meituan.sdk.model.wmoperNg.order.innovativeOrderQuery.InnovativeOrderQueryRequest request, String tenantId);

    /**
     * 众包配送场景－查询配送费。
     * <p>官方接口：{@code /wmoper/ng/order/queryZbShippingFee}，API：{@code order_query_zb_shipping_fee}，版本：{@code 10059}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgOrderQueryZbShippingFee(com.meituan.sdk.model.wmoperNg.order.orderQueryZbShippingFee.OrderQueryZbShippingFeeRequest request, String tenantId);

    /**
     * 众包配送场景－配送单加小费。
     * <p>官方接口：{@code /wmoper/ng/order/updateZbDispatchTip}，API：{@code order_update_zb_dispatch_tip}，版本：{@code 10083}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgOrderUpdateZbDispatchTip(com.meituan.sdk.model.wmoperNg.order.orderUpdateZbDispatchTip.OrderUpdateZbDispatchTipRequest request, String tenantId);

    /**
     * 商家确认已完成出餐。
     * <p>官方接口：{@code /wmoper/ng/order/preparationMealComplete}，API：{@code preparation_meal_complete}，版本：{@code 10012}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgPreparationMealComplete(com.meituan.sdk.model.wmoperNg.order.preparationMealComplete.PreparationMealCompleteRequest request, String tenantId);

    /**
     * 获取订单可以取消跑腿的原因。
     * <p>官方接口：{@code /wmoper/ng/order/queryZbCancelDeliveryReason}，API：{@code query_zb_cancel_delivery_reason}，版本：{@code 10085}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgQueryZbCancelDeliveryReason(com.meituan.sdk.model.wmoperNg.order.queryZbCancelDeliveryReason.QueryZbCancelDeliveryReasonRequest request, String tenantId);

    /**
     * 自配订单同步配送信息。
     * <p>官方接口：{@code /wmoper/ng/order/riderPosition}，API：{@code rider_position}，版本：{@code 10095}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgRiderPosition(com.meituan.sdk.model.wmoperNg.order.riderPosition.RiderPositionRequest request, String tenantId);

    /**
     * 发送短信。
     * <p>官方接口：{@code /wmoper/ng/order/sendSMS}，API：{@code send_sms}，版本：{@code 10088}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgSendSms(com.meituan.sdk.model.wmoperNg.order.sendSms.SendSmsRequest request, String tenantId);

    /**
     * 获取配送详情页面授权码（非接单）。
     * <p>官方接口：{@code /wmoper/ng/order/business_auth/code/generate}，API：{@code wmoper_get_auth_code}，版本：{@code 10089}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperGetAuthCode(WmoperGetAuthCodeRequest request, String tenantId);

    /**
     * 查询订单详情。
     * <p>官方接口：{@code /wmoper/order/queryOrderDetail}，API：{@code wmoper_order_query_order_detail}，版本：{@code 10072}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperOrderQueryOrderDetail(WmoperOrderQueryOrderDetailRequest request, String tenantId);

    /**
     * 查询订单列表。
     * <p>官方接口：{@code /wmoper/order/queryOrders}，API：{@code wmoper_order_query_orders}，版本：{@code 10032}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperOrderQueryOrders(WmoperOrderQueryOrdersRequest request, String tenantId);

    /**
     * 批量查询跑腿配送费。
     * <p>官方接口：{@code /wmoper/ng/order/zhongbao/shippingFeeByCode}，API：{@code wmoper_zhongbao_shippingfeebycode}，版本：{@code 10029}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperZhongbaoShippingfeebycode(WmoperZhongbaoShippingfeebycodeRequest request, String tenantId);

    /**
     * 查询订单详情。
     * <p>官方接口：{@code /wmoper/ng/order/detail}，API：{@code wmoperng_get_order_detail}，版本：{@code 10023}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperngGetOrderDetail(WmoperngGetOrderDetailRequest request, String tenantId);

    /**
     * 查询订单列表。
     * <p>官方接口：{@code /wmoper/ng/order/queryOrders}，API：{@code wmoperng_order_list}，版本：{@code 10000}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperngOrderList(WmoperngOrderListRequest request, String tenantId);

    /**
     * 获取配送订单状态。
     * <p>官方接口：{@code /wmoper/ng/order/logistics/status}，API：{@code wmoperng_query_logistics_status}，版本：{@code 10087}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperngQueryLogisticsStatus(WmoperngQueryLogisticsStatusRequest request, String tenantId);

    /**
     * 查询订单详情(展示费率相关字段)。
     * <p>官方接口：{@code /wmoper/ng/order/queryDetail}，API：{@code wmoperng_query_order_detail}，版本：{@code 10094}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperngQueryOrderDetail(WmoperngQueryOrderDetailRequest request, String tenantId);

    /**
     * 众包配送-发配送。
     * <p>官方接口：{@code /wmoper/ng/order/zbDispatch}，API：{@code zb_dispatch}，版本：{@code 10081}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgZbDispatch(com.meituan.sdk.model.wmoperNg.order.zbDispatch.ZbDispatchRequest request, String tenantId);

    /**
     * 查询众包配送费。
     * <p>官方接口：{@code /wmoper/ng/order/zbLogisticsPreview}，API：{@code zb_logistics_preview}，版本：{@code 10083}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgZbLogisticsPreview(com.meituan.sdk.model.wmoperNg.order.zbLogisticsPreview.ZbLogisticsPreviewRequest request, String tenantId);

    /**
     * 查询门店二维码。
     * <p>官方接口：{@code /wmoper/ng/poi/getPoiExtendInfo}，API：{@code get_poi_extend_info}，版本：{@code 10006}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGetPoiExtendInfo(com.meituan.sdk.model.wmoperNg.poi.getPoiExtendInfo.GetPoiExtendInfoRequest request, String tenantId);

    /**
     * 查询店铺分数据。
     * <p>官方接口：{@code /wmoper/ng/poi/getPoiScoreDetail}，API：{@code get_poi_score_detail}，版本：{@code 10004}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGetPoiScoreDetail(com.meituan.sdk.model.wmoperNg.poi.getPoiScoreDetail.GetPoiScoreDetailRequest request, String tenantId);

    /**
     * 获取门店品类列表。
     * <p>官方接口：{@code /wmoper/ng/poi/poiTag/list}，API：{@code poi_tag_list}，版本：{@code 10002}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> poiTagList(PoiTagListRequest request, String tenantId);

    /**
     * 查询门店实时评价权益。
     * <p>官方接口：{@code /wmoper/ng/poi/queryStoreEvaluationBenefit}，API：{@code query_store_evaluation_benefit}，版本：{@code 10008}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgQueryStoreEvaluationBenefit(com.meituan.sdk.model.wmoperNg.poi.queryStoreEvaluationBenefit.QueryStoreEvaluationBenefitRequest request, String tenantId);

    /**
     * 批量获取门店详情信息。
     * <p>官方接口：{@code /wmoper/ng/poi/mget}，API：{@code wmoper_batch_query_poi}，版本：{@code 10009}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperBatchQueryPoi(WmoperBatchQueryPoiRequest request, String tenantId);

    /**
     * 门店是否可开启加权。
     * <p>官方接口：{@code /wmoper/ng/poi/weight/canOpen}，API：{@code wmoper_poi_weight_can_open}，版本：{@code 10002}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperPoiWeightCanOpen(WmoperPoiWeightCanOpenRequest request, String tenantId);

    /**
     * 获取门店详情信息。
     * <p>官方接口：{@code /wmoper/ng/poi/detail}，API：{@code wmoperng_query_poi_detail}，版本：{@code 10003}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperngQueryPoiDetail(WmoperngQueryPoiDetailRequest request, String tenantId);

    /**
     * 创建或更新门店信息。
     * <p>官方接口：{@code /wmoper/ng/poiop/poi/save}，API：{@code poi_save}，版本：{@code 10002}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> poiSave(PoiSaveRequest request, String tenantId);

    /**
     * 更改门店公告信息。
     * <p>官方接口：{@code /wmoper/ng/poiop/poi/updatepromoteinfo}，API：{@code poi_updatepromoteinfo}，版本：{@code 10002}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> poiUpdatepromoteinfo(PoiUpdatepromoteinfoRequest request, String tenantId);

    /**
     * 门店开启加权。
     * <p>官方接口：{@code /wmoper/ng/poiop/poi/weight/open}，API：{@code poi_weight_open}，版本：{@code 10002}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> poiWeightOpen(PoiWeightOpenRequest request, String tenantId);

    /**
     * 更新门店营业时间。
     * <p>官方接口：{@code /wmoper/ng/poiop/shippingtime/update}，API：{@code shippingtime_update}，版本：{@code 10002}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> shippingtimeUpdate(ShippingtimeUpdateRequest request, String tenantId);

    /**
     * 查询门店配送范围（混合送）。
     * <p>官方接口：{@code /wmoper/ng/shipping/fetch}，API：{@code shipping_fetch}，版本：{@code 10001}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgShippingFetch(com.meituan.sdk.model.wmoperNg.shipping.shippingFetch.ShippingFetchRequest request, String tenantId);

    /**
     * 查询门店配送范围。
     * <p>官方接口：{@code /wmoper/ng/shipping/list}，API：{@code shipping_list}，版本：{@code 10001}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgShippingList(com.meituan.sdk.model.wmoperNg.shipping.shippingList.ShippingListRequest request, String tenantId);

    /**
     * 批量创建/更新配送范围（自配）。
     * <p>官方接口：{@code /wmoper/ng/shippingop/batchsave}，API：{@code shipping_batchsave}，版本：{@code 10001}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgShippingBatchsave(com.meituan.sdk.model.wmoperNg.shippingop.shippingBatchsave.ShippingBatchsaveRequest request, String tenantId);

    /**
     * 删除门店配送范围（自配）。
     * <p>官方接口：{@code /wmoper/ng/shippingop/delete}，API：{@code shipping_delete}，版本：{@code 10001}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgShippingDelete(com.meituan.sdk.model.wmoperNg.shippingop.shippingDelete.ShippingDeleteRequest request, String tenantId);

    /**
     * 重置门店配送范围（自配）。
     * <p>官方接口：{@code /wmoper/ng/shippingop/resetSelfDeliveryArea}，API：{@code shipping_reset_self_delivery_area}，版本：{@code 10001}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgShippingResetSelfDeliveryArea(com.meituan.sdk.model.wmoperNg.shippingop.shippingResetSelfDeliveryArea.ShippingResetSelfDeliveryAreaRequest request, String tenantId);

    /**
     * 创建/更新门店配送范围（自配）。
     * <p>官方接口：{@code /wmoper/ng/shippingop/save}，API：{@code shipping_save}，版本：{@code 10001}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgShippingSave(com.meituan.sdk.model.wmoperNg.shippingop.shippingSave.ShippingSaveRequest request, String tenantId);

    /**
     * 创建/更新特殊时段配送范围（自配）。
     * <p>官方接口：{@code /wmoper/ng/shippingop/spec/save}，API：{@code shipping_spec_save}，版本：{@code 10001}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgShippingSpecSave(com.meituan.sdk.model.wmoperNg.shippingop.shippingSpecSave.ShippingSpecSaveRequest request, String tenantId);

    /**
     * 批量查询商品(拼好饭)。
     * <p>官方接口：{@code /wmoper/ng/special/food/batchQuery}，API：{@code special_food_batch_query}，版本：{@code 10007}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgSpecialFoodBatchQuery(com.meituan.sdk.model.wmoperNg.special.specialFoodBatchQuery.SpecialFoodBatchQueryRequest request, String tenantId);

    /**
     * 建立拼好饭场景菜品映射。
     * <p>官方接口：{@code /wmoper/ng/special/food/bindSpuAndSkuCode}，API：{@code special_food_bind_spu_and_sku_code}，版本：{@code 10006}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgSpecialFoodBindSpuAndSkuCode(com.meituan.sdk.model.wmoperNg.special.specialFoodBindSpuAndSkuCode.SpecialFoodBindSpuAndSkuCodeRequest request, String tenantId);

    /**
     * 查询单个商品(拼好饭)。
     * <p>官方接口：{@code /wmoper/ng/special/food/conditionQuery}，API：{@code special_food_condition_query}，版本：{@code 10003}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgSpecialFoodConditionQuery(com.meituan.sdk.model.wmoperNg.special.specialFoodConditionQuery.SpecialFoodConditionQueryRequest request, String tenantId);

    /**
     * 修改商品上下架状态(拼好饭)。
     * <p>官方接口：{@code /wmoper/ng/special/food/updateSellStatus}，API：{@code special_food_update_sell_status}，版本：{@code 10004}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgSpecialFoodUpdateSellStatus(com.meituan.sdk.model.wmoperNg.special.specialFoodUpdateSellStatus.SpecialFoodUpdateSellStatusRequest request, String tenantId);

    /**
     * 修改商品库存(拼好饭)。
     * <p>官方接口：{@code /wmoper/ng/special/food/updateStock}，API：{@code special_food_update_stock}，版本：{@code 10005}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgSpecialFoodUpdateStock(com.meituan.sdk.model.wmoperNg.special.specialFoodUpdateStock.SpecialFoodUpdateStockRequest request, String tenantId);

    /**
     * 获取自定义标签。
     * <p>官方接口：{@code /wmoper/ng/valueadded/getCustomLabels}，API：{@code get_custom_labels}，版本：{@code 10020}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGetCustomLabels(com.meituan.sdk.model.wmoperNg.valueadded.getCustomLabels.GetCustomLabelsRequest request, String tenantId);

    /**
     * 获取系统标签。
     * <p>官方接口：{@code /wmoper/ng/valueadded/getSystemLabels}，API：{@code get_system_labels}，版本：{@code 10002}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgGetSystemLabels(com.meituan.sdk.model.wmoperNg.valueadded.getSystemLabels.GetSystemLabelsRequest request, String tenantId);

    /**
     * 精准营销-活动效果汇总查询接口（含券使用时间）。
     * <p>官方接口：{@code /wmoper/ng/valueadded/queryCouponDetailExtraResult}，API：{@code query_coupon_detail_extra_result}，版本：{@code 10014}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgQueryCouponDetailExtraResult(com.meituan.sdk.model.wmoperNg.valueadded.queryCouponDetailExtraResult.QueryCouponDetailExtraResultRequest request, String tenantId);

    /**
     * 根据发券任务ID查询发券活动效果明细。
     * <p>官方接口：{@code /wmoper/ng/valueadded/queryCouponDetailResult}，API：{@code query_coupon_detail_result}，版本：{@code 10016}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgQueryCouponDetailResult(com.meituan.sdk.model.wmoperNg.valueadded.queryCouponDetailResult.QueryCouponDetailResultRequest request, String tenantId);

    /**
     * 查询商家当前剩余可发券数量。
     * <p>官方接口：{@code /wmoper/ng/valueadded/queryCouponStock}，API：{@code query_coupon_stock}，版本：{@code 10000}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgQueryCouponStock(com.meituan.sdk.model.wmoperNg.valueadded.queryCouponStock.QueryCouponStockRequest request, String tenantId);

    /**
     * 活动效果汇总查询接口。
     * <p>官方接口：{@code /wmoper/ng/valueadded/queryCouponTotalResult}，API：{@code query_coupon_total_result}，版本：{@code 10012}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgQueryCouponTotalResult(com.meituan.sdk.model.wmoperNg.valueadded.queryCouponTotalResult.QueryCouponTotalResultRequest request, String tenantId);

    /**
     * 查询任务结果。
     * <p>官方接口：{@code /wmoper/ng/valueadded/async/taskResultQuery}，API：{@code task_result_query}，版本：{@code 10013}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgTaskResultQuery(com.meituan.sdk.model.wmoperNg.valueadded.taskResultQuery.TaskResultQueryRequest request, String tenantId);

    /**
     * 任务提交。
     * <p>官方接口：{@code /wmoper/ng/valueadded/async/taskSubmit}，API：{@code task_submit}，版本：{@code 10015}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> wmoperNgTaskSubmit(com.meituan.sdk.model.wmoperNg.valueadded.taskSubmit.TaskSubmitRequest request, String tenantId);

    /**
     * 获取商家购买的应用信息。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/buyinfo}，API：{@code ad_app_buy_info}，版本：{@code 10006}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> adAppBuyInfo(AdAppBuyInfoRequest request, String tenantId);

    /**
     * 获取商家广告余额。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/balance}，API：{@code ad_balance_info}，版本：{@code 10005}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> adBalanceInfo(AdBalanceInfoRequest request, String tenantId);

    /**
     * 广告明细数据，区分小时。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/data/detail}，API：{@code ad_data_detail}，版本：{@code 10004}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> adDataDetail(AdDataDetailRequest request, String tenantId);

    /**
     * 广告历史数据，区分到天。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/data/history}，API：{@code ad_data_history}，版本：{@code 10006}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> adDataHistory(AdDataHistoryRequest request, String tenantId);

    /**
     * 获取不同位置的效果数据。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/data/source}，API：{@code ad_data_source}，版本：{@code 10005}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> adDataSource(AdDataSourceRequest request, String tenantId);

    /**
     * 获取三方人群包出价。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/dmp/queryCrowdBid}，API：{@code ad_dmp_query_crowd_bid}，版本：{@code 10019}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> adDmpQueryCrowdBid(AdDmpQueryCrowdBidRequest request, String tenantId);

    /**
     * 获取广告不同类型价格范围。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/pricerange}，API：{@code ad_price_range}，版本：{@code 10006}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> adPriceRange(AdPriceRangeRequest request, String tenantId);

    /**
     * 获取广告计划状态，包括是否开启、预算、出价。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/status}，API：{@code ad_status_info}，版本：{@code 10004}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> adStatusInfo(AdStatusInfoRequest request, String tenantId);

    /**
     * 修改广告投放计划出价。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/plan/update/bid}，API：{@code ad_update_plan_bid}，版本：{@code 10005}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> adUpdatePlanBid(AdUpdatePlanBidRequest request, String tenantId);

    /**
     * 修改广告投放计划预算。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/plan/update/budget}，API：{@code ad_update_plan_budget}，版本：{@code 10005}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> adUpdatePlanBudget(AdUpdatePlanBudgetRequest request, String tenantId);

    /**
     * 修改广告投放计划状态（不能新建）。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/plan/update/status}，API：{@code ad_update_plan_status}，版本：{@code 10005}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> adUpdatePlanStatus(AdUpdatePlanStatusRequest request, String tenantId);

    /**
     * 应用购买记录。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/app/order/list}，API：{@code app_order_list}，版本：{@code 10014}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> appOrderList(AppOrderListRequest request, String tenantId);

    /**
     * 增值平台接口校验。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/marketplace/app/auth}，API：{@code auth_anti_force_try}，版本：{@code 10016}，businessId：{@code 16}，需要授权：{@code 是}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> authAntiForceTry(AuthAntiForceTryRequest request, String tenantId);

    /**
     * 经营分析-订单数。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/biz/ordcount}，API：{@code biz_ord_count}，版本：{@code 10005}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> bizOrdCount(BizOrdCountRequest request, String tenantId);

    /**
     * 经营分析-订单列表。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/biz/ordlist}，API：{@code biz_ord_list}，版本：{@code 10005}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> bizOrdList(BizOrdListRequest request, String tenantId);

    /**
     * 经营分析-商家活动信息。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/biz/poiact}，API：{@code biz_poi_act}，版本：{@code 10005}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> bizPoiAct(BizPoiActRequest request, String tenantId);

    /**
     * 经营分析-菜品信息。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/biz/foodlist}，API：{@code biz_poi_food}，版本：{@code 10005}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> bizPoiFood(BizPoiFoodRequest request, String tenantId);

    /**
     * 经营分析-商家交易信息。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/biz/poitrade}，API：{@code biz_poi_trade}，版本：{@code 10005}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> bizPoiTrade(BizPoiTradeRequest request, String tenantId);

    /**
     * 针对加密字段解密。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/common/decrypt}，API：{@code decrypt}，版本：{@code 10001}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> decrypt(DecryptRequest request, String tenantId);

    /**
     * 竞价推广-附近商家平均出价。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/peer/bidprice}，API：{@code peer_ad_bidprice}，版本：{@code 10008}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> peerAdBidprice(PeerAdBidpriceRequest request, String tenantId);

    /**
     * 竞价推广-商圈效果数据-曝光与点击。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/peer/effectdata}，API：{@code peer_ad_effectdata}，版本：{@code 10007}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> peerAdEffectdata(PeerAdEffectdataRequest request, String tenantId);

    /**
     * 营业分析-查询流量曝光与入店数据。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/poi/effectdata}，API：{@code poi_ad_effectdata}，版本：{@code 10007}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> poiAdEffectdata(PoiAdEffectdataRequest request, String tenantId);

    /**
     * 竞价推广-商圈与门店效果数据-新客进店。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/poipeer/effectdata}，API：{@code poipeer_ad_effectdata}，版本：{@code 10007}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> poipeerAdEffectdata(PoipeerAdEffectdataRequest request, String tenantId);

    /**
     * 获取商家基本信息。
     * <p>官方接口：{@code /wmoper/ng/waimaiad/common/wmpoiinfo}，API：{@code waimai_poi_info}，版本：{@code 10006}，businessId：{@code 16}，需要授权：{@code 否}。</p>
     *
     * @param request  官方 MtOpJavaSDK 请求对象
     * @param tenantId 租户标识，用于选择对应的 appAuthToken
     * @return 官方 SDK 反序列化后的响应
     */
    MeituanResponse<?> waimaiPoiInfo(WaimaiPoiInfoRequest request, String tenantId);
}
