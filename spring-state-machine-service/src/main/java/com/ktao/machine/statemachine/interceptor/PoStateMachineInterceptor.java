package com.ktao.machine.statemachine.interceptor;

import com.ktao.machine.entity.PurchaseOrder;
import com.ktao.machine.enums.PurchaseOrderEvent;
import com.ktao.machine.enums.PurchaseOrderState;
import lombok.extern.log4j.Log4j2;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.support.StateMachineInterceptorAdapter;
import org.springframework.stereotype.Component;

import static com.ktao.machine.consts.PurchaseOrderConst.PO_STATE_MACHINE_KEY;

/**
 * 采购单状态机拦截器
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/1/13 2:53 下午
 */
@Component
@Log4j2
public class PoStateMachineInterceptor extends StateMachineInterceptorAdapter<PurchaseOrderState, PurchaseOrderEvent> {

    @Override
    public StateContext<PurchaseOrderState, PurchaseOrderEvent> postTransition(StateContext<PurchaseOrderState, PurchaseOrderEvent> stateContext) {
        // 1.获取单据信息
        PurchaseOrder order = (PurchaseOrder)stateContext.getMessageHeader(PO_STATE_MACHINE_KEY);
        // 2.日志记录
        writeStateChangeLog(stateContext, order);
        // 3.消息发送（业务 或 埋点）
        return stateContext;
    }

    private void writeStateChangeLog(StateContext<PurchaseOrderState, PurchaseOrderEvent> stateContext, PurchaseOrder order) {
        log.info("source: {}, target: {}, data: {}", stateContext.getSource(), stateContext.getTarget(), order);
    }
}
