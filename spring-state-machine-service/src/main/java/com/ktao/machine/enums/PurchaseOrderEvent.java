package com.ktao.machine.enums;

/**
 * 采购单动作
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/1/13 12:03 下午
 */
public enum  PurchaseOrderEvent {
    APPROVE(10,"审核"),
    REJECT(20,"驳回"),
    CLOSE(30,"关闭"),
    ;
    private Integer id;
    private String name;

    PurchaseOrderEvent(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }
}
