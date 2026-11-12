package io.github.easy4j.meituan.callback.type;

import cn.hutool.core.util.StrUtil;
import io.github.easy4j.meituan.callback.MeituanCallbackMessage;
import io.github.easy4j.meituan.callback.model.biz18.AssemblyOrderMessage;
import io.github.easy4j.meituan.callback.model.biz18.BrandInformationMessage;
import io.github.easy4j.meituan.callback.model.biz18.ConfigurationChangedMessage;
import io.github.easy4j.meituan.callback.model.biz18.CouponRedemptionChangedMessage;
import io.github.easy4j.meituan.callback.model.biz18.DeliveryOrderMessage;
import io.github.easy4j.meituan.callback.model.biz18.DeliveryPriceMessage;
import io.github.easy4j.meituan.callback.model.biz18.DeliveryReceiptMessage;
import io.github.easy4j.meituan.callback.model.biz18.DisassemblyOrderMessage;
import io.github.easy4j.meituan.callback.model.biz18.DishSoldOutMessage;
import io.github.easy4j.meituan.callback.model.biz18.ExternalSalesOrderQueryMessage;
import io.github.easy4j.meituan.callback.model.biz18.ExternalSalesReturnQueryMessage;
import io.github.easy4j.meituan.callback.model.biz18.ExternalSalesShipmentQueryMessage;
import io.github.easy4j.meituan.callback.model.biz18.FundExceptionMessage;
import io.github.easy4j.meituan.callback.model.biz18.HeadquartersDishMessage;
import io.github.easy4j.meituan.callback.model.biz18.ItemCategoryMessage;
import io.github.easy4j.meituan.callback.model.biz18.ItemMasterMessage;
import io.github.easy4j.meituan.callback.model.biz18.MemberCouponDiscountAllocationMessage;
import io.github.easy4j.meituan.callback.model.biz18.MemberCouponDiscountReversedMessage;
import io.github.easy4j.meituan.callback.model.biz18.MemberCouponRedemptionMessage;
import io.github.easy4j.meituan.callback.model.biz18.MemberOrderAvailableCouponsMessage;
import io.github.easy4j.meituan.callback.model.biz18.MemberPointsRedeemedMessage;
import io.github.easy4j.meituan.callback.model.biz18.MemberPointsReversedMessage;
import io.github.easy4j.meituan.callback.model.biz18.MemberPointsRulesQueryMessage;
import io.github.easy4j.meituan.callback.model.biz18.MemberPriceQueryMessage;
import io.github.easy4j.meituan.callback.model.biz18.MemberSearchMessage;
import io.github.easy4j.meituan.callback.model.biz18.MerchantSettingsChangedMessage;
import io.github.easy4j.meituan.callback.model.biz18.OnlinePaymentSettlementMessage;
import io.github.easy4j.meituan.callback.model.biz18.OnlineTransactionMessage;
import io.github.easy4j.meituan.callback.model.biz18.OrderNotificationMessage;
import io.github.easy4j.meituan.callback.model.biz18.OrderSettlementMessage;
import io.github.easy4j.meituan.callback.model.biz18.OrganizationAddressMessage;
import io.github.easy4j.meituan.callback.model.biz18.OrganizationStructureMessage;
import io.github.easy4j.meituan.callback.model.biz18.PaymentMethodChangedMessage;
import io.github.easy4j.meituan.callback.model.biz18.PaymentNotificationMessage;
import io.github.easy4j.meituan.callback.model.biz18.PosOrderAcceptedMessage;
import io.github.easy4j.meituan.callback.model.biz18.PosOrderCancelledMessage;
import io.github.easy4j.meituan.callback.model.biz18.PosOrderCollectedMessage;
import io.github.easy4j.meituan.callback.model.biz18.PosOrderDeliveredMessage;
import io.github.easy4j.meituan.callback.model.biz18.PosOrderRejectedMessage;
import io.github.easy4j.meituan.callback.model.biz18.PosPartialRefundMessage;
import io.github.easy4j.meituan.callback.model.biz18.PosPreparationCompletedMessage;
import io.github.easy4j.meituan.callback.model.biz18.PosPreparationStartedMessage;
import io.github.easy4j.meituan.callback.model.biz18.PurchaseOrderMessage;
import io.github.easy4j.meituan.callback.model.biz18.PurchaseReceiptMessage;
import io.github.easy4j.meituan.callback.model.biz18.PurchaseReturnMessage;
import io.github.easy4j.meituan.callback.model.biz18.RealtimeOrderMessage;
import io.github.easy4j.meituan.callback.model.biz18.ReceivableExpenseMessage;
import io.github.easy4j.meituan.callback.model.biz18.RefundNotificationMessage;
import io.github.easy4j.meituan.callback.model.biz18.ReplenishmentOrderMessage;
import io.github.easy4j.meituan.callback.model.biz18.ReplenishmentSplitCancellationCheckMessage;
import io.github.easy4j.meituan.callback.model.biz18.ReverseOrderMessage;
import io.github.easy4j.meituan.callback.model.biz18.StockDiscrepancyMessage;
import io.github.easy4j.meituan.callback.model.biz18.StockIssueMessage;
import io.github.easy4j.meituan.callback.model.biz18.StockReceiptMessage;
import io.github.easy4j.meituan.callback.model.biz18.StockReturnAuditReversalCheckMessage;
import io.github.easy4j.meituan.callback.model.biz18.StockReturnMessage;
import io.github.easy4j.meituan.callback.model.biz18.StocktakeOrderMessage;
import io.github.easy4j.meituan.callback.model.biz18.StoreDishMessage;
import io.github.easy4j.meituan.callback.model.biz18.StoreInformationMessage;
import io.github.easy4j.meituan.callback.model.biz18.StoreQrOrderingSettingsChangedMessage;
import io.github.easy4j.meituan.callback.model.biz18.StoreTransferOrderMessage;
import io.github.easy4j.meituan.callback.model.biz18.StoredValueRedeemedMessage;
import io.github.easy4j.meituan.callback.model.biz18.StoredValueReversedMessage;
import io.github.easy4j.meituan.callback.model.biz18.SupplyPaymentMessage;
import io.github.easy4j.meituan.callback.model.biz18.TableAreaChangedMessage;
import io.github.easy4j.meituan.callback.model.biz18.TakeawayDishMessage;
import lombok.Getter;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 业务 {@code businessId=18} 的已登记回调消息类型目录。
 */
