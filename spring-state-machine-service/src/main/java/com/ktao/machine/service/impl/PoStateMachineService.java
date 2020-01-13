package com.ktao.machine.service.impl;

import com.ktao.machine.entity.PurchaseOrder;
import com.ktao.machine.enums.PurchaseOrderEvent;
import com.ktao.machine.enums.PurchaseOrderState;
import com.ktao.machine.statemachine.factory.PoStateMachineFactory;
import com.ktao.machine.statemachine.interceptor.PoStateMachineInterceptor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.ktao.machine.consts.PurchaseOrderConst.PO_STATE_MACHINE_KEY;

/**
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/1/13 3:34 下午
 */
@Log4j2
@Service
public class PoStateMachineService {
    @Resource
    private StateMachinePersister<PurchaseOrderState, PurchaseOrderEvent, PurchaseOrder> stateMachinePersister;

    @Resource
    private PoStateMachineFactory poStateMachineFactory;

    @Resource
    private PoStateMachineInterceptor poStateMachineInterceptor;

    /**
     * 采购单事件过渡
     * @param order
     * @param event
     */
    public void transition(PurchaseOrder order, PurchaseOrderEvent event){
        // 创建状态机实例
        StateMachine<PurchaseOrderState, PurchaseOrderEvent> stateMachine = poStateMachineFactory.createStateMachine();
        // 添加拦截器
        stateMachine.getStateMachineAccessor().withRegion().addStateMachineInterceptor(poStateMachineInterceptor);
        // 启动状态机实例
        stateMachine.start();
        try {
            // 根据采购单恢复状态机实例信息
            stateMachinePersister.restore(stateMachine, order);
            // 封装采购单数据
            Message<PurchaseOrderEvent> message = MessageBuilder
                    .withPayload(event)
                    .setHeader(PO_STATE_MACHINE_KEY, order)
                    .build();
            // 状态机事件相映
            stateMachine.sendEvent(message);
        } catch (Exception e){
            log.error("采购单状态机流转异常, 参数: {}", order, e);
        } finally {
            stateMachine.stop();
        }
    }
}
