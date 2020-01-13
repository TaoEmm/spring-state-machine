package com.ktao.machine.entity;

import lombok.Builder;
import lombok.Data;

/**
 * 采购单实体类
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/1/13 1:17 下午
 */
@Data
@Builder
public class PurchaseOrder {
    /**
     * id
     */
    private Integer id;

    /**
     * 采购单号
     */
    private String poCode;

    /**
     * 采购单状态
     */
    private Integer orderStatus;
}