@Getter
public enum MeituanBusiness18MessageType implements MeituanMessageType {

    /**
     * 店内菜品消息（单店）。
     */
    STORE_DISH("店内菜品消息（单店）", "18201", "https://developer.meituan.com/docs/msg/msg_rms_cbfdd2b4-bfef-4adf-89f6-2e1f04516f56", StoreDishMessage.class),
    /**
     * 门店消息。
     */
    STORE_INFORMATION("门店消息", "18202", "https://developer.meituan.com/docs/msg/msg_rms_2eca15d6-1329-457f-80cd-60f9f89aaa75", StoreInformationMessage.class),
    /**
     * 组织结构消息。
     */
    ORGANIZATION_STRUCTURE("组织结构消息", "18203", "https://developer.meituan.com/docs/msg/msg_rms_f8275f64-fed3-4c86-b7ba-f632933683d9", OrganizationStructureMessage.class),
    /**
     * 品牌消息。
     */
    BRAND_INFORMATION("品牌消息", "18204", "https://developer.meituan.com/docs/msg/msg_rms_295d53bc-b641-4a08-97ab-ba461bc395f7", BrandInformationMessage.class),
    /**
     * 配置消息。
     */
    CONFIGURATION_CHANGED("配置消息", "18205", "https://developer.meituan.com/docs/msg/msg_rms_f95460c6-88ff-4286-8c96-6cdc3a3bf4f8", ConfigurationChangedMessage.class),
    /**
     * 外卖菜品消息。
     */
    TAKEAWAY_DISH("外卖菜品消息", "18206", "https://developer.meituan.com/docs/msg/msg_rms_6afea534-0a04-4905-9244-9afe745eeffe", TakeawayDishMessage.class),
    /**
     * 订单消息。
     */
    ORDER_NOTIFICATION("订单消息", "18207", "https://developer.meituan.com/docs/msg/msg_rms_886675cb-a79f-48e5-b280-c35aebcd191d", OrderNotificationMessage.class),
    /**
     * 订单结算消息。
     */
    ORDER_SETTLEMENT("订单结算消息", "18208", "https://developer.meituan.com/docs/msg/msg_rms_105942f4-4cdf-4c15-89c5-417f3b77c512", OrderSettlementMessage.class),
    /**
     * 店内菜品消息（总部）。
     */
    HEADQUARTERS_DISH("店内菜品消息（总部）", "18209", "https://developer.meituan.com/docs/msg/msg_rms_932df858-a920-4acc-b0cb-201a4151e791", HeadquartersDishMessage.class),
    /**
     * POS接单-自动接单or接单页商家手动同意接单。
     */
    POS_ORDER_ACCEPTED("POS接单-自动接单or接单页商家手动同意接单", "1810011", "https://developer.meituan.com/docs/msg/msg_rms_c338bee4-012c-4cba-98ec-167e7eb4bfbf", PosOrderAcceptedMessage.class),
    /**
     * POS接单-接单页商家手动拒绝接单。
     */
    POS_ORDER_REJECTED("POS接单-接单页商家手动拒绝接单", "1810013", "https://developer.meituan.com/docs/msg/msg_rms_c4ad6b92-7711-4f2c-ba97-f1ff4fe16c6f", PosOrderRejectedMessage.class),
    /**
     * POS接单-接单页商家点击开始制作。
     */
    POS_PREPARATION_STARTED("POS接单-接单页商家点击开始制作", "1810015", "https://developer.meituan.com/docs/msg/msg_rms_437ad66b-818d-400c-8ed3-3939326b15fd", PosPreparationStartedMessage.class),
    /**
     * POS接单-接单页商家点击制作完成。
     */
    POS_PREPARATION_COMPLETED("POS接单-接单页商家点击制作完成", "1810017", "https://developer.meituan.com/docs/msg/msg_rms_c6f755a8-cb26-46be-956a-c9a247642a2c", PosPreparationCompletedMessage.class),
    /**
     * POS接单-接单页商家点击确认取餐。
     */
    POS_ORDER_COLLECTED("POS接单-接单页商家点击确认取餐", "1810019", "https://developer.meituan.com/docs/msg/msg_rms_1675bd8f-12c6-4239-a242-77083e109fc3", PosOrderCollectedMessage.class),
    /**
     * POS接单-接单页商家主动取消订单(退单)。
     */
    POS_ORDER_CANCELLED("POS接单-接单页商家主动取消订单(退单)", "1810023", "https://developer.meituan.com/docs/msg/msg_rms_a1633b76-3d13-4942-82dd-3adce4172dc1", PosOrderCancelledMessage.class),
    /**
     * 美团在线支付结算明细推送。
     */
    ONLINE_PAYMENT_SETTLEMENT("美团在线支付结算明细推送", "1810029", "https://developer.meituan.com/docs/msg/msg_rms_3e5b1e5e-f64e-4715-99cd-6ac2aeaeda50", OnlinePaymentSettlementMessage.class),
    /**
     * POS接单-接单页商家点击已送达。
     */
    POS_ORDER_DELIVERED("POS接单-接单页商家点击已送达", "1810045", "https://developer.meituan.com/docs/msg/msg_rms_f93fd133-2373-4b0f-a7ae-a904031349e5", PosOrderDeliveredMessage.class),
    /**
     * 会员搜索。
     */
    MEMBER_SEARCH("会员搜索", "1810055", "https://developer.meituan.com/docs/msg/msg_rms_f4c3c8ac-0457-48e4-993e-bed7df3dc8ba", MemberSearchMessage.class),
    /**
     * 会员订单可用券列表。
     */
    MEMBER_ORDER_AVAILABLE_COUPONS("会员订单可用券列表", "1810057", "https://developer.meituan.com/docs/msg/msg_rms_b5efd6b4-800b-4f05-b5f3-e554d585ae51", MemberOrderAvailableCouponsMessage.class),
    /**
     * 会员券优惠分摊。
     */
    MEMBER_COUPON_DISCOUNT_ALLOCATION("会员券优惠分摊", "1810059", "https://developer.meituan.com/docs/msg/msg_rms_1e8b7101-896d-422a-bf75-0348367b674b", MemberCouponDiscountAllocationMessage.class),
    /**
     * 会员优惠券核销。
     */
    MEMBER_COUPON_REDEMPTION("会员优惠券核销", "1810061", "https://developer.meituan.com/docs/msg/msg_rms_321e560e-f4c9-441f-8d56-ac3e391d87c2", MemberCouponRedemptionMessage.class),
    /**
     * 会员券优惠冲正。
     */
    MEMBER_COUPON_DISCOUNT_REVERSED("会员券优惠冲正", "1810063", "https://developer.meituan.com/docs/msg/msg_rms_3d21b3f7-ef83-47bc-b689-cce0173a3d3b", MemberCouponDiscountReversedMessage.class),
    /**
     * 会员积分核销。
     */
    MEMBER_POINTS_REDEEMED("会员积分核销", "1810065", "https://developer.meituan.com/docs/msg/msg_rms_7f171809-5e3a-4679-9f88-36a9658677a2", MemberPointsRedeemedMessage.class),
    /**
     * 会员积分冲正。
     */
    MEMBER_POINTS_REVERSED("会员积分冲正", "1810067", "https://developer.meituan.com/docs/msg/msg_rms_d2e18e80-ddeb-44b0-9365-e0980e15ec9f", MemberPointsReversedMessage.class),
    /**
     * 会员储值核销。
     */
    STORED_VALUE_REDEEMED("会员储值核销", "1810069", "https://developer.meituan.com/docs/msg/msg_rms_4b56b8c3-8ea6-4d6c-848f-38847e3107ad", StoredValueRedeemedMessage.class),
    /**
     * 会员储值冲正。
     */
    STORED_VALUE_REVERSED("会员储值冲正", "1810071", "https://developer.meituan.com/docs/msg/msg_rms_9c5cf71e-e998-411b-9bcd-974022856214", StoredValueReversedMessage.class),
    /**
     * 查询会员积分规则。
     */
    MEMBER_POINTS_RULES_QUERY("查询会员积分规则", "1810077", "https://developer.meituan.com/docs/msg/msg_rms_92875d44-c27e-4c62-97d6-43b50372eb35", MemberPointsRulesQueryMessage.class),
    /**
     * 菜品沽清消息。
     */
    DISH_SOLD_OUT("菜品沽清消息", "1810079", "https://developer.meituan.com/docs/msg/msg_rms_2e05df35-5662-4b0a-83a2-df717f7337d5", DishSoldOutMessage.class),
    /**
     * 结账方式变更消息。
     */
    PAYMENT_METHOD_CHANGED("结账方式变更消息", "1810081", "https://developer.meituan.com/docs/msg/msg_rms_cd69c47a-d403-4b40-b938-51b50dead79e", PaymentMethodChangedMessage.class),
    /**
     * 支付回调消息。
     */
    PAYMENT_NOTIFICATION("支付回调消息", "1810083", "https://developer.meituan.com/docs/msg/msg_rms_5f5427a2-f4cf-4793-b29a-bf865a92c167", PaymentNotificationMessage.class),
    /**
     * 退款消息推送。
     */
    REFUND_NOTIFICATION("退款消息推送", "1810085", "https://developer.meituan.com/docs/msg/msg_rms_1aeca49f-7973-4aef-9107-bfa89c289eaa", RefundNotificationMessage.class),
    /**
     * POS部分退-接单页商家主动退菜退款(部分退)。
     */
    POS_PARTIAL_REFUND("POS部分退-接单页商家主动退菜退款(部分退)", "1810089", "https://developer.meituan.com/docs/msg/msg_rms_53f91a3e-8946-4a56-8d36-9c38e3986345", PosPartialRefundMessage.class),
    /**
     * 查询商品会员价。
     */
    MEMBER_PRICE_QUERY("查询商品会员价", "1810093", "https://developer.meituan.com/docs/msg/msg_rms_42758627-f078-43fe-9420-73cc37c31cab", MemberPriceQueryMessage.class),
    /**
     * 【供应链】配送单消息。
     */
    DELIVERY_ORDER("【供应链】配送单消息", "1810095", "https://developer.meituan.com/docs/msg/msg_rms_83cfd8f1-2ea8-49e9-84cb-3e9543e06190", DeliveryOrderMessage.class),
    /**
     * 【供应链】差异单消息。
     */
    STOCK_DISCREPANCY("【供应链】差异单消息", "1810097", "https://developer.meituan.com/docs/msg/msg_rms_413654d3-7a8f-4cef-9e41-3226148f3a6f", StockDiscrepancyMessage.class),
    /**
     * 【供应链】返货单消息。
     */
    STOCK_RETURN("【供应链】返货单消息", "1810099", "https://developer.meituan.com/docs/msg/msg_rms_18138616-36ac-41ab-9cd7-8fb1142134b6", StockReturnMessage.class),
    /**
     * 【供应链】物品档案消息。
     */
    ITEM_MASTER("【供应链】物品档案消息", "1810101", "https://developer.meituan.com/docs/msg/msg_rms_afe81c75-71c8-46e5-87fc-47f9c480cbb4", ItemMasterMessage.class),
    /**
     * 【供应链】物品类别档案消息。
     */
    ITEM_CATEGORY("【供应链】物品类别档案消息", "1810103", "https://developer.meituan.com/docs/msg/msg_rms_643906ec-1526-4e46-b9f1-c8e52136a0c2", ItemCategoryMessage.class),
    /**
     * 【供应链】采购订单消息。
     */
    PURCHASE_ORDER("【供应链】采购订单消息", "1810105", "https://developer.meituan.com/docs/msg/msg_rms_ed3842bf-0e58-4e5b-90e6-9a3e30cb93a8", PurchaseOrderMessage.class),
    /**
     * 【供应链】采购退货单消息。
     */
    PURCHASE_RETURN("【供应链】采购退货单消息", "1810107", "https://developer.meituan.com/docs/msg/msg_rms_104d68dc-8bff-4b27-a618-97333b2beab8", PurchaseReturnMessage.class),
    /**
     * 【供应链】机构地址推送消息。
     */
    ORGANIZATION_ADDRESS("【供应链】机构地址推送消息", "1810111", "https://developer.meituan.com/docs/msg/msg_rms_ffa2fb38-a0f8-417c-a463-f430ea8650d2", OrganizationAddressMessage.class),
    /**
     * 【供应链】订货单消息。
     */
    REPLENISHMENT_ORDER("【供应链】订货单消息", "1810115", "https://developer.meituan.com/docs/msg/msg_rms_ea015b0b-003b-4e37-87b5-651cd0e85c94", ReplenishmentOrderMessage.class),
    /**
     * 【供应链】配送收货单消息。
     */
    DELIVERY_RECEIPT("【供应链】配送收货单消息", "1810117", "https://developer.meituan.com/docs/msg/msg_rms_efc64380-c31f-46b4-b7d7-fff0407b206a", DeliveryReceiptMessage.class),
    /**
     * 【供应链】应收费用单消息。
     */
    RECEIVABLE_EXPENSE("【供应链】应收费用单消息", "1810123", "https://developer.meituan.com/docs/msg/msg_rms_d413d051-9fc4-4c21-b6c1-c1426d596675", ReceivableExpenseMessage.class),
    /**
     * 【供应链】在线交易流水。
     */
    ONLINE_TRANSACTION("【供应链】在线交易流水", "1810125", "https://developer.meituan.com/docs/msg/msg_rms_089d58b9-4ced-44e8-bb9d-77dabefdba88", OnlineTransactionMessage.class),
    /**
     * 【供应链】入库单消息。
     */
    STOCK_RECEIPT("【供应链】入库单消息", "1810127", "https://developer.meituan.com/docs/msg/msg_rms_9782d500-6cb5-4ddb-b2b3-03ac8f941331", StockReceiptMessage.class),
    /**
     * 【供应链】出库单消息。
     */
    STOCK_ISSUE("【供应链】出库单消息", "1810179", "https://developer.meituan.com/docs/msg/msg_rms_ec58ddbd-dbbb-420f-8d1a-3d2402a9bcf1", StockIssueMessage.class),
    /**
     * 实时订单推送。
     */
    REALTIME_ORDER("实时订单推送", "1810235", "https://developer.meituan.com/docs/msg/msg_rms_afe8750e-5e11-496e-b0d7-6ac300bbecd8", RealtimeOrderMessage.class),
    /**
     * 【供应链】（预）付款单消息。
     */
    SUPPLY_PAYMENT("【供应链】（预）付款单消息", "1810237", "https://developer.meituan.com/docs/msg/msg_rms_131d7553-f640-4425-a7fc-42342e3cdf8d", SupplyPaymentMessage.class),
    /**
     * 优惠券实例核销/撤销事件通知。
     */
    COUPON_REDEMPTION_CHANGED("优惠券实例核销/撤销事件通知", "1810243", "https://developer.meituan.com/docs/msg/msg_rms_2f495d7b-a57f-4b38-9c61-2a1e72e0eae5", CouponRedemptionChangedMessage.class),
    /**
     * 【供应链】采购收货单消息。
     */
    PURCHASE_RECEIPT("【供应链】采购收货单消息", "1810249", "https://developer.meituan.com/docs/msg/msg_rms_5f479a1e-4235-47b8-8d49-7a1e421e2939", PurchaseReceiptMessage.class),
    /**
     * 资金业务异常通知。
     */
    FUND_EXCEPTION("资金业务异常通知", "1810251", "https://developer.meituan.com/docs/msg/msg_rms_60d0606f-1762-4008-a59e-5e07eb8424d6", FundExceptionMessage.class),
    /**
     * 【供应链】门店订货单撤销分单三方校验。
     */
    REPLENISHMENT_SPLIT_CANCELLATION_CHECK("【供应链】门店订货单撤销分单三方校验", "1810253", "https://developer.meituan.com/docs/msg/msg_rms_5aefd175-2ed7-4682-b087-a4d5a622af10", ReplenishmentSplitCancellationCheckMessage.class),
    /**
     * 【供应链】门店返货单反审核三方校验。
     */
    STOCK_RETURN_AUDIT_REVERSAL_CHECK("【供应链】门店返货单反审核三方校验", "1810255", "https://developer.meituan.com/docs/msg/msg_rms_7b548983-084e-4d55-82ee-85a729a55b27", StockReturnAuditReversalCheckMessage.class),
    /**
     * 逆向单消息。
     */
    REVERSE_ORDER("逆向单消息", "1810257", "https://developer.meituan.com/docs/msg/msg_rms_2ae666d5-4440-47d5-8cd2-bb3e5ce2b33e", ReverseOrderMessage.class),
    /**
     * 【供应链】查询外销订单消息。
     */
    EXTERNAL_SALES_ORDER_QUERY("【供应链】查询外销订单消息", "1810269", "https://developer.meituan.com/docs/msg/msg_rms_12595847-1e02-4bce-ac29-b3a4fd120ac5", ExternalSalesOrderQueryMessage.class),
    /**
     * 【供应链】查询外销发货单消息。
     */
    EXTERNAL_SALES_SHIPMENT_QUERY("【供应链】查询外销发货单消息", "1810271", "https://developer.meituan.com/docs/msg/msg_rms_09b3f340-8836-4439-afc3-904fd69d9361", ExternalSalesShipmentQueryMessage.class),
    /**
     * 【供应链】查询外销退货单消息。
     */
    EXTERNAL_SALES_RETURN_QUERY("【供应链】查询外销退货单消息", "1810273", "https://developer.meituan.com/docs/msg/msg_rms_b67069a5-7c68-4fe8-87d4-8f853396031a", ExternalSalesReturnQueryMessage.class),
    /**
     * 桌台区域变更通知。
     */
    TABLE_AREA_CHANGED("桌台区域变更通知", "1810275", "https://developer.meituan.com/docs/msg/msg_rms_370a911c-cdeb-413e-8825-db9fb389a266", TableAreaChangedMessage.class),
    /**
     * 商户开关变更消息。
     */
    MERCHANT_SETTINGS_CHANGED("商户开关变更消息", "1810277", "https://developer.meituan.com/docs/msg/msg_rms_fc1fba26-cdbd-42b5-932f-dbf35132d8fe", MerchantSettingsChangedMessage.class),
    /**
     * 门店扫码点餐配置变动通知。
     */
    STORE_QR_ORDERING_SETTINGS_CHANGED("门店扫码点餐配置变动通知", "1810279", "https://developer.meituan.com/docs/msg/msg_rms_d78845e8-5809-40c1-a9b1-64ec3e7c0d32", StoreQrOrderingSettingsChangedMessage.class),
    /**
     * 【供应链】配送价格消息。
     */
    DELIVERY_PRICE("【供应链】配送价格消息", "1810285", "https://developer.meituan.com/docs/msg/msg_rms_3eebad37-1020-42b2-a206-0ce5aca0973e", DeliveryPriceMessage.class),
    /**
     * 【供应链】组合加工单消息。
     */
    ASSEMBLY_ORDER("【供应链】组合加工单消息", "1810335", "https://developer.meituan.com/docs/msg/msg_rms_42ee4c75-d6ef-4186-9f98-7c6ad99d8695", AssemblyOrderMessage.class),
    /**
     * 【供应链】拆分加工单消息。
     */
    DISASSEMBLY_ORDER("【供应链】拆分加工单消息", "1810337", "https://developer.meituan.com/docs/msg/msg_rms_6c2bd567-2045-4285-949e-d01683661d0c", DisassemblyOrderMessage.class),
    /**
     * 【供应链】门店调拨单消息。
     */
    STORE_TRANSFER_ORDER("【供应链】门店调拨单消息", "1810339", "https://developer.meituan.com/docs/msg/msg_rms_e3bfdeab-e8cd-40cb-bce8-36339a757406", StoreTransferOrderMessage.class),
    /**
     * 【供应链】盘点单消息。
     */
    STOCKTAKE_ORDER("【供应链】盘点单消息", "1810341", "https://developer.meituan.com/docs/msg/msg_rms_80884496-1de4-4abe-b2f3-37a6f615fc49", StocktakeOrderMessage.class);

