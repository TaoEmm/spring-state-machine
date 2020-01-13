package com.ktao.machine.statemachine.config;

import com.ktao.machine.enums.PurchaseOrderEvent;
import com.ktao.machine.enums.PurchaseOrderState;
import com.ktao.machine.statemachine.action.PoApproveAction;
import com.ktao.machine.statemachine.action.PoCloseAction;
import com.ktao.machine.statemachine.action.PoRejectAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import javax.annotation.Resource;
import java.util.EnumSet;

/**
 * @version 1.0
 * @author: kongtao
 * @description:
 * @date: 2020/1/13 1:18 下午
 */
@Slf4j
@Configuration
public class PoStateMachineBuilder {

    @Resource
    private PoApproveAction poApproveAction;

    @Resource
    private PoRejectAction poRejectAction;

    @Resource
    private PoCloseAction poCloseAction;

    /**
     * 构建状态机
     * @param beanFactory
     * @param orderCode
     * @return
     * @throws Exception
     */
    public StateMachine<PurchaseOrderState, PurchaseOrderEvent> build(BeanFactory beanFactory, String orderCode) throws Exception {
        StateMachineBuilder.Builder<PurchaseOrderState, PurchaseOrderEvent> builder = StateMachineBuilder.builder();

        builder.configureConfiguration()
                .withConfiguration()
                .machineId(orderCode)
                .beanFactory(beanFactory);

        builder.configureStates()
                .withStates()
                .initial(PurchaseOrderState.INIT)
                .states(EnumSet.allOf(PurchaseOrderState.class));

        builder.configureTransitions()
                //采购单审核
                .withExternal()
                .source(PurchaseOrderState.INIT)
                .target(PurchaseOrderState.APPROVED)
                .event(PurchaseOrderEvent.APPROVE)
                .action(poApproveAction)
                .and()
                // 采购单驳回
                .withExternal()
                .source(PurchaseOrderState.INIT)
                .target(PurchaseOrderState.REJECT)
                .event(PurchaseOrderEvent.REJECT)
                .action(poRejectAction)
                .and()
                // 采购单关闭
                .withExternal()
                .source(PurchaseOrderState.INIT)
                .target(PurchaseOrderState.CLOSED)
                .event(PurchaseOrderEvent.CLOSE)
                .action(poCloseAction)
                .and();
        return builder.build();
    }

}
