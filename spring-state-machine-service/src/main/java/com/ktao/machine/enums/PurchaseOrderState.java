package com.ktao.machine.enums;

/**
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/1/13 12:03 下午
 */
public enum PurchaseOrderState {
    INIT(10,"未审核"),
    APPROVED(20,"已审核"),
    REJECT(30,"驳回"),
    CLOSED(40,"关闭"),
    ;
    private Integer id;
    private String name;

    PurchaseOrderState(Integer id, String name) {
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
