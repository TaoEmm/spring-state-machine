package com.ktao.machine.service.impl;

import com.ktao.machine.entity.PurchaseOrder;
import com.ktao.machine.service.PurchaseOrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/1/13 11:58 上午
 */
@Service
@Log4j2
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Override
    public Boolean approvePurchaseOrder(PurchaseOrder order) {
        return null;
    }

    @Override
    public Boolean rejectPurchaseOrder(PurchaseOrder order) {
        return null;
    }

    @Override
    public Boolean closePurchaseOrder(PurchaseOrder order) {
        return null;
    }
}
