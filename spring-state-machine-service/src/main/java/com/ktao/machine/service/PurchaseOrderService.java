package com.ktao.machine.service;

import com.ktao.machine.entity.PurchaseOrder;

/**
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/1/13 11:58 上午
 */
public interface PurchaseOrderService {

    /**
     * 审核采购订单
     *
     * @param order
     * @return
     */
    Boolean approvePurchaseOrder(PurchaseOrder order);


    /**
     * 驳回采购订单
     *
     * @param order
     * @return
     */
    Boolean rejectPurchaseOrder(PurchaseOrder order);


    /**
     * 关闭采购订单
     *
     * @param order
     * @return
     */
    Boolean closePurchaseOrder(PurchaseOrder order);

}
