package com.ktao.machine.statemachine.action;

import com.ktao.machine.enums.PurchaseOrderEvent;
import com.ktao.machine.enums.PurchaseOrderState;
import lombok.extern.log4j.Log4j2;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/1/13 2:25 下午
 */
@Component
@Log4j2
public class PoCloseAction implements Action<PurchaseOrderState, PurchaseOrderEvent> {
    @Override
    public void execute(StateContext<PurchaseOrderState, PurchaseOrderEvent> context) {
        log.info("采购单关闭");
    }
}