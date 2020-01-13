package com.ktao.machine.dao;

import com.ktao.machine.entity.PurchaseOrder;

/**
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/1/13 1:17 下午
 */
public interface PurchaseOrderMapper {
    /**
     * 新增对象
     *
     * @param purchaseOrder
     * @return
     */
    public boolean insert(PurchaseOrder purchaseOrder);

    /**
     * 更新对象
     *
     * @param purchaseOrder
     * @return
     */
    public boolean update(PurchaseOrder purchaseOrder);

    /**
     * 删除记录
     *
     * @param purchaseOrder
     * @return
     */
    public boolean delete(PurchaseOrder purchaseOrder);

    /**
     * 根据主键获取对象
     *
     * @param id 主键字段
     * @return
     */
    public PurchaseOrder getPurchaseOrderById(Integer id);
}
