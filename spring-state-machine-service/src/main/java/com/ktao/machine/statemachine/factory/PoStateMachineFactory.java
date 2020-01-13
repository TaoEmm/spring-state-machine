package com.ktao.machine.statemachine.factory;

import com.ktao.machine.enums.PurchaseOrderEvent;
import com.ktao.machine.enums.PurchaseOrderState;
import com.ktao.machine.statemachine.config.PoStateMachineBuilder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/1/13 1:19 下午
 */
@Component
@Log4j2
public class PoStateMachineFactory {

    @Resource
    private BeanFactory beanFactory;

    @Resource
    private PoStateMachineBuilder stateMachineBuilder;

    public StateMachine<PurchaseOrderState, PurchaseOrderEvent> createStateMachine(){
        StateMachine<PurchaseOrderState, PurchaseOrderEvent> stateMachine;
        try {
            stateMachine = stateMachineBuilder.build(beanFactory, UUID.randomUUID().toString());
        } catch (Exception e){
            log.error("采购单状态机系统创建异常", e);
            throw new RuntimeException("无法创建状态机");
        }
        return stateMachine;
    }
}