    private static final String BUSINESS_ID = "18";
    private static final String DOCUMENT_BASE_URL = "https://developer.meituan.com/docs/msg/";
    private static final Map<String, MeituanBusiness18MessageType> BY_MSG_TYPE = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(MeituanBusiness18MessageType::getMsgType, Function.identity()))
    );

    /**
     * 美团文档中的消息名称。
     */
    private final String displayName;

    /**
     * 平台用来标识此消息的类型编号。
     */
    private final String msgType;

    /**
     * 美团官网上此消息的文档地址。
     */
    private final String documentUrl;

    /**
     * 业务内容的 Jackson 目标类型；String 表示保留业务原文。
     */
    private final Class<?> messageClass;

    MeituanBusiness18MessageType(String displayName, String msgType, String documentKey, Class<?> messageClass) {
        this.displayName = displayName;
        this.msgType = msgType;
        this.documentUrl = URI.create(DOCUMENT_BASE_URL).resolve(documentKey).toString();
        this.messageClass = Objects.requireNonNull(messageClass, "messageClass must not be null");
    }

    /**
     * 返回此枚举所属的美团业务编号。
     *
     * @return 官方 businessId
     */
    @Override
    public String getBusinessId() {
        return BUSINESS_ID;
    }

    /**
     * 在确认回调属于 {@code businessId=18} 后解析消息类型。
     *
     * @param callback 通用回调信封
     * @return 已登记消息；其他业务或未知类型返回空的 {@link Optional}
     */
    public static Optional<MeituanBusiness18MessageType> resolve(MeituanCallbackMessage<?> callback) {
        if (Objects.isNull(callback) || !BUSINESS_ID.equals(callback.getBusinessId())) {
            return Optional.empty();
        }
        return fromMsgType(callback.getMsgType());
    }

    /**
     * 根据平台消息类型查找已登记消息定义。
     *
     * @param msgType 平台下发消息类型
     * @return 已知消息定义
     */
    public static Optional<MeituanBusiness18MessageType> fromMsgType(String msgType) {
        if (StrUtil.isBlank(msgType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(BY_MSG_TYPE.get(msgType));
    }
}
