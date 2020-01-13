package com.ktao.machine.statemachine.presist;

import com.ktao.machine.entity.PurchaseOrder;
import com.ktao.machine.enums.PurchaseOrderEvent;
import com.ktao.machine.enums.PurchaseOrderState;
import lombok.extern.log4j.Log4j2;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Component;

/**
 * 采购单状态机持久化
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/1/13 3:23 下午
 */
@Component
@Log4j2
public class PoStateMachinePersist implements StateMachinePersist<PurchaseOrderState, PurchaseOrderEvent, PurchaseOrder> {
    @Override
    public void write(StateMachineContext<PurchaseOrderState, PurchaseOrderEvent> context, PurchaseOrder contextObj) throws Exception {
        // 这里不做任何持久化工作
    }

    /**
     * 通过采购单状态来初始化状态机的状态
     * @param order
     * @return
     * @throws Exception
     */
    @Override
    public StateMachineContext<PurchaseOrderState, PurchaseOrderEvent> read(PurchaseOrder order) throws Exception {
        return new DefaultStateMachineContext<>(PurchaseOrderState.valueOf(order.getOrderStatus()), null, null, null);
    }
}
