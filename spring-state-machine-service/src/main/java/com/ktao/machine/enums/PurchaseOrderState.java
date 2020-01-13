package com.ktao.machine.enums;

/**
 * 采购单状态
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
    private Integer code;
    private String name;

    PurchaseOrderState(Integer code, String name) {
        this.code = code;
        this.name = name;
    }


    public Integer getCode() {
        return code;
    }


    public String getName() {
        return name;
    }

    public static PurchaseOrderState valueOf(Integer code) {
        if (code == null) {
            return null;
        }

        PurchaseOrderState[] tempEnumArray = PurchaseOrderState.values();
        for (PurchaseOrderState tempEnum : tempEnumArray) {
            if (tempEnum.getCode().equals(code)) {
                return tempEnum;
            }
        }

        return null;
    }
}
